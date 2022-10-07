//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroid\src\main\java\r\android\text\util\SpannableImpl.java
//

#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "J2ObjC_source.h"
#include "Linkify.h"
#include "SpannableImpl.h"
#include "java/lang/CharSequence.h"
#include "java/util/stream/IntStream.h"


@implementation ADSpannableImpl

- (instancetype)initWithNSString:(NSString *)str {
  ADSpannableImpl_initWithNSString_(self, str);
  return self;
}

- (jint)java_length {
  return [((NSString *) nil_chk(self->str_)) java_length];
}

- (jchar)charAtWithInt:(jint)index {
  return [((NSString *) nil_chk(self->str_)) charAtWithInt:index];
}

- (id<JavaLangCharSequence>)subSequenceFrom:(jint)start
                                         to:(jint)end {
  return [((NSString *) nil_chk(self->str_)) subSequenceFrom:start to:end];
}

- (IOSObjectArray *)getSpansWithInt:(jint)i
                            withInt:(jint)length
                       withIOSClass:(IOSClass *)class1 {
  return [IOSObjectArray arrayWithLength:0 type:ADLinkify_URLSpan_class_()];
}

- (void)removeSpanWithADLinkify_URLSpan:(ADLinkify_URLSpan *)urlSpan {
}

- (NSString *)description {
  return str_;
}

- (id<JavaUtilStreamIntStream>)chars {
  return JavaLangCharSequence_chars(self);
}

- (id<JavaUtilStreamIntStream>)codePoints {
  return JavaLangCharSequence_codePoints(self);
}

- (void)dealloc {
  RELEASE_(str_);
  [super dealloc];
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, 0, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 1, -1, -1, -1, -1, -1 },
    { NULL, "C", 0x1, 2, 3, -1, -1, -1, -1 },
    { NULL, "LJavaLangCharSequence;", 0x1, 4, 5, -1, -1, -1, -1 },
    { NULL, "[LADLinkify_URLSpan;", 0x1, 6, 7, -1, 8, -1, -1 },
    { NULL, "V", 0x1, 9, 10, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 11, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(initWithNSString:);
  methods[1].selector = @selector(java_length);
  methods[2].selector = @selector(charAtWithInt:);
  methods[3].selector = @selector(subSequenceFrom:to:);
  methods[4].selector = @selector(getSpansWithInt:withInt:withIOSClass:);
  methods[5].selector = @selector(removeSpanWithADLinkify_URLSpan:);
  methods[6].selector = @selector(description);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "str_", "LNSString;", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "LNSString;", "length", "charAt", "I", "subSequence", "II", "getSpans", "IILIOSClass;", "(IILjava/lang/Class<Lr/android/text/util/Linkify$URLSpan;>;)[Lr/android/text/util/Linkify$URLSpan;", "removeSpan", "LADLinkify_URLSpan;", "toString" };
  static const J2ObjcClassInfo _ADSpannableImpl = { "SpannableImpl", "r.android.text.util", ptrTable, methods, fields, 7, 0x1, 7, 1, -1, -1, -1, -1, -1 };
  return &_ADSpannableImpl;
}

@end

void ADSpannableImpl_initWithNSString_(ADSpannableImpl *self, NSString *str) {
  NSObject_init(self);
  JreStrongAssign(&self->str_, str);
}

ADSpannableImpl *new_ADSpannableImpl_initWithNSString_(NSString *str) {
  J2OBJC_NEW_IMPL(ADSpannableImpl, initWithNSString_, str)
}

ADSpannableImpl *create_ADSpannableImpl_initWithNSString_(NSString *str) {
  J2OBJC_CREATE_IMPL(ADSpannableImpl, initWithNSString_, str)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADSpannableImpl)
