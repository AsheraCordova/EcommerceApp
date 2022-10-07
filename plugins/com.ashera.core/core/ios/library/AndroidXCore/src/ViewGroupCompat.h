//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroidX-core\src\main\java\androidx\core\view\ViewGroupCompat.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_ViewGroupCompat")
#ifdef RESTRICT_ViewGroupCompat
#define INCLUDE_ALL_ViewGroupCompat 0
#else
#define INCLUDE_ALL_ViewGroupCompat 1
#endif
#undef RESTRICT_ViewGroupCompat

#if !defined (ADXViewGroupCompat_) && (INCLUDE_ALL_ViewGroupCompat || defined(INCLUDE_ADXViewGroupCompat))
#define ADXViewGroupCompat_

@class ADViewGroup;

@interface ADXViewGroupCompat : NSObject

#pragma mark Public

- (instancetype)init;

+ (jint)getLayoutModeWithADViewGroup:(ADViewGroup *)view;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXViewGroupCompat)

FOUNDATION_EXPORT void ADXViewGroupCompat_init(ADXViewGroupCompat *self);

FOUNDATION_EXPORT ADXViewGroupCompat *new_ADXViewGroupCompat_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXViewGroupCompat *create_ADXViewGroupCompat_init(void);

FOUNDATION_EXPORT jint ADXViewGroupCompat_getLayoutModeWithADViewGroup_(ADViewGroup *view);

J2OBJC_TYPE_LITERAL_HEADER(ADXViewGroupCompat)

@compatibility_alias AndroidxCoreViewViewGroupCompat ADXViewGroupCompat;

#endif

#pragma pop_macro("INCLUDE_ALL_ViewGroupCompat")
