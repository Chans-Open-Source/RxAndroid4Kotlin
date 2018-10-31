package com.chansos.rxandroid.kotlin.module.first

import com.alibaba.fastjson.JSON
import com.chansos.libs.rxkotlin.AppManager
import com.chansos.libs.rxkotlin.base.BaseActivity
import com.chansos.libs.rxkotlin.rx.RxKotlin
import com.chansos.libs.rxkotlin.sp.SharedPreferencesHelper
import com.chansos.libs.rxkotlin.support.LogUtils
import com.chansos.libs.rxkotlin.ui.UIHelper
import com.chansos.rxandroid.kotlin.api.test.Test
import com.chansos.rxandroid.kotlin.model.ProjectModel
import com.chansos.rxandroid.kotlin.module.second.SecondActivity

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

  override fun setRandomInfo() {
    SharedPreferencesHelper.set(javaClass.simpleName, System.currentTimeMillis())
    val a = HashSet<String>()
    a.add("1")
    SharedPreferencesHelper.set(javaClass.simpleName + "1", a)
  }

  override fun getRandomInfo() {
    LogUtils.i("xxx ${javaClass.simpleName}: ${SharedPreferencesHelper.get(javaClass.simpleName, Long::class.java, 0L)}")
    LogUtils.i("xxx ${javaClass.simpleName + "1"}: ${SharedPreferencesHelper.get(javaClass.simpleName + "1", Set::class.java, null)}")
  }
}