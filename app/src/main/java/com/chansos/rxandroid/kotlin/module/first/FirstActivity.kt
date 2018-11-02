package com.chansos.rxandroid.kotlin.module.first

import android.Manifest
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.chansos.libs.rxkotlin.Kt
import com.chansos.libs.rxkotlin.annotations.ModulePresenter
import com.chansos.libs.rxkotlin.annotations.PageLayoutId
import com.chansos.libs.rxkotlin.annotations.PageOptions
import com.chansos.libs.rxkotlin.classes.BaseActivity
import com.chansos.libs.rxkotlin.utils.LogUtils
import com.chansos.rxandroid.kotlin.R
import kotlinx.android.synthetic.main.activity_first.*
import java.util.*

@PageLayoutId(R.layout.activity_first)
@ModulePresenter(clazz = com.chansos.rxandroid.kotlin.module.first.Presenter::class)
@PageOptions(title = "FirstActivity")
class FirstActivity : BaseActivity(), Contract.View {
    private lateinit var presenter: Presenter
    override fun initialize() {
        bindClick(this.fetch_data, to_second_page, exit_app, to_list_page, to_crash_page)

        presenter.setRandomInfo()
        presenter.getRandomInfo()

        LogUtils.i("Storage permission: ${Kt.Permission.check(Manifest.permission_group.STORAGE)}")
        Kt.Permission.request(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    override fun onClick(view: View?) {
        when (view) {
            fetch_data -> presenter.fetch()
            to_second_page -> presenter.toSecondPage()
            exit_app -> presenter.exitApp()
            to_list_page -> presenter.toListPage()
            to_crash_page -> presenter.toCrashPage()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_first, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.fetch_data -> presenter.fetch()
            R.id.to_second_page -> presenter.toSecondPage()
            R.id.exit_app -> presenter.exitApp()
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        LogUtils.i("xxx $requestCode ${Arrays.toString(permissions)} ${Arrays.toString(grantResults)}")
    }
}
