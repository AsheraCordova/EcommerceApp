//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-widget_library\widget_library\src\com\ashera\widget\MeasureEvent.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_MeasureEvent")
#ifdef RESTRICT_MeasureEvent
#define INCLUDE_ALL_MeasureEvent 0
#else
#define INCLUDE_ALL_MeasureEvent 1
#endif
#undef RESTRICT_MeasureEvent

#if !defined (ASMeasureEvent_) && (INCLUDE_ALL_MeasureEvent || defined(INCLUDE_ASMeasureEvent))
#define ASMeasureEvent_

#define RESTRICT_WidgetEvent 1
#define INCLUDE_ASWidgetEvent 1
#include "WidgetEvent.h"

@interface ASMeasureEvent : ASWidgetEvent

#pragma mark Public

- (instancetype)init;

- (jint)getHeight;

- (jint)getWidth;

- (void)setHeightWithInt:(jint)height;

- (void)setWidthWithInt:(jint)width;

@end

J2OBJC_EMPTY_STATIC_INIT(ASMeasureEvent)

FOUNDATION_EXPORT void ASMeasureEvent_init(ASMeasureEvent *self);

FOUNDATION_EXPORT ASMeasureEvent *new_ASMeasureEvent_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASMeasureEvent *create_ASMeasureEvent_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ASMeasureEvent)

@compatibility_alias ComAsheraWidgetMeasureEvent ASMeasureEvent;

#endif

#pragma pop_macro("INCLUDE_ALL_MeasureEvent")
