#import <Cordova/CDV.h>

@interface AndroidLayoutsCordovaPlugin : CDVPlugin

- (void) onDeviceReady:(CDVInvokedUrlCommand*)command;
- (void) executeCommand:(CDVInvokedUrlCommand*)command;
- (void) startActivity:(CDVInvokedUrlCommand*)command;
@end
