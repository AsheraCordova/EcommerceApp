//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroid\src\main\stub\r\android\view\WindowManager.java
//

#include "J2ObjC_source.h"
#include "WindowManager.h"


@implementation ADWindowManager

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ADWindowManager_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "LADWindowManager_LayoutParams;" };
  static const J2ObjcClassInfo _ADWindowManager = { "WindowManager", "r.android.view", ptrTable, methods, NULL, 7, 0x1, 1, 0, -1, 0, -1, -1, -1 };
  return &_ADWindowManager;
}

@end

void ADWindowManager_init(ADWindowManager *self) {
  NSObject_init(self);
}

ADWindowManager *new_ADWindowManager_init() {
  J2OBJC_NEW_IMPL(ADWindowManager, init)
}

ADWindowManager *create_ADWindowManager_init() {
  J2OBJC_CREATE_IMPL(ADWindowManager, init)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADWindowManager)

@implementation ADWindowManager_LayoutParams

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ADWindowManager_LayoutParams_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "FLAG_FULLSCREEN", "I", .constantValue.asInt = ADWindowManager_LayoutParams_FLAG_FULLSCREEN, 0x19, -1, -1, -1, -1 },
    { "FLAG_FORCE_NOT_FULLSCREEN", "I", .constantValue.asInt = ADWindowManager_LayoutParams_FLAG_FORCE_NOT_FULLSCREEN, 0x19, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "LADWindowManager;" };
  static const J2ObjcClassInfo _ADWindowManager_LayoutParams = { "LayoutParams", "r.android.view", ptrTable, methods, fields, 7, 0x9, 1, 2, 0, -1, -1, -1, -1 };
  return &_ADWindowManager_LayoutParams;
}

@end

void ADWindowManager_LayoutParams_init(ADWindowManager_LayoutParams *self) {
  NSObject_init(self);
}

ADWindowManager_LayoutParams *new_ADWindowManager_LayoutParams_init() {
  J2OBJC_NEW_IMPL(ADWindowManager_LayoutParams, init)
}

ADWindowManager_LayoutParams *create_ADWindowManager_LayoutParams_init() {
  J2OBJC_CREATE_IMPL(ADWindowManager_LayoutParams, init)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADWindowManager_LayoutParams)
