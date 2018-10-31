package com.chansos.rxandroid.kotlin.module.list

import com.chansos.libs.rxkotlin.base.BaseContract

interface Contract : BaseContract {
  interface View : BaseContract.BaseView
  interface Presenter : BaseContract.BasePresenter
}