//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-widget_library\widget_library\src\com\ashera\model\MethodHandlerFactory.java
//

#include "J2ObjC_source.h"
#include "MethodHandler.h"
#include "MethodHandlerFactory.h"
#include "java/util/ArrayList.h"
#include "java/util/List.h"

@protocol JavaUtilList;


inline id<JavaUtilList> ASMethodHandlerFactory_get_registrations(void);
inline id<JavaUtilList> ASMethodHandlerFactory_set_registrations(id<JavaUtilList> value);
static id<JavaUtilList> ASMethodHandlerFactory_registrations;
J2OBJC_STATIC_FIELD_OBJ(ASMethodHandlerFactory, registrations, id<JavaUtilList>)

J2OBJC_INITIALIZED_DEFN(ASMethodHandlerFactory)

@implementation ASMethodHandlerFactory

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ASMethodHandlerFactory_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

+ (void)init__ {
  ASMethodHandlerFactory_init__();
}

+ (id<JavaUtilList>)getRegistrations {
  return ASMethodHandlerFactory_getRegistrations();
}

+ (void)register__WithASMethodHandler:(id<ASMethodHandler>)methodHandler {
  ASMethodHandlerFactory_register__WithASMethodHandler_(methodHandler);
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x9, 0, -1, -1, -1, -1, -1 },
    { NULL, "LJavaUtilList;", 0x9, -1, -1, -1, 1, -1, -1 },
    { NULL, "V", 0x9, 2, 3, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(init__);
  methods[2].selector = @selector(getRegistrations);
  methods[3].selector = @selector(register__WithASMethodHandler:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "registrations", "LJavaUtilList;", .constantValue.asLong = 0, 0xa, -1, 4, 5, -1 },
  };
  static const void *ptrTable[] = { "init", "()Ljava/util/List<Lcom/ashera/model/MethodHandler;>;", "register", "LASMethodHandler;", &ASMethodHandlerFactory_registrations, "Ljava/util/List<Lcom/ashera/model/MethodHandler;>;" };
  static const J2ObjcClassInfo _ASMethodHandlerFactory = { "MethodHandlerFactory", "com.ashera.model", ptrTable, methods, fields, 7, 0x1, 4, 1, -1, -1, -1, -1, -1 };
  return &_ASMethodHandlerFactory;
}

+ (void)initialize {
  if (self == [ASMethodHandlerFactory class]) {
    JreStrongAssignAndConsume(&ASMethodHandlerFactory_registrations, new_JavaUtilArrayList_init());
    J2OBJC_SET_INITIALIZED(ASMethodHandlerFactory)
  }
}

@end

void ASMethodHandlerFactory_init(ASMethodHandlerFactory *self) {
  NSObject_init(self);
}

ASMethodHandlerFactory *new_ASMethodHandlerFactory_init() {
  J2OBJC_NEW_IMPL(ASMethodHandlerFactory, init)
}

ASMethodHandlerFactory *create_ASMethodHandlerFactory_init() {
  J2OBJC_CREATE_IMPL(ASMethodHandlerFactory, init)
}

void ASMethodHandlerFactory_init__() {
  ASMethodHandlerFactory_initialize();
}

id<JavaUtilList> ASMethodHandlerFactory_getRegistrations() {
  ASMethodHandlerFactory_initialize();
  return ASMethodHandlerFactory_registrations;
}

void ASMethodHandlerFactory_register__WithASMethodHandler_(id<ASMethodHandler> methodHandler) {
  ASMethodHandlerFactory_initialize();
  [((id<JavaUtilList>) nil_chk(ASMethodHandlerFactory_registrations)) addWithId:methodHandler];
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ASMethodHandlerFactory)
