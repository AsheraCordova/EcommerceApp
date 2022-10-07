//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-javafx-widget\SWTAndroidXRecyclerView\src\main\java\androidx\recyclerview\widget\GapWorker.java
//

#include "AdapterHelper.h"
#include "ChildHelper.h"
#include "GapWorker.h"
#include "IOSPrimitiveArray.h"
#include "J2ObjC_source.h"
#include "RecyclerView.h"
#include "TraceCompat.h"
#include "View.h"
#include "java/lang/IllegalArgumentException.h"
#include "java/lang/Math.h"
#include "java/lang/System.h"
#include "java/lang/ThreadLocal.h"
#include "java/lang/ref/WeakReference.h"
#include "java/util/ArrayList.h"
#include "java/util/Arrays.h"
#include "java/util/Collections.h"
#include "java/util/Comparator.h"
#include "java/util/concurrent/TimeUnit.h"
#include "java/util/function/Function.h"
#include "java/util/function/ToDoubleFunction.h"
#include "java/util/function/ToIntFunction.h"
#include "java/util/function/ToLongFunction.h"

@class JavaUtilArrayList;
@protocol JavaUtilComparator;
@protocol JavaUtilFunctionFunction;
@protocol JavaUtilFunctionToDoubleFunction;
@protocol JavaUtilFunctionToIntFunction;
@protocol JavaUtilFunctionToLongFunction;


#pragma clang diagnostic ignored "-Wprotocol"

@interface ADXGapWorker () {
 @public
  /*!
   @brief Temporary storage for prefetch Tasks that execute in <code>prefetch(long)</code>.Task objects
  are pooled in the ArrayList, and never removed to avoid allocations, but always cleared
  in between calls.
   */
  JavaUtilArrayList *mTasks_;
}

- (void)buildTaskList;

- (ADXRecyclerView_ViewHolder *)prefetchPositionWithDeadlineWithADXRecyclerView:(ADXRecyclerView *)view
                                                                        withInt:(jint)position
                                                                       withLong:(jlong)deadlineNs;

- (void)prefetchInnerRecyclerViewWithDeadlineWithADXRecyclerView:(ADXRecyclerView *)innerView
                                                        withLong:(jlong)deadlineNs;

- (void)flushTaskWithDeadlineWithADXGapWorker_Task:(ADXGapWorker_Task *)task
                                          withLong:(jlong)deadlineNs;

- (void)flushTasksWithDeadlineWithLong:(jlong)deadlineNs;

@end

J2OBJC_FIELD_SETTER(ADXGapWorker, mTasks_, JavaUtilArrayList *)

__attribute__((unused)) static void ADXGapWorker_buildTaskList(ADXGapWorker *self);

__attribute__((unused)) static ADXRecyclerView_ViewHolder *ADXGapWorker_prefetchPositionWithDeadlineWithADXRecyclerView_withInt_withLong_(ADXGapWorker *self, ADXRecyclerView *view, jint position, jlong deadlineNs);

__attribute__((unused)) static void ADXGapWorker_prefetchInnerRecyclerViewWithDeadlineWithADXRecyclerView_withLong_(ADXGapWorker *self, ADXRecyclerView *innerView, jlong deadlineNs);

__attribute__((unused)) static void ADXGapWorker_flushTaskWithDeadlineWithADXGapWorker_Task_withLong_(ADXGapWorker *self, ADXGapWorker_Task *task, jlong deadlineNs);

__attribute__((unused)) static void ADXGapWorker_flushTasksWithDeadlineWithLong_(ADXGapWorker *self, jlong deadlineNs);

@interface ADXGapWorker_1 : NSObject < JavaUtilComparator >

- (instancetype)init;

- (jint)compareWithId:(ADXGapWorker_Task *)lhs
               withId:(ADXGapWorker_Task *)rhs;

@end

J2OBJC_EMPTY_STATIC_INIT(ADXGapWorker_1)

__attribute__((unused)) static void ADXGapWorker_1_init(ADXGapWorker_1 *self);

__attribute__((unused)) static ADXGapWorker_1 *new_ADXGapWorker_1_init(void) NS_RETURNS_RETAINED;

__attribute__((unused)) static ADXGapWorker_1 *create_ADXGapWorker_1_init(void);

J2OBJC_INITIALIZED_DEFN(ADXGapWorker)

JavaLangThreadLocal *ADXGapWorker_sGapWorker;
id<JavaUtilComparator> ADXGapWorker_sTaskComparator;

@implementation ADXGapWorker

- (instancetype)initPackagePrivate {
  ADXGapWorker_initPackagePrivate(self);
  return self;
}

- (void)addWithADXRecyclerView:(ADXRecyclerView *)recyclerView {
  [((JavaUtilArrayList *) nil_chk(mRecyclerViews_)) addWithId:recyclerView];
}

- (void)removeWithADXRecyclerView:(ADXRecyclerView *)recyclerView {
  jboolean removeSuccess = [((JavaUtilArrayList *) nil_chk(mRecyclerViews_)) removeWithId:recyclerView];
}

- (void)postFromTraversalWithADXRecyclerView:(ADXRecyclerView *)recyclerView
                                     withInt:(jint)prefetchDx
                                     withInt:(jint)prefetchDy {
  if ([((ADXRecyclerView *) nil_chk(recyclerView)) isAttachedToWindow]) {
    if (mPostTimeNs_ == 0) {
      mPostTimeNs_ = [recyclerView getNanoTime];
      [recyclerView postWithJavaLangRunnable:self];
    }
  }
  [((ADXGapWorker_LayoutPrefetchRegistryImpl *) nil_chk(recyclerView->mPrefetchRegistry_)) setPrefetchVectorWithInt:prefetchDx withInt:prefetchDy];
}

- (void)buildTaskList {
  ADXGapWorker_buildTaskList(self);
}

+ (jboolean)isPrefetchPositionAttachedWithADXRecyclerView:(ADXRecyclerView *)view
                                                  withInt:(jint)position {
  return ADXGapWorker_isPrefetchPositionAttachedWithADXRecyclerView_withInt_(view, position);
}

- (ADXRecyclerView_ViewHolder *)prefetchPositionWithDeadlineWithADXRecyclerView:(ADXRecyclerView *)view
                                                                        withInt:(jint)position
                                                                       withLong:(jlong)deadlineNs {
  return ADXGapWorker_prefetchPositionWithDeadlineWithADXRecyclerView_withInt_withLong_(self, view, position, deadlineNs);
}

- (void)prefetchInnerRecyclerViewWithDeadlineWithADXRecyclerView:(ADXRecyclerView *)innerView
                                                        withLong:(jlong)deadlineNs {
  ADXGapWorker_prefetchInnerRecyclerViewWithDeadlineWithADXRecyclerView_withLong_(self, innerView, deadlineNs);
}

- (void)flushTaskWithDeadlineWithADXGapWorker_Task:(ADXGapWorker_Task *)task
                                          withLong:(jlong)deadlineNs {
  ADXGapWorker_flushTaskWithDeadlineWithADXGapWorker_Task_withLong_(self, task, deadlineNs);
}

- (void)flushTasksWithDeadlineWithLong:(jlong)deadlineNs {
  ADXGapWorker_flushTasksWithDeadlineWithLong_(self, deadlineNs);
}

- (void)prefetchWithLong:(jlong)deadlineNs {
  ADXGapWorker_buildTaskList(self);
  ADXGapWorker_flushTasksWithDeadlineWithLong_(self, deadlineNs);
}

- (void)run {
  @try {
    ADXTraceCompat_beginSectionWithNSString_(ADXRecyclerView_TRACE_PREFETCH_TAG);
    if ([((JavaUtilArrayList *) nil_chk(mRecyclerViews_)) isEmpty]) {
      return;
    }
    jint size = [((JavaUtilArrayList *) nil_chk(mRecyclerViews_)) size];
    jlong latestFrameVsyncMs = 0;
    for (jint i = 0; i < size; i++) {
      ADXRecyclerView *view = JreRetainedLocalValue([((JavaUtilArrayList *) nil_chk(mRecyclerViews_)) getWithInt:i]);
      if ([((ADXRecyclerView *) nil_chk(view)) getWindowVisibility] == ADView_VISIBLE) {
        latestFrameVsyncMs = JavaLangMath_maxWithLong_withLong_([view getDrawingTime], latestFrameVsyncMs);
      }
    }
    if (latestFrameVsyncMs == 0) {
      return;
    }
    jlong nextFrameNs = [((JavaUtilConcurrentTimeUnit *) nil_chk(JreLoadEnum(JavaUtilConcurrentTimeUnit, MILLISECONDS))) toNanosWithLong:latestFrameVsyncMs] + mFrameIntervalNs_;
    [self prefetchWithLong:nextFrameNs];
  }
  @finally {
    mPostTimeNs_ = 0;
    ADXTraceCompat_endSection();
  }
}

- (void)dealloc {
  RELEASE_(mRecyclerViews_);
  RELEASE_(mTasks_);
  [super dealloc];
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x0, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 0, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 2, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x0, 3, 4, -1, -1, -1, -1 },
    { NULL, "V", 0x2, -1, -1, -1, -1, -1, -1 },
    { NULL, "Z", 0x8, 5, 6, -1, -1, -1, -1 },
    { NULL, "LADXRecyclerView_ViewHolder;", 0x2, 7, 8, -1, -1, -1, -1 },
    { NULL, "V", 0x2, 9, 10, -1, -1, -1, -1 },
    { NULL, "V", 0x2, 11, 12, -1, -1, -1, -1 },
    { NULL, "V", 0x2, 13, 14, -1, -1, -1, -1 },
    { NULL, "V", 0x0, 15, 14, -1, -1, -1, -1 },
    { NULL, "V", 0x1, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(initPackagePrivate);
  methods[1].selector = @selector(addWithADXRecyclerView:);
  methods[2].selector = @selector(removeWithADXRecyclerView:);
  methods[3].selector = @selector(postFromTraversalWithADXRecyclerView:withInt:withInt:);
  methods[4].selector = @selector(buildTaskList);
  methods[5].selector = @selector(isPrefetchPositionAttachedWithADXRecyclerView:withInt:);
  methods[6].selector = @selector(prefetchPositionWithDeadlineWithADXRecyclerView:withInt:withLong:);
  methods[7].selector = @selector(prefetchInnerRecyclerViewWithDeadlineWithADXRecyclerView:withLong:);
  methods[8].selector = @selector(flushTaskWithDeadlineWithADXGapWorker_Task:withLong:);
  methods[9].selector = @selector(flushTasksWithDeadlineWithLong:);
  methods[10].selector = @selector(prefetchWithLong:);
  methods[11].selector = @selector(run);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "sGapWorker", "LJavaLangThreadLocal;", .constantValue.asLong = 0, 0x18, -1, 16, 17, -1 },
    { "mRecyclerViews_", "LJavaUtilArrayList;", .constantValue.asLong = 0, 0x0, -1, -1, 18, -1 },
    { "mPostTimeNs_", "J", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "mFrameIntervalNs_", "J", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "mTasks_", "LJavaUtilArrayList;", .constantValue.asLong = 0, 0x2, -1, -1, 19, -1 },
    { "sTaskComparator", "LJavaUtilComparator;", .constantValue.asLong = 0, 0x8, -1, 20, 21, -1 },
  };
  static const void *ptrTable[] = { "add", "LADXRecyclerView;", "remove", "postFromTraversal", "LADXRecyclerView;II", "isPrefetchPositionAttached", "LADXRecyclerView;I", "prefetchPositionWithDeadline", "LADXRecyclerView;IJ", "prefetchInnerRecyclerViewWithDeadline", "LADXRecyclerView;J", "flushTaskWithDeadline", "LADXGapWorker_Task;J", "flushTasksWithDeadline", "J", "prefetch", &ADXGapWorker_sGapWorker, "Ljava/lang/ThreadLocal<Landroidx/recyclerview/widget/GapWorker;>;", "Ljava/util/ArrayList<Landroidx/recyclerview/widget/RecyclerView;>;", "Ljava/util/ArrayList<Landroidx/recyclerview/widget/GapWorker$Task;>;", &ADXGapWorker_sTaskComparator, "Ljava/util/Comparator<Landroidx/recyclerview/widget/GapWorker$Task;>;", "LADXGapWorker_Task;LADXGapWorker_LayoutPrefetchRegistryImpl;" };
  static const J2ObjcClassInfo _ADXGapWorker = { "GapWorker", "androidx.recyclerview.widget", ptrTable, methods, fields, 7, 0x10, 12, 6, -1, 22, -1, -1, -1 };
  return &_ADXGapWorker;
}

+ (void)initialize {
  if (self == [ADXGapWorker class]) {
    JreStrongAssignAndConsume(&ADXGapWorker_sGapWorker, new_JavaLangThreadLocal_init());
    JreStrongAssignAndConsume(&ADXGapWorker_sTaskComparator, new_ADXGapWorker_1_init());
    J2OBJC_SET_INITIALIZED(ADXGapWorker)
  }
}

@end

void ADXGapWorker_initPackagePrivate(ADXGapWorker *self) {
  NSObject_init(self);
  JreStrongAssignAndConsume(&self->mRecyclerViews_, new_JavaUtilArrayList_init());
  JreStrongAssignAndConsume(&self->mTasks_, new_JavaUtilArrayList_init());
}

ADXGapWorker *new_ADXGapWorker_initPackagePrivate() {
  J2OBJC_NEW_IMPL(ADXGapWorker, initPackagePrivate)
}

ADXGapWorker *create_ADXGapWorker_initPackagePrivate() {
  J2OBJC_CREATE_IMPL(ADXGapWorker, initPackagePrivate)
}

void ADXGapWorker_buildTaskList(ADXGapWorker *self) {
  jint viewCount = [((JavaUtilArrayList *) nil_chk(self->mRecyclerViews_)) size];
  jint totalTaskCount = 0;
  for (jint i = 0; i < viewCount; i++) {
    ADXRecyclerView *view = JreRetainedLocalValue([((JavaUtilArrayList *) nil_chk(self->mRecyclerViews_)) getWithInt:i]);
    if ([((ADXRecyclerView *) nil_chk(view)) getWindowVisibility] == ADView_VISIBLE) {
      [((ADXGapWorker_LayoutPrefetchRegistryImpl *) nil_chk(view->mPrefetchRegistry_)) collectPrefetchPositionsFromViewWithADXRecyclerView:view withBoolean:false];
      totalTaskCount += ((ADXGapWorker_LayoutPrefetchRegistryImpl *) nil_chk(view->mPrefetchRegistry_))->mCount_;
    }
  }
  [((JavaUtilArrayList *) nil_chk(self->mTasks_)) ensureCapacityWithInt:totalTaskCount];
  jint totalTaskIndex = 0;
  for (jint i = 0; i < viewCount; i++) {
    ADXRecyclerView *view = JreRetainedLocalValue([((JavaUtilArrayList *) nil_chk(self->mRecyclerViews_)) getWithInt:i]);
    if ([((ADXRecyclerView *) nil_chk(view)) getWindowVisibility] != ADView_VISIBLE) {
      continue;
    }
    ADXGapWorker_LayoutPrefetchRegistryImpl *prefetchRegistry = JreRetainedLocalValue(view->mPrefetchRegistry_);
    jint viewVelocity = JavaLangMath_absWithInt_(((ADXGapWorker_LayoutPrefetchRegistryImpl *) nil_chk(prefetchRegistry))->mPrefetchDx_) + JavaLangMath_absWithInt_(prefetchRegistry->mPrefetchDy_);
    for (jint j = 0; j < prefetchRegistry->mCount_ * 2; j += 2) {
      ADXGapWorker_Task *task;
      if (totalTaskIndex >= [((JavaUtilArrayList *) nil_chk(self->mTasks_)) size]) {
        task = create_ADXGapWorker_Task_init();
        [((JavaUtilArrayList *) nil_chk(self->mTasks_)) addWithId:task];
      }
      else {
        task = [((JavaUtilArrayList *) nil_chk(self->mTasks_)) getWithInt:totalTaskIndex];
      }
      jint distanceToItem = IOSIntArray_Get(nil_chk(prefetchRegistry->mPrefetchArray_), j + 1);
      ((ADXGapWorker_Task *) nil_chk(task))->immediate_ = (distanceToItem <= viewVelocity);
      task->viewVelocity_ = viewVelocity;
      task->distanceToItem_ = distanceToItem;
      JreStrongAssign(&task->view_, view);
      task->position_ = IOSIntArray_Get(prefetchRegistry->mPrefetchArray_, j);
      totalTaskIndex++;
    }
  }
  JavaUtilCollections_sortWithJavaUtilList_withJavaUtilComparator_(self->mTasks_, ADXGapWorker_sTaskComparator);
}

jboolean ADXGapWorker_isPrefetchPositionAttachedWithADXRecyclerView_withInt_(ADXRecyclerView *view, jint position) {
  ADXGapWorker_initialize();
  jint childCount = [((ADXChildHelper *) nil_chk(((ADXRecyclerView *) nil_chk(view))->mChildHelper_)) getUnfilteredChildCount];
  for (jint i = 0; i < childCount; i++) {
    ADView *attachedView = JreRetainedLocalValue([((ADXChildHelper *) nil_chk(view->mChildHelper_)) getUnfilteredChildAtWithInt:i]);
    ADXRecyclerView_ViewHolder *holder = ADXRecyclerView_getChildViewHolderIntWithADView_(attachedView);
    if (((ADXRecyclerView_ViewHolder *) nil_chk(holder))->mPosition_ == position && ![holder isInvalid]) {
      return true;
    }
  }
  return false;
}

ADXRecyclerView_ViewHolder *ADXGapWorker_prefetchPositionWithDeadlineWithADXRecyclerView_withInt_withLong_(ADXGapWorker *self, ADXRecyclerView *view, jint position, jlong deadlineNs) {
  if (ADXGapWorker_isPrefetchPositionAttachedWithADXRecyclerView_withInt_(view, position)) {
    return nil;
  }
  ADXRecyclerView_Recycler *recycler = JreRetainedLocalValue(((ADXRecyclerView *) nil_chk(view))->mRecycler_);
  ADXRecyclerView_ViewHolder *holder;
  @try {
    [view onEnterLayoutOrScroll];
    holder = [((ADXRecyclerView_Recycler *) nil_chk(recycler)) tryGetViewHolderForPositionByDeadlineWithInt:position withBoolean:false withLong:deadlineNs];
    if (holder != nil) {
      if ([holder isBound] && ![holder isInvalid]) {
        [recycler recycleViewWithADView:holder->itemView_];
      }
      else {
        [recycler addViewHolderToRecycledViewPoolWithADXRecyclerView_ViewHolder:holder withBoolean:false];
      }
    }
  }
  @finally {
    [view onExitLayoutOrScrollWithBoolean:false];
  }
  return holder;
}

void ADXGapWorker_prefetchInnerRecyclerViewWithDeadlineWithADXRecyclerView_withLong_(ADXGapWorker *self, ADXRecyclerView *innerView, jlong deadlineNs) {
  if (innerView == nil) {
    return;
  }
  if (innerView->mDataSetHasChangedAfterLayout_ && [((ADXChildHelper *) nil_chk(innerView->mChildHelper_)) getUnfilteredChildCount] != 0) {
    [innerView removeAndRecycleViews];
  }
  ADXGapWorker_LayoutPrefetchRegistryImpl *innerPrefetchRegistry = innerView->mPrefetchRegistry_;
  [((ADXGapWorker_LayoutPrefetchRegistryImpl *) nil_chk(innerPrefetchRegistry)) collectPrefetchPositionsFromViewWithADXRecyclerView:innerView withBoolean:true];
  if (innerPrefetchRegistry->mCount_ != 0) {
    @try {
      ADXTraceCompat_beginSectionWithNSString_(ADXRecyclerView_TRACE_NESTED_PREFETCH_TAG);
      [((ADXRecyclerView_State *) nil_chk(innerView->mState_)) prepareForNestedPrefetchWithADXRecyclerView_Adapter:innerView->mAdapter_];
      for (jint i = 0; i < innerPrefetchRegistry->mCount_ * 2; i += 2) {
        jint innerPosition = IOSIntArray_Get(nil_chk(innerPrefetchRegistry->mPrefetchArray_), i);
        ADXGapWorker_prefetchPositionWithDeadlineWithADXRecyclerView_withInt_withLong_(self, innerView, innerPosition, deadlineNs);
      }
    }
    @finally {
      ADXTraceCompat_endSection();
    }
  }
}

void ADXGapWorker_flushTaskWithDeadlineWithADXGapWorker_Task_withLong_(ADXGapWorker *self, ADXGapWorker_Task *task, jlong deadlineNs) {
  jlong taskDeadlineNs = ((ADXGapWorker_Task *) nil_chk(task))->immediate_ ? ADXRecyclerView_FOREVER_NS : deadlineNs;
  ADXRecyclerView_ViewHolder *holder = ADXGapWorker_prefetchPositionWithDeadlineWithADXRecyclerView_withInt_withLong_(self, task->view_, task->position_, taskDeadlineNs);
  if (holder != nil && holder->mNestedRecyclerView_ != nil && [holder isBound] && ![holder isInvalid]) {
    ADXGapWorker_prefetchInnerRecyclerViewWithDeadlineWithADXRecyclerView_withLong_(self, [holder->mNestedRecyclerView_ get], deadlineNs);
  }
}

void ADXGapWorker_flushTasksWithDeadlineWithLong_(ADXGapWorker *self, jlong deadlineNs) {
  for (jint i = 0; i < [((JavaUtilArrayList *) nil_chk(self->mTasks_)) size]; i++) {
    ADXGapWorker_Task *task = [((JavaUtilArrayList *) nil_chk(self->mTasks_)) getWithInt:i];
    if (((ADXGapWorker_Task *) nil_chk(task))->view_ == nil) {
      break;
    }
    ADXGapWorker_flushTaskWithDeadlineWithADXGapWorker_Task_withLong_(self, task, deadlineNs);
    [task clear];
  }
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADXGapWorker)

@implementation ADXGapWorker_Task

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ADXGapWorker_Task_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (void)clear {
  immediate_ = false;
  viewVelocity_ = 0;
  distanceToItem_ = 0;
  JreStrongAssign(&view_, nil);
  position_ = 0;
}

- (void)dealloc {
  RELEASE_(view_);
  [super dealloc];
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x0, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x1, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(clear);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "immediate_", "Z", .constantValue.asLong = 0, 0x1, -1, -1, -1, -1 },
    { "viewVelocity_", "I", .constantValue.asLong = 0, 0x1, -1, -1, -1, -1 },
    { "distanceToItem_", "I", .constantValue.asLong = 0, 0x1, -1, -1, -1, -1 },
    { "view_", "LADXRecyclerView;", .constantValue.asLong = 0, 0x1, -1, -1, -1, -1 },
    { "position_", "I", .constantValue.asLong = 0, 0x1, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "LADXGapWorker;" };
  static const J2ObjcClassInfo _ADXGapWorker_Task = { "Task", "androidx.recyclerview.widget", ptrTable, methods, fields, 7, 0x8, 2, 5, 0, -1, -1, -1, -1 };
  return &_ADXGapWorker_Task;
}

@end

void ADXGapWorker_Task_init(ADXGapWorker_Task *self) {
  NSObject_init(self);
}

ADXGapWorker_Task *new_ADXGapWorker_Task_init() {
  J2OBJC_NEW_IMPL(ADXGapWorker_Task, init)
}

ADXGapWorker_Task *create_ADXGapWorker_Task_init() {
  J2OBJC_CREATE_IMPL(ADXGapWorker_Task, init)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADXGapWorker_Task)

@implementation ADXGapWorker_LayoutPrefetchRegistryImpl

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ADXGapWorker_LayoutPrefetchRegistryImpl_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (void)setPrefetchVectorWithInt:(jint)dx
                         withInt:(jint)dy {
  mPrefetchDx_ = dx;
  mPrefetchDy_ = dy;
}

- (void)collectPrefetchPositionsFromViewWithADXRecyclerView:(ADXRecyclerView *)view
                                                withBoolean:(jboolean)nested {
  mCount_ = 0;
  if (mPrefetchArray_ != nil) {
    JavaUtilArrays_fillWithIntArray_withInt_(mPrefetchArray_, -1);
  }
  ADXRecyclerView_LayoutManager *layout = ((ADXRecyclerView *) nil_chk(view))->mLayout_;
  if (view->mAdapter_ != nil && layout != nil && [layout isItemPrefetchEnabled]) {
    if (nested) {
      if (![((ADXAdapterHelper *) nil_chk(view->mAdapterHelper_)) hasPendingUpdates]) {
        [layout collectInitialPrefetchPositionsWithInt:[((ADXRecyclerView_Adapter *) nil_chk(view->mAdapter_)) getItemCount] withADXRecyclerView_LayoutManager_LayoutPrefetchRegistry:self];
      }
    }
    else {
      if (![view hasPendingAdapterUpdates]) {
        [layout collectAdjacentPrefetchPositionsWithInt:mPrefetchDx_ withInt:mPrefetchDy_ withADXRecyclerView_State:view->mState_ withADXRecyclerView_LayoutManager_LayoutPrefetchRegistry:self];
      }
    }
    if (mCount_ > layout->mPrefetchMaxCountObserved_) {
      layout->mPrefetchMaxCountObserved_ = mCount_;
      layout->mPrefetchMaxObservedInInitialPrefetch_ = nested;
      [((ADXRecyclerView_Recycler *) nil_chk(view->mRecycler_)) updateViewCacheSize];
    }
  }
}

- (void)addPositionWithInt:(jint)layoutPosition
                   withInt:(jint)pixelDistance {
  if (layoutPosition < 0) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_(@"Layout positions must be non-negative");
  }
  if (pixelDistance < 0) {
    @throw create_JavaLangIllegalArgumentException_initWithNSString_(@"Pixel distance must be non-negative");
  }
  jint storagePosition = mCount_ * 2;
  if (mPrefetchArray_ == nil) {
    JreStrongAssignAndConsume(&mPrefetchArray_, [IOSIntArray newArrayWithLength:4]);
    JavaUtilArrays_fillWithIntArray_withInt_(mPrefetchArray_, -1);
  }
  else if (storagePosition >= mPrefetchArray_->size_) {
    IOSIntArray *oldArray = mPrefetchArray_;
    JreStrongAssignAndConsume(&mPrefetchArray_, [IOSIntArray newArrayWithLength:storagePosition * 2]);
    JavaLangSystem_arraycopyWithId_withInt_withId_withInt_withInt_(oldArray, 0, mPrefetchArray_, 0, oldArray->size_);
  }
  *IOSIntArray_GetRef(nil_chk(mPrefetchArray_), storagePosition) = layoutPosition;
  *IOSIntArray_GetRef(mPrefetchArray_, storagePosition + 1) = pixelDistance;
  mCount_++;
}

- (jboolean)lastPrefetchIncludedPositionWithInt:(jint)position {
  if (mPrefetchArray_ != nil) {
    jint count = mCount_ * 2;
    for (jint i = 0; i < count; i += 2) {
      if (IOSIntArray_Get(mPrefetchArray_, i) == position) return true;
    }
  }
  return false;
}

- (void)clearPrefetchPositions {
  if (mPrefetchArray_ != nil) {
    JavaUtilArrays_fillWithIntArray_withInt_(mPrefetchArray_, -1);
  }
  mCount_ = 0;
}

- (void)dealloc {
  RELEASE_(mPrefetchArray_);
  [super dealloc];
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x0, -1, -1, -1, -1, -1, -1 },
    { NULL, "V", 0x0, 0, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x0, 2, 3, -1, -1, -1, -1 },
    { NULL, "V", 0x1, 4, 1, -1, -1, -1, -1 },
    { NULL, "Z", 0x0, 5, 6, -1, -1, -1, -1 },
    { NULL, "V", 0x0, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(setPrefetchVectorWithInt:withInt:);
  methods[2].selector = @selector(collectPrefetchPositionsFromViewWithADXRecyclerView:withBoolean:);
  methods[3].selector = @selector(addPositionWithInt:withInt:);
  methods[4].selector = @selector(lastPrefetchIncludedPositionWithInt:);
  methods[5].selector = @selector(clearPrefetchPositions);
  #pragma clang diagnostic pop
  static const J2ObjcFieldInfo fields[] = {
    { "mPrefetchDx_", "I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "mPrefetchDy_", "I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "mPrefetchArray_", "[I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
    { "mCount_", "I", .constantValue.asLong = 0, 0x0, -1, -1, -1, -1 },
  };
  static const void *ptrTable[] = { "setPrefetchVector", "II", "collectPrefetchPositionsFromView", "LADXRecyclerView;Z", "addPosition", "lastPrefetchIncludedPosition", "I", "LADXGapWorker;" };
  static const J2ObjcClassInfo _ADXGapWorker_LayoutPrefetchRegistryImpl = { "LayoutPrefetchRegistryImpl", "androidx.recyclerview.widget", ptrTable, methods, fields, 7, 0x8, 6, 4, 7, -1, -1, -1, -1 };
  return &_ADXGapWorker_LayoutPrefetchRegistryImpl;
}

@end

void ADXGapWorker_LayoutPrefetchRegistryImpl_init(ADXGapWorker_LayoutPrefetchRegistryImpl *self) {
  NSObject_init(self);
}

ADXGapWorker_LayoutPrefetchRegistryImpl *new_ADXGapWorker_LayoutPrefetchRegistryImpl_init() {
  J2OBJC_NEW_IMPL(ADXGapWorker_LayoutPrefetchRegistryImpl, init)
}

ADXGapWorker_LayoutPrefetchRegistryImpl *create_ADXGapWorker_LayoutPrefetchRegistryImpl_init() {
  J2OBJC_CREATE_IMPL(ADXGapWorker_LayoutPrefetchRegistryImpl, init)
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(ADXGapWorker_LayoutPrefetchRegistryImpl)

@implementation ADXGapWorker_1

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  ADXGapWorker_1_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

- (jint)compareWithId:(ADXGapWorker_Task *)lhs
               withId:(ADXGapWorker_Task *)rhs {
  if ((((ADXGapWorker_Task *) nil_chk(lhs))->view_ == nil) != (((ADXGapWorker_Task *) nil_chk(rhs))->view_ == nil)) {
    return lhs->view_ == nil ? 1 : -1;
  }
  if (lhs->immediate_ != rhs->immediate_) {
    return lhs->immediate_ ? -1 : 1;
  }
  jint deltaViewVelocity = rhs->viewVelocity_ - lhs->viewVelocity_;
  if (deltaViewVelocity != 0) return deltaViewVelocity;
  jint deltaDistanceToItem = lhs->distanceToItem_ - rhs->distanceToItem_;
  if (deltaDistanceToItem != 0) return deltaDistanceToItem;
  return 0;
}

- (id<JavaUtilComparator>)reversed {
  return JavaUtilComparator_reversed(self);
}

- (id<JavaUtilComparator>)thenComparingWithJavaUtilComparator:(id<JavaUtilComparator>)arg0 {
  return JavaUtilComparator_thenComparingWithJavaUtilComparator_(self, arg0);
}

- (id<JavaUtilComparator>)thenComparingWithJavaUtilFunctionFunction:(id<JavaUtilFunctionFunction>)arg0
                                             withJavaUtilComparator:(id<JavaUtilComparator>)arg1 {
  return JavaUtilComparator_thenComparingWithJavaUtilFunctionFunction_withJavaUtilComparator_(self, arg0, arg1);
}

- (id<JavaUtilComparator>)thenComparingWithJavaUtilFunctionFunction:(id<JavaUtilFunctionFunction>)arg0 {
  return JavaUtilComparator_thenComparingWithJavaUtilFunctionFunction_(self, arg0);
}

- (id<JavaUtilComparator>)thenComparingIntWithJavaUtilFunctionToIntFunction:(id<JavaUtilFunctionToIntFunction>)arg0 {
  return JavaUtilComparator_thenComparingIntWithJavaUtilFunctionToIntFunction_(self, arg0);
}

- (id<JavaUtilComparator>)thenComparingLongWithJavaUtilFunctionToLongFunction:(id<JavaUtilFunctionToLongFunction>)arg0 {
  return JavaUtilComparator_thenComparingLongWithJavaUtilFunctionToLongFunction_(self, arg0);
}

- (id<JavaUtilComparator>)thenComparingDoubleWithJavaUtilFunctionToDoubleFunction:(id<JavaUtilFunctionToDoubleFunction>)arg0 {
  return JavaUtilComparator_thenComparingDoubleWithJavaUtilFunctionToDoubleFunction_(self, arg0);
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x0, -1, -1, -1, -1, -1, -1 },
    { NULL, "I", 0x1, 0, 1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(compareWithId:withId:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "compare", "LADXGapWorker_Task;LADXGapWorker_Task;", "LADXGapWorker;", "Ljava/lang/Object;Ljava/util/Comparator<Landroidx/recyclerview/widget/GapWorker$Task;>;" };
  static const J2ObjcClassInfo _ADXGapWorker_1 = { "", "androidx.recyclerview.widget", ptrTable, methods, NULL, 7, 0x8018, 2, 0, 2, -1, -1, 3, -1 };
  return &_ADXGapWorker_1;
}

@end

void ADXGapWorker_1_init(ADXGapWorker_1 *self) {
  NSObject_init(self);
}

ADXGapWorker_1 *new_ADXGapWorker_1_init() {
  J2OBJC_NEW_IMPL(ADXGapWorker_1, init)
}

ADXGapWorker_1 *create_ADXGapWorker_1_init() {
  J2OBJC_CREATE_IMPL(ADXGapWorker_1, init)
}
