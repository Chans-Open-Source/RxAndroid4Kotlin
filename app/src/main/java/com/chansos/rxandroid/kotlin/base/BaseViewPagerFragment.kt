/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import android.os.Bundle

abstract class BaseViewPagerFragment : BaseFragment(), Clickable, Initializable {
  private var isPrepared = false
  private var isRequested = false
  private var visible = false
  private var pause = true
  override fun initialize() {
    isPrepared = true
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    onInitialize()
  }

  override fun setUserVisibleHint(isVisibleToUser: Boolean) {
    super.setUserVisibleHint(isVisibleToUser)
    visible = userVisibleHint
    if (isPrepared) {
      if (visible) {
        if (pause) {
          pause = false
          onResume()
        }
      } else {
        pause = true
        onPause()
      }
    }
  }

  override fun onResume() {
    super.onResume()
    if (isPrepared && visible) {
      if (isRequested) {
        onSecondTime()
      } else {
        isRequested = true
        onFirstTime()
      }
    }
  }

  protected abstract fun onInitialize()

  protected open fun onFirstTime() {}

  protected open fun onSecondTime() {}
}