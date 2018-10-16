package com.chansos.rxandroid.kotlin.utils

class CrashHandler : Thread.UncaughtExceptionHandler {
  private var defaultExceptionHandler: Thread.UncaughtExceptionHandler? = null

  companion object {
    private val instance: CrashHandler by lazy {
      val i = CrashHandler()
      i.defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
      i
    }

    fun init() {
      Thread.setDefaultUncaughtExceptionHandler(instance)
    }
  }

  override fun uncaughtException(t: Thread?, e: Throwable?) {
    if (handleException(e)) {
      AppManager.exit()
    } else {
      defaultExceptionHandler?.uncaughtException(t, e)
    }
  }

  private fun handleException(e: Throwable?): Boolean {
    if (e == null) {
      return false
    }
    return true
  }

}