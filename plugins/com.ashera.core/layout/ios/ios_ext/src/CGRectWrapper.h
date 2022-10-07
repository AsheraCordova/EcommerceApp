#ifndef CGRectWrapper_h
#define CGRectWrapper_h
@interface CGRectWrapper : NSObject
    @property (nonatomic, readwrite) CGRect rect;
    @property (nonatomic, readwrite) CGPoint contentOffset;
@end
#endif
