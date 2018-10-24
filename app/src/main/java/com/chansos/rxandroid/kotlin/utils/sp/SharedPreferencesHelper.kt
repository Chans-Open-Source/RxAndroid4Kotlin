package com.chansos.rxandroid.kotlin.utils.sp

/**
 * SharedPreferences操作工具
 * */
class SharedPreferencesHelper {
  companion object {
    private val instance: SharedPreferencesSupport by lazy {
      SharedPreferencesSupport()
    }

    /**
     *
     * */
    fun set(key: String, value: Any) = instance.set(key, value)

    fun set(nameSpace: String, key: String, value: Any) = instance.set(nameSpace, key, value)

    fun <T> get(key: String, t: Class<T>, defaultValue: Any?): T? = instance.get(key, t, defaultValue)

    fun <T> get(nameSpace: String, key: String, t: Class<T>, defaultValue: Any?): T? = instance.get(nameSpace, key, t, defaultValue)
  }
}