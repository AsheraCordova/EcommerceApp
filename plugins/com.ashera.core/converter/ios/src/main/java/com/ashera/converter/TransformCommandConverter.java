package com.ashera.converter;

import com.ashera.widget.AttributeCommand;
import com.ashera.widget.IWidget;

import r.android.view.View;

/*-[
#include <UIKit/UIKit.h>
#define degreesToRadians(x) ((x) * M_PI / 180.0)
]-*/

public class TransformCommandConverter extends com.ashera.widget.BaseAttributeCommand {
	private float translationX;
	private float translationY;
	private float translationZ;
	private float rotation;
	private float rotationX;
	private float rotationY;
	private float scaleX = 1;
	private float scaleY = 1;
	private Float transformPivotX;
	private Float transformPivotY;

	public TransformCommandConverter(String id) {
		super(id);
	}


	@Override
	public Object modifyValue(IWidget widget, Object nativeView, String phase, String attributeName, Object value) {
		switch (phase) {
		case "preframe":
			resetTranform(widget.asNativeWidget());
			break;
		case "postframe":
			View view = (View) widget.asWidget();
			
			Float anchorX = null;
			Float anchorY = null;
			if (transformPivotX != null || transformPivotY != null) {
				anchorX =  (transformPivotX == null) ? 0.5f : view.getMeasuredWidth()/transformPivotX;
				anchorY =  (transformPivotY == null) ? 0.5f : view.getMeasuredHeight()/transformPivotY;
			}
			updateTranform(widget.asNativeWidget(), translationX, translationY, translationZ, rotation, rotationX, rotationY, scaleX, scaleY, anchorX, anchorY);
			break;

		default:
			break;
		}
		return value;
	}

	private native void resetTranform(Object uiView) /*-[
		if (@available(iOS 13.0, *)) {
			((UIView*)uiView).transform3D = CATransform3DIdentity;
		} else {
		   	((UIView*)uiView).transform = CGAffineTransformIdentity;
		}
	]-*/;

	
	private native void updateTranform(Object view, float translationX, float translationY, float translationZ, float rotation, 
			float rotationX, float rotationY, float scaleX, float scaleY, Float anchorX, Float anchorY) /*-[
		UIView * uiView = ((UIView *) view);
		
		if (anchorX != nil && anchorY != nil) {
			[self setAnchorPoint:CGPointMake([anchorX floatValue], [anchorY floatValue]) forView:uiView];
		}
		if (@available(iOS 13.0, *)) {
      		CATransform3D tranform = CATransform3DTranslate(uiView.transform3D, translationX, translationY, translationZ);
      		if (rotation > 0) {
      			tranform = CATransform3DRotate(tranform, degreesToRadians(rotation),0 ,0, 1);
      		}
      		if (rotationY > 0) {
      			tranform = CATransform3DRotate(tranform, degreesToRadians(rotationY),0 ,1, 0);
      		}
      		if (rotationX > 0) {
      			tranform = CATransform3DRotate(tranform, degreesToRadians(rotationX),1 ,0, 0);
      		}
      		tranform = CATransform3DScale(tranform, scaleX, scaleY, 1);
		    [uiView setTransform3D:tranform];
  		} else {
  			CGAffineTransform tranform = CGAffineTransformTranslate(uiView.transform, translationX, translationY);
  			tranform = CGAffineTransformRotate(tranform, degreesToRadians(rotation));
      		tranform = CGAffineTransformScale(tranform, scaleX, scaleY);
    		[uiView setTransform:tranform];
  		}
	]-*/;
	/*-[
	-(void)setAnchorPoint:(CGPoint)anchorPoint forView:(UIView *)view
	{
	    CGPoint newPoint = CGPointMake(view.bounds.size.width * anchorPoint.x,
	                                   view.bounds.size.height * anchorPoint.y);
	    CGPoint oldPoint = CGPointMake(view.bounds.size.width * view.layer.anchorPoint.x,
	                                   view.bounds.size.height * view.layer.anchorPoint.y);

	    newPoint = CGPointApplyAffineTransform(newPoint, view.transform);
	    oldPoint = CGPointApplyAffineTransform(oldPoint, view.transform);

	    CGPoint position = view.layer.position;

	    position.x -= oldPoint.x;
	    position.x += newPoint.x;

	    position.y -= oldPoint.y;
	    position.y += newPoint.y;

	    view.layer.position = position;
	    view.layer.anchorPoint = anchorPoint;
	}
	]-*/;

	@Override
	public AttributeCommand newInstance(Object... args) {
		TransformCommandConverter transformCommandConverter = new TransformCommandConverter(this.id);
		transformCommandConverter.updateArgs(args);
		return transformCommandConverter;
	}
	
	@Override
	public void updateArgs(Object... args) {
		for (int i = 0; i < args.length; i+=2) {
			String attributeName = (String) args[i];
			
			
			switch (attributeName) {
				case "translationX":
					translationX = ((float) args[i + 1]);
					break;
				case "translationY":
					translationY = ((float) args[i + 1]);
					break;
				case "translationZ":
					translationZ = ((float) args[i + 1]);
					break;
				case "rotation":
					rotation = ((float) args[i + 1]);
					break;
				case "rotationX":
					rotationX = ((float) args[i + 1]);
					break;
				case "rotationY":
					rotationY = ((float) args[i + 1]);
					break;
				case "scaleX":
					scaleX = ((float) args[i + 1]);
					break;
				case "scaleY":
					scaleY = ((float) args[i + 1]);
					break;
				case "transformPivotX":
					transformPivotX  = ((float) args[i + 1]);
					break;
				case "transformPivotY":
					transformPivotY  = ((float) args[i + 1]);
					break;
				default:
					break;
			}

		}
	}
	
	@Override
	public void updatePhaseArgs(java.lang.Object... args) {
	}

	@Override
	public boolean executeAfterPostMeasure() {
		return true;
	}
	
	@Override
	public java.lang.Object getValue(java.lang.String attributeName) {
		switch (attributeName) {
		case "translationX":
			return translationX;
		case "translationY":
			return translationY;
		case "translationZ":
			return translationZ;
		case "rotation":
			return rotation;
		case "rotationX":
			return rotationX;
		case "rotationY":
			return rotationY;
		case "scaleX":
			return scaleX;
		case "scaleY":
			return scaleY;
		case "transformPivotX":
			return transformPivotX;
		case "transformPivotY":
			return transformPivotY;
		default:
			break;
	}

		return null;
	}
}
