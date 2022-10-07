#import "java/util/AbstractMap.h"
#import "java/util/Map.h"

@protocol JavaUtilFunctionBiConsumer;

// An implementation of java.util.Map backed by an NSDictionary.
// The entrySet, keySet and valueSet methods return sets not backed
// by the Map, so modifications to the map won't be reflected in the
// sets and vice-versa.
@interface ASDictionaryMap : JavaUtilAbstractMap < JavaUtilMap > {
 @public
  // The backing native map.
  NSMutableDictionary *dictionary_;
}

// Initializes an empty map.
- (instancetype)init;
+ (instancetype)map;

// Initializes a map with the given dictionary.
- (id)initWithDictionary:(NSDictionary *)dictionary;
+ (ASDictionaryMap *)mapWithDictionary:(NSDictionary *)dictionary;

// Iterate over native dictionary without creating an entry set.
- (void)forEachWithJavaUtilFunctionBiConsumer:(id<JavaUtilFunctionBiConsumer>)action;

@end

