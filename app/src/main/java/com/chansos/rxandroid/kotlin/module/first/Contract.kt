package com.chansos.rxandroid.kotlin.module.first

import com.chansos.libs.rxkotlin.classes.BaseContract


interface Contract : BaseContract {
    interface View : BaseContract.BaseView

    interface Presenter : BaseContract.BasePresenter {
        fun fetch()

        fun toSecondPage()

        fun exitApp()

        fun toListPage()

        fun toCrashPage()

        fun setRandomInfo()

        fun getRandomInfo()
    }
}