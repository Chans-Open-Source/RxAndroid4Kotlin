/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.rx.support

import android.app.Activity
import android.support.v4.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.chansos.rxandroid.kotlin.utils.UIHelper
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

open class RxObserver<T> : Observer<T> {
  private var activity: Activity
  private var isShowLoading: Boolean
  private var loadingDialog: MaterialDialog? = null

  constructor(activity: Activity?, isShowLoading: Boolean) {
    this.activity = activity!!
    this.isShowLoading = isShowLoading
  }

  constructor(fragment: Fragment?, isShowLoading: Boolean) : this(fragment!!.activity!!, isShowLoading)

  constructor(activity: Activity?) : this(activity, true)

  constructor(fragment: Fragment?) : this(fragment, true)

  override fun onSubscribe(d: Disposable) {
    if (isShowLoading) {
      showLoading()
    }
  }

  override fun onComplete() {
    if (isShowLoading) {
      hideLoading()
    }
  }

  open fun showLoading() {
    this.loadingDialog = UIHelper.showLoading(activity, null)
  }

  open fun hideLoading() {
    UIHelper.hideLoading(activity)
  }

  override fun onError(e: Throwable) {
  }

  override fun onNext(t: T) {
  }
}