/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import com.chansos.rxandroid.kotlin.utils.ui.UIHelper

/**
 * 可初始化的
 * */
@Suppress("UNCHECKED_CAST", "MemberVisibilityCanBePrivate", "unused")
interface Initializable {
    /**
     * 初始化
     * */
    fun initialize()

    /**
     * 获取LayoutId
     * */
    fun getLayoutResId(): Int = UIHelper.getLayoutResId(this.javaClass)
}