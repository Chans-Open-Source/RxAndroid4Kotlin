package com.chansos.rxandroid.kotlin.module.crash

import com.chansos.libs.rxkotlin.annotations.PageLayoutId
import com.chansos.libs.rxkotlin.annotations.PageOptions
import com.chansos.libs.rxkotlin.classes.BaseActivity
import com.chansos.rxandroid.kotlin.R

@PageLayoutId(R.layout.activity_crash)
@PageOptions(titleResId = R.string.to_crash_page)
class CrashActivity : BaseActivity() {
    override fun initialize() {
        throw NullPointerException()
    }
}
