package com.chansos.rxandroid.kotlin.utils.handler

import android.os.Handler
import java.util.concurrent.ConcurrentHashMap

class HandlerSupport {
  internal val handlerMap: ConcurrentHashMap<Int, Handler> by lazy {
    ConcurrentHashMap<Int, Handler> ()
  }
}