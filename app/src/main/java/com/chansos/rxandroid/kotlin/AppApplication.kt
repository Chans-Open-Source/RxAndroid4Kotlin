/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin

import android.support.multidex.MultiDexApplication
import com.chansos.rxandroid.kotlin.utils.AppManager
import com.chansos.rxandroid.kotlin.utils.CrashHandler

/**
 * 安卓应用根实例
 * */
class AppApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        /**
         * 初始化应用崩溃事件处理工具
         * */
        CrashHandler.init()
        /**
         * 初始化应用管理工具
         * */
        AppManager.init(this.applicationContext)
    }
}
