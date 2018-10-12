package com.chansos.rxandroid.kotlin.module.first

import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.chansos.rxandroid.kotlin.R
import com.chansos.rxandroid.kotlin.anno.AutowirePresent
import com.chansos.rxandroid.kotlin.anno.LayoutResId
import com.chansos.rxandroid.kotlin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_first.*

@LayoutResId(R.layout.activity_first)
@AutowirePresent("com.chansos.rxandroid.kotlin.module.first.Presenter")
class FirstActivity : BaseActivity(), Contract.View {
  private lateinit var presenter: Presenter
  override fun initialize() {
    bindClick(this.fetch_data, to_second_page, exit_app)
  }

  override fun onClick(view: View?) {
    when (view) {
      fetch_data -> presenter.fetch()
      to_second_page -> presenter.toSecondPage()
      exit_app -> presenter.exitApp()
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
}
