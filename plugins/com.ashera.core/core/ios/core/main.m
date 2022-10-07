#import <UIKit/UIKit.h>
#import "java/lang/Exception.h"

int main(int argc, char* argv[])
{
    @autoreleasepool {
        @try {
          int retVal = UIApplicationMain(argc, argv, nil, @"AppDelegate");
          return retVal;
        }
        @catch (JavaLangException *e) {
            [e printStackTrace];
            @throw e;
        }

    }
}
