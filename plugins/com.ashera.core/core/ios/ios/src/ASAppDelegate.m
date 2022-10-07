#import "ASAppDelegate.h"
#import "ASMainViewController.h"

@implementation ASAppDelegate

- (BOOL)application:(UIApplication*)application didFinishLaunchingWithOptions:(NSDictionary*)launchOptions
{
    self.window = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    self.viewController = [ASMainViewController new];
    [self.window setRootViewController:self.viewController];
    [self.window makeKeyAndVisible];
        
    for (NSString *familyName in [UIFont familyNames]){
        NSLog(@"Family name: %@", familyName);
        for (NSString *fontName in [UIFont fontNamesForFamilyName:familyName]) {
            NSLog(@"--Font name: %@", fontName);
        }
    }
    return YES;
}

@end
