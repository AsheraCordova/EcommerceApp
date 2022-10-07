//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-widget_library\widget_library\src\com\ashera\attributedtext\StyleInterval.java
//

#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "Interval.h"
#include "J2ObjC_source.h"
#include "StyleInterval.h"
#include "WidgetAttributeMap.h"


@interface ASStyleInterval () {
 @public
  ASWidgetAttributeMap *style_;
}

@end

J2OBJC_FIELD_SETTER(ASStyleInterval, style_, ASWidgetAttributeMap *)

@implementation ASStyleInterval

- (ASWidgetAttributeMap *)getStyle {
  return style_;
}

- (void)setStyleWithASWidgetAttributeMap:(ASWidgetAttributeMap *)style {
  JreStrongAssign(&self->style_, style);
}

- (instancetype)initWithInt:(jint)start
                    withInt:(jint)end
   withASWidgetAttributeMap:(ASWidgetAttributeMap *)style {
  ASStyleInterval_initWithInt_withInt_withASWidgetAttributeMap_(self, start, end, style);
  return self;
}

- (NSString *)description {
  return JreStrcat("CI$I$@C", '[', [self getStart], @", ", [self getEnd], @", ", self->style_, ']');
}

- (ASInterval *)makeNodeWithInt:(jint)start
                        withInt:(jint)end
              withNSObjectArray:(IOSObjectArray *)arguments {
  return create_ASStyleInterval_initWithInt_withInt_withASWidgetAttributeMap_(start, end, (ASWidgetAttributeMap *) cast_chk(IOSObjectArray_Get(nil_chk(arguments), 0), [ASWidgetAttributeMap class]));
}

- (IOSObjectArray *)getArgs {
  return [IOSObjectArray arrayWithObjects:(id[]){ style_ } count:1 type:NSObject_class_()];
}

- (void)dealloc {
  RELEASE_(style_);
  [super dealloc];
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LASWidgetAttributeMap;", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 0, 1, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 2, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 3, -1, -1, -1, -1, -1 },
    { NULL, "LASInterval;", 0x81, 4, 5, -1, -1, -1, -1 },
    { NULL, "[LNSObject;", 0x1, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(getStyle);
  methods[1].selector = @selector(setStyleWithASWidgetAttributeMap:);
  methods[2].selector = @selector(initWithInt:withInt:withASWidgetAttributeMap:);
  methods[3].selector = @selector(description);
  methods[4].selector = @selector(makeNodeWithInt:withInt:withNSObjectArray:);
  methods[5].selector = @selector(getArgs);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "style_", "LASWidgetAttributeMap;", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "setStyle", "LASWidgetAttributeMap;", "IILASWidgetAttributeMap;", "toString", "makeNode", "II[LNSObject;" };
  static const J2ObjcClassInfo _ASStyleInterval = { "StyleInterval", "com.ashera.attributedtext", ptrTable, methods, fields, 7, 0x1, 6, 1, -1, -1, -1, -1, -1 };
  return &_ASStyleInterval;
}

@end

void ASStyleInterval_initWithInt_withInt_withASWidgetAttributeMap_(ASStyleInterval *self, jint start, jint end, ASWidgetAttributeMap *style) {
  ASInterval_initWithInt_withInt_(self, start, end);
  JreStrongAssign(&self->style_, style);
}

ASStyleInterval *new_ASStyleInterval_initWithInt_withInt_withASWidgetAttributeMap_(jint start, jint end, ASWidgetAttributeMap *style) {
  J2OBJC_NEW_IMPL(ASStyleInterval, initWithInt_withInt_withASWidgetAttributeMap_, start, end, style)
}

ASStyleInterval *create_ASStyleInterval_initWithInt_withInt_withASWidgetAttributeMap_(jint start, jint end, ASWidgetAttributeMap *style) {
  J2OBJC_CREATE_IMPL(ASStyleInterval, initWithInt_withInt_withASWidgetAttributeMap_, start, end, style)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ASStyleInterval)
