//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroid\src\main\java\r\android\content\Intent.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_Intent")
#ifdef RESTRICT_Intent
#define INCLUDE_ALL_Intent 0
#else
#define INCLUDE_ALL_Intent 1
#endif
#undef RESTRICT_Intent

#if !defined (ADIntent_) && (INCLUDE_ALL_Intent || defined(INCLUDE_ADIntent))
#define ADIntent_

@class ADBundle;
@class ADIntent_ClipData;
@class ADUri;
@protocol JavaIoSerializable;

@interface ADIntent : NSObject

#pragma mark Public

- (instancetype)init;

- (instancetype)initWithInt:(jint)actionView;

- (void)addCategoryWithInt:(jint)categoryBrowsable;

- (id)getAction;

- (ADIntent_ClipData *)getClipData;

- (ADUri *)getData;

- (id)getExtraWithNSString:(NSString *)localIntentOptionKey;

- (ADBundle *)getExtras;

- (id<JavaIoSerializable>)getSerializableExtraWithNSString:(NSString *)localIntentOptionKey;

- (NSString *)getStringExtraWithNSString:(NSString *)localDataKey;

- (jboolean)hasExtraWithNSString:(NSString *)extraState;

- (ADIntent *)putExtraWithNSString:(NSString *)name
                            withId:(id)value;

- (void)setDataWithADUri:(ADUri *)uri;

- (void)setDataAndTypeWithADUri:(ADUri *)uri
                   withNSString:(NSString *)mimeType;

- (void)setTypeWithNSString:(NSString *)string;

@end

J2OBJC_EMPTY_STATIC_INIT(ADIntent)

inline jint ADIntent_get_ACTION_VIEW(void);
#define ADIntent_ACTION_VIEW 0
J2OBJC_STATIC_FIELD_CONSTANT(ADIntent, ACTION_VIEW, jint)

inline jint ADIntent_get_CATEGORY_BROWSABLE(void);
#define ADIntent_CATEGORY_BROWSABLE 0
J2OBJC_STATIC_FIELD_CONSTANT(ADIntent, CATEGORY_BROWSABLE, jint)

inline jint ADIntent_get_ACTION_GET_CONTENT(void);
#define ADIntent_ACTION_GET_CONTENT 0
J2OBJC_STATIC_FIELD_CONSTANT(ADIntent, ACTION_GET_CONTENT, jint)

inline jint ADIntent_get_CATEGORY_OPENABLE(void);
#define ADIntent_CATEGORY_OPENABLE 0
J2OBJC_STATIC_FIELD_CONSTANT(ADIntent, CATEGORY_OPENABLE, jint)

inline NSString *ADIntent_get_ACTION_CONFIGURATION_CHANGED(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT NSString *ADIntent_ACTION_CONFIGURATION_CHANGED;
J2OBJC_STATIC_FIELD_OBJ_FINAL(ADIntent, ACTION_CONFIGURATION_CHANGED, NSString *)

/*!
 @brief If set, the recipient of this Intent will be granted permission to
  perform read operations on the URI in the Intent's data and any URIs
  specified in its ClipData.When applying to an Intent's ClipData,
  all URIs as well as recursive traversals through data or other ClipData
  in Intent items will be granted; only the grant flags of the top-level
  Intent are used.
 */
inline jint ADIntent_get_FLAG_GRANT_READ_URI_PERMISSION(void);
#define ADIntent_FLAG_GRANT_READ_URI_PERMISSION 1
J2OBJC_STATIC_FIELD_CONSTANT(ADIntent, FLAG_GRANT_READ_URI_PERMISSION, jint)

/*!
 @brief If set, the recipient of this Intent will be granted permission to
  perform write operations on the URI in the Intent's data and any URIs
  specified in its ClipData.When applying to an Intent's ClipData,
  all URIs as well as recursive traversals through data or other ClipData
  in Intent items will be granted; only the grant flags of the top-level
  Intent are used.
 */
inline jint ADIntent_get_FLAG_GRANT_WRITE_URI_PERMISSION(void);
#define ADIntent_FLAG_GRANT_WRITE_URI_PERMISSION 2
J2OBJC_STATIC_FIELD_CONSTANT(ADIntent, FLAG_GRANT_WRITE_URI_PERMISSION, jint)

/*!
 @brief Can be set by the caller to indicate that this Intent is coming from
  a background operation, not from direct user interaction.
 */
inline jint ADIntent_get_FLAG_FROM_BACKGROUND(void);
#define ADIntent_FLAG_FROM_BACKGROUND 4
J2OBJC_STATIC_FIELD_CONSTANT(ADIntent, FLAG_FROM_BACKGROUND, jint)

/*!
 @brief When combined with <code>FLAG_GRANT_READ_URI_PERMISSION</code> and/or 
 <code>FLAG_GRANT_WRITE_URI_PERMISSION</code>, the URI permission grant can be
  persisted across device reboots until explicitly revoked with 
 <code>Context.revokeUriPermission(Uri, int)</code>.This flag only offers the
  grant for possible persisting; the receiving application must call 
 <code>ContentResolver.takePersistableUriPermission(Uri, int)</code> to
  actually persist.
 - seealso: ContentResolver#takePersistableUriPermission(Uri, int)
 - seealso: ContentResolver#releasePersistableUriPermission(Uri, int)
 - seealso: ContentResolver#getPersistedUriPermissions()
 - seealso: ContentResolver#getOutgoingPersistedUriPermissions()
 */
inline jint ADIntent_get_FLAG_GRANT_PERSISTABLE_URI_PERMISSION(void);
#define ADIntent_FLAG_GRANT_PERSISTABLE_URI_PERMISSION 64
J2OBJC_STATIC_FIELD_CONSTANT(ADIntent, FLAG_GRANT_PERSISTABLE_URI_PERMISSION, jint)

/*!
 @brief When combined with <code>FLAG_GRANT_READ_URI_PERMISSION</code> and/or 
 <code>FLAG_GRANT_WRITE_URI_PERMISSION</code>, the URI permission grant
  applies to any URI that is a prefix match against the original granted
  URI.
 (Without this flag, the URI must match exactly for access to be
  granted.) Another URI is considered a prefix match only when scheme,
  authority, and all path segments defined by the prefix are an exact
  match.
 */
inline jint ADIntent_get_FLAG_GRANT_PREFIX_URI_PERMISSION(void);
#define ADIntent_FLAG_GRANT_PREFIX_URI_PERMISSION 128
J2OBJC_STATIC_FIELD_CONSTANT(ADIntent, FLAG_GRANT_PREFIX_URI_PERMISSION, jint)

inline NSString *ADIntent_get_EXTRA_ALLOW_MULTIPLE(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT NSString *ADIntent_EXTRA_ALLOW_MULTIPLE;
J2OBJC_STATIC_FIELD_OBJ_FINAL(ADIntent, EXTRA_ALLOW_MULTIPLE, NSString *)

inline NSString *ADIntent_get_EXTRA_MIME_TYPES(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT NSString *ADIntent_EXTRA_MIME_TYPES;
J2OBJC_STATIC_FIELD_OBJ_FINAL(ADIntent, EXTRA_MIME_TYPES, NSString *)

FOUNDATION_EXPORT void ADIntent_initWithInt_(ADIntent *self, jint actionView);

FOUNDATION_EXPORT ADIntent *new_ADIntent_initWithInt_(jint actionView) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADIntent *create_ADIntent_initWithInt_(jint actionView);

FOUNDATION_EXPORT void ADIntent_init(ADIntent *self);

FOUNDATION_EXPORT ADIntent *new_ADIntent_init(void) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADIntent *create_ADIntent_init(void);

J2OBJC_TYPE_LITERAL_HEADER(ADIntent)

@compatibility_alias RAndroidContentIntent ADIntent;

#endif

#if !defined (ADIntent_ClipData_) && (INCLUDE_ALL_Intent || defined(INCLUDE_ADIntent_ClipData))
#define ADIntent_ClipData_

@class ADIntent;
@class ADIntent_Item;

@interface ADIntent_ClipData : NSObject

#pragma mark Public

- (instancetype)initWithADIntent:(ADIntent *)outer$;

- (ADIntent_Item *)getItemAtWithInt:(jint)i;

- (jint)getItemCount;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ADIntent_ClipData)

FOUNDATION_EXPORT void ADIntent_ClipData_initWithADIntent_(ADIntent_ClipData *self, ADIntent *outer$);

FOUNDATION_EXPORT ADIntent_ClipData *new_ADIntent_ClipData_initWithADIntent_(ADIntent *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADIntent_ClipData *create_ADIntent_ClipData_initWithADIntent_(ADIntent *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ADIntent_ClipData)

#endif

#if !defined (ADIntent_Item_) && (INCLUDE_ALL_Intent || defined(INCLUDE_ADIntent_Item))
#define ADIntent_Item_

@class ADIntent;
@class ADUri;

@interface ADIntent_Item : NSObject

#pragma mark Public

- (instancetype)initWithADIntent:(ADIntent *)outer$;

- (ADUri *)getUri;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ADIntent_Item)

FOUNDATION_EXPORT void ADIntent_Item_initWithADIntent_(ADIntent_Item *self, ADIntent *outer$);

FOUNDATION_EXPORT ADIntent_Item *new_ADIntent_Item_initWithADIntent_(ADIntent *outer$) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADIntent_Item *create_ADIntent_Item_initWithADIntent_(ADIntent *outer$);

J2OBJC_TYPE_LITERAL_HEADER(ADIntent_Item)

#endif

#pragma pop_macro("INCLUDE_ALL_Intent")
