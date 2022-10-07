#import "CordovaDateTimePlugin.h"
#import "DateTimePlugin.h"

@implementation CordovaDateTimePlugin
+ (void)initialize
{
    [ASDateTimePlugin initPlugin];
}

@end
