#import "ASDialogFragmentController.h"
#import "GenericFragment.h"
#import "DialogFragment.h"
#import "CordovaActivity.h"
#include "Bundle.h"
#include "IRoot.h"
#include "IWidget.h"
#include "ASMainViewController.h"

@interface ASDialogFragmentController ()
@property (readwrite, strong, nonatomic) UIView *backgroundView;
@end
@implementation ASDialogFragmentController

- (id)initWithNibName:(NSString*)nibNameOrNil bundle:(NSBundle*)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    return self;
}

- (id)init
{
    self = [super init];
    return self;
}

#pragma mark View lifecycle
- (void)viewDidLoad
{
    _backgroundView = [[UIView alloc] initWithFrame:CGRectZero];
    _backgroundView.backgroundColor = [UIColor clearColor];
    _backgroundView.userInteractionEnabled = YES;
    _backgroundView.multipleTouchEnabled = NO;
    [self.view addSubview:_backgroundView];

    [super viewDidLoad];
    
    if (self.backgroundDimEnabled == nil || [self.backgroundDimEnabled isEqualToString:@"true"]) {
		if (self.backdropColor == nil) {
	    	self.view.backgroundColor = [UIColor blackColor];
	    	self.view.backgroundColor = [self.view.backgroundColor colorWithAlphaComponent:0.3];
    	} else {
    		self.view.backgroundColor = self.backdropColor;
    	}
    } else {
    	self.view.backgroundColor = [UIColor clearColor];
    }

    if (self.windowCloseOnTouchOutside != nil && [self.windowCloseOnTouchOutside isEqualToString:@"true"]) {
		UITapGestureRecognizer* tapGestureRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(dismiss:)];
		[tapGestureRecognizer setNumberOfTapsRequired:1];
		[_backgroundView addGestureRecognizer:tapGestureRecognizer];
	}
}

- (void)dismiss:(UITapGestureRecognizer *)sender {
    [self dismiss];
}

- (void)dismiss {
    [self dismissViewControllerAnimated:YES completion:^ {}];
}

- (void)remeasure {
	[(ASDialogFragment*) self.rootFragment setMaxHeightWithInt:-1];
	[(ASDialogFragment*) self.rootFragment setMaxWidthWithInt:-1];
   	[self.rootFragment remeasure];
   	
   	[_backgroundView setFrame:self.view.frame];
   	UIView* uiview = (UIView*)[[self.rootFragment getRootWidget] asNativeWidget];
   	[uiview setFrame:CGRectMake((self.view.frame.size.width-uiview.frame.size.width)/2, (self.view.frame.size.height-uiview.frame.size.height)/2, uiview.frame.size.width, uiview.frame.size.height)];
}

- (void)dealloc {
	UIViewController* parent = self.presentingViewController;
	
	if ([parent class] == [ASDialogFragmentController class]) {
		// do nothing
	} else {
		ASMainViewController* mainViewController = (ASMainViewController*) [UIApplication sharedApplication].delegate.window.rootViewController;
		parent = ((ASGenericFragmentController*) [mainViewController.navController.viewControllers lastObject]);		
	}
	
	[((ASGenericFragmentController*) parent).rootFragment onCloseDialog];
}

@end
