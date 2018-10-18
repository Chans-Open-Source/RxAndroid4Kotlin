/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin

import android.support.multidex.MultiDexApplication
import com.chansos.rxandroid.kotlin.utils.AppManager
import com.chansos.rxandroid.kotlin.utils.CrashHandler

class AppApplication : MultiDexApplication() {
  override fun onCreate() {
    super.onCreate()
    CrashHandler.init()
    AppManager.init(this.applicationContext)
  }
}
