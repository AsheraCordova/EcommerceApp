package r.android.support.v7.view.menu;

import java.util.ArrayList;

import r.android.support.v7.widget.ActionMenuPresenter;
public class MenuBuilder {
    /**
     * Contains only the items that should appear in the Action Bar, if present.
     */
    private ArrayList<MenuItemImpl> mActionItems;

    /**
     * Contains items that should NOT appear in the Action Bar, if present.
     */
    private ArrayList<MenuItemImpl> mNonActionItems;
    /**
     * Contains only the items that are currently visible.  This will be created/refreshed from
     * {@link #getVisibleItems()}
     */    private static final int[] sCategoryToOrder = new int[]{
         1, /* No category */
         4, /* CONTAINER */
         5, /* SYSTEM */
         3, /* SECONDARY */
         2, /* ALTERNATIVE */
         0, /* SELECTED_ALTERNATIVE */
 };
     // Field descriptor #5 I
     public static final int USER_MASK = 65535;
     
     // Field descriptor #5 I
     public static final int USER_SHIFT = 0;
     
     // Field descriptor #5 I
     public static final int CATEGORY_MASK = -65536;
     
     // Field descriptor #5 I
     public static final int CATEGORY_SHIFT = 16;
     private int mDefaultShowAsAction = MenuItemImpl.SHOW_AS_ACTION_NEVER;

    private ArrayList<MenuItemImpl> mVisibleItems;
    private ActionMenuPresenter mActionMenuPresenter;

	private boolean mIsVisibleItemsStale;
    private ArrayList<MenuItemImpl> mItems;
    private boolean mIsActionItemsStale;

    public MenuBuilder() {
        mItems = new ArrayList<MenuItemImpl>();

        mVisibleItems = new ArrayList<MenuItemImpl>();
        mIsVisibleItemsStale = true;

        mActionItems = new ArrayList<MenuItemImpl>();
        mNonActionItems = new ArrayList<MenuItemImpl>();
        mIsActionItemsStale = true;
    }

    
    public void flagActionItems() {
        if (!mIsActionItemsStale) {
            return;
        }
        // Presenters flag action items as needed.
        boolean flagged = false;
        flagged =  mActionMenuPresenter.flagActionItems();
        if (flagged) {
            mActionItems.clear();
            mNonActionItems.clear();
            ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
            final int itemsSize = visibleItems.size();
            for (int i = 0; i < itemsSize; i++) {
                MenuItemImpl item = visibleItems.get(i);
                if (item.isActionButton()) {
                    mActionItems.add(item);
                } else {
                    mNonActionItems.add(item);
                }
            }
        } else if (mActionItems.size() + mNonActionItems.size() != getVisibleItems().size()) {
            // Nobody flagged anything, but if something doesn't add up then treat everything
            // as non-action items.
            // (This happens during a first pass with no action-item presenters.)
            mActionItems.clear();
            mNonActionItems.clear();
            mNonActionItems.addAll(getVisibleItems());
        }
        mIsActionItemsStale = false;
    }
		
		

    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!mIsVisibleItemsStale) return mVisibleItems;

        // Refresh the visible items
        mVisibleItems.clear();

        final int itemsSize = mItems.size();
        MenuItemImpl item;
        for (int i = 0; i < itemsSize; i++) {
            item = mItems.get(i);
            if (item.isVisible()) mVisibleItems.add(item);
        }

        mIsVisibleItemsStale = false;
        mIsActionItemsStale = true;

        return mVisibleItems;
    }
	public void onItemsChanged(boolean b) {
	}
	
    public MenuItemImpl add(int group, int id, int categoryOrder, CharSequence title) {
        return addInternal(group, id, categoryOrder, title);
    }
    
    protected MenuItemImpl addInternal(int group, int id, int categoryOrder, CharSequence title) {
        final int ordering = getOrdering(categoryOrder);

        final MenuItemImpl item = createNewMenuItem(group, id, categoryOrder, ordering, title,
                mDefaultShowAsAction);


        mItems.add(findInsertIndex(mItems, ordering), item);
        onItemsChanged(true);

        return item;
    }
    
    private static int getOrdering(int categoryOrder) {
        final int index = (categoryOrder & CATEGORY_MASK) >> CATEGORY_SHIFT;

        if (index < 0 || index >= sCategoryToOrder.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }

        return (sCategoryToOrder[index] << CATEGORY_SHIFT) | (categoryOrder & USER_MASK);
    }
    
    private MenuItemImpl createNewMenuItem(int group, int id, int categoryOrder, int ordering,
            CharSequence title, int defaultShowAsAction) {
        return new MenuItemImpl(group, id, categoryOrder, ordering, title,
                defaultShowAsAction);
    }
    private static int findInsertIndex(ArrayList<MenuItemImpl> items, int ordering) {
        for (int i = items.size() - 1; i >= 0; i--) {
            MenuItemImpl item = items.get(i);
            if (item.getOrdering() <= ordering) {
                return i + 1;
            }
        }

        return 0;
    }
    
    public void setActionMenuPresenter(ActionMenuPresenter mActionMenuPresenter) {
		this.mActionMenuPresenter = mActionMenuPresenter;
	}
    
    public void updateView(boolean cleared) {
                mActionMenuPresenter.updateMenuView(cleared);
    }
    
    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return mActionItems;
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return mNonActionItems;
    }
}
