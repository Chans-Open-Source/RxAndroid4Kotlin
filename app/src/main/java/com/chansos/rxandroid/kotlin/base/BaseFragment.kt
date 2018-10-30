/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chansos.rxandroid.kotlin.utils.support.ObjectUtils
import com.chansos.rxandroid.kotlin.utils.handler.HandlerHelper
import com.trello.rxlifecycle2.components.support.RxFragment

/**
 * Fragment的基类
 * */
abstract class BaseFragment : RxFragment(), Clickable, Initializable, Autowire {
    protected lateinit var self: BaseFragment
    private var container: ViewGroup? = null
    private lateinit var inflater: LayoutInflater
    lateinit var rootView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        self = this
        autowire()
        this.inflater = inflater
        this.container = container
        this.rootView = createViewByLayoutResId(getLayoutResId())
        initialize()
        return rootView
    }

    /**
     * 根据LayoutId获取Layout实例
     * */
    fun createViewByLayoutResId(layoutResId: Int): View {
        return inflater.inflate(layoutResId, container, false)
    }

    /**
     * 结束当前页面
     * */
    fun finish() {
        activity!!.finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        HandlerHelper.destory(self)
        ObjectUtils.destory(self)
    }
}
