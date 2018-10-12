/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import android.view.View
import com.chansos.rxandroid.kotlin.utils.ui.UIHelper

interface Clickable : View.OnClickListener, View.OnLongClickListener {
  fun bindClick(vararg views: View) = UIHelper.bindClick(this, *views)
  fun bindLongClick(vararg views: View) = UIHelper.bindLongClick(this, *views)
  override fun onClick(view: View?) {
  }

  override fun onLongClick(view: View?): Boolean {
    return false
  }
}