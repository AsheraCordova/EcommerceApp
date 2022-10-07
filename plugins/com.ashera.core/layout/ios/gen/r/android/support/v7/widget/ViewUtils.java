package r.android.support.v7.widget;

import r.android.support.v4.view.ViewCompat;
import r.android.view.View;

public class ViewUtils {
	public static boolean isLayoutRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == ViewCompat.LAYOUT_DIRECTION_RTL;
    }

    /**
     * Merge two states as returned by {@link ViewCompat#getMeasuredState(android.view.View)} ()}.
     * @param curState The current state as returned from a view or the result
     * of combining multiple views.
     * @param newState The new view state to combine.
     * @return Returns a new integer reflecting the combination of the two
     * states.
     */
    public static int combineMeasuredStates(int curState, int newState) {
        return curState | newState;
    }
}
