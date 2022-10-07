#import <Cordova/CDVViewController.h>
#import <Cordova/CDVCommandDelegateImpl.h>
#import <Cordova/CDVCommandQueue.h>
#import "IActivity.h"
#import "GenericFragment.h"
#import "CordovaActivity.h"

@interface ASMainViewController : CDVViewController<ASIActivity>
    @property UINavigationController* navController;
    @property ASCordovaActivity* cordovaActivity;
@end

@interface ASMainCommandDelegate : CDVCommandDelegateImpl
@end

@interface ASMainCommandQueue : CDVCommandQueue
@end
