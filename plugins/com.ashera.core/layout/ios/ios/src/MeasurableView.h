//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-ios-widgets\ios_widget_library\src\main\java\com\ashera\layout\MeasurableView.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_MeasurableView")
#ifdef RESTRICT_MeasurableView
#define INCLUDE_ALL_MeasurableView 0
#else
#define INCLUDE_ALL_MeasurableView 1
#endif
#undef RESTRICT_MeasurableView

#if !defined (ASMeasurableView_) && (INCLUDE_ALL_MeasurableView || defined(INCLUDE_ASMeasurableView))
#define ASMeasurableView_

#define RESTRICT_BaseMeasurableView 1
#define INCLUDE_ASBaseMeasurableView 1
#include "BaseMeasurableView.h"

@protocol ASIWidget;

@interface ASMeasurableView : ASBaseMeasurableView

#pragma mark Public

- (instancetype)initWithASIWidget:(id<ASIWidget>)widget;

- (jint)nativeMeasureHeightWithId:(id)uiView
                          withInt:(jint)width;

- (jint)nativeMeasureWidthWithId:(id)uiView;

@end

J2OBJC_EMPTY_STATIC_INIT(ASMeasurableView)

FOUNDATION_EXPORT void ASMeasurableView_initWithASIWidget_(ASMeasurableView *self, id<ASIWidget> widget);

FOUNDATION_EXPORT ASMeasurableView *new_ASMeasurableView_initWithASIWidget_(id<ASIWidget> widget) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASMeasurableView *create_ASMeasurableView_initWithASIWidget_(id<ASIWidget> widget);

J2OBJC_TYPE_LITERAL_HEADER(ASMeasurableView)

@compatibility_alias ComAsheraLayoutMeasurableView ASMeasurableView;

#endif

#pragma pop_macro("INCLUDE_ALL_MeasurableView")
