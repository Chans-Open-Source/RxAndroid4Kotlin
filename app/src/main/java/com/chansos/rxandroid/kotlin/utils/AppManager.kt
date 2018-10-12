/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import java.util.*

@SuppressLint("StaticFieldLeak")
class AppManager private constructor() : Stack<Activity>() {
  private var lastSize: Int = 0
  lateinit var context: Context

  companion object {
    var instance: AppManager = AppManager()

    fun init(context: Context) {
      instance.context = context
    }

    fun add(activity: Activity): Activity? {
      val act = instance.push(activity)
      instance.status()
      return act
    }

    fun last(): Activity {
      return instance.lastElement()
    }

    fun finish(activity: Activity) {
      if (!activity.isFinishing) {
        activity.finish()
      }
      remove(activity)
    }

    fun remove(activity: Activity) {
      instance.remove(activity)
      instance.status()
    }

    fun exit() {
      while (instance.size > 0) {
        finish(instance.pop())
      }
    }
  }

  fun status() {
    LogUtils.i("App Stack:${this}")
    if (lastSize != this.size && this.size > 0 && (get(0) as? AppCompatActivity)?.supportActionBar != null) {
      (get(0) as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
    lastSize = this.size
  }
}