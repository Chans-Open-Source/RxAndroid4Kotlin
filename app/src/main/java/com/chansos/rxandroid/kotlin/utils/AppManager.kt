/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import java.util.*

@SuppressLint("StaticFieldLeak")
class AppManager private constructor() : Stack<Activity>() {
  private var lastSize: Int = 0
  lateinit var context: Context

  companion object {
    private var instance: AppManager = AppManager()

    fun init(context: Context) {
      instance.context = context
    }

    fun getContext(): Context {
      return instance.context
    }

    fun getResources(): Resources {
      return getContext().resources
    }

    fun add(activity: Activity): Activity {
      var act: Activity? = null
      synchronized(instance) {
        act = instance.push(activity)
        instance.status()
      }
      return act!!
    }

    fun last(): Activity {
      return instance.lastElement()
    }

    fun finish(activity: Activity) {
      if (!activity.isFinishing) {
        synchronized(instance) {
          if (!activity.isFinishing) {
            activity.finish()
          }
        }
      }
      remove(activity)
    }

    fun remove(activity: Activity) {
      synchronized(instance) {
        instance.remove(activity)
        instance.status()
      }
    }

    fun exit() {
      while (instance.size > 0) {
        finish(instance.pop())
      }
      LogUtils.i("Exit at ${System.currentTimeMillis()}")
    }
  }

  fun status() {
    LogUtils.i("${AppManager::class.java.simpleName}: ${this}")
    if (lastSize != this.size && this.size > 0 && (get(0) as? AppCompatActivity)?.supportActionBar != null) {
      (get(0) as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
    lastSize = this.size
  }
}