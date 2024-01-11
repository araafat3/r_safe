import Flutter
import UIKit
import DTTJailbreakDetection

public class SwiftRSafePlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "bs", binaryMessenger: registrar.messenger())
    let instance = SwiftRSafePlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        switch call.method {
        case "r":

            let isJailBroken = DTTJailbreakDetection.isJailbroken()

            result(isJailBroken)
            break
        default:
            result(FlutterMethodNotImplemented)
        }
  }
}
