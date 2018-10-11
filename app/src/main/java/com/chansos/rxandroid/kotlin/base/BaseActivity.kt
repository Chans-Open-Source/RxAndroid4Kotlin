/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import android.os.Bundle
import android.view.Menu
import com.chansos.rxandroid.kotlin.utils.AppManager
import com.chansos.rxandroid.kotlin.utils.UIHelper
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

abstract class BaseActivity : RxAppCompatActivity(), Clickable, Initializable, Autowire {
  lateinit var self: BaseActivity
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    self = this
    autowire()
    setContentView(getLayoutResId())
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    AppManager.add(self)
    initialize()
  }

  override fun onDestroy() {
    super.onDestroy()
    AppManager.remove(self)
    UIHelper.removeLoadingDialog(self)
  }

  override fun onSupportNavigateUp(): Boolean {
    finish()
    return true
  }

  override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
    if (menu != null) {
      if (menu.javaClass.simpleName == "MenuBuilder") {
        try {
          val method = menu.javaClass.getDeclaredMethod("setOptionalIconsVisible", Boolean::class.java)
          method.isAccessible = true
          method.invoke(menu, true)
        } catch (e: Exception) {
          e.printStackTrace()
        }
      }
    }
    return super.onMenuOpened(featureId, menu)
  }
}