package com.chansos.rxandroid.kotlin.utils.sp

import android.content.Context
import android.content.SharedPreferences
import com.chansos.rxandroid.kotlin.utils.AppManager
import java.util.concurrent.ConcurrentHashMap

class SharedPreferencesSupport {
  val defaultKey: String by lazy {
    AppManager.getContext().packageName
  }
  private val sharedPreferencesMapper: ConcurrentHashMap<String, SharedPreferences> by lazy {
    ConcurrentHashMap<String, SharedPreferences>()
  }

  fun setSp(key: String = defaultKey): SharedPreferences {
    val sp = AppManager.getContext().getSharedPreferences(key, Context.MODE_PRIVATE)
    sharedPreferencesMapper[key] = sp
    return sp
  }

  fun getSp(key: String = defaultKey): SharedPreferences {
    return sharedPreferencesMapper[key] ?: return setSp(key)
  }
}