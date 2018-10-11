/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import com.chansos.rxandroid.kotlin.utils.UIHelper

interface Initializable {
  fun initialize()
  fun getLayoutResId(): Int = UIHelper.getLayoutResId(this.javaClass)
}