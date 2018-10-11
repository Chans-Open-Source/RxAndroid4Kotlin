package com.chansos.rxandroid.kotlin.module.first

import com.alibaba.fastjson.JSON
import com.chansos.rxandroid.kotlin.api.test.Test
import com.chansos.rxandroid.kotlin.base.BaseActivity
import com.chansos.rxandroid.kotlin.model.ProjectModel
import com.chansos.rxandroid.kotlin.module.second.SecondActivity
import com.chansos.rxandroid.kotlin.rx.RxKotlin
import com.chansos.rxandroid.kotlin.utils.AppManager
import com.chansos.rxandroid.kotlin.utils.LogUtils
import com.chansos.rxandroid.kotlin.utils.UIHelper

class Presenter : Contract.Presenter {
  private lateinit var view: Contract.View

  override fun toSecondPage() {
    UIHelper.quickTo(SecondActivity::class.java, view as BaseActivity)
  }

  override fun exitApp() {
    AppManager.exit()
  }

  override fun fetch() {
    try {
      RxKotlin
        .create<ProjectModel>(view as BaseActivity)
        .api(RxKotlin.api(Test::class.java).projectList(1, 2))
        .obs(object : RxKotlin.RxObserver<ProjectModel>(view as BaseActivity) {
          override fun onNext(t: ProjectModel) {
            super.onNext(t)
            LogUtils.d(JSON.toJSONString(t))
          }

          override fun onError(e: Throwable) {
            super.onError(e)
            LogUtils.e(e)
          }

        })
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }
}