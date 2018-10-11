/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import android.os.Bundle

abstract class BaseViewPagerFragment : BaseFragment(), Clickable, Initializable {
  private var isPrepared = false
  private var isRequested = false
  private var visible = false
  private var resumed = false
  override fun initialize() {
    isPrepared = true
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    onInitialize()
  }

  override fun setUserVisibleHint(isVisibleToUser: Boolean) {
    super.setUserVisibleHint(isVisibleToUser)
    if (userVisibleHint) {
      visible = true
      onVisible()
    } else {
      visible = false
      onInvisible()
    }
  }

  private fun onInvisible() {
    if (!visible && isPrepared) {
      resumed = false
      onPause()
    }
  }

  private fun onVisible() {
    if (isPrepared && visible && !resumed) {
      resumed = true
      onResume()
    }
  }

  override fun onResume() {
    super.onResume()
    if (isPrepared && visible && !isRequested) {
      isRequested = true
      onFirstTime()
    } else if (isPrepared && visible) {
      onSecondTime()
    }
  }

  protected abstract fun onInitialize()

  protected open fun onFirstTime() {}

  protected open fun onSecondTime() {}
}