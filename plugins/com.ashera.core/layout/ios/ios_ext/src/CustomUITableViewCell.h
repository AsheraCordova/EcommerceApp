#import <UIKit/UIKit.h>

@interface CustomUITableViewCell : UITableViewCell
@property NSObject* data;

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier data:(NSObject*) data;
@end