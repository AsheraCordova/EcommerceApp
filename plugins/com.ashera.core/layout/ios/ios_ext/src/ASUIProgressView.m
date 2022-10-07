#include "ASUIProgressView.h"

@interface ASUIProgressView () {
@public
	//start - props
	//end - props
}
@end
@implementation ASUIProgressView
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
@end
