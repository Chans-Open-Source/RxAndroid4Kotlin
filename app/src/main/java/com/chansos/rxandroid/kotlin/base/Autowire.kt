/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import android.app.Activity
import android.text.TextUtils
import com.chansos.rxandroid.kotlin.anno.AutowirePresent
import com.chansos.rxandroid.kotlin.anno.PageDefaultOptions
import com.chansos.rxandroid.kotlin.utils.AppManager
import com.chansos.rxandroid.kotlin.utils.ObjectUtils

interface Autowire {
  fun autowire() {
    autowirePageDefaultOptions()
    autowirePresenter()
  }

  private fun validOption(value: Int): Boolean {
    return value != -0x4
  }

  fun autowirePageDefaultOptions() {
    val clazz = this.javaClass
    val annotation = clazz.getAnnotation(PageDefaultOptions::class.java)
    if (annotation != null && (this is Activity)) {
      if (validOption(annotation.theme)) {
        this.setTheme(annotation.theme)
      }
      if (validOption(annotation.orientation)) {
        this.requestedOrientation = annotation.orientation
      }
      if (!TextUtils.isEmpty(annotation.title)) {
        this.title = annotation.title
      } else if (validOption(annotation.titleResId)) {
        this.title = AppManager.getContext().getText(annotation.titleResId)
      }
    }
  }

  fun autowirePresenter() {
    val clazz = this.javaClass
    val annotation = clazz.getAnnotation(AutowirePresent::class.java)
    if (annotation != null && !TextUtils.isEmpty(annotation.path)) {
      val presenterClass = Class.forName(annotation.path)
      val constructor = presenterClass.getConstructor()
      val presenter = constructor.newInstance() as BaseContract.BasePresenter?
      presenter!!.bind(this as BaseContract.BaseView)
      ObjectUtils.inject(this, "presenter", presenter)
    }
  }
}