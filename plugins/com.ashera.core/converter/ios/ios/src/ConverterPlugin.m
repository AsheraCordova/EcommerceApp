//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-ios-widgets\IOSConverter\src\main\java\com\ashera\converter\ConverterPlugin.java
//

#include "BaseConverterPlugin.h"
#include "CGTintColorCommandConverter.h"
#include "ColorConverter.h"
#include "ColorImageConverter.h"
#include "ColorStateConverter.h"
#include "ColorUtil.h"
#include "CommonConverters.h"
#include "ConverterFactory.h"
#include "ConverterPlugin.h"
#include "DrawDrawableCommandConverter.h"
#include "DrawForegroundCommandConverter.h"
#include "DrawImageCommandConverter.h"
#include "DrawImageOrColorCommandConverter.h"
#include "DrawableConverter.h"
#include "FontConverter.h"
#include "IOSPrimitiveArray.h"
#include "ImageConverter.h"
#include "ImageRepeatCommandConverter.h"
#include "J2ObjC_source.h"
#include "PluginInvoker.h"
#include "PluginManager.h"
#include "StringUtils.h"
#include "TintColorCommandConverter.h"
#include "TransformCommandConverter.h"
#include "java/lang/Float.h"
#include "java/lang/RuntimeException.h"

#include <UIKit/UIKit.h>


@interface ASConverterPlugin ()

- (jint)getScaleFactor;

@end

inline NSString *ASConverterPlugin_get_CONVERTER_PLUGIN_NAME(void);
static NSString *ASConverterPlugin_CONVERTER_PLUGIN_NAME = @"converter";
J2OBJC_STATIC_FIELD_OBJ_FINAL(ASConverterPlugin, CONVERTER_PLUGIN_NAME, NSString *)

__attribute__((unused)) static jint ASConverterPlugin_getScaleFactor(ASConverterPlugin *self);

@implementation ASConverterPlugin

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ASConverterPlugin_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (id)getColorWithNSString:(NSString *)color {
  IOSIntArray *colorInt = ASColorUtil_hexStr2IntWithNSString_(color);
  return ASConverterPlugin_getColorWithInt_withInt_(IOSIntArray_Get(nil_chk(colorInt), 0), IOSIntArray_Get(colorInt, 1));
}

+ (id)getColorWithInt:(jint)hexint
              withInt:(jint)alpha {
  return ASConverterPlugin_getColorWithInt_withInt_(hexint, alpha);
}

- (jfloat)convertDpToPixelWithNSString:(NSString *)dimen {
  if ([((NSString *) nil_chk(dimen)) java_hasSuffix:@"dp"]) {
    return JavaLangFloat_parseFloatWithNSString_([dimen java_replace:@"dp" withSequence:@""]) * ASPluginInvoker_getDisplayMetricDensity();
  }
  @throw new_JavaLangRuntimeException_initWithNSString_(JreStrcat("$$", @"unsupported dimesion type ", dimen));
}

- (jint)getScaleFactor {
  return ASConverterPlugin_getScaleFactor(self);
}

- (jfloat)convertSpToPixelWithNSString:(NSString *)dimen {
  if ([((NSString *) nil_chk(dimen)) java_hasSuffix:@"sp"]) {
    return JavaLangFloat_parseFloatWithNSString_([dimen java_replace:@"sp" withSequence:@""]) * ASPluginInvoker_getDisplayMetricDensity();
  }
  @throw new_JavaLangRuntimeException_initWithNSString_(JreStrcat("$$", @"unsupported dimesion type ", dimen));
}

- (NSString *)getName {
  return ASConverterPlugin_CONVERTER_PLUGIN_NAME;
}

- (NSString *)convertPixelToDpWithId:(id)px
                         withBoolean:(jboolean)isInt {
  jfloat f = [((NSNumber *) nil_chk(((NSNumber *) cast_chk(px, [NSNumber class])))) floatValue] / ASPluginInvoker_getDisplayMetricDensity();
  if (isInt) {
    return JreStrcat("$$", ASStringUtils_floatToStringWithFloat_(JreFpToInt(f)), @"dp");
  }
  return JreStrcat("$$", ASStringUtils_floatToStringWithFloat_(f), @"dp");
}

- (NSString *)convertPixelToSpWithId:(id)px
                         withBoolean:(jboolean)isInt {
  jfloat scalingFactor = 1;
  jfloat f = [((NSNumber *) nil_chk(((NSNumber *) cast_chk(px, [NSNumber class])))) floatValue] / ASPluginInvoker_getDisplayMetricDensity() / scalingFactor;
  if (isInt) {
    return JreStrcat("$$", ASStringUtils_floatToStringWithFloat_(JreFpToInt(f)), @"sp");
  }
  return JreStrcat("$$", ASStringUtils_floatToStringWithFloat_(f), @"sp");
}

+ (void)initPlugin {
  ASConverterPlugin_initPlugin();
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LNSObject;", 0x1, 0, 1, -1, -1, -1, -1 },
    { NULL, "LNSObject;", 0x109, 0, 2, -1, -1, -1, -1 },
    { NULL, "F", 0x1, 3, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x102, -1, -1, -1, -1, -1, -1 },
    { NULL, "F", 0x1, 4, 1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 5, 6, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 7, 6, -1, -1, -1, -1 },
    { NULL, "V", 0x9, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(getColorWithNSString:);
  methods[2].selector = @selector(getColorWithInt:withInt:);
  methods[3].selector = @selector(convertDpToPixelWithNSString:);
  methods[4].selector = @selector(getScaleFactor);
  methods[5].selector = @selector(convertSpToPixelWithNSString:);
  methods[6].selector = @selector(getName);
  methods[7].selector = @selector(convertPixelToDpWithId:withBoolean:);
  methods[8].selector = @selector(convertPixelToSpWithId:withBoolean:);
  methods[9].selector = @selector(initPlugin);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "CONVERTER_PLUGIN_NAME", "LNSString;", .constantValue.asLong = 0, 0x1a, -1, 8, -1, -1 },
  };
  static const void *ptrTable[] = { "getColor", "LNSString;", "II", "convertDpToPixel", "convertSpToPixel", "convertPixelToDp", "LNSObject;Z", "convertPixelToSp", &ASConverterPlugin_CONVERTER_PLUGIN_NAME };
  static const J2ObjcClassInfo _ASConverterPlugin = { "ConverterPlugin", "com.ashera.converter", ptrTable, methods, fields, 7, 0x1, 10, 1, -1, -1, -1, -1, -1 };
  return &_ASConverterPlugin;
}

@end

void ASConverterPlugin_init(ASConverterPlugin *self) {
  ASBaseConverterPlugin_init(self);
}

ASConverterPlugin *new_ASConverterPlugin_init() {
  J2OBJC_NEW_IMPL(ASConverterPlugin, init)
}

ASConverterPlugin *create_ASConverterPlugin_init() {
  J2OBJC_CREATE_IMPL(ASConverterPlugin, init)
}

id ASConverterPlugin_getColorWithInt_withInt_(jint hexint, jint alpha) {
  ASConverterPlugin_initialize();
  // Create color object, specifying alpha as well
  UIColor *color =
  [UIColor colorWithRed:((CGFloat) ((hexint & 0xFF0000) >> 16))/255
  green:((CGFloat) ((hexint & 0xFF00) >> 8))/255
  blue:((CGFloat) (hexint & 0xFF))/255
  alpha:alpha/255.0];
  
  return color;
}

jint ASConverterPlugin_getScaleFactor(ASConverterPlugin *self) {
  return [UIScreen mainScreen].scale;
}

void ASConverterPlugin_initPlugin() {
  ASConverterPlugin_initialize();
  ASPluginManager_register__WithASIPlugin_(new_ASConverterPlugin_init());
  ASCommonConverters_init__();
  ASConverterFactory_register__WithNSString_withASIConverter_(@"color", new_ASColorConverter_init());
  ASConverterFactory_register__WithNSString_withASIConverter_(@"colorimage", new_ASColorImageConverter_init());
  ASConverterFactory_register__WithNSString_withASIConverter_(@"image", new_ASImageConverter_init());
  ASConverterFactory_register__WithNSString_withASIConverter_(@"drawable", new_ASDrawableConverter_init());
  ASConverterFactory_register__WithNSString_withASIConverter_(@"font", new_ASFontConverter_init());
  ASConverterFactory_register__WithNSString_withASIConverter_(@"colorstate", new_ASColorStateConverter_init());
  ASConverterFactory_registerCommandConverterWithASAttributeCommand_(new_ASImageRepeatCommandConverter_initWithNSString_(@"imageRepeat"));
  ASConverterFactory_registerCommandConverterWithASAttributeCommand_(new_ASTintColorCommandConverter_initWithNSString_(@"tintColor"));
  ASConverterFactory_registerCommandConverterWithASAttributeCommand_(new_ASCGTintColorCommandConverter_initWithNSString_(@"cgTintColor"));
  ASConverterFactory_registerCommandConverterWithASAttributeCommand_(new_ASDrawImageCommandConverter_initWithNSString_(@"drawImage"));
  ASConverterFactory_registerCommandConverterWithASAttributeCommand_(new_ASDrawImageOrColorCommandConverter_initWithNSString_(@"drawImageOrColor"));
  ASConverterFactory_registerCommandConverterWithASAttributeCommand_(new_ASDrawForegroundCommandConverter_initWithNSString_(@"drawForeground"));
  ASConverterFactory_registerCommandConverterWithASAttributeCommand_(new_ASDrawDrawableCommandConverter_initWithNSString_(@"drawDrawableIcon"));
  ASConverterFactory_registerCommandConverterWithASAttributeCommand_(new_ASTransformCommandConverter_initWithNSString_(@"transform"));
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ASConverterPlugin)
