/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin

import android.support.multidex.MultiDexApplication
import com.chansos.rxandroid.kotlin.utils.AppManager
import com.chansos.rxandroid.kotlin.utils.UIHelper

class AppApplication : MultiDexApplication() {
  override fun onCreate() {
    super.onCreate()
    AppManager.init(this.applicationContext)
    UIHelper.init(this.applicationContext)
  }
}
