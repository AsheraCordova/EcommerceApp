//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-ios-widgets\ios_widget_library\src\main\java\com\ashera\layout\MeasurableViewGroup.java
//

#include "BaseMeasurableViewGroup.h"
#include "IWidget.h"
#include "J2ObjC_source.h"
#include "MeasurableViewGroup.h"


@implementation ASMeasurableViewGroup

- (instancetype)initWithASIWidget:(id<ASIWidget>)widget {
  ASMeasurableViewGroup_initWithASIWidget_(self, widget);
  return self;
}

- (jint)nativeMeasureWidthWithId:(id)uiView {
  CGSize maximumLabelSize = CGSizeMake(CGFLOAT_MAX,CGFLOAT_MAX);
  CGSize requiredSize = [((UIView*)uiView) sizeThatFits:maximumLabelSize];
  return ceil(requiredSize.width);
}

- (jint)nativeMeasureHeightWithId:(id)uiView
                          withInt:(jint)width {
  CGSize maximumLabelSize = CGSizeMake(width,CGFLOAT_MAX);
  CGSize requiredSize = [((UIView*)uiView) sizeThatFits:maximumLabelSize];
  return ceil(requiredSize.height);
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, 0, -1, -1, -1, -1 },
    { NULL, "I", 0x101, 1, 2, -1, -1, -1, -1 },
    { NULL, "I", 0x101, 3, 4, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(initWithASIWidget:);
  methods[1].selector = @selector(nativeMeasureWidthWithId:);
  methods[2].selector = @selector(nativeMeasureHeightWithId:withInt:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "LASIWidget;", "nativeMeasureWidth", "LNSObject;", "nativeMeasureHeight", "LNSObject;I" };
  static const J2ObjcClassInfo _ASMeasurableViewGroup = { "MeasurableViewGroup", "com.ashera.layout", ptrTable, methods, NULL, 7, 0x1, 3, 0, -1, -1, -1, -1, -1 };
  return &_ASMeasurableViewGroup;
}

@end

void ASMeasurableViewGroup_initWithASIWidget_(ASMeasurableViewGroup *self, id<ASIWidget> widget) {
  ASBaseMeasurableViewGroup_initWithASIWidget_(self, widget);
}

ASMeasurableViewGroup *new_ASMeasurableViewGroup_initWithASIWidget_(id<ASIWidget> widget) {
  J2OBJC_NEW_IMPL(ASMeasurableViewGroup, initWithASIWidget_, widget)
}

ASMeasurableViewGroup *create_ASMeasurableViewGroup_initWithASIWidget_(id<ASIWidget> widget) {
  J2OBJC_CREATE_IMPL(ASMeasurableViewGroup, initWithASIWidget_, widget)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ASMeasurableViewGroup)
