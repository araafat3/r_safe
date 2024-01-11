package com.example.r_safe

import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding
import android.content.Context
import android.provider.Settings
import com.scottyab.rootbeer.RootBeer
import io.flutter.plugin.common.PluginRegistry.Registrar
import io.flutter.plugin.common.BinaryMessenger



fun registerPlugin(messenger: BinaryMessenger, context: Context): Unit {
  val channel = MethodChannel(messenger, "bs")
  val plugin = RSafePlugin()
  plugin.context = context
  channel.setMethodCallHandler(plugin)
}

class RSafePlugin: FlutterPlugin, MethodCallHandler {
  lateinit var context: Context

  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar): Unit {
      registerPlugin(registrar.messenger(), registrar.context())
    }
  }

  override fun onAttachedToEngine(binding: FlutterPluginBinding) {
    registerPlugin(binding.getBinaryMessenger(), binding.getApplicationContext())
  }

  override fun onDetachedFromEngine(binding: FlutterPluginBinding) {}


  override fun onMethodCall(call: MethodCall, result: Result): Unit {
    if (call.method.equals("r")) {
      val rootBeer = RootBeer(context)
      result.success(rootBeer.isRooted)
    } else {
      result.notImplemented()
    }
  }
}
