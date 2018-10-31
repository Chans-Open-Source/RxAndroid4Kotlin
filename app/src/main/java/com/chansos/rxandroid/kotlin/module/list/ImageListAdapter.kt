package com.chansos.rxandroid.kotlin.module.list

import android.support.v7.widget.RecyclerView
import android.view.View
import com.chansos.libs.rxkotlin.base.BaseRecyclerViewAdapter
import com.chansos.libs.rxkotlin.base.BaseRecyclerViewHolder
import com.chansos.rxandroid.kotlin.R

class ImageListAdapter : BaseRecyclerViewAdapter<String>() {
  override fun getRootLayoutResId(): Int {
    return R.layout.item_image
  }

  override fun onViewCreate(view: View) {
    view.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
  }

  override fun onBind(viewHolder: BaseRecyclerViewHolder, data: String, position: Int) {
    viewHolder.setImage(R.id.image_view, data)
  }
}
