#import "CordovaShutterBugPlugin.h"
#import "ShutterBugPlugin.h"

@implementation CordovaShutterBugPlugin
+ (void)initialize
{
    [ASShutterBugPlugin initPlugin];
}

@end
