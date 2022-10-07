#import "CustomUITableViewCell.h"

@implementation CustomUITableViewCell
- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier data:(NSObject*) data
{
    self = [super initWithStyle:style reuseIdentifier:reuseIdentifier];
    self.autoresizesSubviews = YES;
    self.data = data;
    return self;
}
@end