//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-widget_library\Plugin_Converter\src\com\ashera\validations\IsPositiveInteger.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_IsPositiveInteger")
#ifdef RESTRICT_IsPositiveInteger
#define INCLUDE_ALL_IsPositiveInteger 0
#else
#define INCLUDE_ALL_IsPositiveInteger 1
#endif
#undef RESTRICT_IsPositiveInteger

#if !defined (ASIsPositiveInteger_) && (INCLUDE_ALL_IsPositiveInteger || defined(INCLUDE_ASIsPositiveInteger))
#define ASIsPositiveInteger_

#define RESTRICT_BaseValidator 1
#define INCLUDE_ASBaseValidator 1
#include "BaseValidator.h"

@class IOSObjectArray;
@protocol ASIWidget;
@protocol ASValidation;

/*!
 @brief Class for IsPositiveInteger form validation
 */
@interface ASIsPositiveInteger : ASBaseValidator

#pragma mark Public

- (instancetype)init;

/*!
 @param context Context class instance
 @return error message string
 */
- (NSString *)getDefaultErrorMessageWithASIWidget:(id<ASIWidget>)widget;

/*!
 @brief checks if the field is a positive number
 @param text Text string
 @return isValid true or false
 */
- (jboolean)isValidWithNSString:(NSString *)text
                  withASIWidget:(id<ASIWidget>)widget;

- (id<ASValidation>)newInstanceWithNSStringArray:(IOSObjectArray *)argument OBJC_METHOD_FAMILY_NONE;

@end

J2OBJC_EMPTY_STATIC_INIT(ASIsPositiveInteger)

inline NSString *ASIsPositiveInteger_get_POSITIVE_INT_PATTERN(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT NSString *ASIsPositiveInteger_POSITIVE_INT_PATTERN;
J2OBJC_STATIC_FIELD_OBJ_FINAL(ASIsPositiveInteger, POSITIVE_INT_PATTERN, NSString *)

FOUNDATION_EXPORT void ASIsPositiveInteger_init(ASIsPositiveInteger *self);

FOUNDATION_EXPORT ASIsPositiveInteger *new_ASIsPositiveInteger_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ASIsPositiveInteger *create_ASIsPositiveInteger_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ASIsPositiveInteger)

@compatibility_alias ComAsheraValidationsIsPositiveInteger ASIsPositiveInteger;

#endif

#pragma pop_macro("INCLUDE_ALL_IsPositiveInteger")
