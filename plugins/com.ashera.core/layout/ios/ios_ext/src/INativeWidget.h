#import <UIKit/UIKit.h>
#include <J2ObjC_header.h>
#include "IWidget.h"

@protocol INativeWidget <NSObject>

-(id<ASIWidget>) getWidget;

@end

