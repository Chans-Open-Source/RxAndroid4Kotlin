/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import com.chansos.rxandroid.kotlin.utils.ObjectSupport

interface BaseContract {
  interface BaseView

  interface BasePresenter {
    fun bind(view: BaseContract.BaseView) {
      ObjectSupport.inject(this, "view", view)
    }
  }
}