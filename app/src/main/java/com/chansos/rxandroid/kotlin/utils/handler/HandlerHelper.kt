package com.chansos.rxandroid.kotlin.utils.handler

import android.os.Handler
import android.os.Message

class HandlerHelper {
  companion object {
    private val instance = HandlerSupport()

    fun create(obj: Any, onHandlerMessage: OnHandlerMessage?): Handler? = instance.create(obj, onHandlerMessage)

    fun what(obj: Any, what: Int): Boolean = instance.what(obj, what)

    fun whatDelayed(obj: Any, what: Int, delay: Long): Boolean = instance.whatDelayed(obj, what, delay)

    fun whatAtTime(obj: Any, what: Int, uptime: Long): Boolean = instance.whatAtTime(obj, what, uptime)

    fun send(obj: Any, msg: Message): Boolean = instance.send(obj, msg)

    fun sendDelayed(obj: Any, msg: Message, delay: Long): Boolean = instance.sendDelayed(obj, msg, delay)

    fun sendAtTime(obj: Any, msg: Message, uptime: Long): Boolean = instance.sendAtTime(obj, msg, uptime)

    fun sendAtFirst(obj: Any, msg: Message): Boolean = instance.sendAtFirst(obj, msg)

    fun remove(obj: Any, what: Int) = instance.remove(obj, what)

    fun destory(obj: Any) = instance.destory(obj)
  }
}