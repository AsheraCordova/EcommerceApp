package r.android.support.v7.widget;
import r.android.graphics.drawable.Drawable;
import r.android.support.v4.view.ActionProvider;
import r.android.support.v4.view.GravityCompat;
import r.android.support.v7.view.menu.BaseMenuPresenter;
import r.android.support.v7.view.menu.MenuItemImpl;
import r.android.util.SparseBooleanArray;
import r.android.view.View;
import r.android.view.View.MeasureSpec;
import r.android.view.ViewGroup;
import java.util.ArrayList;
public class ActionMenuPresenter extends BaseMenuPresenter {
  private OverflowMenuButton mOverflowButton;
  private boolean mPendingOverflowIconSet;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private int mWidthLimit;
  private int mActionItemWidthLimit;
  private int mMaxItems;
  private boolean mMaxItemsSet;
  private boolean mStrictWidthLimit;
  private boolean mWidthLimitSet;
  private boolean mExpandedActionViewsExclusive;
  private int mMinCellSize;
  private final SparseBooleanArray mActionButtonGroups=new SparseBooleanArray();
  private View mScrapActionButtonView;
  int mOpenSubMenuId;
  public void setReserveOverflow(  boolean reserveOverflow){
    mReserveOverflow=reserveOverflow;
    mReserveOverflowSet=true;
  }
  public View getItemView(  final MenuItemImpl item,  View convertView,  ViewGroup parent){
    View actionView=item.getActionView();
    if (actionView == null || item.hasCollapsibleActionView()) {
      actionView=super.getItemView(item,convertView,parent);
    }
    actionView.setVisibility(item.isActionViewExpanded() ? View.GONE : View.VISIBLE);
    final ActionMenuView menuParent=(ActionMenuView)parent;
    final ViewGroup.LayoutParams lp=actionView.getLayoutParams();
    if (!menuParent.checkLayoutParams(lp)) {
      actionView.setLayoutParams(menuParent.generateLayoutParams(lp));
    }
    return actionView;
  }
  public void updateMenuView(  boolean cleared){
    final ViewGroup menuViewParent=(ViewGroup)((View)mMenuView).getParent();
    if (menuViewParent != null) {
      ActionBarTransition.beginDelayedTransition(menuViewParent);
    }
    super.updateMenuView(cleared);
    ((View)mMenuView).requestLayout();
    if (mMenu != null) {
      final ArrayList<MenuItemImpl> actionItems=mMenu.getActionItems();
      final int count=actionItems.size();
      for (int i=0; i < count; i++) {
        final ActionProvider provider=actionItems.get(i).getSupportActionProvider();
        if (provider != null) {
          provider.setSubUiVisibilityListener(this);
        }
      }
    }
    final ArrayList<MenuItemImpl> nonActionItems=mMenu != null ? mMenu.getNonActionItems() : null;
    boolean hasOverflow=false;
    if (mReserveOverflow && nonActionItems != null) {
      final int count=nonActionItems.size();
      if (count == 1) {
        hasOverflow=!nonActionItems.get(0).isActionViewExpanded();
      }
 else {
        hasOverflow=count > 0;
      }
    }
    if (hasOverflow) {
      if (mOverflowButton == null) {
        mOverflowButton=new OverflowMenuButton(mSystemContext);
      }
      ViewGroup parent=(ViewGroup)mOverflowButton.getParent();
      if (parent != mMenuView) {
        if (parent != null) {
          parent.removeView(mOverflowButton);
        }
        ActionMenuView menuView=(ActionMenuView)mMenuView;
        menuView.addView(mOverflowButton,menuView.generateOverflowButtonLayoutParams());
      }
    }
 else     if (mOverflowButton != null && mOverflowButton.getParent() == mMenuView) {
      ((ViewGroup)mMenuView).removeView(mOverflowButton);
    }
    ((ActionMenuView)mMenuView).setOverflowReserved(mReserveOverflow);
  }
  public boolean flagActionItems(){
    final ArrayList<MenuItemImpl> visibleItems=mMenu.getVisibleItems();
    final int itemsSize=visibleItems.size();
    int maxActions=mMaxItems;
    int widthLimit=mActionItemWidthLimit;
    final int querySpec=MeasureSpec.makeMeasureSpec(0,MeasureSpec.UNSPECIFIED);
    final ViewGroup parent=(ViewGroup)mMenuView;
    int requiredItems=0;
    int requestedItems=0;
    int firstActionWidth=0;
    boolean hasOverflow=false;
    for (int i=0; i < itemsSize; i++) {
      MenuItemImpl item=visibleItems.get(i);
      if (item.requiresActionButton()) {
        requiredItems++;
      }
 else       if (item.requestsActionButton()) {
        requestedItems++;
      }
 else {
        hasOverflow=true;
      }
      if (mExpandedActionViewsExclusive && item.isActionViewExpanded()) {
        maxActions=0;
      }
    }
    if (mReserveOverflow && (hasOverflow || requiredItems + requestedItems > maxActions)) {
      maxActions--;
    }
    maxActions-=requiredItems;
    final SparseBooleanArray seenGroups=mActionButtonGroups;
    seenGroups.clear();
    int cellSize=0;
    int cellsRemaining=0;
    if (mStrictWidthLimit) {
      cellsRemaining=widthLimit / mMinCellSize;
      final int cellSizeRemaining=widthLimit % mMinCellSize;
      cellSize=mMinCellSize + cellSizeRemaining / cellsRemaining;
    }
    for (int i=0; i < itemsSize; i++) {
      MenuItemImpl item=visibleItems.get(i);
      if (item.requiresActionButton()) {
        View v=getItemView(item,mScrapActionButtonView,parent);
        if (mScrapActionButtonView == null) {
          mScrapActionButtonView=v;
        }
        if (mStrictWidthLimit) {
          cellsRemaining-=ActionMenuView.measureChildForCells(v,cellSize,cellsRemaining,querySpec,0);
        }
 else {
          v.measure(querySpec,querySpec);
        }
        final int measuredWidth=v.getMeasuredWidth();
        widthLimit-=measuredWidth;
        if (firstActionWidth == 0) {
          firstActionWidth=measuredWidth;
        }
        final int groupId=item.getGroupId();
        if (groupId != 0) {
          seenGroups.put(groupId,true);
        }
        item.setIsActionButton(true);
      }
 else       if (item.requestsActionButton()) {
        final int groupId=item.getGroupId();
        final boolean inGroup=seenGroups.get(groupId);
        boolean isAction=(maxActions > 0 || inGroup) && widthLimit > 0 && (!mStrictWidthLimit || cellsRemaining > 0);
        if (isAction) {
          View v=getItemView(item,mScrapActionButtonView,parent);
          if (mScrapActionButtonView == null) {
            mScrapActionButtonView=v;
          }
          if (mStrictWidthLimit) {
            final int cells=ActionMenuView.measureChildForCells(v,cellSize,cellsRemaining,querySpec,0);
            cellsRemaining-=cells;
            if (cells == 0) {
              isAction=false;
            }
          }
 else {
            v.measure(querySpec,querySpec);
          }
          final int measuredWidth=v.getMeasuredWidth();
          widthLimit-=measuredWidth;
          if (firstActionWidth == 0) {
            firstActionWidth=measuredWidth;
          }
          if (mStrictWidthLimit) {
            isAction&=widthLimit >= 0;
          }
 else {
            isAction&=widthLimit + firstActionWidth > 0;
          }
        }
        if (isAction && groupId != 0) {
          seenGroups.put(groupId,true);
        }
 else         if (inGroup) {
          seenGroups.put(groupId,false);
          for (int j=0; j < i; j++) {
            MenuItemImpl areYouMyGroupie=visibleItems.get(j);
            if (areYouMyGroupie.getGroupId() == groupId) {
              if (areYouMyGroupie.isActionButton())               maxActions++;
              areYouMyGroupie.setIsActionButton(false);
            }
          }
        }
        if (isAction)         maxActions--;
        item.setIsActionButton(isAction);
      }
 else {
        item.setIsActionButton(false);
      }
    }
    return true;
  }
  public void setMenuView(  ActionMenuView menuView){
    mMenuView=menuView;
    menuView.initialize(mMenu);
  }
  private com.ashera.android.factory.ui.NativeImpl nativeImpl=com.ashera.android.factory.ui.NativeImpl.getInstance();
  public ActionMenuPresenter(){
    mReserveOverflow=true;
    mWidthLimit=nativeImpl.getActionItemWidthLimit();
    mMaxItems=nativeImpl.getMaxItems();
    mActionItemWidthLimit=mWidthLimit;
    mMinCellSize=(int)(ActionMenuView.MIN_CELL_SIZE);
    mScrapActionButtonView=null;
  }
  public void setOverFlowButton(  View child){
    com.ashera.widget.IWidget tag=(com.ashera.widget.IWidget)child.getTag();
    mOverflowButton=new OverflowMenuButton(tag);
    mOverflowButton.setId(((View)tag.asWidget()).getId());
    mOverflowButton.setMinimumHeight(com.ashera.android.factory.ui.ToolbarImpl.TOOL_BAR_HEIGHT);
    mOverflowButton.setTag(tag);
  }
}
