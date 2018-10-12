package com.chansos.rxandroid.kotlin.utils.handler

import android.os.Handler
import android.os.Message
import java.util.concurrent.ConcurrentHashMap

class HandlerHelper {
  companion object {
    private val instance = HandlerSupport()

    private fun getMap(): ConcurrentHashMap<Int, Handler> {
      var map = instance.handlerMap
      if (map == null) {
        map = ConcurrentHashMap()
        instance.handlerMap = map
      }
      return map
    }

    fun create(obj: Any, onHandlerMessage: OnHandlerMessage?): Handler? {
      val hash = obj.hashCode()
      var handler = getMap()[hash]
      if (handler == null && onHandlerMessage != null) {
        handler = Handler(Handler.Callback { msg: Message ->
          onHandlerMessage.onMessage(msg)
        })
        getMap()[hash] = handler
      }
      return handler
    }

    fun what(obj: Any, what: Int): Boolean {
      val handler = create(obj, null)
      if (handler != null) {
        return handler.sendEmptyMessage(what)
      }
      return false
    }

    fun whatDelayed(obj: Any, what: Int, delay: Long): Boolean {
      val handler = create(obj, null)
      if (handler != null) {
        return handler.sendEmptyMessageDelayed(what, delay)
      }
      return false
    }

    fun whatAtTime(obj: Any, what: Int, uptime: Long): Boolean {
      val handler = create(obj, null)
      if (handler != null) {
        return handler.sendEmptyMessageAtTime(what, uptime)
      }
      return false
    }

    fun send(obj: Any, msg: Message): Boolean {
      val handler = create(obj, null)
      if (handler != null) {
        return handler.sendMessage(msg)
      }
      return false
    }

    fun sendDelayed(obj: Any, msg: Message, delay: Long): Boolean {
      val handler = create(obj, null)
      if (handler != null) {
        return handler.sendMessageDelayed(msg, delay)
      }
      return false
    }

    fun sendAtTime(obj: Any, msg: Message, uptime: Long): Boolean {
      val handler = create(obj, null)
      if (handler != null) {
        return handler.sendMessageAtTime(msg, uptime)
      }
      return false
    }

    fun sendAtFirst(obj: Any, msg: Message): Boolean {
      val handler = create(obj, null)
      if (handler != null) {
        return handler.sendMessageAtFrontOfQueue(msg)
      }
      return false
    }

    fun remove(obj: Any, what: Int) {
      create(obj, null)?.removeMessages(what)
    }

    fun destory(obj: Any) {
      getMap().remove(obj.hashCode())
    }
  }
}