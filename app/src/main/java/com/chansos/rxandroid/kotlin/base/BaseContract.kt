/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import com.chansos.rxandroid.kotlin.utils.support.ObjectUtils

/**
 * MVP项目结构的合约接口
 * */
interface BaseContract {
  interface BaseView

  interface BasePresenter {
    /**
     * 自动绑定BaseView
     * */
    fun bind(view: BaseContract.BaseView) {
      ObjectUtils.inject(this, "view", view)
    }
  }
}