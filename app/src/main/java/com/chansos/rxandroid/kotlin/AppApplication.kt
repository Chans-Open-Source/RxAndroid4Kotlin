/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin

import android.support.multidex.MultiDexApplication
import com.chansos.libs.rxkotlin.Kt

/**
 * 安卓应用根实例
 * */
@Suppress("UNCHECKED_CAST", "MemberVisibilityCanBePrivate", "unused")
class AppApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        /**
         * 初始化应用管理工具
         * */
        Kt.App.init(this.applicationContext)
    }
}
