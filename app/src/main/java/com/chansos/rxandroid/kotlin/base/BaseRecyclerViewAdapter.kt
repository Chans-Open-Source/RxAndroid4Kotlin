package com.chansos.rxandroid.kotlin.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.chansos.rxandroid.kotlin.utils.ObjectUtils

abstract class BaseRecyclerViewAdapter<T> : RecyclerView.Adapter<BaseRecyclerViewHolder>() {
  private val dataList: ArrayList<T> by lazy {
    ArrayList<T>()
  }
  private val viewHolderList: ArrayList<BaseRecyclerViewHolder> by lazy {
    ArrayList<BaseRecyclerViewHolder>()
  }
  var onItemClickListener: BaseRecyclerViewAdapter.OnItemClickListener? = null
  var onItemLongClickListener: BaseRecyclerViewAdapter.OnItemLongClickListener? = null

  interface OnItemClickListener {
    fun onItemClick(view: View, position: Int)
  }

  interface OnItemLongClickListener {
    fun onItemLongClick(view: View, position: Int): Boolean
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder {
    val view = BaseRecyclerViewHolder.createView(parent, getRootLayoutResId())
    onViewCreate(view)
    val viewHolder = BaseRecyclerViewHolder.create(view, parent)
    viewHolderList.add(viewHolder)
    return viewHolder
  }

  override fun onBindViewHolder(viewHolder: BaseRecyclerViewHolder, position: Int) {
    viewHolder.itemView.setOnClickListener { v ->
      if (onItemClickListener != null) {
        onItemClickListener?.onItemClick(v, position)
      }
    }
    viewHolder.itemView.setOnLongClickListener(View.OnLongClickListener { v ->
      if (onItemLongClickListener == null) {
        false
      } else {
        return@OnLongClickListener onItemLongClickListener?.onItemLongClick(v, position)!!
      }
    })
    onBind(viewHolder, dataList[position], position)
  }

  override fun getItemCount(): Int {
    return dataList.size
  }

  fun setDataList(list: ArrayList<T>) {
    dataList.clear()
    appendDataList(list)
  }

  fun appendDataList(list: ArrayList<T>) {
    dataList.addAll(list)
    notifyDataSetChanged()
  }

  fun release() {
    viewHolderList.forEach { viewHolder ->
      run {
        viewHolder.release()
      }
    }
    ObjectUtils.destory(this)
  }

  abstract fun getRootLayoutResId(): Int

  abstract fun onViewCreate(view: View)

  abstract fun onBind(viewHolder: BaseRecyclerViewHolder, data: T, position: Int)
}
