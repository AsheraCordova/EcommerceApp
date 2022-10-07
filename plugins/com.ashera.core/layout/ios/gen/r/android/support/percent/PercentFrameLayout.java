package r.android.support.percent;
import r.android.view.ViewGroup;
import r.android.widget.FrameLayout;
public class PercentFrameLayout extends FrameLayout {
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
public static class LayoutParams extends FrameLayout.LayoutParams implements PercentLayoutHelper.PercentLayoutParams {
    private PercentLayoutHelper.PercentLayoutInfo mPercentLayoutInfo;
    public LayoutParams(    int width,    int height){
      super(width,height);
    }
    public LayoutParams(    int width,    int height,    int gravity){
      super(width,height,gravity);
    }
    public LayoutParams(    ViewGroup.LayoutParams source){
      super(source);
    }
    public LayoutParams(    LayoutParams source){
      this((FrameLayout.LayoutParams)source);
      mPercentLayoutInfo=source.mPercentLayoutInfo;
    }
    public PercentLayoutHelper.PercentLayoutInfo getPercentLayoutInfo(){
      if (mPercentLayoutInfo == null) {
        mPercentLayoutInfo=new PercentLayoutHelper.PercentLayoutInfo();
      }
      return mPercentLayoutInfo;
    }
  }
}
