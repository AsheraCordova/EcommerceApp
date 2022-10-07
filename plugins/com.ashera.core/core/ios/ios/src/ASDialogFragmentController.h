#import <UIKit/UIKit.h>
#import "IActivity.h"
#import "GenericFragment.h"
#include "CordovaActivity.h"
#include "ASGenericFragmentController.h"

@interface ASDialogFragmentController : ASGenericFragmentController
	@property NSString* windowCloseOnTouchOutside;
    @property NSString* backgroundDimEnabled;
    @property UIColor* backdropColor;
@end

