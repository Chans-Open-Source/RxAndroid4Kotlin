package com.chansos.rxandroid.kotlin.module.launch

import com.chansos.libs.rxkotlin.classes.BaseContract

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