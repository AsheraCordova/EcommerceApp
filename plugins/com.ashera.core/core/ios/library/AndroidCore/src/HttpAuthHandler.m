//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroid\src\main\stub\r\android\webkit\HttpAuthHandler.java
//

#include "HttpAuthHandler.h"
#include "J2ObjC_source.h"


@implementation ADHttpAuthHandler

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ADHttpAuthHandler_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (void)cancel {
}

- (void)proceedWithNSString:(NSString *)username
               withNSString:(NSString *)password {
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 0, 1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(cancel);
  methods[2].selector = @selector(proceedWithNSString:withNSString:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "proceed", "LNSString;LNSString;" };
  static const J2ObjcClassInfo _ADHttpAuthHandler = { "HttpAuthHandler", "r.android.webkit", ptrTable, methods, NULL, 7, 0x1, 3, 0, -1, -1, -1, -1, -1 };
  return &_ADHttpAuthHandler;
}

@end

void ADHttpAuthHandler_init(ADHttpAuthHandler *self) {
  NSObject_init(self);
}

ADHttpAuthHandler *new_ADHttpAuthHandler_init() {
  J2OBJC_NEW_IMPL(ADHttpAuthHandler, init)
}

ADHttpAuthHandler *create_ADHttpAuthHandler_init() {
  J2OBJC_CREATE_IMPL(ADHttpAuthHandler, init)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADHttpAuthHandler)
