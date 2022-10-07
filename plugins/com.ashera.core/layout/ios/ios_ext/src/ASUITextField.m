#include "ASUITextField.h"
#include "BaseMeasurableView.h"

@interface ASUITextField () {
@public
	//start - props
	//end - props
    int executingSizeThatFits;
    float forcePlaceHolderDraw;
}
@end
@implementation ASUITextField
//start - body

-(void) setFrame :(CGRect) rect {
	[_widget runAttributeCommandsWithId:self withNSString:@"preframe" withNSString:nil withNSObjectArray:nil];
    [super setFrame:rect];
	[_widget runAttributeCommandsWithId:self withNSString:@"postframe" withNSString:nil withNSObjectArray:nil];
    if ([self.widget hasMethodListenerWithNSString:@"setFrame"]) {
        // params
        CGRectWrapper* wrapper = [CGRectWrapper new];
        wrapper.rect = rect;
        wrapper.contentOffset = CGPointZero;
        IOSObjectArray* objectArray = [IOSObjectArray arrayWithNSArray: @[wrapper] type:NSObject_class_()];

        [self.widget executeMethodListenersWithNSString:@"setFrame" withNSObjectArray:objectArray];
        
    }  
}

-(void) drawRect:(CGRect)rect {
    CGRectWrapper* wrapper = [CGRectWrapper new];
    wrapper.rect = rect;
    IOSObjectArray* bgobjectArray = [IOSObjectArray arrayWithNSArray: @[@"rect", wrapper] type:NSObject_class_()];
    [_widget runAttributeCommandsWithId:self withNSString:@"predraw" withNSString:self.commandRegex withNSObjectArray:bgobjectArray];
    [super drawRect:rect];
    [_widget runAttributeCommandsWithId:self withNSString:@"postdraw" withNSString:self.commandRegex withNSObjectArray:bgobjectArray];
    if ([self.widget hasMethodListenerWithNSString:@"drawRect"]) {
        CGRectWrapper* wrapper = [CGRectWrapper new];
        wrapper.rect = rect;
        IOSObjectArray* objectArray = [IOSObjectArray arrayWithNSArray: @[wrapper] type:NSObject_class_()];

        [self.widget executeMethodListenersWithNSString:@"drawRect" withNSObjectArray:objectArray];
    }
}

- (void)layoutSubviews {
	[super layoutSubviews];
    [_widget replayBufferedEvents];
    ASBaseMeasurableView *measurableView = ((ASBaseMeasurableView*)[_widget asWidget]);
    if ([measurableView hasDrawables]) {
    	[self setNeedsDisplay];
    }
}

-(id<ASIWidget>) getWidget {
	return self.widget;
}

- (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event {
    [super touchesBegan:touches withEvent:event];
    ADView* view = [_widget asWidget];
    if ([view isClickable]) {
        [view setPressedWithBoolean:YES];
    }

}

- (void)touchesEnded:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event {
    [super touchesEnded:touches withEvent:event];
    ADView* view = [_widget asWidget];

    if ([view isClickable]) {
        [view setPressedWithBoolean:NO];
    }
}

- (void)touchesCancelled:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event {
    [super touchesCancelled:touches withEvent:event];
    ADView* view = [_widget asWidget];

    if ([view isClickable]) {
        [view setPressedWithBoolean:NO];
    }
}

- (void)pressesBegan:(NSSet<UIPress *> *)presses withEvent:(UIPressesEvent *)event {
    [super pressesBegan:presses withEvent:event];
    if (presses.count > 0) {
    	UIKey* key = [[presses allObjects] objectAtIndex:0].key;
    	if (key != nil) {
    		int keyCode = key.keyCode;
	    	ADView* view = [_widget asWidget];
	    	if ([view hasOnKeyListener]) {
	        	[view invokeKeyListenerDownWithInt:keyCode];
	    	}
    	}
    }

}

- (void)pressesEnded:(NSSet<UIPress *> *)presses withEvent:(UIPressesEvent *)event {
    [super pressesEnded:presses withEvent:event];
    ADView* view = [_widget asWidget];

	if (presses.count > 0) {
    	UIKey* key = [[presses allObjects] objectAtIndex:0].key;
    	if (key != nil) {
    		int keyCode = key.keyCode;
	    	ADView* view = [_widget asWidget];
	    	if ([view hasOnKeyListener]) {
	        	[view invokeKeyListenerUpWithInt:keyCode];
	    	}
    	}
    }
}

- (void)pressesCancelled:(NSSet<UIPress *> *)presses withEvent:(UIPressesEvent *)event {
    [super pressesCancelled:presses withEvent:event];
	if (presses.count > 0) {
    	UIKey* key = [[presses allObjects] objectAtIndex:0].key;
    	if (key != nil) {
    		int keyCode = key.keyCode;
	    	ADView* view = [_widget asWidget];
	    	if ([view hasOnKeyListener]) {
	        	[view invokeKeyListenerUpWithInt:keyCode];
	    	}
    	}
    }
}
//end - body

-(id)initWithFrame:(CGRect)frame {
    self = [super initWithFrame:frame];
    if (!self) return nil;
    return self;
}

- (CGSize)sizeThatFits:(CGSize)size {
    executingSizeThatFits = 1;
    CGSize cgsize = [super sizeThatFits:size];
    executingSizeThatFits = 0;
    return cgsize;
}

- (CGRect)textRectForBounds:(CGRect)rect {
    if (executingSizeThatFits == 1) {
        return [super textRectForBounds:rect];
    }
    ASBaseMeasurableView *measurableView = ((ASBaseMeasurableView*)[_widget asWidget]);
    return UIEdgeInsetsInsetRect(rect, UIEdgeInsetsMake([measurableView getCompoundPaddingTop], [measurableView getCompoundPaddingLeftWithIgnoreCheck], [measurableView getCompoundPaddingBottom], [measurableView getCompoundPaddingRightWithIgnoreCheck]));
}

- (CGRect)editingRectForBounds:(CGRect)bounds {
    return [self textRectForBounds:bounds];
}

- (CGRect)placeholderRectForBounds:(CGRect)bounds {
	if (_placeHolderColor != nil) {
	    if (forcePlaceHolderDraw == 0) {
	        forcePlaceHolderDraw = 0.000001;
	    } else {
	        forcePlaceHolderDraw = 0;
	    }
	}
    return [self textRectForBounds:CGRectMake(bounds.origin.x, bounds.origin.y, bounds.size.width + forcePlaceHolderDraw, bounds.size.height)];
}


- (void)drawPlaceholderInRect:(CGRect)rect {
    CGRect placeholderRect = rect;

	if (_placeHolderColor != nil) {
    	[_placeHolderColor setFill];
        ASBaseMeasurableView *measurableView = ((ASBaseMeasurableView*)[_widget asWidget]);
        if ([measurableView isVerticalAlignTop]) {
            // nothing to do
        } else if ([measurableView isVerticalAlignBottom]) {
            placeholderRect = CGRectMake(rect.origin.x, rect.origin.y + rect.size.height - self.font.lineHeight, rect.size.width, self.font.lineHeight);
        } else {
            placeholderRect = CGRectMake(rect.origin.x, (rect.size.height- self.font.lineHeight)/2, rect.size.width, self.font.lineHeight);
        }
        
        [[self placeholder] drawInRect:placeholderRect withFont:self.font lineBreakMode:NSLineBreakByClipping alignment:self.textAlignment];

    } else {
        ASBaseMeasurableView *measurableView = ((ASBaseMeasurableView*)[_widget asWidget]);
        if ([measurableView isVerticalAlignTop]) {
            placeholderRect = CGRectMake(rect.origin.x, rect.origin.y, rect.size.width, self.font.lineHeight);
        } else if ([measurableView isVerticalAlignBottom]) {
            placeholderRect = CGRectMake(rect.origin.x, rect.origin.y + rect.size.height - self.font.lineHeight, rect.size.width, self.font.lineHeight);
        } else {
            // nothing to do here
        }
        
        [super drawPlaceholderInRect:placeholderRect];
    }
    
}

@end
