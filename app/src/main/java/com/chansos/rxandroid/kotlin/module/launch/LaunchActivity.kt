/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.module.launch

import android.view.View
import com.chansos.libs.rxkotlin.Kt
import com.chansos.libs.rxkotlin.annotations.Autowire
import com.chansos.libs.rxkotlin.annotations.PageLayoutId
import com.chansos.libs.rxkotlin.annotations.PageOptions
import com.chansos.libs.rxkotlin.classes.BaseActivity
import com.chansos.rxandroid.kotlin.R
import kotlinx.android.synthetic.main.activity_launch.*

@PageLayoutId(R.layout.activity_launch)
@PageOptions(orientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT, theme = R.style.NoActionBarPage)
class LaunchActivity : BaseActivity(), Contract.View {
    @Autowire
    private lateinit var presenter: Presenter

    override fun initialize() {
        bindClick(textView)
        Kt.Image.noCacheLoad(imageView, "https://tinypng.com/images/pro/panda-pro.png", self)
        presenter.startTimer()
    }

    override fun showCount(count: String) {
        textView.text = count
    }

    override fun onClick(view: View?) {
        when (view) {
            textView -> {
                presenter.nextStep()
            }
        }
    }
}
