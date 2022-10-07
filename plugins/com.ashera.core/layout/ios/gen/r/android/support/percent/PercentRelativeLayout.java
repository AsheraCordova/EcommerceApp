package r.android.support.percent;
import r.android.view.ViewGroup;
import r.android.widget.RelativeLayout;
public class PercentRelativeLayout extends RelativeLayout {
  private final PercentLayoutHelper mHelper=new PercentLayoutHelper(this);
  protected LayoutParams generateDefaultLayoutParams(){
    return new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
  }
  protected void onMeasure(  int widthMeasureSpec,  int heightMeasureSpec){
    mHelper.adjustChildren(widthMeasureSpec,heightMeasureSpec);
    super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    if (mHelper.handleMeasuredStateTooSmall()) {
      super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    }
  }
  protected void onLayout(  boolean changed,  int left,  int top,  int right,  int bottom){
    super.onLayout(changed,left,top,right,bottom);
    mHelper.restoreOriginalParams();
  }
public static class LayoutParams extends RelativeLayout.LayoutParams implements PercentLayoutHelper.PercentLayoutParams {
    private PercentLayoutHelper.PercentLayoutInfo mPercentLayoutInfo;
    public LayoutParams(    int width,    int height){
      super(width,height);
    }
    public LayoutParams(    ViewGroup.LayoutParams source){
      super(source);
    }
    public PercentLayoutHelper.PercentLayoutInfo getPercentLayoutInfo(){
      if (mPercentLayoutInfo == null) {
        mPercentLayoutInfo=new PercentLayoutHelper.PercentLayoutInfo();
      }
      return mPercentLayoutInfo;
    }
  }
}
