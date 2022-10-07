package r.android.widget;
import r.android.os.Build.VERSION_CODES;
import r.android.graphics.Rect;
import r.android.view.View;
import r.android.view.ViewGroup;
public class ScrollView extends FrameLayout {
  static final int ANIMATED_SCROLL_GAP=250;
  private int mLastMotionY;
  private boolean mIsLayoutDirty=true;
  private boolean mIsBeingDragged=false;
  private boolean mFillViewport;
  private boolean mSmoothScrollingEnabled=true;
  private int mTouchSlop;
  private int mMinimumVelocity;
  private int mMaximumVelocity;
  private int mOverscrollDistance;
  private int mOverflingDistance;
  private int mActivePointerId=INVALID_POINTER;
  private int mNestedYOffset;
  private static final int INVALID_POINTER=-1;
  public boolean isFillViewport(){
    return mFillViewport;
  }
  public void setFillViewport(  boolean fillViewport){
    if (fillViewport != mFillViewport) {
      mFillViewport=fillViewport;
      requestLayout();
    }
  }
  protected void onMeasure(  int widthMeasureSpec,  int heightMeasureSpec){
    super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    if (!mFillViewport) {
      return;
    }
    final int heightMode=MeasureSpec.getMode(heightMeasureSpec);
    if (heightMode == MeasureSpec.UNSPECIFIED) {
      return;
    }
    if (getChildCount() > 0) {
      final View child=getChildAt(0);
      final int height=getMeasuredHeight();
      if (child.getMeasuredHeight() < height) {
        final int widthPadding;
        final int heightPadding;
        final FrameLayout.LayoutParams lp=(LayoutParams)child.getLayoutParams();
        final int targetSdkVersion=getContext().getApplicationInfo().targetSdkVersion;
        if (targetSdkVersion >= VERSION_CODES.M) {
          widthPadding=mPaddingLeft + mPaddingRight + lp.leftMargin+ lp.rightMargin;
          heightPadding=mPaddingTop + mPaddingBottom + lp.topMargin+ lp.bottomMargin;
        }
 else {
          widthPadding=mPaddingLeft + mPaddingRight;
          heightPadding=mPaddingTop + mPaddingBottom;
        }
        final int childWidthMeasureSpec=getChildMeasureSpec(widthMeasureSpec,widthPadding,lp.width);
        final int childHeightMeasureSpec=MeasureSpec.makeMeasureSpec(height - heightPadding,MeasureSpec.EXACTLY);
        child.measure(childWidthMeasureSpec,childHeightMeasureSpec);
      }
    }
  }
  protected int computeVerticalScrollRange(){
    final int count=getChildCount();
    final int contentHeight=getHeight() - mPaddingBottom - mPaddingTop;
    if (count == 0) {
      return contentHeight;
    }
    int scrollRange=getChildAt(0).getBottom();
    final int scrollY=mScrollY;
    final int overscrollBottom=Math.max(0,scrollRange - contentHeight);
    if (scrollY < 0) {
      scrollRange-=scrollY;
    }
 else     if (scrollY > overscrollBottom) {
      scrollRange+=scrollY - overscrollBottom;
    }
    return scrollRange;
  }
  protected void measureChild(  View child,  int parentWidthMeasureSpec,  int parentHeightMeasureSpec){
    ViewGroup.LayoutParams lp=child.getLayoutParams();
    int childWidthMeasureSpec;
    int childHeightMeasureSpec;
    childWidthMeasureSpec=getChildMeasureSpec(parentWidthMeasureSpec,mPaddingLeft + mPaddingRight,lp.width);
    childHeightMeasureSpec=MeasureSpec.makeSafeMeasureSpec(MeasureSpec.getSize(parentHeightMeasureSpec),MeasureSpec.UNSPECIFIED);
    child.measure(childWidthMeasureSpec,childHeightMeasureSpec);
  }
  protected void measureChildWithMargins(  View child,  int parentWidthMeasureSpec,  int widthUsed,  int parentHeightMeasureSpec,  int heightUsed){
    final MarginLayoutParams lp=(MarginLayoutParams)child.getLayoutParams();
    final int childWidthMeasureSpec=getChildMeasureSpec(parentWidthMeasureSpec,mPaddingLeft + mPaddingRight + lp.leftMargin+ lp.rightMargin+ widthUsed,lp.width);
    final int childHeightMeasureSpec=MeasureSpec.makeSafeMeasureSpec(MeasureSpec.getSize(parentHeightMeasureSpec),MeasureSpec.UNSPECIFIED);
    child.measure(childWidthMeasureSpec,childHeightMeasureSpec);
  }
  public void requestLayout(){
    mIsLayoutDirty=true;
    super.requestLayout();
  }
}
