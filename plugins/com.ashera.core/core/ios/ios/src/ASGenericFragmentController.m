#import "ASGenericFragmentController.h"
#import "GenericFragment.h"
#import "CordovaActivity.h"
#include "Bundle.h"
#include "IRoot.h"

@implementation ASGenericFragmentController

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

- (void)dealloc {
    [self.rootFragment onDestroy];
    [self.rootFragment onDetach];
}

#pragma mark View lifecycle
- (void)viewDidLoad
{
    [super viewDidLoad];
    [self.view setBackgroundColor:[UIColor whiteColor]];
    [self.rootFragment onAttachWithASIActivity:self.cordovaActivity];
    [self.rootFragment onCreateWithADBundle:nil];
    UIView* uiView = [self.rootFragment onCreateViewWithBoolean:NO];
    [self.view addSubview:uiView];
}

- (void)viewDidLayoutSubviews {
    [super viewDidLayoutSubviews];
	[self remeasure];
}

- (void)remeasure {
    CGFloat topPadding = 0;
    CGFloat bottomPadding = 0;
    if (@available(iOS 11.0, *)) {
        UIWindow *window = UIApplication.sharedApplication.keyWindow;
        topPadding = window.safeAreaInsets.top;
        bottomPadding = window.safeAreaInsets.bottom;
    }
   if (self.navigationController.navigationBarHidden == NO){
   	topPadding += self.navigationController.navigationBar.frame.size.height;
   }
   [self.rootFragment setFrameWithInt:0 withInt:topPadding withInt:self.view.frame.size.width withInt:self.view.frame.size.height-topPadding-bottomPadding];
   [self.rootFragment remeasure];
} 

- (void) onPause:(NSNotification *) notification {
       [self.rootFragment onPause];
}

- (void) onResume:(NSNotification *) notification {
    [self.rootFragment onResume];
}

- (void)viewDidAppear:(BOOL)animated {
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(onPause:) name:UIApplicationWillResignActiveNotification object:nil];
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(onResume:) name:UIApplicationWillEnterForegroundNotification object:nil];

    [super viewDidAppear:animated];
    [self.rootFragment onResume];
}

- (void)viewDidDisappear:(BOOL)animated {
    [[NSNotificationCenter defaultCenter] removeObserver:self name:UIApplicationWillResignActiveNotification object:nil];
    [[NSNotificationCenter defaultCenter] removeObserver:self name:UIApplicationWillEnterForegroundNotification object:nil];

    [super viewDidDisappear:animated];
    [self.rootFragment onPause];
}

- (id<ASIFragment>)getActiveRootFragment {
    return self.rootFragment;
}
@end
