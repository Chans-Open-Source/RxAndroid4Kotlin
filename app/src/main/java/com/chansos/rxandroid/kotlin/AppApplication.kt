/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin

import android.support.multidex.MultiDexApplication
import com.chansos.rxandroid.kotlin.utils.AppManager

/**
 * 安卓应用根实例
 * */
class AppApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        /**
         * 初始化应用管理工具
         * */
        AppManager.init(this.applicationContext)
    }
}
