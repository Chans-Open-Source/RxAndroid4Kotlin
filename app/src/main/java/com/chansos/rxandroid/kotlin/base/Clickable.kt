/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import android.view.View
import com.chansos.rxandroid.kotlin.utils.ui.UIHelper

/**
 * 可点击
 * */
interface Clickable : View.OnClickListener, View.OnLongClickListener {
    /**
     * 绑定点击事件
     * */
    fun bindClick(vararg views: View) = UIHelper.bindClick(this, *views)

    /**
     * 绑定长按事件
     * */
    fun bindLongClick(vararg views: View) = UIHelper.bindLongClick(this, *views)

    override fun onClick(view: View?) {
    }

    override fun onLongClick(view: View?): Boolean {
        return false
    }
}