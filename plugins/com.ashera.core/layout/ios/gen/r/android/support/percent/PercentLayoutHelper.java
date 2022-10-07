package r.android.support.percent;
import r.android.content.Context;
import r.android.support.v4.view.MarginLayoutParamsCompat;
import r.android.support.v4.view.ViewCompat;
import r.android.util.Log;
import r.android.view.View;
import r.android.view.ViewGroup;
public class PercentLayoutHelper {
  private static final String TAG="PercentLayout";
  private final ViewGroup mHost;
  public PercentLayoutHelper(  ViewGroup host){
    mHost=host;
  }
  public void adjustChildren(  int widthMeasureSpec,  int heightMeasureSpec){
    if (Log.isLoggable(TAG,Log.DEBUG)) {
      Log.d(TAG,"adjustChildren: " + mHost + " widthMeasureSpec: "+ View.MeasureSpec.toString(widthMeasureSpec)+ " heightMeasureSpec: "+ View.MeasureSpec.toString(heightMeasureSpec));
    }
    int widthHint=View.MeasureSpec.getSize(widthMeasureSpec);
    int heightHint=View.MeasureSpec.getSize(heightMeasureSpec);
    for (int i=0, N=mHost.getChildCount(); i < N; i++) {
      View view=mHost.getChildAt(i);
      ViewGroup.LayoutParams params=view.getLayoutParams();
      if (Log.isLoggable(TAG,Log.DEBUG)) {
        Log.d(TAG,"should adjust " + view + " "+ params);
      }
      if (params instanceof PercentLayoutParams) {
        PercentLayoutInfo info=((PercentLayoutParams)params).getPercentLayoutInfo();
        if (Log.isLoggable(TAG,Log.DEBUG)) {
          Log.d(TAG,"using " + info);
        }
        if (info != null) {
          if (params instanceof ViewGroup.MarginLayoutParams) {
            info.fillMarginLayoutParams((ViewGroup.MarginLayoutParams)params,widthHint,heightHint);
          }
 else {
            info.fillLayoutParams(params,widthHint,heightHint);
          }
        }
      }
    }
  }
  public void restoreOriginalParams(){
    for (int i=0, N=mHost.getChildCount(); i < N; i++) {
      View view=mHost.getChildAt(i);
      ViewGroup.LayoutParams params=view.getLayoutParams();
      if (Log.isLoggable(TAG,Log.DEBUG)) {
        Log.d(TAG,"should restore " + view + " "+ params);
      }
      if (params instanceof PercentLayoutParams) {
        PercentLayoutInfo info=((PercentLayoutParams)params).getPercentLayoutInfo();
        if (Log.isLoggable(TAG,Log.DEBUG)) {
          Log.d(TAG,"using " + info);
        }
        if (info != null) {
          if (params instanceof ViewGroup.MarginLayoutParams) {
            info.restoreMarginLayoutParams((ViewGroup.MarginLayoutParams)params);
          }
 else {
            info.restoreLayoutParams(params);
          }
        }
      }
    }
  }
  public boolean handleMeasuredStateTooSmall(){
    boolean needsSecondMeasure=false;
    for (int i=0, N=mHost.getChildCount(); i < N; i++) {
      View view=mHost.getChildAt(i);
      ViewGroup.LayoutParams params=view.getLayoutParams();
      if (Log.isLoggable(TAG,Log.DEBUG)) {
        Log.d(TAG,"should handle measured state too small " + view + " "+ params);
      }
      if (params instanceof PercentLayoutParams) {
        PercentLayoutInfo info=((PercentLayoutParams)params).getPercentLayoutInfo();
        if (info != null) {
          if (shouldHandleMeasuredWidthTooSmall(view,info)) {
            needsSecondMeasure=true;
            params.width=ViewGroup.LayoutParams.WRAP_CONTENT;
          }
          if (shouldHandleMeasuredHeightTooSmall(view,info)) {
            needsSecondMeasure=true;
            params.height=ViewGroup.LayoutParams.WRAP_CONTENT;
          }
        }
      }
    }
    if (Log.isLoggable(TAG,Log.DEBUG)) {
      Log.d(TAG,"should trigger second measure pass: " + needsSecondMeasure);
    }
    return needsSecondMeasure;
  }
  private static boolean shouldHandleMeasuredWidthTooSmall(  View view,  PercentLayoutInfo info){
    int state=ViewCompat.getMeasuredWidthAndState(view) & ViewCompat.MEASURED_STATE_MASK;
    return state == ViewCompat.MEASURED_STATE_TOO_SMALL && info.widthPercent >= 0 && info.mPreservedParams.width == ViewGroup.LayoutParams.WRAP_CONTENT;
  }
  private static boolean shouldHandleMeasuredHeightTooSmall(  View view,  PercentLayoutInfo info){
    int state=ViewCompat.getMeasuredHeightAndState(view) & ViewCompat.MEASURED_STATE_MASK;
    return state == ViewCompat.MEASURED_STATE_TOO_SMALL && info.heightPercent >= 0 && info.mPreservedParams.height == ViewGroup.LayoutParams.WRAP_CONTENT;
  }
public static class PercentLayoutInfo {
    public float widthPercent;
    public float heightPercent;
    public float leftMarginPercent;
    public float topMarginPercent;
    public float rightMarginPercent;
    public float bottomMarginPercent;
    public float startMarginPercent;
    public float endMarginPercent;
    public float aspectRatio;
    final ViewGroup.MarginLayoutParams mPreservedParams;
    public PercentLayoutInfo(){
      widthPercent=-1f;
      heightPercent=-1f;
      leftMarginPercent=-1f;
      topMarginPercent=-1f;
      rightMarginPercent=-1f;
      bottomMarginPercent=-1f;
      startMarginPercent=-1f;
      endMarginPercent=-1f;
      mPreservedParams=new ViewGroup.MarginLayoutParams(0,0);
    }
    public void fillLayoutParams(    ViewGroup.LayoutParams params,    int widthHint,    int heightHint){
      mPreservedParams.width=params.width;
      mPreservedParams.height=params.height;
      final boolean widthNotSet=params.width == 0 && widthPercent < 0;
      final boolean heightNotSet=params.height == 0 && heightPercent < 0;
      if (widthPercent >= 0) {
        params.width=(int)(widthHint * widthPercent);
      }
      if (heightPercent >= 0) {
        params.height=(int)(heightHint * heightPercent);
      }
      if (aspectRatio >= 0) {
        if (widthNotSet) {
          params.width=(int)(params.height * aspectRatio);
        }
        if (heightNotSet) {
          params.height=(int)(params.width / aspectRatio);
        }
      }
      if (Log.isLoggable(TAG,Log.DEBUG)) {
        Log.d(TAG,"after fillLayoutParams: (" + params.width + ", "+ params.height+ ")");
      }
    }
    public void fillMarginLayoutParams(    ViewGroup.MarginLayoutParams params,    int widthHint,    int heightHint){
      fillLayoutParams(params,widthHint,heightHint);
      mPreservedParams.leftMargin=params.leftMargin;
      mPreservedParams.topMargin=params.topMargin;
      mPreservedParams.rightMargin=params.rightMargin;
      mPreservedParams.bottomMargin=params.bottomMargin;
      MarginLayoutParamsCompat.setMarginStart(mPreservedParams,MarginLayoutParamsCompat.getMarginStart(params));
      MarginLayoutParamsCompat.setMarginEnd(mPreservedParams,MarginLayoutParamsCompat.getMarginEnd(params));
      if (leftMarginPercent >= 0) {
        params.leftMargin=(int)(widthHint * leftMarginPercent);
      }
      if (topMarginPercent >= 0) {
        params.topMargin=(int)(heightHint * topMarginPercent);
      }
      if (rightMarginPercent >= 0) {
        params.rightMargin=(int)(widthHint * rightMarginPercent);
      }
      if (bottomMarginPercent >= 0) {
        params.bottomMargin=(int)(heightHint * bottomMarginPercent);
      }
      if (startMarginPercent >= 0) {
        MarginLayoutParamsCompat.setMarginStart(params,(int)(widthHint * startMarginPercent));
      }
      if (endMarginPercent >= 0) {
        MarginLayoutParamsCompat.setMarginEnd(params,(int)(widthHint * endMarginPercent));
      }
      if (Log.isLoggable(TAG,Log.DEBUG)) {
        Log.d(TAG,"after fillMarginLayoutParams: (" + params.width + ", "+ params.height+ ")");
      }
    }
    public String toString(){
      return String.format("PercentLayoutInformation width: %f height %f, margins (%f, %f, " + " %f, %f, %f, %f)",widthPercent,heightPercent,leftMarginPercent,topMarginPercent,rightMarginPercent,bottomMarginPercent,startMarginPercent,endMarginPercent);
    }
    public void restoreMarginLayoutParams(    ViewGroup.MarginLayoutParams params){
      restoreLayoutParams(params);
      params.leftMargin=mPreservedParams.leftMargin;
      params.topMargin=mPreservedParams.topMargin;
      params.rightMargin=mPreservedParams.rightMargin;
      params.bottomMargin=mPreservedParams.bottomMargin;
      MarginLayoutParamsCompat.setMarginStart(params,MarginLayoutParamsCompat.getMarginStart(mPreservedParams));
      MarginLayoutParamsCompat.setMarginEnd(params,MarginLayoutParamsCompat.getMarginEnd(mPreservedParams));
    }
    public void restoreLayoutParams(    ViewGroup.LayoutParams params){
      params.width=mPreservedParams.width;
      params.height=mPreservedParams.height;
    }
  }
public interface PercentLayoutParams {
    PercentLayoutInfo getPercentLayoutInfo();
  }
}
