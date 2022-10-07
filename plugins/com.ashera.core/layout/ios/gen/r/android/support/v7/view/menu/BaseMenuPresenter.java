package r.android.support.v7.view.menu;
import r.android.content.Context;
import r.android.support.v4.view.ViewCompat;
import r.android.view.View;
import r.android.view.ViewGroup;
import java.util.ArrayList;
public abstract class BaseMenuPresenter {
  protected Context mSystemContext;
  protected MenuBuilder mMenu;
  private int mMenuLayoutRes;
  private int mItemLayoutRes;
  private int mId;
  public void updateMenuView(  boolean cleared){
    final ViewGroup parent=(ViewGroup)mMenuView;
    if (parent == null)     return;
    int childIndex=0;
    if (mMenu != null) {
      mMenu.flagActionItems();
      ArrayList<MenuItemImpl> visibleItems=mMenu.getVisibleItems();
      final int itemCount=visibleItems.size();
      for (int i=0; i < itemCount; i++) {
        MenuItemImpl item=visibleItems.get(i);
        if (shouldIncludeItem(childIndex,item)) {
          final View convertView=parent.getChildAt(childIndex);
          final MenuItemImpl oldItem=convertView instanceof MenuView.ItemView ? ((MenuView.ItemView)convertView).getItemData() : null;
          final View itemView=getItemView(item,convertView,parent);
          if (item != oldItem) {
            itemView.setPressed(false);
            ViewCompat.jumpDrawablesToCurrentState(itemView);
          }
          if (itemView != convertView) {
            addItemView(itemView,childIndex);
          }
          childIndex++;
        }
      }
    }
    while (childIndex < parent.getChildCount()) {
      if (!filterLeftoverView(parent,childIndex)) {
        childIndex++;
      }
    }
  }
  protected void addItemView(  View itemView,  int childIndex){
    final ViewGroup currentParent=(ViewGroup)itemView.getParent();
    if (currentParent != null) {
      currentParent.removeView(itemView);
    }
    ((ViewGroup)mMenuView).addView(itemView,childIndex);
  }
  protected boolean filterLeftoverView(  ViewGroup parent,  int childIndex){
    parent.removeViewAt(childIndex);
    return true;
  }
  public boolean shouldIncludeItem(  int childIndex,  MenuItemImpl item){
    return true;
  }
  protected r.android.support.v7.widget.ActionMenuView mMenuView;
  public View getItemView(  final MenuItemImpl item,  View convertView,  ViewGroup parent){
    return null;
  }
  public void setMenu(  MenuBuilder mMenu){
    this.mMenu=mMenu;
  }
}
