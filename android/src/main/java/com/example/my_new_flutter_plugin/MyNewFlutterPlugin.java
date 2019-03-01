package com.example.my_new_flutter_plugin;

import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** MyNewFlutterPlugin */
public class MyNewFlutterPlugin implements MethodCallHandler {
  /** Plugin registration. */
  static Registrar registrarLocal;
  public static void registerWith(Registrar registrar) {
    registrarLocal= registrar;
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "my_new_flutter_plugin");
    channel.setMethodCallHandler(new MyNewFlutterPlugin());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("showToast")) {
      String message=call.argument("message");
      Toast.makeText(registrarLocal.context(), message, Toast.LENGTH_LONG).show();
    } else {
      result.notImplemented();
    }
  }
}
