/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.module.launch

import android.view.View
import com.chansos.libs.rxkotlin.AppHelper
import com.chansos.libs.rxkotlin.anno.ModulePresenter
import com.chansos.libs.rxkotlin.anno.PageLayoutId
import com.chansos.libs.rxkotlin.anno.PageOptions
import com.chansos.libs.rxkotlin.base.BaseActivity
import com.chansos.rxandroid.kotlin.R
import kotlinx.android.synthetic.main.activity_launch.*

@PageLayoutId(R.layout.activity_launch)
@ModulePresenter("com.chansos.rxandroid.kotlin.module.launch.Presenter")
@PageOptions(orientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT, theme = R.style.NoActionBarPage)
class LaunchActivity : BaseActivity(), Contract.View {
    private lateinit var presenter: Presenter
    override fun initialize() {
        bindClick(textView)
        AppHelper.Image.noCacheLoad(imageView, "https://tinypng.com/images/pro/panda-pro.png", self)
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
