package com.chansos.rxandroid.kotlin.utils.sp

import android.content.SharedPreferences

class SharedPreferencesHelper {
  companion object {
    private val sharedPreferencesSupport: SharedPreferencesSupport by lazy {
      SharedPreferencesSupport()
    }

    fun init() {
      sharedPreferencesSupport.setSp()
    }

    private fun getSp(key: String = sharedPreferencesSupport.defaultKey): SharedPreferences {
      return sharedPreferencesSupport.getSp(key)
    }

    private fun getEditor(key: String = sharedPreferencesSupport.defaultKey): SharedPreferences.Editor {
      return getSp(key).edit()
    }

    fun set(key: String, value: Any) {
      set(sharedPreferencesSupport.defaultKey, key, value)
    }

    fun set(nameSpace: String, key: String, value: Any) {
      val editor = getEditor(nameSpace)
      println("xxx $nameSpace $key $value ${value.javaClass.simpleName}")
      when (value.javaClass.simpleName) {
        "String" -> {
          editor.putString(key, value as String)
        }
        "Int" -> {
          editor.putInt(key, value as Int)
        }
        "Long" -> {
          editor.putLong(key, value as Long)
        }
        "Float" -> {
          editor.putFloat(key, value as Float)
        }
        "Boolean" -> {
          editor.putBoolean(key, value as Boolean)
        }
        else -> {
          if (value is Set<*>) {
            println("xxx set ${value as Set<String>}")
            editor.putStringSet(key, value)
          }
          return
        }
      }
      editor.apply()
    }

    fun <T> get(key: String, t: Class<T>, defaultValue: Any?): T? {
      return get(sharedPreferencesSupport.defaultKey, key, t, defaultValue)
    }

    fun <T> get(nameSpace: String, key: String, t: Class<T>, defaultValue: Any?): T? {
      println("xxx $nameSpace $key $defaultValue ${t}")
      when (t) {
        String::class.java -> {
          return getSp(nameSpace).getString(key, defaultValue as String) as T
        }
        Int::class.java -> {
          return getSp(nameSpace).getInt(key, defaultValue as Int) as T
        }
        Long::class.java -> {
          return getSp(nameSpace).getLong(key, defaultValue as Long) as T
        }
        Float::class.java -> {
          return getSp(nameSpace).getFloat(key, defaultValue as Float) as T
        }
        Boolean::class.java -> {
          return getSp(nameSpace).getBoolean(key, defaultValue as Boolean) as T
        }
        Set::class.java -> {
          println("xxx get $defaultValue")
          if (defaultValue == null) {
            return getSp(nameSpace).getStringSet(key, defaultValue) as T
          }
          return getSp(nameSpace).getStringSet(key, defaultValue as Set<String>) as T
        }
        else -> {
          return null
        }
      }
    }
  }
}