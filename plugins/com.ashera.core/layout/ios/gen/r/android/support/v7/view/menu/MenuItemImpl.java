package r.android.support.v7.view.menu;

import r.android.support.v4.view.ActionProvider;
import r.android.view.View;


public class MenuItemImpl {
	private int mShowAsAction = SHOW_AS_ACTION_NEVER;
	private View mActionView;
    /*
     * These should be kept in sync with attrs.xml enum constants for showAsAction
     */
    /** Never show this item as a button in an Action Bar. */
    public static final int SHOW_AS_ACTION_NEVER = 0;
    /** Show this item as a button in an Action Bar if the system decides there is room for it. */
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    /**
     * Always show this item as a button in an Action Bar.
     * Use sparingly! If too many items are set to always show in the Action Bar it can
     * crowd the Action Bar and degrade the user experience on devices with smaller screens.
     * A good rule of thumb is to have no more than 2 items set to always show at a time.
     */
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    /**
     * When this item is in the action bar, always show it with a text label even if
     * it also has an icon specified.
     */
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final int CHECKABLE = 0x00000001;
    private static final int CHECKED = 0x00000002;
    private static final int EXCLUSIVE = 0x00000004;
    private static final int HIDDEN = 0x00000008;
    private static final int ENABLED = 0x00000010;
    private static final int IS_ACTION = 0x00000020;
    private int mFlags = ENABLED;
    /**
     * This item's action view collapses to a normal menu item.
     * When expanded, the action view temporarily takes over
     * a larger segment of its container.
     */
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    private final int mId;
    private final int mGroup;
    private final int mCategoryOrder;
    private final int mOrdering;
    private CharSequence mTitle;
	private CharSequence mTitleCondensed;
    private boolean mIsActionViewExpanded = false;
    MenuItemImpl(int group, int id, int categoryOrder, int ordering,
            CharSequence title, int showAsAction) {

        mId = id;
        mGroup = group;
        mCategoryOrder = categoryOrder;
        mOrdering = ordering;
        mTitle = title;
        mShowAsAction = showAsAction;
    }
    
    public void setShowAsAction(int mShowAsAction) {
		this.mShowAsAction = mShowAsAction;
	}

	public boolean requestsActionButton() {
        return (mShowAsAction & SHOW_AS_ACTION_IF_ROOM) == SHOW_AS_ACTION_IF_ROOM;
    }

    public boolean requiresActionButton() {
        return (mShowAsAction & SHOW_AS_ACTION_ALWAYS) == SHOW_AS_ACTION_ALWAYS;
    }

	public boolean isActionViewExpanded() {
		return mIsActionViewExpanded;
	}

    public void setIsActionButton(boolean isActionButton) {
        if (isActionButton) {
            mFlags |= IS_ACTION;
        } else {
            mFlags &= ~IS_ACTION;
        }
    }
    
    public int getGroupId() {
        return mGroup;
    }

    public int getItemId() {
        return mId;
    }

    public int getOrder() {
        return mCategoryOrder;
    }

    public int getOrdering() {
        return mOrdering;
    }
    
    public boolean isActionButton() {
        return (mFlags & IS_ACTION) == IS_ACTION;
    }
    
    public boolean hasCollapsibleActionView() {
        if ((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) != 0) {
            return mActionView != null;
        }
        return false;
    }
    
    public void setActionView(View view) {
    	this.mActionView = view;
    }
    
    public View getActionView() {
        return mActionView;
    }
    
    public boolean isVisible() {
        return (mFlags & HIDDEN) == 0;
    }
    
    public ActionProvider getSupportActionProvider() {
        return null;
    }
    public CharSequence getTitle() {
		return mTitle;
	}
}
