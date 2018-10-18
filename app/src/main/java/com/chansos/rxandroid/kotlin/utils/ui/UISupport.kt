package com.chansos.rxandroid.kotlin.utils.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.chansos.rxandroid.kotlin.R
import com.chansos.rxandroid.kotlin.anno.LayoutResId
import com.chansos.rxandroid.kotlin.utils.AppManager
import java.util.concurrent.ConcurrentHashMap

@SuppressLint("ShowToast")
class UISupport {
  private val toast: Toast by lazy {
    Toast.makeText(UIHelper.getContext(), R.string.app_name, Toast.LENGTH_SHORT)
  }
  private val loadingDialogMapper: ConcurrentHashMap<Int, MaterialDialog> by lazy {
    ConcurrentHashMap<Int, MaterialDialog>()
  }

  fun showToast(message: CharSequence): Toast? {
    toast.run {
      setText(message)
      show()
    }
    return toast
  }

  fun showToast(@StringRes strResId: Int): Toast? {
    return showToast(AppManager.getResources().getString(strResId))
  }

  fun showLoading(ctx: Activity?, message: String?): MaterialDialog? = showLoadingByContext(ctx, message)

  fun showLoading(fragment: Fragment, message: String?): MaterialDialog? = showLoading(fragment.activity, message)

  private fun getLoadingDialog(hash: Int): MaterialDialog? {
    if (loadingDialogMapper[hash] != null) {
      return loadingDialogMapper[hash]
    }
    return null
  }

  fun removeLoadingDialog(activity: Activity) {
    val hash = activity.hashCode()
    hideLoading(activity)
    loadingDialogMapper.remove(hash)
  }

  fun removeLoadingDialog(fragment: Fragment) = removeLoadingDialog(fragment.activity!!)

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
    loadingDialogMapper[hash] = dialog
    return dialog
  }

  fun hideLoading(ctx: Context?) {
    val hash = ctx!!.hashCode()
    if (loadingDialogMapper[hash] != null) {
      hideLoading(loadingDialogMapper[hash])
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

  fun quickTo(c: Class<*>, a: Activity = AppManager.last()) = a.startActivity(normalIntent(c))

  fun quickTo(c: Class<*>, f: Fragment) = f.startActivity(normalIntent(c))

  fun normalIntent(c: Class<*>): Intent {
    val intent = Intent()
    intent.setClass(UIHelper.getContext(), c)
    return intent
  }

  fun quickToForResult(c: Class<*>, requestCode: Int, a: Activity = AppManager.last()) = a.startActivityForResult(normalIntent(c), requestCode)

  fun quickToForResult(c: Class<*>, requestCode: Int, f: Fragment) = f.startActivityForResult(normalIntent(c), requestCode)

  fun <T : View?> get(layout: View, viewId: Int): T = layout.findViewById<T>(viewId)
}
