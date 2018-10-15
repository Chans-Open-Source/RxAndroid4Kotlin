package com.chansos.rxandroid.kotlin.utils.ui

import android.annotation.SuppressLint
import android.support.v4.content.LocalBroadcastManager
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.chansos.rxandroid.kotlin.R
import com.chansos.rxandroid.kotlin.utils.AppManager
import java.util.concurrent.ConcurrentHashMap

@SuppressLint("ShowToast")
class UISupport {
  internal val toast: Toast by lazy {
    Toast.makeText(UIHelper.getContext(), R.string.app_name, Toast.LENGTH_SHORT)
  }
  internal val receiverManager: LocalBroadcastManager by lazy {
    LocalBroadcastManager.getInstance(UIHelper.getContext())
  }
  internal val loadingDialogMap: ConcurrentHashMap<Int, MaterialDialog> by lazy {
    ConcurrentHashMap<Int, MaterialDialog>()
  }
}
