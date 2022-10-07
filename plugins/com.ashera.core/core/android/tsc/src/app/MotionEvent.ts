export interface MotionEvent {
	ACTION_DOWN : 0;
	ACTION_UP : 1;
	ACTION_MOVE : 2;
	ACTION_CANCEL : 3;
	ACTION_OUTSIDE : 4;
	ACTION_SCROLL : 8;
	ACTION_BUTTON_PRESS : 11;
	ACTION_BUTTON_RELEASE : 12;
	action: number;
	x: number;
	y: number;
	rawX: number;
	rawY: number;
}
