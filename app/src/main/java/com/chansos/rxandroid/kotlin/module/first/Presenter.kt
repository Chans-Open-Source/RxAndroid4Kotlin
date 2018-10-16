package com.chansos.rxandroid.kotlin.module.first

import com.alibaba.fastjson.JSON
import com.chansos.rxandroid.kotlin.api.test.Test
import com.chansos.rxandroid.kotlin.base.BaseActivity
import com.chansos.rxandroid.kotlin.model.ProjectModel
import com.chansos.rxandroid.kotlin.module.second.SecondActivity
import com.chansos.rxandroid.kotlin.rx.RxKotlin
import com.chansos.rxandroid.kotlin.utils.AppManager
import com.chansos.rxandroid.kotlin.utils.LogUtils
import com.chansos.rxandroid.kotlin.utils.ui.UIHelper

class Presenter : Contract.Presenter {
  private lateinit var view: Contract.View

  override fun toSecondPage() {
    UIHelper.quickTo(SecondActivity::class.java, view as BaseActivity)
  }

  override fun exitApp() {
    AppManager.exit()
  }

  override fun fetch() {
    RxKotlin
      .create<ProjectModel>(view as BaseActivity)
      .api(RxKotlin.api(Test::class.java).projectList(1, 2))
      .obs(Obs(view as BaseActivity))
  }

  class Obs(activity: BaseActivity) : RxKotlin.RxObserver<ProjectModel>(activity) {
    override fun onNext(t: ProjectModel) {
      LogUtils.d(JSON.toJSONString(t))
    }

    override fun onError(e: Throwable) {
      super.onError(e)
      LogUtils.e(e)
    }
  }

  override fun toListPage() {
    UIHelper.quickTo(com.chansos.rxandroid.kotlin.module.list.ListActivity::class.java, view as BaseActivity)
  }

  override fun toCrashPage() {
    UIHelper.quickTo(com.chansos.rxandroid.kotlin.module.crash.CrashActivity::class.java, view as BaseActivity)
  }
}