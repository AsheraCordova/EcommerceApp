//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-widget_library\widget_library\src\com\ashera\widget\IMaxDimension.java
//

#include "IMaxDimension.h"
#include "J2ObjC_source.h"


@interface ASIMaxDimension : NSObject

@end

@implementation ASIMaxDimension

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "V", 0x401, 0, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x401, 2, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x401, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x401, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(setMaxWidthWithInt:);
  methods[1].selector = @selector(setMaxHeightWithInt:);
  methods[2].selector = @selector(getMaxWidth);
  methods[3].selector = @selector(getMaxHeight);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "setMaxWidth", "I", "setMaxHeight" };
  static const J2ObjcClassInfo _ASIMaxDimension = { "IMaxDimension", "com.ashera.widget", ptrTable, methods, NULL, 7, 0x609, 4, 0, -1, -1, -1, -1, -1 };
  return &_ASIMaxDimension;
}

@end

J2OBJC_INTERFACE_TYPE_LITERAL_SOURCE(ASIMaxDimension)
