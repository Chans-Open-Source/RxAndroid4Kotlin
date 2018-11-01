package com.chansos.rxandroid.kotlin.module.first

import com.alibaba.fastjson.JSON
import com.chansos.libs.rxkotlin.AppHelper
import com.chansos.libs.rxkotlin.AppManager
import com.chansos.libs.rxkotlin.RxRequest
import com.chansos.libs.rxkotlin.base.BaseActivity
import com.chansos.libs.rxkotlin.log.LogUtils
import com.chansos.rxandroid.kotlin.api.test.Test
import com.chansos.rxandroid.kotlin.model.ProjectModel
import com.chansos.rxandroid.kotlin.module.second.SecondActivity

class Presenter : Contract.Presenter {
    private lateinit var view: Contract.View

    override fun toSecondPage() {
        AppHelper.UI.quickTo(SecondActivity::class.java, view as BaseActivity)
    }

    override fun exitApp() {
        AppManager.exit()
    }

    override fun fetch() {
        RxRequest
                .create<ProjectModel>(view as BaseActivity)
                .api(RxRequest.api(Test::class.java).projectList(1, 2))
                .obs(Obs(view as BaseActivity))
    }

    class Obs(activity: BaseActivity) : RxRequest.RxObserver<ProjectModel>(activity) {
        override fun onNext(t: ProjectModel) {
            LogUtils.d(JSON.toJSONString(t))
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            LogUtils.e(e)
        }
    }

    override fun toListPage() {
        AppHelper.UI.quickTo(com.chansos.rxandroid.kotlin.module.list.ListActivity::class.java, view as BaseActivity)
    }

    override fun toCrashPage() {
        AppHelper.UI.quickTo(com.chansos.rxandroid.kotlin.module.crash.CrashActivity::class.java, view as BaseActivity)
    }

    override fun setRandomInfo() {
        AppHelper.SharedPreferences.set(javaClass.simpleName, System.currentTimeMillis())
        val a = HashSet<String>()
        a.add("1")
        AppHelper.SharedPreferences.set(javaClass.simpleName + "1", a)
    }

    override fun getRandomInfo() {
        LogUtils.i("xxx ${javaClass.simpleName}: ${AppHelper.SharedPreferences.get(javaClass.simpleName, Long::class.java, 0L)}")
        LogUtils.i("xxx ${javaClass.simpleName + "1"}: ${AppHelper.SharedPreferences.get(javaClass.simpleName + "1", Set::class.java, null)}")
    }
}