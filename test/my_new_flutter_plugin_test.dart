import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:my_new_flutter_plugin/my_new_flutter_plugin.dart';

void main() {
  const MethodChannel channel = MethodChannel('my_new_flutter_plugin');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await MyNewFlutterPlugin.platformVersion, '42');
  });
}
