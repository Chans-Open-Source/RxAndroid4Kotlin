package com.chansos.rxandroid.kotlin.module.list

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chansos.rxandroid.kotlin.R
import com.chansos.rxandroid.kotlin.anno.AutowirePresent
import com.chansos.rxandroid.kotlin.anno.LayoutResId
import com.chansos.rxandroid.kotlin.base.BaseActivity
import com.chansos.rxandroid.kotlin.base.BaseRecyclerViewAdapter
import com.chansos.rxandroid.kotlin.utils.ui.UIHelper
import kotlinx.android.synthetic.main.activity_list.*

@LayoutResId(R.layout.activity_list)
@AutowirePresent("com.chansos.rxandroid.kotlin.module.list.Presenter")
class ListActivity : BaseActivity(), BaseRecyclerViewAdapter.OnItemClickListener, Contract.View {
  private lateinit var presenter: Presenter
  private lateinit var adapter: ImageListAdapter

  override fun initialize() {
    val layoutManager = LinearLayoutManager(self, LinearLayoutManager.VERTICAL, false)
    adapter = ImageListAdapter()
    recycler_view.layoutManager = layoutManager
    recycler_view.adapter = adapter
    adapter.onItemClickListener = this
    adapter.setDataList(presenter.imageList)
  }

  override fun onItemClick(view: View, position: Int) {
    UIHelper.showToast("Clicked $position.")
  }

  override fun onDestroy() {
    adapter.release()
    super.onDestroy()
  }
}
