package com.chansos.rxandroid.kotlin.utils.ui

import android.support.v4.content.LocalBroadcastManager
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import java.util.concurrent.ConcurrentHashMap

class UISupport {
  internal var loadingDialogMap: ConcurrentHashMap<Int, MaterialDialog>? = null
  internal var toast: Toast? = null
  internal var receiverManager: LocalBroadcastManager? = null
}
