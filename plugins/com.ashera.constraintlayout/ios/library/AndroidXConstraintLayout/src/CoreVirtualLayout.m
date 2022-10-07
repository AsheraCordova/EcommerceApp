//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroidXConstraintLayout\src\main\java\androidx\constraintlayout\core\widgets\CoreVirtualLayout.java
//

#include "BasicMeasure.h"
#include "ConstraintWidget.h"
#include "ConstraintWidgetContainer.h"
#include "CoreGuideline.h"
#include "CoreVirtualLayout.h"
#include "HelperWidget.h"
#include "IOSObjectArray.h"
#include "J2ObjC_source.h"
#include "java/util/HashSet.h"


@interface ADXCoreVirtualLayout () {
 @public
  jint mPaddingTop_;
  jint mPaddingBottom_;
  jint mPaddingLeft_;
  jint mPaddingRight_;
  jint mPaddingStart_;
  jint mPaddingEnd_;
  jint mResolvedPaddingLeft_;
  jint mResolvedPaddingRight_;
  jboolean mNeedsCallFromSolver_;
  jint mMeasuredWidth_;
  jint mMeasuredHeight_;
}

@end

@implementation ADXCoreVirtualLayout

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ADXCoreVirtualLayout_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (void)setPaddingWithInt:(jint)value {
  mPaddingLeft_ = value;
  mPaddingTop_ = value;
  mPaddingRight_ = value;
  mPaddingBottom_ = value;
  mPaddingStart_ = value;
  mPaddingEnd_ = value;
}

- (void)setPaddingStartWithInt:(jint)value {
  mPaddingStart_ = value;
  mResolvedPaddingLeft_ = value;
  mResolvedPaddingRight_ = value;
}

- (void)setPaddingEndWithInt:(jint)value {
  mPaddingEnd_ = value;
}

- (void)setPaddingLeftWithInt:(jint)value {
  mPaddingLeft_ = value;
  mResolvedPaddingLeft_ = value;
}

- (void)applyRtlWithBoolean:(jboolean)isRtl {
  if (mPaddingStart_ > 0 || mPaddingEnd_ > 0) {
    if (isRtl) {
      mResolvedPaddingLeft_ = mPaddingEnd_;
      mResolvedPaddingRight_ = mPaddingStart_;
    }
    else {
      mResolvedPaddingLeft_ = mPaddingStart_;
      mResolvedPaddingRight_ = mPaddingEnd_;
    }
  }
}

- (void)setPaddingTopWithInt:(jint)value {
  mPaddingTop_ = value;
}

- (void)setPaddingRightWithInt:(jint)value {
  mPaddingRight_ = value;
  mResolvedPaddingRight_ = value;
}

- (void)setPaddingBottomWithInt:(jint)value {
  mPaddingBottom_ = value;
}

- (jint)getPaddingTop {
  return mPaddingTop_;
}

- (jint)getPaddingBottom {
  return mPaddingBottom_;
}

- (jint)getPaddingLeft {
  return mResolvedPaddingLeft_;
}

- (jint)getPaddingRight {
  return mResolvedPaddingRight_;
}

- (void)needsCallbackFromSolverWithBoolean:(jboolean)value {
  mNeedsCallFromSolver_ = value;
}

- (jboolean)needSolverPass {
  return mNeedsCallFromSolver_;
}

- (void)measureWithInt:(jint)widthMode
               withInt:(jint)widthSize
               withInt:(jint)heightMode
               withInt:(jint)heightSize {
}

- (void)updateConstraintsWithADXConstraintWidgetContainer:(ADXConstraintWidgetContainer *)container {
  [self captureWidgets];
}

- (void)captureWidgets {
  for (jint i = 0; i < mWidgetsCount_; i++) {
    ADXConstraintWidget *widget = IOSObjectArray_Get(nil_chk(mWidgets_), i);
    if (widget != nil) {
      [widget setInVirtualLayoutWithBoolean:true];
    }
  }
}

- (jint)getMeasuredWidth {
  return mMeasuredWidth_;
}

- (jint)getMeasuredHeight {
  return mMeasuredHeight_;
}

- (void)setMeasureWithInt:(jint)width
                  withInt:(jint)height {
  mMeasuredWidth_ = width;
  mMeasuredHeight_ = height;
}

- (jboolean)measureChildren {
  id<ADXBasicMeasure_Measurer> measurer = nil;
  if (mParent_ != nil) {
    measurer = [((ADXConstraintWidgetContainer *) cast_chk(mParent_, [ADXConstraintWidgetContainer class])) getMeasurer];
  }
  if (measurer == nil) {
    return false;
  }
  for (jint i = 0; i < mWidgetsCount_; i++) {
    ADXConstraintWidget *widget = IOSObjectArray_Get(nil_chk(mWidgets_), i);
    if (widget == nil) {
      continue;
    }
    if ([widget isKindOfClass:[ADXCoreGuideline class]]) {
      continue;
    }
    ADXConstraintWidget_DimensionBehaviour *widthBehavior = JreRetainedLocalValue([widget getDimensionBehaviourWithInt:ADXConstraintWidget_HORIZONTAL]);
    ADXConstraintWidget_DimensionBehaviour *heightBehavior = JreRetainedLocalValue([widget getDimensionBehaviourWithInt:ADXConstraintWidget_VERTICAL]);
    jboolean skip = widthBehavior == JreLoadEnum(ADXConstraintWidget_DimensionBehaviour, MATCH_CONSTRAINT) && widget->mMatchConstraintDefaultWidth_ != ADXConstraintWidget_MATCH_CONSTRAINT_WRAP && heightBehavior == JreLoadEnum(ADXConstraintWidget_DimensionBehaviour, MATCH_CONSTRAINT) && widget->mMatchConstraintDefaultHeight_ != ADXConstraintWidget_MATCH_CONSTRAINT_WRAP;
    if (skip) {
      continue;
    }
    if (widthBehavior == JreLoadEnum(ADXConstraintWidget_DimensionBehaviour, MATCH_CONSTRAINT)) {
      widthBehavior = JreLoadEnum(ADXConstraintWidget_DimensionBehaviour, WRAP_CONTENT);
    }
    if (heightBehavior == JreLoadEnum(ADXConstraintWidget_DimensionBehaviour, MATCH_CONSTRAINT)) {
      heightBehavior = JreLoadEnum(ADXConstraintWidget_DimensionBehaviour, WRAP_CONTENT);
    }
    JreStrongAssign(&((ADXBasicMeasure_Measure *) nil_chk(mMeasure_))->horizontalBehavior_, widthBehavior);
    JreStrongAssign(&mMeasure_->verticalBehavior_, heightBehavior);
    mMeasure_->horizontalDimension_ = [widget getWidth];
    ((ADXBasicMeasure_Measure *) nil_chk(mMeasure_))->verticalDimension_ = [widget getHeight];
    [measurer measureWithADXConstraintWidget:widget withADXBasicMeasure_Measure:mMeasure_];
    [widget setWidthWithInt:((ADXBasicMeasure_Measure *) nil_chk(mMeasure_))->measuredWidth_];
    [widget setHeightWithInt:((ADXBasicMeasure_Measure *) nil_chk(mMeasure_))->measuredHeight_];
    [widget setBaselineDistanceWithInt:((ADXBasicMeasure_Measure *) nil_chk(mMeasure_))->measuredBaseline_];
  }
  return true;
}

- (void)measureWithADXConstraintWidget:(ADXConstraintWidget *)widget
withADXConstraintWidget_DimensionBehaviour:(ADXConstraintWidget_DimensionBehaviour *)horizontalBehavior
                               withInt:(jint)horizontalDimension
withADXConstraintWidget_DimensionBehaviour:(ADXConstraintWidget_DimensionBehaviour *)verticalBehavior
                               withInt:(jint)verticalDimension {
  while (mMeasurer_ == nil && [self getParent] != nil) {
    ADXConstraintWidgetContainer *parent = (ADXConstraintWidgetContainer *) cast_chk([self getParent], [ADXConstraintWidgetContainer class]);
    JreStrongAssign(&mMeasurer_, [((ADXConstraintWidgetContainer *) nil_chk(parent)) getMeasurer]);
  }
  JreStrongAssign(&((ADXBasicMeasure_Measure *) nil_chk(mMeasure_))->horizontalBehavior_, horizontalBehavior);
  JreStrongAssign(&mMeasure_->verticalBehavior_, verticalBehavior);
  mMeasure_->horizontalDimension_ = horizontalDimension;
  mMeasure_->verticalDimension_ = verticalDimension;
  [((id<ADXBasicMeasure_Measurer>) nil_chk(mMeasurer_)) measureWithADXConstraintWidget:widget withADXBasicMeasure_Measure:mMeasure_];
  [((ADXConstraintWidget *) nil_chk(widget)) setWidthWithInt:((ADXBasicMeasure_Measure *) nil_chk(mMeasure_))->measuredWidth_];
  [widget setHeightWithInt:((ADXBasicMeasure_Measure *) nil_chk(mMeasure_))->measuredHeight_];
  [widget setHasBaselineWithBoolean:((ADXBasicMeasure_Measure *) nil_chk(mMeasure_))->measuredHasBaseline_];
  [widget setBaselineDistanceWithInt:((ADXBasicMeasure_Measure *) nil_chk(mMeasure_))->measuredBaseline_];
}

- (jboolean)containsWithJavaUtilHashSet:(JavaUtilHashSet *)widgets {
  for (jint i = 0; i < mWidgetsCount_; i++) {
    ADXConstraintWidget *widget = IOSObjectArray_Get(nil_chk(mWidgets_), i);
    if ([((JavaUtilHashSet *) nil_chk(widgets)) containsWithId:widget]) {
      return true;
    }
  }
  return false;
}

- (void)dealloc {
  RELEASE_(mMeasure_);
  RELEASE_(mMeasurer_);
  [super dealloc];
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 0, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 2, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 3, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 4, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 5, 6, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 7, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 8, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 9, 1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x4, 10, 6, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 11, 12, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 13, 14, -1, -1, -1, -1 },
    { NULL, "V", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 15, 16, -1, -1, -1, -1 },
    { NULL, "Z", 0x4, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x4, 11, 17, -1, -1, -1, -1 },
    { NULL, "Z", 0x1, 18, 19, -1, 20, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(setPaddingWithInt:);
  methods[2].selector = @selector(setPaddingStartWithInt:);
  methods[3].selector = @selector(setPaddingEndWithInt:);
  methods[4].selector = @selector(setPaddingLeftWithInt:);
  methods[5].selector = @selector(applyRtlWithBoolean:);
  methods[6].selector = @selector(setPaddingTopWithInt:);
  methods[7].selector = @selector(setPaddingRightWithInt:);
  methods[8].selector = @selector(setPaddingBottomWithInt:);
  methods[9].selector = @selector(getPaddingTop);
  methods[10].selector = @selector(getPaddingBottom);
  methods[11].selector = @selector(getPaddingLeft);
  methods[12].selector = @selector(getPaddingRight);
  methods[13].selector = @selector(needsCallbackFromSolverWithBoolean:);
  methods[14].selector = @selector(needSolverPass);
  methods[15].selector = @selector(measureWithInt:withInt:withInt:withInt:);
  methods[16].selector = @selector(updateConstraintsWithADXConstraintWidgetContainer:);
  methods[17].selector = @selector(captureWidgets);
  methods[18].selector = @selector(getMeasuredWidth);
  methods[19].selector = @selector(getMeasuredHeight);
  methods[20].selector = @selector(setMeasureWithInt:withInt:);
  methods[21].selector = @selector(measureChildren);
  methods[22].selector = @selector(measureWithADXConstraintWidget:withADXConstraintWidget_DimensionBehaviour:withInt:withADXConstraintWidget_DimensionBehaviour:withInt:);
  methods[23].selector = @selector(containsWithJavaUtilHashSet:);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "mPaddingTop_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mPaddingBottom_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mPaddingLeft_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mPaddingRight_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mPaddingStart_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mPaddingEnd_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mResolvedPaddingLeft_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mResolvedPaddingRight_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mNeedsCallFromSolver_", "Z", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mMeasuredWidth_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mMeasuredHeight_", "I", .constantValue.asLong = 0, 0x2, -1, -1, -1, -1 },
    { "mMeasure_", "LADXBasicMeasure_Measure;", .constantValue.asLong = 0, 0x4, -1, -1, -1, -1 },
    { "mMeasurer_", "LADXBasicMeasure_Measurer;", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "setPadding", "I", "setPaddingStart", "setPaddingEnd", "setPaddingLeft", "applyRtl", "Z", "setPaddingTop", "setPaddingRight", "setPaddingBottom", "needsCallbackFromSolver", "measure", "IIII", "updateConstraints", "LADXConstraintWidgetContainer;", "setMeasure", "II", "LADXConstraintWidget;LADXConstraintWidget_DimensionBehaviour;ILADXConstraintWidget_DimensionBehaviour;I", "contains", "LJavaUtilHashSet;", "(Ljava/util/HashSet<Landroidx/constraintlayout/core/widgets/ConstraintWidget;>;)Z" };
  static const J2ObjcClassInfo _ADXCoreVirtualLayout = { "CoreVirtualLayout", "androidx.constraintlayout.core.widgets", ptrTable, methods, fields, 7, 0x1, 24, 13, -1, -1, -1, -1, -1 };
  return &_ADXCoreVirtualLayout;
}

@end

void ADXCoreVirtualLayout_init(ADXCoreVirtualLayout *self) {
  ADXHelperWidget_init(self);
  self->mPaddingTop_ = 0;
  self->mPaddingBottom_ = 0;
  self->mPaddingLeft_ = 0;
  self->mPaddingRight_ = 0;
  self->mPaddingStart_ = 0;
  self->mPaddingEnd_ = 0;
  self->mResolvedPaddingLeft_ = 0;
  self->mResolvedPaddingRight_ = 0;
  self->mNeedsCallFromSolver_ = false;
  self->mMeasuredWidth_ = 0;
  self->mMeasuredHeight_ = 0;
  JreStrongAssignAndConsume(&self->mMeasure_, new_ADXBasicMeasure_Measure_init());
  JreStrongAssign(&self->mMeasurer_, nil);
}

ADXCoreVirtualLayout *new_ADXCoreVirtualLayout_init() {
  J2OBJC_NEW_IMPL(ADXCoreVirtualLayout, init)
}

ADXCoreVirtualLayout *create_ADXCoreVirtualLayout_init() {
  J2OBJC_CREATE_IMPL(ADXCoreVirtualLayout, init)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADXCoreVirtualLayout)
