#import "RSafePlugin.h"
#if __has_include(<r_safe/r_safe-Swift.h>)
#import <r_safe/r_safe-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "r_safe-Swift.h"
#endif

@implementation RSafePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftRSafePlugin registerWithRegistrar:registrar];
}
@end
