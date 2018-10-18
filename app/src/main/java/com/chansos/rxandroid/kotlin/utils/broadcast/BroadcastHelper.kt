package com.chansos.rxandroid.kotlin.utils.broadcast

import android.content.BroadcastReceiver
import android.support.v4.content.LocalBroadcastManager

class BroadcastHelper {
  companion object {
    private val instance: BroadcastSupport by lazy {
      BroadcastSupport()
    }

    fun getReceiverManager(): LocalBroadcastManager {
      return instance.receiverManager
    }

    fun register(receiver: BroadcastReceiver, vararg actions: String): Boolean = instance.register(receiver, *actions)

    fun unregister(receiver: BroadcastReceiver): Boolean = instance.unregister(receiver)

    fun send(clazz: Class<*>, action: String) = instance.send(clazz, action)

    fun sendSync(clazz: Class<*>, action: String) = instance.sendSync(clazz, action)
  }
}