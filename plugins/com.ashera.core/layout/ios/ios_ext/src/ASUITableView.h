//start - imports
#import <UIKit/UIKit.h>
#include <J2ObjC_header.h>
#include "IWidget.h"
#include "ILifeCycleDecorator.h"
#include "java/util/List.h"
#include "CGRectWrapper.h"
#import "INativeWidget.h"
#include "View.h"
//end - imports
#import "CustomUITableViewCell.h"

@interface ASUITableView : UITableView<INativeWidget>

//start - body
@property(nonatomic, weak) id<ASIWidget> widget;
@property(nonatomic, retain) NSString* commandRegex;
//end - body

@property jboolean stackFromBottom;
@property jboolean trackSelectedCell;
@property(nonatomic, weak) CustomUITableViewCell* currentSelectedCell;
@end



