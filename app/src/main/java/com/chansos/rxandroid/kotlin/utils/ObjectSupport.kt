package com.chansos.rxandroid.kotlin.utils

class ObjectSupport {
  companion object {
    fun inject(obj: Any, fieldName: String, fieldValue: Any?) {
      try {
        val clazz = obj.javaClass
        try {
          val field1 = clazz.getField(fieldName)
          field1.set(obj, fieldValue)
        } catch (e: Exception) {
          val field2 = clazz.getDeclaredField(fieldName)
          field2.isAccessible = true
          field2.set(obj, fieldValue)
        }
      } catch (e: Exception) {
        LogUtils.e(e)
      }
    }
  }
}