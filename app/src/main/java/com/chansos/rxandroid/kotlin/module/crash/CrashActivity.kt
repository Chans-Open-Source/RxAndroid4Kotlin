package com.chansos.rxandroid.kotlin.module.crash

import com.chansos.libs.rxkotlin.anno.LayoutResId
import com.chansos.libs.rxkotlin.anno.PageDefaultOptions
import com.chansos.libs.rxkotlin.base.BaseActivity
import com.chansos.rxandroid.kotlin.R

@LayoutResId(R.layout.activity_crash)
@PageDefaultOptions(titleResId = R.string.to_crash_page)
class CrashActivity : BaseActivity() {
  override fun initialize() {
    throw NullPointerException()
  }
}
