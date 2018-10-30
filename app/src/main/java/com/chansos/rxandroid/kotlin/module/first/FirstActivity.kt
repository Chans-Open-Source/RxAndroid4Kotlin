package com.chansos.rxandroid.kotlin.module.first

import android.Manifest
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.chansos.rxandroid.kotlin.R
import com.chansos.rxandroid.kotlin.anno.AutowirePresent
import com.chansos.rxandroid.kotlin.anno.LayoutResId
import com.chansos.rxandroid.kotlin.anno.PageDefaultOptions
import com.chansos.rxandroid.kotlin.base.BaseActivity
import com.chansos.rxandroid.kotlin.utils.support.LogUtils
import com.chansos.rxandroid.kotlin.utils.permission.PermissionHelper
import kotlinx.android.synthetic.main.activity_first.*
import java.util.*

@LayoutResId(R.layout.activity_first)
@AutowirePresent("com.chansos.rxandroid.kotlin.module.first.Presenter")
@PageDefaultOptions(title = "FirstActivity")
class FirstActivity : BaseActivity(), Contract.View {
  private lateinit var presenter: Presenter
  override fun initialize() {
    bindClick(this.fetch_data, to_second_page, exit_app, to_list_page, to_crash_page)

    presenter.setRandomInfo()
    presenter.getRandomInfo()

    LogUtils.i("Storage permission: ${PermissionHelper.check(Manifest.permission_group.STORAGE)}")
    PermissionHelper.request(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
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
