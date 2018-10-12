package com.chansos.rxandroid.kotlin.utils

import java.lang.reflect.Field

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

    fun destory(obj: Any) {
      val clazz = obj.javaClass
      clazz.declaredFields.forEach { field ->
        reset(obj, field)
      }
      clazz.fields.forEach { field ->
        reset(obj, field)
      }
    }

    private fun reset(obj: Any, field: Field) {
      val name = field.name
      val type = field.type.name
      if (!(name == name.toUpperCase() || type == type.toLowerCase())) {
        inject(obj, name, null)
      }
    }
  }
}