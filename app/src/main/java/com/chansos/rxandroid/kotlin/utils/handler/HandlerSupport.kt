package com.chansos.rxandroid.kotlin.utils.handler

import android.os.Handler
import java.util.concurrent.ConcurrentHashMap

class HandlerSupport {
  internal var handlerMap: ConcurrentHashMap<Int, Handler>? = null
}