package com.chansos.rxandroid.kotlin.module.launch

import android.app.Activity
import android.os.Handler
import com.chansos.rxandroid.kotlin.module.first.FirstActivity
import com.chansos.rxandroid.kotlin.utils.ui.UIHelper

class Presenter : Contract.Presenter {
  private lateinit var view: Contract.View
  private var count = MAX_COUNT

  companion object {
    private const val COUNT_DOWN = 0
    private const val MAX_COUNT = 5
  }

  private val handler = Handler(Handler.Callback { msg ->
    when (msg.what) {
      COUNT_DOWN -> {
        if (count > 1) {
          count--
          countDown()
        } else {
          nextStep()
        }
      }
    }
    false
  })

  override fun startTimer() {
    count = MAX_COUNT
    countDown()
  }

  override fun countDown() {
    view.showCount("${count}秒后跳过")
    handler.sendEmptyMessageDelayed(COUNT_DOWN, 1000)
  }

  override fun nextStep() {
    handler.removeMessages(COUNT_DOWN)
    UIHelper.quickTo(FirstActivity::class.java)
    (view as Activity).finish()
  }
}