package com.chansos.rxandroid.kotlin.utils.permission

import android.app.Activity
import android.support.v4.app.ActivityCompat
import com.chansos.rxandroid.kotlin.utils.AppManager

class PermissionSupport {
  companion object {
    private const val REQUEST_CODE = 0x1024
  }

  fun check(permission: String): Boolean {
    return ActivityCompat.checkSelfPermission(AppManager.getContext(), permission) == android.content.pm.PackageManager.PERMISSION_GRANTED
  }

  fun request(activity: Activity, permission: String) = request(activity, Array(1) { permission })

  fun request(activity: Activity, permissions: Array<String>) {
    ActivityCompat.requestPermissions(activity, permissions, REQUEST_CODE)
  }

}