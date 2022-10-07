//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-widget_library\widget_library\src\com\ashera\widget\HasLifeCycleDecorators.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_HasLifeCycleDecorators")
#ifdef RESTRICT_HasLifeCycleDecorators
#define INCLUDE_ALL_HasLifeCycleDecorators 0
#else
#define INCLUDE_ALL_HasLifeCycleDecorators 1
#endif
#undef RESTRICT_HasLifeCycleDecorators

#if !defined (ASHasLifeCycleDecorators_) && (INCLUDE_ALL_HasLifeCycleDecorators || defined(INCLUDE_ASHasLifeCycleDecorators))
#define ASHasLifeCycleDecorators_

@class IOSObjectArray;
@protocol ASILifeCycleDecorator;
@protocol JavaLangRunnable;

@protocol ASHasLifeCycleDecorators < JavaObject >

- (void)addDecoratorWithASILifeCycleDecorator:(id<ASILifeCycleDecorator>)decorator;

- (void)executeMethodListenersWithNSString:(NSString *)methodName
                         withNSObjectArray:(IOSObjectArray *)objectArray;

- (void)executeMethodListenersWithNSString:(NSString *)methodName
                      withJavaLangRunnable:(id<JavaLangRunnable>)callback
                         withNSObjectArray:(IOSObjectArray *)args;

- (void)setOnMethodCalledWithBoolean:(jboolean)onMethodCalled;

- (jboolean)hasMethodListenerWithNSString:(NSString *)methodName;

@end

J2OBJC_EMPTY_STATIC_INIT(ASHasLifeCycleDecorators)

J2OBJC_TYPE_LITERAL_HEADER(ASHasLifeCycleDecorators)

#define ComAsheraWidgetHasLifeCycleDecorators ASHasLifeCycleDecorators

#endif

#pragma pop_macro("INCLUDE_ALL_HasLifeCycleDecorators")
