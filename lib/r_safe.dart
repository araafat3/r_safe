

import 'package:flutter/services.dart';

class RSafe {
  static const MethodChannel _channel =
  const MethodChannel('bs');

  static Future<bool> get jailbroken async {
    bool? jailbroken = await _channel.invokeMethod<bool>('r');
    return jailbroken ?? true;
  }
}
