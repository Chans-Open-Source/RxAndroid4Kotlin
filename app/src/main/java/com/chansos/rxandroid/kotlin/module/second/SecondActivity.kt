/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.module.second

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import com.chansos.rxandroid.kotlin.R
import com.chansos.rxandroid.kotlin.R.layout.activity_second
import com.chansos.rxandroid.kotlin.anno.LayoutResId
import com.chansos.rxandroid.kotlin.base.BaseActivity
import com.chansos.rxandroid.kotlin.utils.ui.UIHelper
import kotlinx.android.synthetic.main.activity_second.*

@LayoutResId(R.layout.activity_second)
class SecondActivity : BaseActivity(), ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {
  val fragmentList = ArrayList<Fragment>()
  override fun initialize() {
    fragmentList.add(FirstFragment())
    fragmentList.add(SecondFragment())
    view_pager.adapter = Adapter(self as SecondActivity, supportFragmentManager)
    view_pager.addOnPageChangeListener(self as SecondActivity)
    tab_layout.setupWithViewPager(view_pager)
    tab_layout.addOnTabSelectedListener(self as SecondActivity)
    for (i in 0..(tab_layout.tabCount - 1)) {
      tab_layout.getTabAt(i)?.text = fragmentList[i].javaClass.simpleName
    }
    onPageSelected(0)
    supportActionBar?.javaClass?.declaredFields!!.forEach { field -> println(field.name) }
  }

  override fun onPageScrollStateChanged(p0: Int) {
  }

  override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
  }

  override fun onPageSelected(position: Int) {
    view_pager.setCurrentItem(position, false)
    self.title = fragmentList[position].javaClass.simpleName
  }

  override fun onTabReselected(p0: TabLayout.Tab?) {
  }

  override fun onTabUnselected(p0: TabLayout.Tab?) {
  }

  override fun onTabSelected(p0: TabLayout.Tab?) {
    onPageSelected(p0!!.position)
  }

  private fun setCurrentMenuOptions(position: Int, menu: Menu?) {
    menu!!.clear()
    val title = fragmentList[position].javaClass.simpleName
    when (position) {
      0 -> {
        menu.add(0, R.id.page_one, 0, title).setIcon(R.drawable.ic_svg_picture)
      }
      1 -> {
        menu.add(0, R.id.page_two, 0, title).setIcon(R.drawable.ic_svg_picture_error)
      }
    }
  }

  class Adapter(private var activity: SecondActivity, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
      return activity.fragmentList[position]
    }

    override fun getCount(): Int {
      return activity.fragmentList.size
    }
  }

  override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
    setCurrentMenuOptions(view_pager.currentItem, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    when (item!!.itemId) {
      R.id.page_one -> {
        UIHelper.showToast(fragmentList[0].javaClass.simpleName)
      }
      R.id.page_two -> {
        UIHelper.showToast(fragmentList[1].javaClass.simpleName)
      }
      else -> {
        return false
      }
    }
    return true
  }
}
