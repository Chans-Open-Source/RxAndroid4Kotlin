/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.model

import android.os.Parcel
import android.os.Parcelable

class ProjectModel() : Parcelable {
  var code: Int? = null
  var message: String? = null
  var result: ResultBean? = null
  var timeStamp: Long = 0

  constructor(parcel: Parcel?) : this() {
    if (parcel != null) {
      code = parcel.readValue(Int::class.java.classLoader) as? Int
      message = parcel.readString()
      result = parcel.readParcelable(ResultBean::class.java.classLoader)
      timeStamp = parcel.readLong()
    }
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeValue(code)
    parcel.writeString(message)
    parcel.writeParcelable(result, flags)
    parcel.writeLong(timeStamp)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<ProjectModel> {
    override fun createFromParcel(parcel: Parcel): ProjectModel {
      return ProjectModel(parcel)
    }

    override fun newArray(size: Int): Array<ProjectModel?> {
      return arrayOfNulls(size)
    }
  }

  class ResultBean() : Parcelable {
    var itemList: List<ItemListBean>? = null

    constructor(parcel: Parcel?) : this() {
      if (parcel != null) {
        itemList = parcel.createTypedArrayList(ItemListBean)
      }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
      parcel.writeTypedList(itemList)
    }

    override fun describeContents(): Int {
      return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultBean> {
      override fun createFromParcel(parcel: Parcel): ResultBean {
        return ResultBean(parcel)
      }

      override fun newArray(size: Int): Array<ResultBean?> {
        return arrayOfNulls(size)
      }
    }
  }

  class ItemListBean() : Parcelable {
    var create_at: String? = null
    var description: String? = null
    var href: String? = null
    var id: Int = 0
    var image: String? = null
    var lang: String? = null
    var ref: String? = null
    var title: String? = null
    var type: String? = null
    var update_at: String? = null

    constructor(parcel: Parcel?) : this() {
      if (parcel != null) {
        create_at = parcel.readString()
        description = parcel.readString()
        href = parcel.readString()
        id = parcel.readInt()
        image = parcel.readString()
        lang = parcel.readString()
        ref = parcel.readString()
        title = parcel.readString()
        type = parcel.readString()
        update_at = parcel.readString()
      }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
      parcel.writeString(create_at)
      parcel.writeString(description)
      parcel.writeString(href)
      parcel.writeInt(id)
      parcel.writeString(image)
      parcel.writeString(lang)
      parcel.writeString(ref)
      parcel.writeString(title)
      parcel.writeString(type)
      parcel.writeString(update_at)
    }

    override fun describeContents(): Int {
      return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemListBean> {
      override fun createFromParcel(parcel: Parcel): ItemListBean {
        return ItemListBean(parcel)
      }

      override fun newArray(size: Int): Array<ItemListBean?> {
        return arrayOfNulls(size)
      }
    }

  }
}
