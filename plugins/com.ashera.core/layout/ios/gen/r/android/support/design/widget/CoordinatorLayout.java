package r.android.support.design.widget;
import r.android.graphics.Rect;
import r.android.graphics.drawable.Drawable;
import r.android.support.v4.view.GravityCompat;
import r.android.support.v4.view.ViewCompat;
import r.android.util.Log;
import r.android.view.Gravity;
import r.android.view.View;
import r.android.view.ViewGroup;
import r.android.view.ViewParent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CoordinatorLayout extends ViewGroup {
  static final String TAG="CoordinatorLayout";
  private static final int TYPE_ON_INTERCEPT=0;
  private static final int TYPE_ON_TOUCH=1;
  final Comparator<View> mLayoutDependencyComparator=new LayoutParamsComparator()
;
  private final List<View> mDependencySortedChildren=new ArrayList<View>();
  private final List<View> mTempDependenciesList=new ArrayList<>();
  private final Rect mTempRect1=new Rect();
  private final Rect mTempRect2=new Rect();
  private final Rect mTempRect3=new Rect();
  private boolean mIsAttachedToWindow;
  private int[] mKeylines;
  private boolean mNeedsPreDrawListener;
  private WindowInsetsCompat mLastInsets;
  private boolean mDrawStatusBarBackground;
  private int getKeyline(  int index){
    if (mKeylines == null) {
      Log.e(TAG,"No keylines defined for " + this + " - attempted index lookup "+ index);
      return 0;
    }
    if (index < 0 || index >= mKeylines.length) {
      Log.e(TAG,"Keyline index " + index + " out of range for "+ this);
      return 0;
    }
    return mKeylines[index];
  }
  private void prepareChildren(){
    mDependencySortedChildren.clear();
    for (int i=0, count=getChildCount(); i < count; i++) {
      final View child=getChildAt(i);
      final LayoutParams lp=getResolvedLayoutParams(child);
      lp.findAnchorView(this,child);
      mDependencySortedChildren.add(child);
    }
    selectionSort(mDependencySortedChildren,mLayoutDependencyComparator);
  }
  void getDescendantRect(  View descendant,  Rect out){
    ViewGroupUtils.getDescendantRect(this,descendant,out);
  }
  public void onMeasureChild(  View child,  int parentWidthMeasureSpec,  int widthUsed,  int parentHeightMeasureSpec,  int heightUsed){
    measureChildWithMargins(child,parentWidthMeasureSpec,widthUsed,parentHeightMeasureSpec,heightUsed);
  }
  protected void onMeasure(  int widthMeasureSpec,  int heightMeasureSpec){
    prepareChildren();
    ensurePreDrawListener();
    final int paddingLeft=getPaddingLeft();
    final int paddingTop=getPaddingTop();
    final int paddingRight=getPaddingRight();
    final int paddingBottom=getPaddingBottom();
    final int layoutDirection=ViewCompat.getLayoutDirection(this);
    final boolean isRtl=layoutDirection == ViewCompat.LAYOUT_DIRECTION_RTL;
    final int widthMode=MeasureSpec.getMode(widthMeasureSpec);
    final int widthSize=MeasureSpec.getSize(widthMeasureSpec);
    final int heightMode=MeasureSpec.getMode(heightMeasureSpec);
    final int heightSize=MeasureSpec.getSize(heightMeasureSpec);
    final int widthPadding=paddingLeft + paddingRight;
    final int heightPadding=paddingTop + paddingBottom;
    int widthUsed=getSuggestedMinimumWidth();
    int heightUsed=getSuggestedMinimumHeight();
    int childState=0;
    final boolean applyInsets=mLastInsets != null && ViewCompat.getFitsSystemWindows(this);
    final int childCount=mDependencySortedChildren.size();
    for (int i=0; i < childCount; i++) {
      final View child=mDependencySortedChildren.get(i);
      final LayoutParams lp=(LayoutParams)child.getLayoutParams();
      int keylineWidthUsed=0;
      if (lp.keyline >= 0 && widthMode != MeasureSpec.UNSPECIFIED) {
        final int keylinePos=getKeyline(lp.keyline);
        final int keylineGravity=GravityCompat.getAbsoluteGravity(resolveKeylineGravity(lp.gravity),layoutDirection) & Gravity.HORIZONTAL_GRAVITY_MASK;
        if ((keylineGravity == Gravity.LEFT && !isRtl) || (keylineGravity == Gravity.RIGHT && isRtl)) {
          keylineWidthUsed=Math.max(0,widthSize - paddingRight - keylinePos);
        }
 else         if ((keylineGravity == Gravity.RIGHT && !isRtl) || (keylineGravity == Gravity.LEFT && isRtl)) {
          keylineWidthUsed=Math.max(0,keylinePos - paddingLeft);
        }
      }
      int childWidthMeasureSpec=widthMeasureSpec;
      int childHeightMeasureSpec=heightMeasureSpec;
      if (applyInsets && !ViewCompat.getFitsSystemWindows(child)) {
        final int horizInsets=mLastInsets.getSystemWindowInsetLeft() + mLastInsets.getSystemWindowInsetRight();
        final int vertInsets=mLastInsets.getSystemWindowInsetTop() + mLastInsets.getSystemWindowInsetBottom();
        childWidthMeasureSpec=MeasureSpec.makeMeasureSpec(widthSize - horizInsets,widthMode);
        childHeightMeasureSpec=MeasureSpec.makeMeasureSpec(heightSize - vertInsets,heightMode);
      }
      final Behavior b=lp.getBehavior();
      if (b == null || !b.onMeasureChild(this,child,childWidthMeasureSpec,keylineWidthUsed,childHeightMeasureSpec,0)) {
        onMeasureChild(child,childWidthMeasureSpec,keylineWidthUsed,childHeightMeasureSpec,0);
      }
      widthUsed=Math.max(widthUsed,widthPadding + child.getMeasuredWidth() + lp.leftMargin+ lp.rightMargin);
      heightUsed=Math.max(heightUsed,heightPadding + child.getMeasuredHeight() + lp.topMargin+ lp.bottomMargin);
      childState=ViewCompat.combineMeasuredStates(childState,ViewCompat.getMeasuredState(child));
    }
    final int width=ViewCompat.resolveSizeAndState(widthUsed,widthMeasureSpec,childState & ViewCompat.MEASURED_STATE_MASK);
    final int height=ViewCompat.resolveSizeAndState(heightUsed,heightMeasureSpec,childState << ViewCompat.MEASURED_HEIGHT_STATE_SHIFT);
    setMeasuredDimension(width,height);
  }
  public void onLayoutChild(  View child,  int layoutDirection){
    final LayoutParams lp=(LayoutParams)child.getLayoutParams();
    if (lp.checkAnchorChanged()) {
      throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout" + " measurement begins before layout is complete.");
    }
    if (lp.mAnchorView != null) {
      layoutChildWithAnchor(child,lp.mAnchorView,layoutDirection);
    }
 else     if (lp.keyline >= 0) {
      layoutChildWithKeyline(child,lp.keyline,layoutDirection);
    }
 else {
      layoutChild(child,layoutDirection);
    }
  }
  protected void onLayout(  boolean changed,  int l,  int t,  int r,  int b){
    final int layoutDirection=ViewCompat.getLayoutDirection(this);
    final int childCount=mDependencySortedChildren.size();
    for (int i=0; i < childCount; i++) {
      final View child=mDependencySortedChildren.get(i);
      final LayoutParams lp=(LayoutParams)child.getLayoutParams();
      final Behavior behavior=lp.getBehavior();
      if (behavior == null || !behavior.onLayoutChild(this,child,layoutDirection)) {
        onLayoutChild(child,layoutDirection);
      }
    }
  }
  void recordLastChildRect(  View child,  Rect r){
    final LayoutParams lp=(LayoutParams)child.getLayoutParams();
    lp.setLastChildRect(r);
  }
  void getLastChildRect(  View child,  Rect out){
    final LayoutParams lp=(LayoutParams)child.getLayoutParams();
    out.set(lp.getLastChildRect());
  }
  void getChildRect(  View child,  boolean transform,  Rect out){
    if (child.isLayoutRequested() || child.getVisibility() == View.GONE) {
      out.set(0,0,0,0);
      return;
    }
    if (transform) {
      getDescendantRect(child,out);
    }
 else {
      out.set(child.getLeft(),child.getTop(),child.getRight(),child.getBottom());
    }
  }
  void getDesiredAnchoredChildRect(  View child,  int layoutDirection,  Rect anchorRect,  Rect out){
    final LayoutParams lp=(LayoutParams)child.getLayoutParams();
    final int absGravity=GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(lp.gravity),layoutDirection);
    final int absAnchorGravity=GravityCompat.getAbsoluteGravity(resolveGravity(lp.anchorGravity),layoutDirection);
    final int hgrav=absGravity & Gravity.HORIZONTAL_GRAVITY_MASK;
    final int vgrav=absGravity & Gravity.VERTICAL_GRAVITY_MASK;
    final int anchorHgrav=absAnchorGravity & Gravity.HORIZONTAL_GRAVITY_MASK;
    final int anchorVgrav=absAnchorGravity & Gravity.VERTICAL_GRAVITY_MASK;
    final int childWidth=child.getMeasuredWidth();
    final int childHeight=child.getMeasuredHeight();
    int left;
    int top;
switch (anchorHgrav) {
default :
case Gravity.LEFT:
      left=anchorRect.left;
    break;
case Gravity.RIGHT:
  left=anchorRect.right;
break;
case Gravity.CENTER_HORIZONTAL:
left=anchorRect.left + anchorRect.width() / 2;
break;
}
switch (anchorVgrav) {
default :
case Gravity.TOP:
top=anchorRect.top;
break;
case Gravity.BOTTOM:
top=anchorRect.bottom;
break;
case Gravity.CENTER_VERTICAL:
top=anchorRect.top + anchorRect.height() / 2;
break;
}
switch (hgrav) {
default :
case Gravity.LEFT:
left-=childWidth;
break;
case Gravity.RIGHT:
break;
case Gravity.CENTER_HORIZONTAL:
left-=childWidth / 2;
break;
}
switch (vgrav) {
default :
case Gravity.TOP:
top-=childHeight;
break;
case Gravity.BOTTOM:
break;
case Gravity.CENTER_VERTICAL:
top-=childHeight / 2;
break;
}
final int width=getWidth();
final int height=getHeight();
left=Math.max(getPaddingLeft() + lp.leftMargin,Math.min(left,width - getPaddingRight() - childWidth- lp.rightMargin));
top=Math.max(getPaddingTop() + lp.topMargin,Math.min(top,height - getPaddingBottom() - childHeight- lp.bottomMargin));
out.set(left,top,left + childWidth,top + childHeight);
}
private void layoutChildWithAnchor(View child,View anchor,int layoutDirection){
final LayoutParams lp=(LayoutParams)child.getLayoutParams();
final Rect anchorRect=mTempRect1;
final Rect childRect=mTempRect2;
getDescendantRect(anchor,anchorRect);
getDesiredAnchoredChildRect(child,layoutDirection,anchorRect,childRect);
child.layout(childRect.left,childRect.top,childRect.right,childRect.bottom);
}
private void layoutChildWithKeyline(View child,int keyline,int layoutDirection){
final LayoutParams lp=(LayoutParams)child.getLayoutParams();
final int absGravity=GravityCompat.getAbsoluteGravity(resolveKeylineGravity(lp.gravity),layoutDirection);
final int hgrav=absGravity & Gravity.HORIZONTAL_GRAVITY_MASK;
final int vgrav=absGravity & Gravity.VERTICAL_GRAVITY_MASK;
final int width=getWidth();
final int height=getHeight();
final int childWidth=child.getMeasuredWidth();
final int childHeight=child.getMeasuredHeight();
if (layoutDirection == ViewCompat.LAYOUT_DIRECTION_RTL) {
keyline=width - keyline;
}
int left=getKeyline(keyline) - childWidth;
int top=0;
switch (hgrav) {
default :
case Gravity.LEFT:
break;
case Gravity.RIGHT:
left+=childWidth;
break;
case Gravity.CENTER_HORIZONTAL:
left+=childWidth / 2;
break;
}
switch (vgrav) {
default :
case Gravity.TOP:
break;
case Gravity.BOTTOM:
top+=childHeight;
break;
case Gravity.CENTER_VERTICAL:
top+=childHeight / 2;
break;
}
left=Math.max(getPaddingLeft() + lp.leftMargin,Math.min(left,width - getPaddingRight() - childWidth- lp.rightMargin));
top=Math.max(getPaddingTop() + lp.topMargin,Math.min(top,height - getPaddingBottom() - childHeight- lp.bottomMargin));
child.layout(left,top,left + childWidth,top + childHeight);
}
private void layoutChild(View child,int layoutDirection){
final LayoutParams lp=(LayoutParams)child.getLayoutParams();
final Rect parent=mTempRect1;
parent.set(getPaddingLeft() + lp.leftMargin,getPaddingTop() + lp.topMargin,getWidth() - getPaddingRight() - lp.rightMargin,getHeight() - getPaddingBottom() - lp.bottomMargin);
if (mLastInsets != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(child)) {
parent.left+=mLastInsets.getSystemWindowInsetLeft();
parent.top+=mLastInsets.getSystemWindowInsetTop();
parent.right-=mLastInsets.getSystemWindowInsetRight();
parent.bottom-=mLastInsets.getSystemWindowInsetBottom();
}
final Rect out=mTempRect2;
GravityCompat.apply(resolveGravity(lp.gravity),child.getMeasuredWidth(),child.getMeasuredHeight(),parent,out,layoutDirection);
child.layout(out.left,out.top,out.right,out.bottom);
}
private static int resolveGravity(int gravity){
return gravity == Gravity.NO_GRAVITY ? GravityCompat.START | Gravity.TOP : gravity;
}
private static int resolveKeylineGravity(int gravity){
return gravity == Gravity.NO_GRAVITY ? GravityCompat.END | Gravity.TOP : gravity;
}
private static int resolveAnchoredChildGravity(int gravity){
return gravity == Gravity.NO_GRAVITY ? Gravity.CENTER : gravity;
}
void dispatchOnDependentViewChanged(final boolean fromNestedScroll){
final int layoutDirection=ViewCompat.getLayoutDirection(this);
final int childCount=mDependencySortedChildren.size();
for (int i=0; i < childCount; i++) {
final View child=mDependencySortedChildren.get(i);
final LayoutParams lp=(LayoutParams)child.getLayoutParams();
for (int j=0; j < i; j++) {
final View checkChild=mDependencySortedChildren.get(j);
if (lp.mAnchorDirectChild == checkChild) {
offsetChildToAnchor(child,layoutDirection);
}
}
final Rect oldRect=mTempRect1;
final Rect newRect=mTempRect2;
getLastChildRect(child,oldRect);
getChildRect(child,true,newRect);
if (oldRect.equals(newRect)) {
continue;
}
recordLastChildRect(child,newRect);
for (int j=i + 1; j < childCount; j++) {
final View checkChild=mDependencySortedChildren.get(j);
final LayoutParams checkLp=(LayoutParams)checkChild.getLayoutParams();
final Behavior b=checkLp.getBehavior();
if (b != null && b.layoutDependsOn(this,checkChild,child)) {
if (!fromNestedScroll && checkLp.getChangedAfterNestedScroll()) {
checkLp.resetChangedAfterNestedScroll();
continue;
}
final boolean handled=b.onDependentViewChanged(this,checkChild,child);
if (fromNestedScroll) {
checkLp.setChangedAfterNestedScroll(handled);
}
}
}
}
}
public void dispatchDependentViewsChanged(View view){
final int childCount=mDependencySortedChildren.size();
boolean viewSeen=false;
for (int i=0; i < childCount; i++) {
final View child=mDependencySortedChildren.get(i);
if (child == view) {
viewSeen=true;
continue;
}
if (viewSeen) {
CoordinatorLayout.LayoutParams lp=(CoordinatorLayout.LayoutParams)child.getLayoutParams();
CoordinatorLayout.Behavior b=lp.getBehavior();
if (b != null && lp.dependsOn(this,child,view)) {
b.onDependentViewChanged(this,child,view);
}
}
}
}
public List<View> getDependencies(View child){
final LayoutParams lp=(LayoutParams)child.getLayoutParams();
final List<View> list=mTempDependenciesList;
list.clear();
final int childCount=getChildCount();
for (int i=0; i < childCount; i++) {
final View other=getChildAt(i);
if (other == child) {
continue;
}
if (lp.dependsOn(this,child,other)) {
list.add(other);
}
}
return list;
}
void ensurePreDrawListener(){
boolean hasDependencies=false;
final int childCount=getChildCount();
for (int i=0; i < childCount; i++) {
final View child=getChildAt(i);
if (hasDependencies(child)) {
hasDependencies=true;
break;
}
}
if (hasDependencies != mNeedsPreDrawListener) {
if (hasDependencies) {
addPreDrawListener();
}
 else {
removePreDrawListener();
}
}
}
boolean hasDependencies(View child){
final LayoutParams lp=(LayoutParams)child.getLayoutParams();
if (lp.mAnchorView != null) {
return true;
}
final int childCount=getChildCount();
for (int i=0; i < childCount; i++) {
final View other=getChildAt(i);
if (other == child) {
continue;
}
if (lp.dependsOn(this,child,other)) {
return true;
}
}
return false;
}
void offsetChildToAnchor(View child,int layoutDirection){
final LayoutParams lp=(LayoutParams)child.getLayoutParams();
if (lp.mAnchorView != null) {
final Rect anchorRect=mTempRect1;
final Rect childRect=mTempRect2;
final Rect desiredChildRect=mTempRect3;
getDescendantRect(lp.mAnchorView,anchorRect);
getChildRect(child,false,childRect);
getDesiredAnchoredChildRect(child,layoutDirection,anchorRect,desiredChildRect);
final int dx=desiredChildRect.left - childRect.left;
final int dy=desiredChildRect.top - childRect.top;
if (dx != 0) {
child.offsetLeftAndRight(dx);
}
if (dy != 0) {
child.offsetTopAndBottom(dy);
}
if (dx != 0 || dy != 0) {
final Behavior b=lp.getBehavior();
if (b != null) {
b.onDependentViewChanged(this,child,lp.mAnchorView);
}
}
}
}
@com.google.j2objc.annotations.WeakOuter
private final class LayoutParamsComparator implements Comparator<View> {
	public int compare(    View lhs,    View rhs){
      if (lhs == rhs) {
        return 0;
      }
 else       if (((LayoutParams)lhs.getLayoutParams()).dependsOn(CoordinatorLayout.this,lhs,rhs)) {
        return 1;
      }
 else       if (((LayoutParams)rhs.getLayoutParams()).dependsOn(CoordinatorLayout.this,rhs,lhs)) {
        return -1;
      }
 else {
        return 0;
      }
    }
}
public static abstract class Behavior<V extends View> {
public Behavior(){
}
public boolean layoutDependsOn(CoordinatorLayout parent,V child,View dependency){
return false;
}
public boolean onDependentViewChanged(CoordinatorLayout parent,V child,View dependency){
return false;
}
public boolean onMeasureChild(CoordinatorLayout parent,V child,int parentWidthMeasureSpec,int widthUsed,int parentHeightMeasureSpec,int heightUsed){
return false;
}
public boolean onLayoutChild(CoordinatorLayout parent,V child,int layoutDirection){
return false;
}
}
public static class LayoutParams extends ViewGroup.MarginLayoutParams {
Behavior mBehavior;
boolean mBehaviorResolved=false;
public int gravity=Gravity.NO_GRAVITY;
public int anchorGravity=Gravity.NO_GRAVITY;
public int keyline=-1;
int mAnchorId=View.NO_ID;
View mAnchorView;
View mAnchorDirectChild;
private boolean mDidBlockInteraction;
private boolean mDidAcceptNestedScroll;
private boolean mDidChangeAfterNestedScroll;
final Rect mLastChildRect=new Rect();
Object mBehaviorTag;
public LayoutParams(int width,int height){
super(width,height);
}
public LayoutParams(LayoutParams p){
super(p);
}
public LayoutParams(ViewGroup.LayoutParams p){
super(p);
}
public Behavior getBehavior(){
return mBehavior;
}
public void setBehavior(Behavior behavior){
if (mBehavior != behavior) {
mBehavior=behavior;
mBehaviorTag=null;
mBehaviorResolved=true;
}
}
void setLastChildRect(Rect r){
mLastChildRect.set(r);
}
Rect getLastChildRect(){
return mLastChildRect;
}
boolean checkAnchorChanged(){
return mAnchorView == null && mAnchorId != View.NO_ID;
}
boolean getChangedAfterNestedScroll(){
return mDidChangeAfterNestedScroll;
}
void setChangedAfterNestedScroll(boolean changed){
mDidChangeAfterNestedScroll=changed;
}
void resetChangedAfterNestedScroll(){
mDidChangeAfterNestedScroll=false;
}
boolean dependsOn(CoordinatorLayout parent,View child,View dependency){
return dependency == mAnchorDirectChild || (mBehavior != null && mBehavior.layoutDependsOn(parent,child,dependency));
}
View findAnchorView(CoordinatorLayout parent,View forChild){
if (mAnchorId == View.NO_ID) {
mAnchorView=mAnchorDirectChild=null;
return null;
}
if (mAnchorView == null || !verifyAnchorView(forChild,parent)) {
resolveAnchorView(forChild,parent);
}
return mAnchorView;
}
private void resolveAnchorView(final View forChild,final CoordinatorLayout parent){
mAnchorView=parent.findViewById(mAnchorId);
if (mAnchorView != null) {
if (mAnchorView == parent) {
if (parent.isInEditMode()) {
mAnchorView=mAnchorDirectChild=null;
return;
}
throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
}
View directChild=mAnchorView;
for (ViewParent p=mAnchorView.getParent(); p != parent && p != null; p=p.getParent()) {
if (p == forChild) {
if (parent.isInEditMode()) {
mAnchorView=mAnchorDirectChild=null;
return;
}
throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
}
if (p instanceof View) {
directChild=(View)p;
}
}
mAnchorDirectChild=directChild;
}
 else {
if (parent.isInEditMode()) {
mAnchorView=mAnchorDirectChild=null;
return;
}
throw new IllegalStateException("Could not find CoordinatorLayout descendant view" + " with id " + parent.getResources().getResourceName(mAnchorId) + " to anchor view "+ forChild);
}
}
private boolean verifyAnchorView(View forChild,CoordinatorLayout parent){
if (mAnchorView.getId() != mAnchorId) {
return false;
}
View directChild=mAnchorView;
for (ViewParent p=mAnchorView.getParent(); p != parent; p=p.getParent()) {
if (p == null || p == forChild) {
mAnchorView=mAnchorDirectChild=null;
return false;
}
if (p instanceof View) {
directChild=(View)p;
}
}
mAnchorDirectChild=directChild;
return true;
}
}
private static void selectionSort(final List<View> list,final Comparator<View> comparator){
if (list == null || list.size() < 2) {
return;
}
final View[] array=new View[list.size()];
list.toArray(array);
final int count=array.length;
for (int i=0; i < count; i++) {
int min=i;
for (int j=i + 1; j < count; j++) {
if (comparator.compare(array[j],array[min]) < 0) {
min=j;
}
}
if (i != min) {
final View minItem=array[min];
array[min]=array[i];
array[i]=minItem;
}
}
list.clear();
for (int i=0; i < count; i++) {
list.add(array[i]);
}
}
LayoutParams getResolvedLayoutParams(View child){
final LayoutParams result=(LayoutParams)child.getLayoutParams();
result.mBehaviorResolved=true;
return result;
}
Resources getResources(){
return new Resources();
}
void addPreDrawListener(){
}
void removePreDrawListener(){
}
boolean isInEditMode(){
return false;
}
class WindowInsetsCompat {
public int getSystemWindowInsetLeft(){
return 0;
}
public int getSystemWindowInsetBottom(){
return 0;
}
public int getSystemWindowInsetTop(){
return 0;
}
public int getSystemWindowInsetRight(){
return 0;
}
}
class Resources {
public String getResourceName(int mAnchorId){
return "";
}
}
static class ViewGroupUtils {
public static void getDescendantRect(CoordinatorLayout coordinatorLayout,View descendant,Rect out){
}
}
}
