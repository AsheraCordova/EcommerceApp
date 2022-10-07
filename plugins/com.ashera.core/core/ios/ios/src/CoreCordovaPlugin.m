#import "CoreCordovaPlugin.h"
#import "CorePlugin.h"
#include "IActivity.h"
#include "IFragment.h"
#include "IFragment.h"
#include "PluginInvoker.h"
#include "java/util/List.h"


@implementation CoreCordovaPlugin
+ (void)initialize
{
    [ASCorePlugin initPlugin];
}

- (void)onDeviceReady:(CDVInvokedUrlCommand*)command
{
    [((id<ASIActivity>) self.viewController) onDeviceReady];
    CDVPluginResult* result = [CDVPluginResult
                               resultWithStatus:CDVCommandStatus_OK];

    [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

- (void) navigateCommand:(CDVInvokedUrlCommand*)context {
    NSArray* commands = [[context arguments] objectAtIndex:0];
    id<ASIActivity> activity = ((id<ASIActivity>) self.viewController);

    for(int i = 0; i < commands.count; i++) {
        NSArray* command = [commands objectAtIndex:i];
        NSString* commandName = [command objectAtIndex:0];
        
        if ([commandName isEqualToString:@"navigate"]) {
            NSString* actionId = [command objectAtIndex:1];
            NSArray* scopedObjects = [command objectAtIndex:2];

            [ASCorePlugin navigateWithNSString:actionId withId:scopedObjects withASIFragment:[ activity getActiveRootFragment]];
        } else if ([commandName isEqualToString:@"navigateWithPopBackStack"]) {
            NSString* actionId = [command objectAtIndex:1];
            NSArray* scopedObjects = [command objectAtIndex:2];

            [ASCorePlugin navigateWithPopBackStackWithNSString:actionId withId:scopedObjects withASIFragment:[ activity getActiveRootFragment]];
        } else if ([commandName isEqualToString:@"navigateAsTop"]) {
        	NSString* actionId = [command objectAtIndex:1];
            NSArray* scopedObjects = [command objectAtIndex:2];

            [ASCorePlugin navigateAsTopWithNSString:actionId withId:scopedObjects withASIFragment:[ activity getActiveRootFragment]];
        } else if ([commandName isEqualToString:@"popBackStack"]) {
        	[ASCorePlugin popBackStackWithASIFragment:[ activity getActiveRootFragment]];
        } else if ([commandName isEqualToString:@"popBackStackTo"]) {
        	NSString* destinationId = [command objectAtIndex:1];
            NSNumber* inclusive = [command objectAtIndex:2];
        	[ASCorePlugin popBackStackWithASIFragment:[activity getActiveRootFragment] withNSString:destinationId withBoolean:[inclusive intValue] == YES];
        } else if ([commandName isEqualToString:@"closeDialog"]) {
        	[ASCorePlugin closeDialog];
        } else if ([commandName isEqualToString:@"navigateWithPopBackStackTo"]) {
        	NSString* actionId = [command objectAtIndex:1];
        	NSString* destinationId = [command objectAtIndex:2];
            NSNumber* inclusive = [command objectAtIndex:3];
            NSArray* scopedObjects = [command objectAtIndex:4];
        	[ASCorePlugin navigateWithPopBackStackToWithNSString:actionId withNSString:destinationId withBoolean:[inclusive intValue] == YES
        			withId: scopedObjects withASIFragment:[activity getActiveRootFragment]];
        }
    }
            
	[self successWithId: context withNSString: @"{}"];
    
}

- (void) executeSimpleCommand:(CDVInvokedUrlCommand*)context {
    NSArray* commands = [context arguments];
    id<ASIActivity> activity = ((id<ASIActivity>) self.viewController);

	NSString* result = [ASCorePlugin executeSimpleCommandWithId:commands withASIFragment:[ activity getActiveRootFragment]];
	[self successWithId: context withNSString: result];
}

- (void)executeCommand:(CDVInvokedUrlCommand*)command
{
    id<ASIActivity> activity = ((id<ASIActivity>) self.viewController);
    NSString* jsonString = [[command arguments] objectAtIndex:0];
    [ASCommandHelper executeCommandWithASIActivity:activity withId:command withNSString:jsonString withASCommandHelper_SucessCallBack:self];
}

- (void)successWithId:(id)command
                withNSString:(NSString *)payload {
    CDVPluginResult* result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:payload];
    [self.commandDelegate sendPluginResult:result callbackId:((CDVInvokedUrlCommand*)command).callbackId];
}

@end
