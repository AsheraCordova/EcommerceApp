//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-widget_library\widget_library\src\com\ashera\converter\Converter.java
//

#include "Converter.h"
#include "J2ObjC_source.h"


@interface ASConverter : NSObject

@end

@implementation ASConverter

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LNSObject;", 0x401, 0, 1, -1, 2, -1, -1 },
    { NULL, "LNSObject;", 0x401, 3, 4, -1, -1, -1, -1 },
    { NULL, "LASIConverter;", 0x401, 5, 6, -1, -1, -1, -1 },
    { NULL, "LJavaUtilList;", 0x401, 7, 8, -1, 9, -1, -1 },
    { NULL, "LNSObject;", 0x401, 10, 6, -1, -1, -1, -1 },
    { NULL, "F", 0x401, 11, 6, -1, -1, -1, -1 },
    { NULL, "F", 0x401, 12, 6, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x401, 13, 14, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x401, 15, 14, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(convertFromWithASIConverter:withJavaUtilMap:withId:withASIFragment:);
  methods[1].selector = @selector(convertToWithASIConverter:withId:withASIFragment:);
  methods[2].selector = @selector(getConverterWithNSString:);
  methods[3].selector = @selector(getDependentAttributesWithASIConverter:);
  methods[4].selector = @selector(getColorWithNSString:);
  methods[5].selector = @selector(convertDpToPixelWithNSString:);
  methods[6].selector = @selector(convertSpToPixelWithNSString:);
  methods[7].selector = @selector(convertPixelToDpWithId:withBoolean:);
  methods[8].selector = @selector(convertPixelToSpWithId:withBoolean:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "convertFrom", "LASIConverter;LJavaUtilMap;LNSObject;LASIFragment;", "(Lcom/ashera/converter/IConverter;Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;Ljava/lang/Object;Lcom/ashera/core/IFragment;)Ljava/lang/Object;", "convertTo", "LASIConverter;LNSObject;LASIFragment;", "getConverter", "LNSString;", "getDependentAttributes", "LASIConverter;", "(Lcom/ashera/converter/IConverter;)Ljava/util/List<Ljava/lang/String;>;", "getColor", "convertDpToPixel", "convertSpToPixel", "convertPixelToDp", "LNSObject;Z", "convertPixelToSp" };
  static const J2ObjcClassInfo _ASConverter = { "Converter", "com.ashera.converter", ptrTable, methods, NULL, 7, 0x609, 9, 0, -1, -1, -1, -1, -1 };
  return &_ASConverter;
}

@end

J2OBJC_INTERFACE_TYPE_LITERAL_SOURCE(ASConverter)
