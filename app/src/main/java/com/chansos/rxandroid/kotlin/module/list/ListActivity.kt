package com.chansos.rxandroid.kotlin.module.list

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chansos.libs.rxkotlin.Kt
import com.chansos.libs.rxkotlin.annotations.Autowire
import com.chansos.libs.rxkotlin.annotations.PageLayoutId
import com.chansos.libs.rxkotlin.classes.BaseActivity
import com.chansos.libs.rxkotlin.classes.BaseRecyclerViewAdapter
import com.chansos.rxandroid.kotlin.R
import kotlinx.android.synthetic.main.activity_list.*

@PageLayoutId(R.layout.activity_list)
class ListActivity : BaseActivity(), BaseRecyclerViewAdapter.OnItemClickListener, Contract.View {
    @Autowire
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
        Kt.UI.showToast("Clicked $position.")
    }

    override fun onDestroy() {
        adapter.release()
        super.onDestroy()
    }
}
