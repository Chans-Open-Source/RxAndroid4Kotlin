/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.utils.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.content.LocalBroadcastManager
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.chansos.rxandroid.kotlin.anno.LayoutResId
import com.chansos.rxandroid.kotlin.utils.AppManager
import java.util.concurrent.ConcurrentHashMap

@SuppressLint("ShowToast")
class UIHelper {
  companion object {
    private val instance: UISupport by lazy {
      UISupport()
    }

    internal fun getContext(): Context {
      return AppManager.instance.context
    }

    private fun getToast(): Toast {
      return instance.toast
    }

    private fun getLoadingDialogMap(): ConcurrentHashMap<Int, MaterialDialog> {
      return instance.loadingDialogMap
    }

    private fun getReceiverManager(): LocalBroadcastManager {
      return instance.receiverManager
    }

    fun showToast(message: CharSequence): Toast? {
      val toast = getToast()
      toast.run {
        setText(message)
        show()
      }
      return toast
    }

    fun showToast(@StringRes strResId: Int): Toast? {
      return showToast(getContext().resources.getString(strResId))
    }

    fun showLoading(ctx: Activity?, message: String?): MaterialDialog? {
      return showLoadingByContext(ctx, message)
    }

    fun showLoading(fragment: Fragment, message: String?): MaterialDialog? {
      return showLoading(fragment.activity, message)
    }

    private fun getLoadingDialog(hash: Int): MaterialDialog? {
      val map = getLoadingDialogMap()
      if (map[hash] != null) {
        return map[hash]
      }
      return null
    }

    fun removeLoadingDialog(activity: Activity) {
      val hash = activity.hashCode()
      hideLoading(activity)
      getLoadingDialogMap().remove(hash)
    }

    fun removeLoadingDialog(fragment: Fragment) {
      removeLoadingDialog(fragment.activity!!)
    }

    private fun showLoadingByContext(ctx: Context?, message: String?): MaterialDialog? {
      var msg = message
      if (TextUtils.isEmpty(message)) {
        msg = "请稍等..."
      }
      val hash = ctx!!.hashCode()
      var dialog = getLoadingDialog(hash)
      if (dialog == null) {
        dialog = MaterialDialog
          .Builder(ctx)
          .cancelable(false)
          .progress(true, 0)
          .show()
      }
      dialog!!.setContent(msg!!)
      dialog.show()
      getLoadingDialogMap()[hash] = dialog
      return dialog
    }

    fun hideLoading(ctx: Context?) {
      val map = getLoadingDialogMap()
      val hash = ctx!!.hashCode()
      if (map[hash] != null) {
        hideLoading(map[hash])
      }
    }

    fun hideLoading(dialog: MaterialDialog?) {
      try {
        dialog!!.dismiss()
      } catch (e: Exception) {
      }
    }

    fun bindClick(listener: View.OnClickListener, vararg views: View) {
      views.forEach { view ->
        view.setOnClickListener { listener.onClick(view) }
      }
    }

    fun bindLongClick(listener: View.OnLongClickListener, vararg views: View) {
      views.forEach { view ->
        view.setOnLongClickListener { listener.onLongClick(view) }
      }
    }

    fun getLayoutResId(clazz: Class<*>): Int {
      val annotation = clazz.getAnnotation(LayoutResId::class.java)
      if (annotation != null) {
        return annotation.id
      }
      return 0x0
    }

    fun quickTo(c: Class<*>, a: Activity = AppManager.last()) {
      a.startActivity(normalIntent(c))
    }

    fun quickTo(c: Class<*>, f: Fragment) {
      f.startActivity(normalIntent(c))
    }

    fun normalIntent(c: Class<*>): Intent {
      val intent = Intent()
      intent.setClass(getContext(), c)
      return intent
    }

    fun quickToForResult(c: Class<*>, requestCode: Int, a: Activity = AppManager.last()) {
      a.startActivityForResult(normalIntent(c), requestCode)
    }

    fun quickToForResult(c: Class<*>, requestCode: Int, f: Fragment) {
      f.startActivityForResult(normalIntent(c), requestCode)
    }

    fun registerReceiver(receiver: BroadcastReceiver, vararg actions: String) {
      try {
        val filter = IntentFilter()
        actions.forEach { action -> filter.addAction(action) }
        getReceiverManager().registerReceiver(receiver, filter)
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }

    fun unregisterReceiver(receiver: BroadcastReceiver) {
      try {
        getReceiverManager().unregisterReceiver(receiver)
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }
  }
}
