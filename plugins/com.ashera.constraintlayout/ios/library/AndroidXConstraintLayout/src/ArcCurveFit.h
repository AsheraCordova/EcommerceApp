//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroidXConstraintLayout\src\main\java\androidx\constraintlayout\core\motion\utils\ArcCurveFit.java
//

#include "J2ObjC_header.h"

#pragma push_macro("INCLUDE_ALL_ArcCurveFit")
#ifdef RESTRICT_ArcCurveFit
#define INCLUDE_ALL_ArcCurveFit 0
#else
#define INCLUDE_ALL_ArcCurveFit 1
#endif
#undef RESTRICT_ArcCurveFit

#if !defined (ADXArcCurveFit_) && (INCLUDE_ALL_ArcCurveFit || defined(INCLUDE_ADXArcCurveFit))
#define ADXArcCurveFit_

#define RESTRICT_CurveFit 1
#define INCLUDE_ADXCurveFit 1
#include "CurveFit.h"

@class IOSDoubleArray;
@class IOSFloatArray;
@class IOSIntArray;
@class IOSObjectArray;

/*!
 @brief This provides provides a curve fit system that stitches the x,y path together with
  quarter ellipses
 */
@interface ADXArcCurveFit : ADXCurveFit {
 @public
  IOSObjectArray *mArcs_;
}

#pragma mark Public

- (instancetype)initWithIntArray:(IOSIntArray *)arcModes
                 withDoubleArray:(IOSDoubleArray *)time
                withDoubleArray2:(IOSObjectArray *)y;

- (void)getPosWithDouble:(jdouble)t
         withDoubleArray:(IOSDoubleArray *)v;

- (void)getPosWithDouble:(jdouble)t
          withFloatArray:(IOSFloatArray *)v;

- (jdouble)getPosWithDouble:(jdouble)t
                    withInt:(jint)j;

- (void)getSlopeWithDouble:(jdouble)t
           withDoubleArray:(IOSDoubleArray *)v;

- (jdouble)getSlopeWithDouble:(jdouble)t
                      withInt:(jint)j;

- (IOSDoubleArray *)getTimePoints;

// Disallowed inherited constructors, do not use.

- (instancetype)init NS_UNAVAILABLE;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXArcCurveFit)

J2OBJC_FIELD_SETTER(ADXArcCurveFit, mArcs_, IOSObjectArray *)

inline jint ADXArcCurveFit_get_ARC_START_VERTICAL(void);
#define ADXArcCurveFit_ARC_START_VERTICAL 1
J2OBJC_STATIC_FIELD_CONSTANT(ADXArcCurveFit, ARC_START_VERTICAL, jint)

inline jint ADXArcCurveFit_get_ARC_START_HORIZONTAL(void);
#define ADXArcCurveFit_ARC_START_HORIZONTAL 2
J2OBJC_STATIC_FIELD_CONSTANT(ADXArcCurveFit, ARC_START_HORIZONTAL, jint)

inline jint ADXArcCurveFit_get_ARC_START_FLIP(void);
#define ADXArcCurveFit_ARC_START_FLIP 3
J2OBJC_STATIC_FIELD_CONSTANT(ADXArcCurveFit, ARC_START_FLIP, jint)

inline jint ADXArcCurveFit_get_ARC_START_LINEAR(void);
#define ADXArcCurveFit_ARC_START_LINEAR 0
J2OBJC_STATIC_FIELD_CONSTANT(ADXArcCurveFit, ARC_START_LINEAR, jint)

FOUNDATION_EXPORT void ADXArcCurveFit_initWithIntArray_withDoubleArray_withDoubleArray2_(ADXArcCurveFit *self, IOSIntArray *arcModes, IOSDoubleArray *time, IOSObjectArray *y);

FOUNDATION_EXPORT ADXArcCurveFit *new_ADXArcCurveFit_initWithIntArray_withDoubleArray_withDoubleArray2_(IOSIntArray *arcModes, IOSDoubleArray *time, IOSObjectArray *y) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT ADXArcCurveFit *create_ADXArcCurveFit_initWithIntArray_withDoubleArray_withDoubleArray2_(IOSIntArray *arcModes, IOSDoubleArray *time, IOSObjectArray *y);

J2OBJC_TYPE_LITERAL_HEADER(ADXArcCurveFit)

@compatibility_alias AndroidxConstraintlayoutCoreMotionUtilsArcCurveFit ADXArcCurveFit;

#endif

#pragma pop_macro("INCLUDE_ALL_ArcCurveFit")
