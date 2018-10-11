/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.model

class ProjectModel {
  var code: Int? = null
  var message: String? = null
  var result: ResultBean? = null
  var timeStamp: Long = 0

  class ResultBean {
    var itemList: List<ItemListBean>? = null

    class ItemListBean {
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
    }
  }
}
