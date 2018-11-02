package com.chansos.rxandroid.kotlin.module.first

import com.alibaba.fastjson.JSON
import com.chansos.libs.rxkotlin.Kt
import com.chansos.libs.rxkotlin.classes.BaseActivity
import com.chansos.libs.rxkotlin.utils.LogUtils
import com.chansos.rxandroid.kotlin.api.test.Test
import com.chansos.rxandroid.kotlin.model.ProjectModel
import com.chansos.rxandroid.kotlin.module.second.SecondActivity

class Presenter : Contract.Presenter {
    private lateinit var view: Contract.View

    override fun toSecondPage() {
        Kt.UI.quickTo(SecondActivity::class.java, view as BaseActivity)
    }

    override fun exitApp() {
        Kt.App.exit()
    }

    override fun fetch() {
        Kt.Request
                .create<ProjectModel>(view as BaseActivity)
                .api(Kt.Request.api(Test::class.java).projectList(1, 2))
                .obs(Obs(view as BaseActivity))
    }

    class Obs(activity: BaseActivity) : Kt.Observer<ProjectModel>(activity) {
        override fun onNext(t: ProjectModel) {
            LogUtils.d(JSON.toJSONString(t))
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            LogUtils.e(e)
        }
    }

    override fun toListPage() {
        Kt.UI.quickTo(com.chansos.rxandroid.kotlin.module.list.ListActivity::class.java, view as BaseActivity)
    }

    override fun toCrashPage() {
        Kt.UI.quickTo(com.chansos.rxandroid.kotlin.module.crash.CrashActivity::class.java, view as BaseActivity)
    }

    override fun setRandomInfo() {
        Kt.SharedPreferences.set(javaClass.simpleName, System.currentTimeMillis())
        val a = HashSet<String>()
        a.add("1")
        Kt.SharedPreferences.set(javaClass.simpleName + "1", a)
    }

    override fun getRandomInfo() {
        LogUtils.i("xxx ${javaClass.simpleName}: ${Kt.SharedPreferences.get(javaClass.simpleName, Long::class.java, 0L)}")
        LogUtils.i("xxx ${javaClass.simpleName + "1"}: ${Kt.SharedPreferences.get(javaClass.simpleName + "1", Set::class.java, null)}")
    }
}