//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroidXConstraintLayout\src\main\java\androidx\constraintlayout\motion\widget\CLDebug.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_CLDebug")
#ifdef RESTRICT_CLDebug
#define INCLUDE_ALL_CLDebug 0
#else
#define INCLUDE_ALL_CLDebug 1
#endif
#undef RESTRICT_CLDebug

#if !defined (ADXCLDebug_) && (INCLUDE_ALL_CLDebug || defined(INCLUDE_ADXCLDebug))
#define ADXCLDebug_

@class ADView;

@interface ADXCLDebug : NSObject

#pragma mark Public

- (instancetype)init;

+ (NSString *)getNameWithADView:(ADView *)view;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXCLDebug)

FOUNDATION_EXPORT void ADXCLDebug_init(ADXCLDebug *self);

FOUNDATION_EXPORT ADXCLDebug *new_ADXCLDebug_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXCLDebug *create_ADXCLDebug_init(void);

FOUNDATION_EXPORT NSString *ADXCLDebug_getNameWithADView_(ADView *view);

J2OBJC_TYPE_LITERAL_HEADER(ADXCLDebug)

@compatibility_alias AndroidxConstraintlayoutMotionWidgetCLDebug ADXCLDebug;

#endif

#pragma pop_macro("INCLUDE_ALL_CLDebug")
