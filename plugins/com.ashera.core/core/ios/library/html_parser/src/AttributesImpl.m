//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-widget_library\html_parser\src\repackaged\org\ccil\cowan\tagsoup\AttributesImpl.java
//

#include "AttributesImpl.h"
#include "IOSClass.h"
#include "IOSObjectArray.h"
#include "J2ObjC_source.h"
#include "java/lang/ArrayIndexOutOfBoundsException.h"
#include "java/lang/System.h"
#include "org/xml/sax/Attributes.h"


@interface TSAttributesImpl ()

/*!
 @brief Ensure the internal array's capacity.
 @param n The minimum number of attributes that the array must         be able to hold.
 */
- (void)ensureCapacityWithInt:(jint)n;

/*!
 @brief Report a bad array index in a manipulator.
 @param index The index to report.
 @throw java.lang.ArrayIndexOutOfBoundsExceptionAlways.
 */
- (void)badIndexWithInt:(jint)index;

@end

__attribute__((unused)) static void TSAttributesImpl_ensureCapacityWithInt_(TSAttributesImpl *self, jint n);

__attribute__((unused)) static void TSAttributesImpl_badIndexWithInt_(TSAttributesImpl *self, jint index);

@implementation TSAttributesImpl

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  TSAttributesImpl_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (instancetype)initWithOrgXmlSaxAttributes:(id<OrgXmlSaxAttributes>)atts {
  TSAttributesImpl_initWithOrgXmlSaxAttributes_(self, atts);
  return self;
}

- (jint)getLength {
  return length_;
}

- (NSString *)getURIWithInt:(jint)index {
  if (index >= 0 && index < length_) {
    return IOSObjectArray_Get(nil_chk(data_), index * 5);
  }
  else {
    return nil;
  }
}

- (NSString *)getLocalNameWithInt:(jint)index {
  if (index >= 0 && index < length_) {
    return IOSObjectArray_Get(nil_chk(data_), index * 5 + 1);
  }
  else {
    return nil;
  }
}

- (NSString *)getQNameWithInt:(jint)index {
  if (index >= 0 && index < length_) {
    return IOSObjectArray_Get(nil_chk(data_), index * 5 + 2);
  }
  else {
    return nil;
  }
}

- (NSString *)getTypeWithInt:(jint)index {
  if (index >= 0 && index < length_) {
    return IOSObjectArray_Get(nil_chk(data_), index * 5 + 3);
  }
  else {
    return nil;
  }
}

- (NSString *)getValueWithInt:(jint)index {
  if (index >= 0 && index < length_) {
    return IOSObjectArray_Get(nil_chk(data_), index * 5 + 4);
  }
  else {
    return nil;
  }
}

- (jint)getIndexWithNSString:(NSString *)uri
                withNSString:(NSString *)localName {
  jint max = length_ * 5;
  for (jint i = 0; i < max; i += 5) {
    if ([((NSString *) nil_chk(IOSObjectArray_Get(nil_chk(data_), i))) isEqual:uri] && [((NSString *) nil_chk(IOSObjectArray_Get(nil_chk(data_), i + 1))) isEqual:localName]) {
      return JreIntDiv(i, 5);
    }
  }
  return -1;
}

- (jint)getIndexWithNSString:(NSString *)qName {
  jint max = length_ * 5;
  for (jint i = 0; i < max; i += 5) {
    if ([((NSString *) nil_chk(IOSObjectArray_Get(nil_chk(data_), i + 2))) isEqual:qName]) {
      return JreIntDiv(i, 5);
    }
  }
  return -1;
}

- (NSString *)getTypeWithNSString:(NSString *)uri
                     withNSString:(NSString *)localName {
  jint max = length_ * 5;
  for (jint i = 0; i < max; i += 5) {
    if ([((NSString *) nil_chk(IOSObjectArray_Get(nil_chk(data_), i))) isEqual:uri] && [((NSString *) nil_chk(IOSObjectArray_Get(nil_chk(data_), i + 1))) isEqual:localName]) {
      return IOSObjectArray_Get(nil_chk(data_), i + 3);
    }
  }
  return nil;
}

- (NSString *)getTypeWithNSString:(NSString *)qName {
  jint max = length_ * 5;
  for (jint i = 0; i < max; i += 5) {
    if ([((NSString *) nil_chk(IOSObjectArray_Get(nil_chk(data_), i + 2))) isEqual:qName]) {
      return IOSObjectArray_Get(nil_chk(data_), i + 3);
    }
  }
  return nil;
}

- (NSString *)getValueWithNSString:(NSString *)uri
                      withNSString:(NSString *)localName {
  jint max = length_ * 5;
  for (jint i = 0; i < max; i += 5) {
    if ([((NSString *) nil_chk(IOSObjectArray_Get(nil_chk(data_), i))) isEqual:uri] && [((NSString *) nil_chk(IOSObjectArray_Get(nil_chk(data_), i + 1))) isEqual:localName]) {
      return IOSObjectArray_Get(nil_chk(data_), i + 4);
    }
  }
  return nil;
}

- (NSString *)getValueWithNSString:(NSString *)qName {
  jint max = length_ * 5;
  for (jint i = 0; i < max; i += 5) {
    NSString *myData = IOSObjectArray_Get(nil_chk(data_), i + 2);
    jint indexmyData = [((NSString *) nil_chk(myData)) java_indexOfString:@":"];
    if (indexmyData != -1) {
      myData = [myData java_substring:indexmyData + 1];
    }
    jint indexQname = [((NSString *) nil_chk(qName)) java_indexOfString:@":"];
    if (indexQname != -1) {
      qName = [qName java_substring:indexQname + 1];
    }
    if ([((NSString *) nil_chk(myData)) isEqual:qName]) {
      return IOSObjectArray_Get(nil_chk(data_), i + 4);
    }
  }
  return nil;
}

- (void)clear {
  if (data_ != nil) {
    for (jint i = 0; i < (length_ * 5); i++) IOSObjectArray_Set(data_, i, nil);
  }
  length_ = 0;
}

- (void)setAttributesWithOrgXmlSaxAttributes:(id<OrgXmlSaxAttributes>)atts {
  [self clear];
  length_ = [((id<OrgXmlSaxAttributes>) nil_chk(atts)) getLength];
  if (length_ > 0) {
    JreStrongAssignAndConsume(&data_, [IOSObjectArray newArrayWithLength:length_ * 5 type:NSString_class_()]);
    for (jint i = 0; i < length_; i++) {
      IOSObjectArray_Set(nil_chk(data_), i * 5, [atts getURIWithInt:i]);
      IOSObjectArray_Set(nil_chk(data_), i * 5 + 1, [atts getLocalNameWithInt:i]);
      IOSObjectArray_Set(nil_chk(data_), i * 5 + 2, [atts getQNameWithInt:i]);
      IOSObjectArray_Set(nil_chk(data_), i * 5 + 3, [atts getTypeWithInt:i]);
      IOSObjectArray_Set(nil_chk(data_), i * 5 + 4, [atts getValueWithInt:i]);
    }
  }
}

- (void)addAttributeWithNSString:(NSString *)uri
                    withNSString:(NSString *)localName
                    withNSString:(NSString *)qName
                    withNSString:(NSString *)type
                    withNSString:(NSString *)value {
  TSAttributesImpl_ensureCapacityWithInt_(self, length_ + 1);
  IOSObjectArray_Set(nil_chk(data_), length_ * 5, uri);
  IOSObjectArray_Set(data_, length_ * 5 + 1, localName);
  IOSObjectArray_Set(data_, length_ * 5 + 2, qName);
  IOSObjectArray_Set(data_, length_ * 5 + 3, type);
  IOSObjectArray_Set(data_, length_ * 5 + 4, value);
  length_++;
}

- (void)setAttributeWithInt:(jint)index
               withNSString:(NSString *)uri
               withNSString:(NSString *)localName
               withNSString:(NSString *)qName
               withNSString:(NSString *)type
               withNSString:(NSString *)value {
  if (index >= 0 && index < length_) {
    IOSObjectArray_Set(nil_chk(data_), index * 5, uri);
    IOSObjectArray_Set(data_, index * 5 + 1, localName);
    IOSObjectArray_Set(data_, index * 5 + 2, qName);
    IOSObjectArray_Set(data_, index * 5 + 3, type);
    IOSObjectArray_Set(data_, index * 5 + 4, value);
  }
  else {
    TSAttributesImpl_badIndexWithInt_(self, index);
  }
}

- (void)removeAttributeWithInt:(jint)index {
  if (index >= 0 && index < length_) {
    if (index < length_ - 1) {
      JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(data_, (index + 1) * 5, data_, index * 5, (length_ - index - 1) * 5);
    }
    index = (length_ - 1) * 5;
    IOSObjectArray_Set(nil_chk(data_), index++, nil);
    IOSObjectArray_Set(data_, index++, nil);
    IOSObjectArray_Set(data_, index++, nil);
    IOSObjectArray_Set(data_, index++, nil);
    IOSObjectArray_Set(data_, index, nil);
    length_--;
  }
  else {
    TSAttributesImpl_badIndexWithInt_(self, index);
  }
}

- (void)setURIWithInt:(jint)index
         withNSString:(NSString *)uri {
  if (index >= 0 && index < length_) {
    IOSObjectArray_Set(nil_chk(data_), index * 5, uri);
  }
  else {
    TSAttributesImpl_badIndexWithInt_(self, index);
  }
}

- (void)setLocalNameWithInt:(jint)index
               withNSString:(NSString *)localName {
  if (index >= 0 && index < length_) {
    IOSObjectArray_Set(nil_chk(data_), index * 5 + 1, localName);
  }
  else {
    TSAttributesImpl_badIndexWithInt_(self, index);
  }
}

- (void)setQNameWithInt:(jint)index
           withNSString:(NSString *)qName {
  if (index >= 0 && index < length_) {
    IOSObjectArray_Set(nil_chk(data_), index * 5 + 2, qName);
  }
  else {
    TSAttributesImpl_badIndexWithInt_(self, index);
  }
}

- (void)setTypeWithInt:(jint)index
          withNSString:(NSString *)type {
  if (index >= 0 && index < length_) {
    IOSObjectArray_Set(nil_chk(data_), index * 5 + 3, type);
  }
  else {
    TSAttributesImpl_badIndexWithInt_(self, index);
  }
}

- (void)setValueWithInt:(jint)index
           withNSString:(NSString *)value {
  if (index >= 0 && index < length_) {
    IOSObjectArray_Set(nil_chk(data_), index * 5 + 4, value);
  }
  else {
    TSAttributesImpl_badIndexWithInt_(self, index);
  }
}

- (void)ensureCapacityWithInt:(jint)n {
  TSAttributesImpl_ensureCapacityWithInt_(self, n);
}

- (void)badIndexWithInt:(jint)index {
  TSAttributesImpl_badIndexWithInt_(self, index);
}

- (void)dealloc {
  RELEASE_(data_);
  [super dealloc];
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, NULL, 0x1, -1, 0, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 1, 2, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 3, 2, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 4, 2, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 5, 2, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 6, 2, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 7, 8, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 7, 9, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 5, 8, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 5, 9, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 6, 8, -1, -1, -1, -1 },
    { NULL, "LNSString;", 0x1, 6, 9, -1, -1, -1, -1 },
    { NULL, "V", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 10, 0, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 11, 12, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 13, 14, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 15, 2, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 16, 17, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 18, 17, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 19, 17, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 20, 17, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 21, 17, -1, -1, -1, -1 },
    { NULL, "V", 0x2, 22, 2, -1, -1, -1, -1 },
    { NULL, "V", 0x2, 23, 2, 24, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(initWithOrgXmlSaxAttributes:);
  methods[2].selector = @selector(getLength);
  methods[3].selector = @selector(getURIWithInt:);
  methods[4].selector = @selector(getLocalNameWithInt:);
  methods[5].selector = @selector(getQNameWithInt:);
  methods[6].selector = @selector(getTypeWithInt:);
  methods[7].selector = @selector(getValueWithInt:);
  methods[8].selector = @selector(getIndexWithNSString:withNSString:);
  methods[9].selector = @selector(getIndexWithNSString:);
  methods[10].selector = @selector(getTypeWithNSString:withNSString:);
  methods[11].selector = @selector(getTypeWithNSString:);
  methods[12].selector = @selector(getValueWithNSString:withNSString:);
  methods[13].selector = @selector(getValueWithNSString:);
  methods[14].selector = @selector(clear);
  methods[15].selector = @selector(setAttributesWithOrgXmlSaxAttributes:);
  methods[16].selector = @selector(addAttributeWithNSString:withNSString:withNSString:withNSString:withNSString:);
  methods[17].selector = @selector(setAttributeWithInt:withNSString:withNSString:withNSString:withNSString:withNSString:);
  methods[18].selector = @selector(removeAttributeWithInt:);
  methods[19].selector = @selector(setURIWithInt:withNSString:);
  methods[20].selector = @selector(setLocalNameWithInt:withNSString:);
  methods[21].selector = @selector(setQNameWithInt:withNSString:);
  methods[22].selector = @selector(setTypeWithInt:withNSString:);
  methods[23].selector = @selector(setValueWithInt:withNSString:);
  methods[24].selector = @selector(ensureCapacityWithInt:);
  methods[25].selector = @selector(badIndexWithInt:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "length_", "I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "data_", "[LNSString;", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "LOrgXmlSaxAttributes;", "getURI", "I", "getLocalName", "getQName", "getType", "getValue", "getIndex", "LNSString;LNSString;", "LNSString;", "setAttributes", "addAttribute", "LNSString;LNSString;LNSString;LNSString;LNSString;", "setAttribute", "ILNSString;LNSString;LNSString;LNSString;LNSString;", "removeAttribute", "setURI", "ILNSString;", "setLocalName", "setQName", "setType", "setValue", "ensureCapacity", "badIndex", "LJavaLangArrayIndexOutOfBoundsException;" };
  static const J2ObjcClassInfo _TSAttributesImpl = { "AttributesImpl", "repackaged.org.ccil.cowan.tagsoup", ptrTable, methods, fields, 7, 0x1, 26, 2, -1, -1, -1, -1, -1 };
  return &_TSAttributesImpl;
}

@end

void TSAttributesImpl_init(TSAttributesImpl *self) {
  NSObject_init(self);
  self->length_ = 0;
  JreStrongAssign(&self->data_, nil);
}

TSAttributesImpl *new_TSAttributesImpl_init() {
  J2OBJC_NEW_IMPL(TSAttributesImpl, init)
}

TSAttributesImpl *create_TSAttributesImpl_init() {
  J2OBJC_CREATE_IMPL(TSAttributesImpl, init)
}

void TSAttributesImpl_initWithOrgXmlSaxAttributes_(TSAttributesImpl *self, id<OrgXmlSaxAttributes> atts) {
  NSObject_init(self);
  [self setAttributesWithOrgXmlSaxAttributes:atts];
}

TSAttributesImpl *new_TSAttributesImpl_initWithOrgXmlSaxAttributes_(id<OrgXmlSaxAttributes> atts) {
  J2OBJC_NEW_IMPL(TSAttributesImpl, initWithOrgXmlSaxAttributes_, atts)
}

TSAttributesImpl *create_TSAttributesImpl_initWithOrgXmlSaxAttributes_(id<OrgXmlSaxAttributes> atts) {
  J2OBJC_CREATE_IMPL(TSAttributesImpl, initWithOrgXmlSaxAttributes_, atts)
}

void TSAttributesImpl_ensureCapacityWithInt_(TSAttributesImpl *self, jint n) {
  if (n <= 0) {
    return;
  }
  jint max;
  if (self->data_ == nil || self->data_->size_ == 0) {
    max = 25;
  }
  else if (self->data_->size_ >= n * 5) {
    return;
  }
  else {
    max = self->data_->size_;
  }
  while (max < n * 5) {
    max *= 2;
  }
  IOSObjectArray *newData = [IOSObjectArray arrayWithLength:max type:NSString_class_()];
  if (self->length_ > 0) {
    JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(self->data_, 0, newData, 0, self->length_ * 5);
  }
  JreStrongAssign(&self->data_, newData);
}

void TSAttributesImpl_badIndexWithInt_(TSAttributesImpl *self, jint index) {
  NSString *msg = JreStrcat("$I", @"Attempt to modify attribute at illegal index: ", index);
  @throw create_JavaLangArrayIndexOutOfBoundsException_initWithNSString_(msg);
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(TSAttributesImpl)
