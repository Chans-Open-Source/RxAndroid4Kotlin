/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.module.launch

import android.view.View
import com.chansos.rxandroid.kotlin.R
import com.chansos.rxandroid.kotlin.R.layout.activity_launch
import com.chansos.rxandroid.kotlin.anno.AutowirePresent
import com.chansos.rxandroid.kotlin.anno.PageDefaultOptions
import com.chansos.rxandroid.kotlin.anno.LayoutResId
import com.chansos.rxandroid.kotlin.base.BaseActivity
import com.chansos.rxandroid.kotlin.utils.ImageLoader
import kotlinx.android.synthetic.main.activity_launch.*

@LayoutResId(activity_launch)
@AutowirePresent("com.chansos.rxandroid.kotlin.module.launch.Presenter")
@PageDefaultOptions(orientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT, theme = R.style.NoActionBarPage)
class LaunchActivity : BaseActivity(), Contract.View {
  private lateinit var presenter: Presenter
  override fun initialize() {
    bindClick(textView)
    ImageLoader.noCacheLoad(imageView, "https://tinypng.com/images/pro/panda-pro.png", self)
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
