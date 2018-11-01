package com.chansos.rxandroid.kotlin.module.crash

import com.chansos.libs.rxkotlin.anno.PageLayoutId
import com.chansos.libs.rxkotlin.anno.PageOptions
import com.chansos.libs.rxkotlin.base.BaseActivity
import com.chansos.rxandroid.kotlin.R

@PageLayoutId(R.layout.activity_crash)
@PageOptions(titleResId = R.string.to_crash_page)
class CrashActivity : BaseActivity() {
    override fun initialize() {
        throw NullPointerException()
    }
}
