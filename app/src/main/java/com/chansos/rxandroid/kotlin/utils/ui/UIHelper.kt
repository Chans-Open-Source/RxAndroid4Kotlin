/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.utils.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.chansos.rxandroid.kotlin.utils.AppManager

class UIHelper {
  companion object {
    private val instance: UISupport by lazy {
      UISupport()
    }

    internal fun getContext() = AppManager.getContext()

    fun showToast(message: CharSequence): Toast? = instance.showToast(message)

    fun showToast(@StringRes strResId: Int): Toast? = instance.showToast(strResId)

    fun showLoading(ctx: Activity?, message: String?): MaterialDialog? = instance.showLoading(ctx, message)

    fun showLoading(fragment: Fragment, message: String?): MaterialDialog? = instance.showLoading(fragment, message)

    fun removeLoadingDialog(activity: Activity) = instance.removeLoadingDialog(activity)

    fun removeLoadingDialog(fragment: Fragment) = instance.removeLoadingDialog(fragment)

    fun hideLoading(ctx: Context?) = instance.hideLoading(ctx)

    fun hideLoading(dialog: MaterialDialog?) = instance.hideLoading(dialog)

    fun bindClick(listener: View.OnClickListener, vararg views: View) = instance.bindClick(listener, * views)

    fun bindLongClick(listener: View.OnLongClickListener, vararg views: View) = instance.bindLongClick(listener, *views)

    fun getLayoutResId(clazz: Class<*>): Int = instance.getLayoutResId(clazz)

    fun quickTo(c: Class<*>, a: Activity = AppManager.last()) = instance.quickTo(c, a)

    fun quickTo(c: Class<*>, f: Fragment) = instance.quickTo(c, f)

    fun normalIntent(c: Class<*>): Intent = instance.normalIntent(c)

    fun quickToForResult(c: Class<*>, requestCode: Int, a: Activity = AppManager.last()) = instance.quickToForResult(c, requestCode, a)

    fun quickToForResult(c: Class<*>, requestCode: Int, f: Fragment) = instance.quickToForResult(c, requestCode, f)

    fun <T : View?> get(layout: View, viewId: Int): T = instance.get<T>(layout, viewId)
  }
}
