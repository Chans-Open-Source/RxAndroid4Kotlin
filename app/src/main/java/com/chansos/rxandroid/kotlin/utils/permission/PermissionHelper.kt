package com.chansos.rxandroid.kotlin.utils.permission

import android.app.Activity

class PermissionHelper {
  companion object {
    private val instance: PermissionSupport by lazy {
      PermissionSupport()
    }

    fun check(permission: String): Boolean = instance.check(permission)

    fun request(activity: Activity, permission: String) = instance.request(activity, permission)

    fun request(activity: Activity, permissions: Array<String>) = instance.request(activity, permissions)
  }
}