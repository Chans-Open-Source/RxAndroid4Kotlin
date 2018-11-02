/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.module.second

import com.chansos.libs.rxkotlin.classes.BaseContract

interface Contract : BaseContract {
    interface View : BaseContract.BaseView

    interface Presenter : BaseContract.BasePresenter {
        fun fetch()
    }
}