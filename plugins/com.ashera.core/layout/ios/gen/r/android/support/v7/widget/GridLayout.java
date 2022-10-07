package r.android.support.v7.widget;
import r.android.support.v4.view.ViewCompat;
import r.android.support.v4.view.ViewGroupCompat;
import r.android.util.Pair;
import r.android.view.Gravity;
import r.android.view.View;
import r.android.view.ViewGroup;
import r.android.widget.LinearLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static r.android.view.Gravity.*;
import static r.android.view.View.MeasureSpec.EXACTLY;
import static r.android.view.View.MeasureSpec.makeMeasureSpec;
import static java.lang.Math.max;
import static java.lang.Math.min;
public class GridLayout extends ViewGroup {
  public static final int HORIZONTAL=LinearLayout.HORIZONTAL;
  public static final int VERTICAL=LinearLayout.VERTICAL;
  public static final int UNDEFINED=Integer.MIN_VALUE;
  public static final int ALIGN_BOUNDS=0;
  public static final int ALIGN_MARGINS=1;
  static final int MAX_SIZE=100000;
  static final int DEFAULT_CONTAINER_MARGIN=0;
  static final int UNINITIALIZED_HASH=0;
  private static final int DEFAULT_ORIENTATION=HORIZONTAL;
  private static final int DEFAULT_COUNT=UNDEFINED;
  private static final boolean DEFAULT_USE_DEFAULT_MARGINS=false;
  private static final boolean DEFAULT_ORDER_PRESERVED=true;
  private static final int DEFAULT_ALIGNMENT_MODE=ALIGN_MARGINS;
  final Axis mHorizontalAxis=new Axis(true);
  final Axis mVerticalAxis=new Axis(false);
  int mOrientation=DEFAULT_ORIENTATION;
  boolean mUseDefaultMargins=DEFAULT_USE_DEFAULT_MARGINS;
  int mAlignmentMode=DEFAULT_ALIGNMENT_MODE;
  int mDefaultGap;
  int mLastLayoutParamsHashCode=UNINITIALIZED_HASH;
  public void setOrientation(  int orientation){
    if (this.mOrientation != orientation) {
      this.mOrientation=orientation;
      invalidateStructure();
      requestLayout();
    }
  }
  public void setRowCount(  int rowCount){
    mVerticalAxis.setCount(rowCount);
    invalidateStructure();
    requestLayout();
  }
  public void setColumnCount(  int columnCount){
    mHorizontalAxis.setCount(columnCount);
    invalidateStructure();
    requestLayout();
  }
  public void setUseDefaultMargins(  boolean useDefaultMargins){
    this.mUseDefaultMargins=useDefaultMargins;
    requestLayout();
  }
  public void setAlignmentMode(  int alignmentMode){
    this.mAlignmentMode=alignmentMode;
    requestLayout();
  }
  public void setRowOrderPreserved(  boolean rowOrderPreserved){
    mVerticalAxis.setOrderPreserved(rowOrderPreserved);
    invalidateStructure();
    requestLayout();
  }
  public void setColumnOrderPreserved(  boolean columnOrderPreserved){
    mHorizontalAxis.setOrderPreserved(columnOrderPreserved);
    invalidateStructure();
    requestLayout();
  }
  static int max2(  int[] a,  int valueIfEmpty){
    int result=valueIfEmpty;
    for (int i=0, N=a.length; i < N; i++) {
      result=Math.max(result,a[i]);
    }
    return result;
  }
  static <T>T[] append(  T[] a,  T[] b){
    T[] result=(T[])Array.newInstance(a.getClass().getComponentType(),a.length + b.length);
    System.arraycopy(a,0,result,0,a.length);
    System.arraycopy(b,0,result,a.length,b.length);
    return result;
  }
  private int getDefaultMargin(  View c,  boolean horizontal,  boolean leading){
    if (c.getClass() == r.android.support.v7.widget.Space.class) {
      return 0;
    }
    return mDefaultGap / 2;
  }
  private int getDefaultMargin(  View c,  boolean isAtEdge,  boolean horizontal,  boolean leading){
    return getDefaultMargin(c,horizontal,leading);
  }
  private int getDefaultMargin(  View c,  LayoutParams p,  boolean horizontal,  boolean leading){
    if (!mUseDefaultMargins) {
      return 0;
    }
    Spec spec=horizontal ? p.columnSpec : p.rowSpec;
    Axis axis=horizontal ? mHorizontalAxis : mVerticalAxis;
    Interval span=spec.span;
    boolean leading1=(horizontal && isLayoutRtlCompat()) ? !leading : leading;
    boolean isAtEdge=leading1 ? (span.min == 0) : (span.max == axis.getCount());
    return getDefaultMargin(c,isAtEdge,horizontal,leading);
  }
  int getMargin1(  View view,  boolean horizontal,  boolean leading){
    LayoutParams lp=getLayoutParams(view);
    int margin=horizontal ? (leading ? lp.leftMargin : lp.rightMargin) : (leading ? lp.topMargin : lp.bottomMargin);
    return margin == UNDEFINED ? getDefaultMargin(view,lp,horizontal,leading) : margin;
  }
  private boolean isLayoutRtlCompat(){
    return ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_RTL;
  }
  private int getMargin(  View view,  boolean horizontal,  boolean leading){
    if (mAlignmentMode == ALIGN_MARGINS) {
      return getMargin1(view,horizontal,leading);
    }
 else {
      Axis axis=horizontal ? mHorizontalAxis : mVerticalAxis;
      int[] margins=leading ? axis.getLeadingMargins() : axis.getTrailingMargins();
      LayoutParams lp=getLayoutParams(view);
      Spec spec=horizontal ? lp.columnSpec : lp.rowSpec;
      int index=leading ? spec.span.min : spec.span.max;
      return margins[index];
    }
  }
  private int getTotalMargin(  View child,  boolean horizontal){
    return getMargin(child,horizontal,true) + getMargin(child,horizontal,false);
  }
  private static boolean fits(  int[] a,  int value,  int start,  int end){
    if (end > a.length) {
      return false;
    }
    for (int i=start; i < end; i++) {
      if (a[i] > value) {
        return false;
      }
    }
    return true;
  }
  private static void procrusteanFill(  int[] a,  int start,  int end,  int value){
    int length=a.length;
    Arrays.fill(a,Math.min(start,length),Math.min(end,length),value);
  }
  private static void setCellGroup(  LayoutParams lp,  int row,  int rowSpan,  int col,  int colSpan){
    lp.setRowSpecSpan(new Interval(row,row + rowSpan));
    lp.setColumnSpecSpan(new Interval(col,col + colSpan));
  }
  private static int clip(  Interval minorRange,  boolean minorWasDefined,  int count){
    int size=minorRange.size();
    if (count == 0) {
      return size;
    }
    int min=minorWasDefined ? min(minorRange.min,count) : 0;
    return min(size,count - min);
  }
  private void validateLayoutParams(){
    final boolean horizontal=(mOrientation == HORIZONTAL);
    final Axis axis=horizontal ? mHorizontalAxis : mVerticalAxis;
    final int count=(axis.definedCount != UNDEFINED) ? axis.definedCount : 0;
    int major=0;
    int minor=0;
    int[] maxSizes=new int[count];
    for (int i=0, N=getChildCount(); i < N; i++) {
      LayoutParams lp=(LayoutParams)getChildAt(i).getLayoutParams();
      final Spec majorSpec=horizontal ? lp.rowSpec : lp.columnSpec;
      final Interval majorRange=majorSpec.span;
      final boolean majorWasDefined=majorSpec.startDefined;
      final int majorSpan=majorRange.size();
      if (majorWasDefined) {
        major=majorRange.min;
      }
      final Spec minorSpec=horizontal ? lp.columnSpec : lp.rowSpec;
      final Interval minorRange=minorSpec.span;
      final boolean minorWasDefined=minorSpec.startDefined;
      final int minorSpan=clip(minorRange,minorWasDefined,count);
      if (minorWasDefined) {
        minor=minorRange.min;
      }
      if (count != 0) {
        if (!majorWasDefined || !minorWasDefined) {
          while (!fits(maxSizes,major,minor,minor + minorSpan)) {
            if (minorWasDefined) {
              major++;
            }
 else {
              if (minor + minorSpan <= count) {
                minor++;
              }
 else {
                minor=0;
                major++;
              }
            }
          }
        }
        procrusteanFill(maxSizes,minor,minor + minorSpan,major + majorSpan);
      }
      if (horizontal) {
        setCellGroup(lp,major,majorSpan,minor,minorSpan);
      }
 else {
        setCellGroup(lp,minor,minorSpan,major,majorSpan);
      }
      minor=minor + minorSpan;
    }
  }
  private void invalidateStructure(){
    mLastLayoutParamsHashCode=UNINITIALIZED_HASH;
    if (mHorizontalAxis != null)     mHorizontalAxis.invalidateStructure();
    if (mVerticalAxis != null)     mVerticalAxis.invalidateStructure();
    invalidateValues();
  }
  private void invalidateValues(){
    if (mHorizontalAxis != null && mVerticalAxis != null) {
      mHorizontalAxis.invalidateValues();
      mVerticalAxis.invalidateValues();
    }
  }
  final LayoutParams getLayoutParams(  View c){
    return (LayoutParams)c.getLayoutParams();
  }
  private static void handleInvalidParams(  String msg){
    throw new IllegalArgumentException(msg + ". ");
  }
  private void checkLayoutParams(  LayoutParams lp,  boolean horizontal){
    String groupName=horizontal ? "column" : "row";
    Spec spec=horizontal ? lp.columnSpec : lp.rowSpec;
    Interval span=spec.span;
    if (span.min != UNDEFINED && span.min < 0) {
      handleInvalidParams(groupName + " indices must be positive");
    }
    Axis axis=horizontal ? mHorizontalAxis : mVerticalAxis;
    int count=axis.definedCount;
    if (count != UNDEFINED) {
      if (span.max > count) {
        handleInvalidParams(groupName + " indices (start + span) mustn't exceed the " + groupName+ " count");
      }
      if (span.size() > count) {
        handleInvalidParams(groupName + " span mustn't exceed the " + groupName+ " count");
      }
    }
  }
  protected boolean checkLayoutParams(  ViewGroup.LayoutParams p){
    if (!(p instanceof LayoutParams)) {
      return false;
    }
    LayoutParams lp=(LayoutParams)p;
    checkLayoutParams(lp,true);
    checkLayoutParams(lp,false);
    return true;
  }
  protected LayoutParams generateDefaultLayoutParams(){
    return new LayoutParams();
  }
  protected LayoutParams generateLayoutParams(  ViewGroup.LayoutParams p){
    return new LayoutParams(p);
  }
  private int computeLayoutParamsHashCode(){
    int result=1;
    for (int i=0, N=getChildCount(); i < N; i++) {
      View c=getChildAt(i);
      if (c.getVisibility() == View.GONE)       continue;
      LayoutParams lp=(LayoutParams)c.getLayoutParams();
      result=31 * result + lp.hashCode();
    }
    return result;
  }
  private void consistencyCheck(){
    if (mLastLayoutParamsHashCode == UNINITIALIZED_HASH) {
      validateLayoutParams();
      mLastLayoutParamsHashCode=computeLayoutParamsHashCode();
    }
 else     if (mLastLayoutParamsHashCode != computeLayoutParamsHashCode()) {
      mPrinter.println("The fields of some layout parameters were modified in between " + "layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
      invalidateStructure();
      consistencyCheck();
    }
  }
  private void measureChildWithMargins2(  View child,  int parentWidthSpec,  int parentHeightSpec,  int childWidth,  int childHeight){
    int childWidthSpec=getChildMeasureSpec(parentWidthSpec,getTotalMargin(child,true),childWidth);
    int childHeightSpec=getChildMeasureSpec(parentHeightSpec,getTotalMargin(child,false),childHeight);
    child.measure(childWidthSpec,childHeightSpec);
  }
  private void measureChildrenWithMargins(  int widthSpec,  int heightSpec,  boolean firstPass){
    for (int i=0, N=getChildCount(); i < N; i++) {
      View c=getChildAt(i);
      if (c.getVisibility() == View.GONE)       continue;
      LayoutParams lp=getLayoutParams(c);
      if (firstPass) {
        measureChildWithMargins2(c,widthSpec,heightSpec,lp.width,lp.height);
      }
 else {
        boolean horizontal=(mOrientation == HORIZONTAL);
        Spec spec=horizontal ? lp.columnSpec : lp.rowSpec;
        if (spec.getAbsoluteAlignment(horizontal) == FILL) {
          Interval span=spec.span;
          Axis axis=horizontal ? mHorizontalAxis : mVerticalAxis;
          int[] locations=axis.getLocations();
          int cellSize=locations[span.max] - locations[span.min];
          int viewSize=cellSize - getTotalMargin(c,horizontal);
          if (horizontal) {
            measureChildWithMargins2(c,widthSpec,heightSpec,viewSize,lp.height);
          }
 else {
            measureChildWithMargins2(c,widthSpec,heightSpec,lp.width,viewSize);
          }
        }
      }
    }
  }
  static int adjust(  int measureSpec,  int delta){
    return makeMeasureSpec(MeasureSpec.getSize(measureSpec + delta),MeasureSpec.getMode(measureSpec));
  }
  protected void onMeasure(  int widthSpec,  int heightSpec){
    consistencyCheck();
    invalidateValues();
    int hPadding=getPaddingLeft() + getPaddingRight();
    int vPadding=getPaddingTop() + getPaddingBottom();
    int widthSpecSansPadding=adjust(widthSpec,-hPadding);
    int heightSpecSansPadding=adjust(heightSpec,-vPadding);
    measureChildrenWithMargins(widthSpecSansPadding,heightSpecSansPadding,true);
    int widthSansPadding;
    int heightSansPadding;
    if (mOrientation == HORIZONTAL) {
      widthSansPadding=mHorizontalAxis.getMeasure(widthSpecSansPadding);
      measureChildrenWithMargins(widthSpecSansPadding,heightSpecSansPadding,false);
      heightSansPadding=mVerticalAxis.getMeasure(heightSpecSansPadding);
    }
 else {
      heightSansPadding=mVerticalAxis.getMeasure(heightSpecSansPadding);
      measureChildrenWithMargins(widthSpecSansPadding,heightSpecSansPadding,false);
      widthSansPadding=mHorizontalAxis.getMeasure(widthSpecSansPadding);
    }
    int measuredWidth=Math.max(widthSansPadding + hPadding,getSuggestedMinimumWidth());
    int measuredHeight=Math.max(heightSansPadding + vPadding,getSuggestedMinimumHeight());
    setMeasuredDimension(ViewCompat.resolveSizeAndState(measuredWidth,widthSpec,0),ViewCompat.resolveSizeAndState(measuredHeight,heightSpec,0));
  }
  private int getMeasurement(  View c,  boolean horizontal){
    return horizontal ? c.getMeasuredWidth() : c.getMeasuredHeight();
  }
  final int getMeasurementIncludingMargin(  View c,  boolean horizontal){
    if (c.getVisibility() == View.GONE) {
      return 0;
    }
    return getMeasurement(c,horizontal) + getTotalMargin(c,horizontal);
  }
  public void requestLayout(){
    super.requestLayout();
    invalidateStructure();
  }
  protected void onLayout(  boolean changed,  int left,  int top,  int right,  int bottom){
    consistencyCheck();
    int targetWidth=right - left;
    int targetHeight=bottom - top;
    int paddingLeft=getPaddingLeft();
    int paddingTop=getPaddingTop();
    int paddingRight=getPaddingRight();
    int paddingBottom=getPaddingBottom();
    mHorizontalAxis.layout(targetWidth - paddingLeft - paddingRight);
    mVerticalAxis.layout(targetHeight - paddingTop - paddingBottom);
    int[] hLocations=mHorizontalAxis.getLocations();
    int[] vLocations=mVerticalAxis.getLocations();
    for (int i=0, N=getChildCount(); i < N; i++) {
      View c=getChildAt(i);
      if (c.getVisibility() == View.GONE)       continue;
      LayoutParams lp=getLayoutParams(c);
      Spec columnSpec=lp.columnSpec;
      Spec rowSpec=lp.rowSpec;
      Interval colSpan=columnSpec.span;
      Interval rowSpan=rowSpec.span;
      int x1=hLocations[colSpan.min];
      int y1=vLocations[rowSpan.min];
      int x2=hLocations[colSpan.max];
      int y2=vLocations[rowSpan.max];
      int cellWidth=x2 - x1;
      int cellHeight=y2 - y1;
      int pWidth=getMeasurement(c,true);
      int pHeight=getMeasurement(c,false);
      Alignment hAlign=columnSpec.getAbsoluteAlignment(true);
      Alignment vAlign=rowSpec.getAbsoluteAlignment(false);
      Bounds boundsX=mHorizontalAxis.getGroupBounds().getValue(i);
      Bounds boundsY=mVerticalAxis.getGroupBounds().getValue(i);
      int gravityOffsetX=hAlign.getGravityOffset(c,cellWidth - boundsX.size(true));
      int gravityOffsetY=vAlign.getGravityOffset(c,cellHeight - boundsY.size(true));
      int leftMargin=getMargin(c,true,true);
      int topMargin=getMargin(c,false,true);
      int rightMargin=getMargin(c,true,false);
      int bottomMargin=getMargin(c,false,false);
      int sumMarginsX=leftMargin + rightMargin;
      int sumMarginsY=topMargin + bottomMargin;
      int alignmentOffsetX=boundsX.getOffset(this,c,hAlign,pWidth + sumMarginsX,true);
      int alignmentOffsetY=boundsY.getOffset(this,c,vAlign,pHeight + sumMarginsY,false);
      int width=hAlign.getSizeInCell(c,pWidth,cellWidth - sumMarginsX);
      int height=vAlign.getSizeInCell(c,pHeight,cellHeight - sumMarginsY);
      int dx=x1 + gravityOffsetX + alignmentOffsetX;
      int cx=!isLayoutRtlCompat() ? paddingLeft + leftMargin + dx : targetWidth - width - paddingRight- rightMargin- dx;
      int cy=paddingTop + y1 + gravityOffsetY+ alignmentOffsetY+ topMargin;
      if (width != c.getMeasuredWidth() || height != c.getMeasuredHeight()) {
        c.measure(makeMeasureSpec(width,EXACTLY),makeMeasureSpec(height,EXACTLY));
      }
      c.layout(cx,cy,cx + width,cy + height);
    }
  }
final class Axis {
    private static final int NEW=0;
    private static final int PENDING=1;
    private static final int COMPLETE=2;
    public final boolean horizontal;
    public int definedCount=UNDEFINED;
    private int maxIndex=UNDEFINED;
    PackedMap<Spec,Bounds> groupBounds;
    public boolean groupBoundsValid=false;
    PackedMap<Interval,MutableInt> forwardLinks;
    public boolean forwardLinksValid=false;
    PackedMap<Interval,MutableInt> backwardLinks;
    public boolean backwardLinksValid=false;
    public int[] leadingMargins;
    public boolean leadingMarginsValid=false;
    public int[] trailingMargins;
    public boolean trailingMarginsValid=false;
    public Arc[] arcs;
    public boolean arcsValid=false;
    public int[] locations;
    public boolean locationsValid=false;
    public boolean hasWeights;
    public boolean hasWeightsValid=false;
    public int[] deltas;
    boolean orderPreserved=DEFAULT_ORDER_PRESERVED;
    private MutableInt parentMin=new MutableInt(0);
    private MutableInt parentMax=new MutableInt(-MAX_SIZE);
    private Axis(    boolean horizontal){
      this.horizontal=horizontal;
    }
    private int calculateMaxIndex(){
      int result=-1;
      for (int i=0, N=getChildCount(); i < N; i++) {
        View c=getChildAt(i);
        LayoutParams params=getLayoutParams(c);
        Spec spec=horizontal ? params.columnSpec : params.rowSpec;
        Interval span=spec.span;
        result=max(result,span.min);
        result=max(result,span.max);
        result=max(result,span.size());
      }
      return result == -1 ? UNDEFINED : result;
    }
    private int getMaxIndex(){
      if (maxIndex == UNDEFINED) {
        maxIndex=max(0,calculateMaxIndex());
      }
      return maxIndex;
    }
    public int getCount(){
      return max(definedCount,getMaxIndex());
    }
    public void setCount(    int count){
      if (count != UNDEFINED && count < getMaxIndex()) {
        handleInvalidParams((horizontal ? "column" : "row") + "Count must be greater than or equal to the maximum of all grid indices " + "(and spans) defined in the LayoutParams of each child");
      }
      this.definedCount=count;
    }
    public boolean isOrderPreserved(){
      return orderPreserved;
    }
    public void setOrderPreserved(    boolean orderPreserved){
      this.orderPreserved=orderPreserved;
      invalidateStructure();
    }
    private PackedMap<Spec,Bounds> createGroupBounds(){
      Assoc<Spec,Bounds> assoc=Assoc.of(Spec.class,Bounds.class);
      for (int i=0, N=getChildCount(); i < N; i++) {
        View c=getChildAt(i);
        LayoutParams lp=getLayoutParams(c);
        Spec spec=horizontal ? lp.columnSpec : lp.rowSpec;
        Bounds bounds=spec.getAbsoluteAlignment(horizontal).getBounds();
        assoc.put(spec,bounds);
      }
      return assoc.pack();
    }
    private void computeGroupBounds(){
      Bounds[] values=groupBounds.values;
      for (int i=0; i < values.length; i++) {
        values[i].reset();
      }
      for (int i=0, N=getChildCount(); i < N; i++) {
        View c=getChildAt(i);
        LayoutParams lp=getLayoutParams(c);
        Spec spec=horizontal ? lp.columnSpec : lp.rowSpec;
        int size=getMeasurementIncludingMargin(c,horizontal) + ((spec.weight == 0) ? 0 : getDeltas()[i]);
        groupBounds.getValue(i).include(GridLayout.this,c,spec,this,size);
      }
    }
    public PackedMap<Spec,Bounds> getGroupBounds(){
      if (groupBounds == null) {
        groupBounds=createGroupBounds();
      }
      if (!groupBoundsValid) {
        computeGroupBounds();
        groupBoundsValid=true;
      }
      return groupBounds;
    }
    private PackedMap<Interval,MutableInt> createLinks(    boolean min){
      Assoc<Interval,MutableInt> result=Assoc.of(Interval.class,MutableInt.class);
      Spec[] keys=getGroupBounds().keys;
      for (int i=0, N=keys.length; i < N; i++) {
        Interval span=min ? keys[i].span : keys[i].span.inverse();
        result.put(span,new MutableInt());
      }
      return result.pack();
    }
    private void computeLinks(    PackedMap<Interval,MutableInt> links,    boolean min){
      MutableInt[] spans=links.values;
      for (int i=0; i < spans.length; i++) {
        spans[i].reset();
      }
      Bounds[] bounds=getGroupBounds().values;
      for (int i=0; i < bounds.length; i++) {
        int size=bounds[i].size(min);
        MutableInt valueHolder=links.getValue(i);
        valueHolder.value=max(valueHolder.value,min ? size : -size);
      }
    }
    private PackedMap<Interval,MutableInt> getForwardLinks(){
      if (forwardLinks == null) {
        forwardLinks=createLinks(true);
      }
      if (!forwardLinksValid) {
        computeLinks(forwardLinks,true);
        forwardLinksValid=true;
      }
      return forwardLinks;
    }
    private PackedMap<Interval,MutableInt> getBackwardLinks(){
      if (backwardLinks == null) {
        backwardLinks=createLinks(false);
      }
      if (!backwardLinksValid) {
        computeLinks(backwardLinks,false);
        backwardLinksValid=true;
      }
      return backwardLinks;
    }
    private void include(    List<Arc> arcs,    Interval key,    MutableInt size,    boolean ignoreIfAlreadyPresent){
      if (key.size() == 0) {
        return;
      }
      if (ignoreIfAlreadyPresent) {
        for (        Arc arc : arcs) {
          Interval span=arc.span;
          if (span.equals(key)) {
            return;
          }
        }
      }
      arcs.add(new Arc(key,size));
    }
    private void include(    List<Arc> arcs,    Interval key,    MutableInt size){
      include(arcs,key,size,true);
    }
    Arc[][] groupArcsByFirstVertex(    Arc[] arcs){
      int N=getCount() + 1;
      Arc[][] result=new Arc[N][];
      int[] sizes=new int[N];
      for (      Arc arc : arcs) {
        sizes[arc.span.min]++;
      }
      for (int i=0; i < sizes.length; i++) {
        result[i]=new Arc[sizes[i]];
      }
      Arrays.fill(sizes,0);
      for (      Arc arc : arcs) {
        int i=arc.span.min;
        result[i][sizes[i]++]=arc;
      }
      return result;
    }
    private Arc[] topologicalSort(    final Arc[] arcs){
      return new Object(){
        Arc[] result=new Arc[arcs.length];
        int cursor=result.length - 1;
        Arc[][] arcsByVertex=groupArcsByFirstVertex(arcs);
        int[] visited=new int[getCount() + 1];
        void walk(        int loc){
switch (visited[loc]) {
case NEW:
{
              visited[loc]=PENDING;
              for (              Arc arc : arcsByVertex[loc]) {
                walk(arc.span.max);
                result[cursor--]=arc;
              }
              visited[loc]=COMPLETE;
              break;
            }
case PENDING:
{
            assert false;
            break;
          }
case COMPLETE:
{
          break;
        }
    }
  }
  Arc[] sort(){
    for (int loc=0, N=arcsByVertex.length; loc < N; loc++) {
      walk(loc);
    }
    assert cursor == -1;
    return result;
  }
}
.sort();
}
private Arc[] topologicalSort(List<Arc> arcs){
return topologicalSort(arcs.toArray(new Arc[arcs.size()]));
}
private void addComponentSizes(List<Arc> result,PackedMap<Interval,MutableInt> links){
for (int i=0; i < links.keys.length; i++) {
  Interval key=links.keys[i];
  include(result,key,links.values[i],false);
}
}
private Arc[] createArcs(){
List<Arc> mins=new ArrayList<Arc>();
List<Arc> maxs=new ArrayList<Arc>();
addComponentSizes(mins,getForwardLinks());
addComponentSizes(maxs,getBackwardLinks());
if (orderPreserved) {
  for (int i=0; i < getCount(); i++) {
    include(mins,new Interval(i,i + 1),new MutableInt(0));
  }
}
int N=getCount();
include(mins,new Interval(0,N),parentMin,false);
include(maxs,new Interval(N,0),parentMax,false);
Arc[] sMins=topologicalSort(mins);
Arc[] sMaxs=topologicalSort(maxs);
return append(sMins,sMaxs);
}
private void computeArcs(){
getForwardLinks();
getBackwardLinks();
}
public Arc[] getArcs(){
if (arcs == null) {
  arcs=createArcs();
}
if (!arcsValid) {
  computeArcs();
  arcsValid=true;
}
return arcs;
}
private boolean relax(int[] locations,Arc entry){
if (!entry.valid) {
  return false;
}
Interval span=entry.span;
int u=span.min;
int v=span.max;
int value=entry.value.value;
int candidate=locations[u] + value;
if (candidate > locations[v]) {
  locations[v]=candidate;
  return true;
}
return false;
}
private void init(int[] locations){
Arrays.fill(locations,0);
}
private String arcsToString(List<Arc> arcs){
String var=horizontal ? "x" : "y";
StringBuilder result=new StringBuilder();
boolean first=true;
for (Arc arc : arcs) {
  if (first) {
    first=false;
  }
 else {
    result=result.append(", ");
  }
  int src=arc.span.min;
  int dst=arc.span.max;
  int value=arc.value.value;
  result.append((src < dst) ? var + dst + "-"+ var+ src+ ">="+ value : var + src + "-"+ var+ dst+ "<="+ -value);
}
return result.toString();
}
private void logError(String axisName,Arc[] arcs,boolean[] culprits0){
List<Arc> culprits=new ArrayList<Arc>();
List<Arc> removed=new ArrayList<Arc>();
for (int c=0; c < arcs.length; c++) {
  Arc arc=arcs[c];
  if (culprits0[c]) {
    culprits.add(arc);
  }
  if (!arc.valid) {
    removed.add(arc);
  }
}
mPrinter.println(axisName + " constraints: " + arcsToString(culprits)+ " are inconsistent; permanently removing: "+ arcsToString(removed)+ ". ");
}
private boolean solve(Arc[] arcs,int[] locations){
return solve(arcs,locations,true);
}
private boolean solve(Arc[] arcs,int[] locations,boolean modifyOnError){
String axisName=horizontal ? "horizontal" : "vertical";
int N=getCount() + 1;
boolean[] originalCulprits=null;
for (int p=0; p < arcs.length; p++) {
  init(locations);
  for (int i=0; i < N; i++) {
    boolean changed=false;
    for (int j=0, length=arcs.length; j < length; j++) {
      changed|=relax(locations,arcs[j]);
    }
    if (!changed) {
      if (originalCulprits != null) {
        logError(axisName,arcs,originalCulprits);
      }
      return true;
    }
  }
  if (!modifyOnError) {
    return false;
  }
  boolean[] culprits=new boolean[arcs.length];
  for (int i=0; i < N; i++) {
    for (int j=0, length=arcs.length; j < length; j++) {
      culprits[j]|=relax(locations,arcs[j]);
    }
  }
  if (p == 0) {
    originalCulprits=culprits;
  }
  for (int i=0; i < arcs.length; i++) {
    if (culprits[i]) {
      Arc arc=arcs[i];
      if (arc.span.min < arc.span.max) {
        continue;
      }
      arc.valid=false;
      break;
    }
  }
}
return true;
}
private void computeMargins(boolean leading){
int[] margins=leading ? leadingMargins : trailingMargins;
for (int i=0, N=getChildCount(); i < N; i++) {
  View c=getChildAt(i);
  if (c.getVisibility() == View.GONE)   continue;
  LayoutParams lp=getLayoutParams(c);
  Spec spec=horizontal ? lp.columnSpec : lp.rowSpec;
  Interval span=spec.span;
  int index=leading ? span.min : span.max;
  margins[index]=max(margins[index],getMargin1(c,horizontal,leading));
}
}
public int[] getLeadingMargins(){
if (leadingMargins == null) {
  leadingMargins=new int[getCount() + 1];
}
if (!leadingMarginsValid) {
  computeMargins(true);
  leadingMarginsValid=true;
}
return leadingMargins;
}
public int[] getTrailingMargins(){
if (trailingMargins == null) {
  trailingMargins=new int[getCount() + 1];
}
if (!trailingMarginsValid) {
  computeMargins(false);
  trailingMarginsValid=true;
}
return trailingMargins;
}
private boolean solve(int[] a){
return solve(getArcs(),a);
}
private boolean computeHasWeights(){
for (int i=0, N=getChildCount(); i < N; i++) {
  final View child=getChildAt(i);
  if (child.getVisibility() == View.GONE) {
    continue;
  }
  LayoutParams lp=getLayoutParams(child);
  Spec spec=horizontal ? lp.columnSpec : lp.rowSpec;
  if (spec.weight != 0) {
    return true;
  }
}
return false;
}
private boolean hasWeights(){
if (!hasWeightsValid) {
  hasWeights=computeHasWeights();
  hasWeightsValid=true;
}
return hasWeights;
}
public int[] getDeltas(){
if (deltas == null) {
  deltas=new int[getChildCount()];
}
return deltas;
}
private void shareOutDelta(int totalDelta,float totalWeight){
Arrays.fill(deltas,0);
for (int i=0, N=getChildCount(); i < N; i++) {
  final View c=getChildAt(i);
  if (c.getVisibility() == View.GONE) {
    continue;
  }
  LayoutParams lp=getLayoutParams(c);
  Spec spec=horizontal ? lp.columnSpec : lp.rowSpec;
  float weight=spec.weight;
  if (weight != 0) {
    int delta=Math.round((weight * totalDelta / totalWeight));
    deltas[i]=delta;
    totalDelta-=delta;
    totalWeight-=weight;
  }
}
}
private void solveAndDistributeSpace(int[] a){
Arrays.fill(getDeltas(),0);
solve(a);
int deltaMax=parentMin.value * getChildCount() + 1;
if (deltaMax < 2) {
  return;
}
int deltaMin=0;
float totalWeight=calculateTotalWeight();
int validDelta=-1;
boolean validSolution=true;
while (deltaMin < deltaMax) {
  final int delta=(int)(((long)deltaMin + deltaMax) / 2);
  invalidateValues();
  shareOutDelta(delta,totalWeight);
  validSolution=solve(getArcs(),a,false);
  if (validSolution) {
    validDelta=delta;
    deltaMin=delta + 1;
  }
 else {
    deltaMax=delta;
  }
}
if (validDelta > 0 && !validSolution) {
  invalidateValues();
  shareOutDelta(validDelta,totalWeight);
  solve(a);
}
}
private float calculateTotalWeight(){
float totalWeight=0f;
for (int i=0, N=getChildCount(); i < N; i++) {
  View c=getChildAt(i);
  if (c.getVisibility() == View.GONE) {
    continue;
  }
  LayoutParams lp=getLayoutParams(c);
  Spec spec=horizontal ? lp.columnSpec : lp.rowSpec;
  totalWeight+=spec.weight;
}
return totalWeight;
}
private void computeLocations(int[] a){
if (!hasWeights()) {
  solve(a);
}
 else {
  solveAndDistributeSpace(a);
}
if (!orderPreserved) {
  int a0=a[0];
  for (int i=0, N=a.length; i < N; i++) {
    a[i]=a[i] - a0;
  }
}
}
public int[] getLocations(){
if (locations == null) {
  int N=getCount() + 1;
  locations=new int[N];
}
if (!locationsValid) {
  computeLocations(locations);
  locationsValid=true;
}
return locations;
}
private int size(int[] locations){
return locations[getCount()];
}
private void setParentConstraints(int min,int max){
parentMin.value=min;
parentMax.value=-max;
locationsValid=false;
}
private int getMeasure(int min,int max){
setParentConstraints(min,max);
return size(getLocations());
}
public int getMeasure(int measureSpec){
int mode=MeasureSpec.getMode(measureSpec);
int size=MeasureSpec.getSize(measureSpec);
switch (mode) {
case MeasureSpec.UNSPECIFIED:
{
    return getMeasure(0,MAX_SIZE);
  }
case MeasureSpec.EXACTLY:
{
  return getMeasure(size,size);
}
case MeasureSpec.AT_MOST:
{
return getMeasure(0,size);
}
default :
{
assert false;
return 0;
}
}
}
public void layout(int size){
setParentConstraints(size,size);
getLocations();
}
public void invalidateStructure(){
maxIndex=UNDEFINED;
groupBounds=null;
forwardLinks=null;
backwardLinks=null;
leadingMargins=null;
trailingMargins=null;
arcs=null;
locations=null;
deltas=null;
hasWeightsValid=false;
invalidateValues();
}
public void invalidateValues(){
groupBoundsValid=false;
forwardLinksValid=false;
backwardLinksValid=false;
leadingMarginsValid=false;
trailingMarginsValid=false;
arcsValid=false;
locationsValid=false;
}
}
public static class LayoutParams extends MarginLayoutParams {
private static final int DEFAULT_WIDTH=WRAP_CONTENT;
private static final int DEFAULT_HEIGHT=WRAP_CONTENT;
private static final int DEFAULT_MARGIN=UNDEFINED;
private static final int DEFAULT_ROW=UNDEFINED;
private static final int DEFAULT_COLUMN=UNDEFINED;
private static final Interval DEFAULT_SPAN=new Interval(UNDEFINED,UNDEFINED + 1);
private static final int DEFAULT_SPAN_SIZE=DEFAULT_SPAN.size();
public Spec rowSpec=Spec.UNDEFINED;
public Spec columnSpec=Spec.UNDEFINED;
private LayoutParams(int width,int height,int left,int top,int right,int bottom,Spec rowSpec,Spec columnSpec){
super(width,height);
setMargins(left,top,right,bottom);
this.rowSpec=rowSpec;
this.columnSpec=columnSpec;
}
public LayoutParams(Spec rowSpec,Spec columnSpec){
this(DEFAULT_WIDTH,DEFAULT_HEIGHT,DEFAULT_MARGIN,DEFAULT_MARGIN,DEFAULT_MARGIN,DEFAULT_MARGIN,rowSpec,columnSpec);
}
public LayoutParams(){
this(Spec.UNDEFINED,Spec.UNDEFINED);
}
public LayoutParams(ViewGroup.LayoutParams params){
super(params);
}
public LayoutParams(LayoutParams source){
super(source);
this.rowSpec=source.rowSpec;
this.columnSpec=source.columnSpec;
}
final void setRowSpecSpan(Interval span){
rowSpec=rowSpec.copyWriteSpan(span);
}
final void setColumnSpecSpan(Interval span){
columnSpec=columnSpec.copyWriteSpan(span);
}
}
final static class Arc {
public final Interval span;
public final MutableInt value;
public boolean valid=true;
public Arc(Interval span,MutableInt value){
this.span=span;
this.value=value;
}
public String toString(){
return span + " " + (!valid ? "+>" : "->")+ " "+ value;
}
}
final static class MutableInt {
public int value;
public MutableInt(){
reset();
}
public MutableInt(int value){
this.value=value;
}
public void reset(){
value=Integer.MIN_VALUE;
}
public String toString(){
return Integer.toString(value);
}
}
final static class Assoc<K,V> extends ArrayList<Pair<K,V>> {
private final Class<K> keyType;
private final Class<V> valueType;
private Assoc(Class<K> keyType,Class<V> valueType){
this.keyType=keyType;
this.valueType=valueType;
}
public static <K,V>Assoc<K,V> of(Class<K> keyType,Class<V> valueType){
return new Assoc<K,V>(keyType,valueType);
}
public void put(K key,V value){
add(Pair.create(key,value));
}
public PackedMap<K,V> pack(){
int N=size();
K[] keys=(K[])Array.newInstance(keyType,N);
V[] values=(V[])Array.newInstance(valueType,N);
for (int i=0; i < N; i++) {
keys[i]=get(i).first;
values[i]=get(i).second;
}
return new PackedMap<K,V>(keys,values);
}
}
final static class PackedMap<K,V> {
public final int[] index;
public final K[] keys;
public final V[] values;
private PackedMap(K[] keys,V[] values){
this.index=createIndex(keys);
this.keys=compact(keys,index);
this.values=compact(values,index);
}
public V getValue(int i){
return values[index[i]];
}
private static <K>int[] createIndex(K[] keys){
int size=keys.length;
int[] result=new int[size];
Map<K,Integer> keyToIndex=new HashMap<K,Integer>();
for (int i=0; i < size; i++) {
K key=keys[i];
Integer index=keyToIndex.get(key);
if (index == null) {
index=keyToIndex.size();
keyToIndex.put(key,index);
}
result[i]=index;
}
return result;
}
private static <K>K[] compact(K[] a,int[] index){
int size=a.length;
Class<?> componentType=a.getClass().getComponentType();
K[] result=(K[])Array.newInstance(componentType,max2(index,-1) + 1);
for (int i=0; i < size; i++) {
result[index[i]]=a[i];
}
return result;
}
}
static class Bounds {
public int before;
public int after;
public int flexibility;
private Bounds(){
reset();
}
protected void reset(){
before=Integer.MIN_VALUE;
after=Integer.MIN_VALUE;
flexibility=CAN_STRETCH;
}
protected void include(int before,int after){
this.before=max(this.before,before);
this.after=max(this.after,after);
}
protected int size(boolean min){
if (!min) {
if (canStretch(flexibility)) {
return MAX_SIZE;
}
}
return before + after;
}
protected int getOffset(GridLayout gl,View c,Alignment a,int size,boolean horizontal){
return before - a.getAlignmentValue(c,size,ViewGroupCompat.getLayoutMode(gl));
}
protected final void include(GridLayout gl,View c,Spec spec,Axis axis,int size){
this.flexibility&=spec.getFlexibility();
boolean horizontal=axis.horizontal;
Alignment alignment=spec.getAbsoluteAlignment(horizontal);
int before=alignment.getAlignmentValue(c,size,ViewGroupCompat.getLayoutMode(gl));
include(before,size - before);
}
public String toString(){
return "Bounds{" + "before=" + before + ", after="+ after+ '}';
}
}
final static class Interval {
public final int min;
public final int max;
public Interval(int min,int max){
this.min=min;
this.max=max;
}
int size(){
return max - min;
}
Interval inverse(){
return new Interval(max,min);
}
public boolean equals(Object that){
if (this == that) {
return true;
}
if (that == null || getClass() != that.getClass()) {
return false;
}
Interval interval=(Interval)that;
if (max != interval.max) {
return false;
}
if (min != interval.min) {
return false;
}
return true;
}
public int hashCode(){
int result=min;
result=31 * result + max;
return result;
}
public String toString(){
return "[" + min + ", "+ max+ "]";
}
}
public static class Spec {
static final Spec UNDEFINED=spec(GridLayout.UNDEFINED);
static final float DEFAULT_WEIGHT=0;
final boolean startDefined;
final Interval span;
final Alignment alignment;
final float weight;
private Spec(boolean startDefined,Interval span,Alignment alignment,float weight){
this.startDefined=startDefined;
this.span=span;
this.alignment=alignment;
this.weight=weight;
}
private Spec(boolean startDefined,int start,int size,Alignment alignment,float weight){
this(startDefined,new Interval(start,start + size),alignment,weight);
}
public Alignment getAbsoluteAlignment(boolean horizontal){
if (alignment != UNDEFINED_ALIGNMENT) {
return alignment;
}
if (weight == 0f) {
return horizontal ? START : BASELINE;
}
return FILL;
}
final Spec copyWriteSpan(Interval span){
return new Spec(startDefined,span,alignment,weight);
}
final Spec copyWriteAlignment(Alignment alignment){
return new Spec(startDefined,span,alignment,weight);
}
final int getFlexibility(){
return (alignment == UNDEFINED_ALIGNMENT && weight == 0) ? INFLEXIBLE : CAN_STRETCH;
}
public boolean equals(Object that){
if (this == that) {
return true;
}
if (that == null || getClass() != that.getClass()) {
return false;
}
Spec spec=(Spec)that;
if (!alignment.equals(spec.alignment)) {
return false;
}
if (!span.equals(spec.span)) {
return false;
}
return true;
}
public int hashCode(){
int result=span.hashCode();
result=31 * result + alignment.hashCode();
return result;
}
}
public static Spec spec(int start,int size,Alignment alignment,float weight){
return new Spec(start != UNDEFINED,start,size,alignment,weight);
}
public static Spec spec(int start,Alignment alignment,float weight){
return spec(start,1,alignment,weight);
}
public static Spec spec(int start,int size,float weight){
return spec(start,size,UNDEFINED_ALIGNMENT,weight);
}
public static Spec spec(int start,float weight){
return spec(start,1,weight);
}
public static Spec spec(int start,int size,Alignment alignment){
return spec(start,size,alignment,Spec.DEFAULT_WEIGHT);
}
public static Spec spec(int start,Alignment alignment){
return spec(start,1,alignment);
}
public static Spec spec(int start,int size){
return spec(start,size,UNDEFINED_ALIGNMENT);
}
public static Spec spec(int start){
return spec(start,1);
}
public static abstract class Alignment {
Alignment(){
}
abstract int getGravityOffset(View view,int cellDelta);
abstract int getAlignmentValue(View view,int viewSize,int mode);
int getSizeInCell(View view,int viewSize,int cellSize){
return viewSize;
}
Bounds getBounds(){
return new Bounds();
}
abstract String getDebugString();
public String toString(){
return "Alignment:" + getDebugString();
}
}
static final Alignment UNDEFINED_ALIGNMENT=new Alignment(){
int getGravityOffset(View view,int cellDelta){
return UNDEFINED;
}
public int getAlignmentValue(View view,int viewSize,int mode){
return UNDEFINED;
}
String getDebugString(){
return "UNDEFINED";
}
}
;
private static final Alignment LEADING=new Alignment(){
int getGravityOffset(View view,int cellDelta){
return 0;
}
public int getAlignmentValue(View view,int viewSize,int mode){
return 0;
}
String getDebugString(){
return "LEADING";
}
}
;
private static final Alignment TRAILING=new Alignment(){
int getGravityOffset(View view,int cellDelta){
return cellDelta;
}
public int getAlignmentValue(View view,int viewSize,int mode){
return viewSize;
}
String getDebugString(){
return "TRAILING";
}
}
;
public static final Alignment TOP=LEADING;
public static final Alignment BOTTOM=TRAILING;
public static final Alignment START=LEADING;
public static final Alignment END=TRAILING;
private static Alignment createSwitchingAlignment(final Alignment ltr,final Alignment rtl){
return new Alignment(){
int getGravityOffset(View view,int cellDelta){
boolean isLayoutRtl=ViewCompat.getLayoutDirection(view) == ViewCompat.LAYOUT_DIRECTION_RTL;
return (!isLayoutRtl ? ltr : rtl).getGravityOffset(view,cellDelta);
}
public int getAlignmentValue(View view,int viewSize,int mode){
boolean isLayoutRtl=ViewCompat.getLayoutDirection(view) == ViewCompat.LAYOUT_DIRECTION_RTL;
return (!isLayoutRtl ? ltr : rtl).getAlignmentValue(view,viewSize,mode);
}
String getDebugString(){
return "SWITCHING[L:" + ltr.getDebugString() + ", R:"+ rtl.getDebugString()+ "]";
}
}
;
}
public static final Alignment LEFT=createSwitchingAlignment(START,END);
public static final Alignment RIGHT=createSwitchingAlignment(END,START);
public static final Alignment CENTER=new Alignment(){
int getGravityOffset(View view,int cellDelta){
return cellDelta >> 1;
}
public int getAlignmentValue(View view,int viewSize,int mode){
return viewSize >> 1;
}
String getDebugString(){
return "CENTER";
}
}
;
public static final Alignment BASELINE=new Alignment(){
int getGravityOffset(View view,int cellDelta){
return 0;
}
public int getAlignmentValue(View view,int viewSize,int mode){
if (view.getVisibility() == GONE) {
return 0;
}
int baseline=view.getBaseline();
return baseline == -1 ? UNDEFINED : baseline;
}
public Bounds getBounds(){
return new Bounds(){
private int size;
protected void reset(){
super.reset();
size=Integer.MIN_VALUE;
}
protected void include(int before,int after){
super.include(before,after);
size=max(size,before + after);
}
protected int size(boolean min){
return max(super.size(min),size);
}
protected int getOffset(GridLayout gl,View c,Alignment a,int size,boolean hrz){
return max(0,super.getOffset(gl,c,a,size,hrz));
}
}
;
}
String getDebugString(){
return "BASELINE";
}
}
;
public static final Alignment FILL=new Alignment(){
int getGravityOffset(View view,int cellDelta){
return 0;
}
public int getAlignmentValue(View view,int viewSize,int mode){
return UNDEFINED;
}
public int getSizeInCell(View view,int viewSize,int cellSize){
return cellSize;
}
String getDebugString(){
return "FILL";
}
}
;
static boolean canStretch(int flexibility){
return (flexibility & CAN_STRETCH) != 0;
}
private static final int INFLEXIBLE=0;
private static final int CAN_STRETCH=2;
Printer LOG_PRINTER=new Printer();
class Printer {
void println(String str){
}
}
Printer mPrinter=LOG_PRINTER;
}
