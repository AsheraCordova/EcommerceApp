#import "ASMainViewController.h"
#import "GenericFragment.h"
#import "CordovaActivity.h"
#include "Bundle.h"
#include "CordovaActivity.h"
#include "IRoot.h"
#include "ASGenericFragmentController.h"
#include "PluginInvoker.h"

@interface ASMainViewController () {
 @public
    BOOL bufferEvents;
    NSMutableArray* events;
}
@end
@implementation ASMainViewController

- (id)initWithNibName:(NSString*)nibNameOrNil bundle:(NSBundle*)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    bufferEvents = YES;
    events = [NSMutableArray new];
    return self;
}

- (id)init
{
    self = [super init];
    bufferEvents = YES;
    events = [NSMutableArray new];
    return self;
}

- (void)didReceiveMemoryWarning
{
    // Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];

    // Release any cached data, images, etc that aren't in use.
}

#pragma mark View lifecycle
- (void)viewDidLoad
{
    [super viewDidLoad];
    [self.webView setFrame:CGRectMake(0, 0, 0, 0)];
    [self.view setBackgroundColor:[UIColor whiteColor]];
    
    ASGenericFragmentController* childController = [ASGenericFragmentController new];
    self.navController = [[UINavigationController alloc] initWithRootViewController:childController];
    self.navController.modalPresentationStyle = UIModalPresentationOverCurrentContext;
	[self.navController setNavigationBarHidden:[self.settings[@"ioshidetoolbar"] isEqualToString:@"true"]];

    self.cordovaActivity = [[ASCordovaActivity alloc] initWithASIActivity:self];
    childController.cordovaActivity = self.cordovaActivity;
    ADBundle* bundle = [ASGenericFragment getInitialBundleWithNSString:@"index" withNSString:@"layout/index.xml" withJavaUtilList:nil];
    childController.rootFragment = [ASGenericFragment new];
    [childController.rootFragment setArgumentsWithADBundle:bundle];
    [self.navController willMoveToParentViewController:self];
    self.navController.view.frame = [[UIScreen mainScreen] bounds];  //Set a frame or constraints
    [self.view addSubview:self.navController.view];
    [self addChildViewController:self.navController];
    [self.navController didMoveToParentViewController:self];
}

- (void)onDeviceReady {
    bufferEvents = NO;
    for (NSString* js in events) {
        [self.commandDelegate evalJs:js scheduledOnRunLoop:NO];
    }
    [events removeAllObjects];
}

- (NSString *)getAssetMode {
    return self.settings[@"assetmode"];
}

- (NSString *)getDevServerIp {
    return self.settings[@"devserverip"];
}

- (jfloat)getScaleFactor {
	NSString *key = [NSString stringWithFormat:@"%@ScaleFactor", [ASPluginInvoker getOS]];
	NSString* val = self.settings[key];
	if (!val) {
		val = @"1";
	} 
	return [val floatValue];
}


- (NSString *)getPreferenceWithNSString:(NSString *)name {
	NSString* val = self.settings[name];
	if (!val) {
		val = @"";
	} 
	return val;
}


- (void)sendEventMessageWithJavaUtilMap:(id<JavaUtilMap>)dataMap {
    NSDictionary* map = [ASPluginInvoker getNativeMapWithJavaUtilMap:dataMap];
    CDVPluginResult* cdvPluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary: map];
    NSString* event = [map valueForKey: @"action"];
    NSString* data = [cdvPluginResult argumentsAsJSON];
    NSString *js = [NSString stringWithFormat:@"cordova.fireDocumentEvent('%@', %@);", event, data];
    if (bufferEvents) {
        [events addObject:js];
    } else {
        [self.commandDelegate evalJs:js scheduledOnRunLoop:NO];
    }
}

- (id<ASIFragment>)getActiveRootFragment {
	UIViewController* presentedController = self;
	
	while (presentedController.presentedViewController != nil) {
		presentedController = presentedController.presentedViewController;
	}
	
	if (presentedController != self) {
		return ((ASGenericFragmentController*) presentedController).rootFragment;
	}
    return ((ASGenericFragmentController*) [self.navController.viewControllers lastObject]).rootFragment;
}
@end

@implementation ASMainCommandDelegate

/* To override the methods, uncomment the line in the init function(s)
   in MainViewController.m
 */

#pragma mark CDVCommandDelegate implementation

- (id)getCommandInstance:(NSString*)className
{
    return [super getCommandInstance:className];
}

- (NSString*)pathForResource:(NSString*)resourcepath
{
    return [super pathForResource:resourcepath];
}

@end

@implementation ASMainCommandQueue

/* To override, uncomment the line in the init function(s)
   in MainViewController.m
 */
- (BOOL)execute:(CDVInvokedUrlCommand*)command
{
    return [super execute:command];
}

@end
