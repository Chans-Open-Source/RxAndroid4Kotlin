package com.chansos.rxandroid.kotlin.module.launch

import com.chansos.rxandroid.kotlin.base.BaseContract

interface Contract : BaseContract {
  interface View : BaseContract.BaseView {
    fun showCount(count: String)
  }

  interface Presenter : BaseContract.BasePresenter {
    fun startTimer()

    fun countDown()

    fun nextStep()
  }
}