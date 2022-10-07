//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroid\src\main\stub\r\android\webkit\MimeTypeMap.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_MimeTypeMap")
#ifdef RESTRICT_MimeTypeMap
#define INCLUDE_ALL_MimeTypeMap 0
#else
#define INCLUDE_ALL_MimeTypeMap 1
#endif
#undef RESTRICT_MimeTypeMap

#if !defined (ADMimeTypeMap_) && (INCLUDE_ALL_MimeTypeMap || defined(INCLUDE_ADMimeTypeMap))
#define ADMimeTypeMap_

@interface ADMimeTypeMap : NSObject

#pragma mark Public

- (instancetype)init;

- (NSString *)getMimeTypeFromExtensionWithNSString:(NSString *)extension;

+ (ADMimeTypeMap *)getSingleton;

@end

J2OBJC_EMPTY_STATIC_INIT(ADMimeTypeMap)

FOUNDATION_EXPORT void ADMimeTypeMap_init(ADMimeTypeMap *self);

FOUNDATION_EXPORT ADMimeTypeMap *new_ADMimeTypeMap_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADMimeTypeMap *create_ADMimeTypeMap_init(void);

FOUNDATION_EXPORT ADMimeTypeMap *ADMimeTypeMap_getSingleton(void);

J2OBJC_TYPE_LITERAL_HEADER(ADMimeTypeMap)

@compatibility_alias RAndroidWebkitMimeTypeMap ADMimeTypeMap;

#endif

#pragma pop_macro("INCLUDE_ALL_MimeTypeMap")
