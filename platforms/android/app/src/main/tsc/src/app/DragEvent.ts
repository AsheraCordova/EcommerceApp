export interface DragEvent {
	"ACTION_DRAG_STARTED" :1;
	"ACTION_DRAG_LOCATION" :2;
	"ACTION_DROP" :3;
	"ACTION_DRAG_ENDED" :4;
	"ACTION_DRAG_ENTERED" :5;
	"ACTION_DRAG_EXITED" :6;

	action: number;
	x: number;
	y: number;
	clipData: string;
}
