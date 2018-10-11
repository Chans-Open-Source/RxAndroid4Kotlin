package com.chansos.rxandroid.kotlin.module.first

import com.chansos.rxandroid.kotlin.base.BaseContract

interface Contract : BaseContract {
  interface View : BaseContract.BaseView

  interface Presenter : BaseContract.BasePresenter {
    fun fetch()

    fun toSecondPage()

    fun exitApp()
  }
}