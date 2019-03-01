import 'dart:async';

import 'package:flutter/services.dart';

class MyNewFlutterPlugin {
  static const MethodChannel _channel =
      const MethodChannel('my_new_flutter_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
class FlutterToast {
  static MethodChannel _channel = MethodChannel('my_new_flutter_plugin');

  static showToast(String message) {
    _channel.invokeMethod("showToast", {"message": message});
  }
}
