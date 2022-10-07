#import <Cordova/CDV.h>
#include "CommandHelper.h"

@interface CoreCordovaPlugin : CDVPlugin<ASCommandHelper_SucessCallBack>
	- (void)onDeviceReady:(CDVInvokedUrlCommand*)command;
	- (void)executeCommand:(CDVInvokedUrlCommand*)command;
@end
