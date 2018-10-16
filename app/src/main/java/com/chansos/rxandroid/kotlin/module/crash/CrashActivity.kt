package com.chansos.rxandroid.kotlin.module.crash

import com.chansos.rxandroid.kotlin.R
import com.chansos.rxandroid.kotlin.anno.LayoutResId
import com.chansos.rxandroid.kotlin.anno.PageDefaultOptions
import com.chansos.rxandroid.kotlin.base.BaseActivity

@LayoutResId(R.layout.activity_crash)
@PageDefaultOptions(titleResId = R.string.to_crash_page)
class CrashActivity : BaseActivity() {
  override fun initialize() {
    throw NullPointerException()
  }
}
