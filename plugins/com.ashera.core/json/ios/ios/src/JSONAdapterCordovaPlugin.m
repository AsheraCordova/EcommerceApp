#import "JSONAdapterCordovaPlugin.h"
#import "JSONAdapterImpl.h"

@implementation JSONAdapterCordovaPlugin
+ (void)initialize
{
    [ASJSONAdapterImpl initPlugin];
}

@end
