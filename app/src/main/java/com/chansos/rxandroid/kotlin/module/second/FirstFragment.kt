/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.module.second

import com.chansos.libs.rxkotlin.annotations.Autowire
import com.chansos.libs.rxkotlin.annotations.PageLayoutId
import com.chansos.libs.rxkotlin.classes.BaseViewPagerFragment
import com.chansos.libs.rxkotlin.utils.LogUtils
import com.chansos.rxandroid.kotlin.R

@PageLayoutId(R.layout.fragment_first)
class FirstFragment : BaseViewPagerFragment(), Contract.View {
    @Autowire
    private lateinit var presenter: Presenter

    override fun onInitialize() {
        LogUtils.d("fragment_first onInitialize")
    }

    override fun onFirstTime() {
        LogUtils.d("fragment_first onFirstTime")
        this.presenter.fetch()
    }

    override fun onSecondTime() {
        LogUtils.d("fragment_first onSecondTime")
    }
}