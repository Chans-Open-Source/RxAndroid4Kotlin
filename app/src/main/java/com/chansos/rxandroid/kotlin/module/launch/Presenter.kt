package com.chansos.rxandroid.kotlin.module.launch

import android.app.Activity
import android.os.Message
import com.chansos.libs.rxkotlin.handler.HandlerHelper
import com.chansos.libs.rxkotlin.handler.OnHandlerMessage
import com.chansos.libs.rxkotlin.ui.UIHelper
import com.chansos.rxandroid.kotlin.module.first.FirstActivity

class Presenter : Contract.Presenter, OnHandlerMessage {
  private lateinit var view: Contract.View
  private var count = MAX_COUNT

  companion object {
    private const val COUNT_DOWN = 0
    private const val MAX_COUNT = 5
  }

  override fun onMessage(msg: Message): Boolean {
    when (msg.what) {
      COUNT_DOWN -> {
        if (count > 1) {
          count--
          countDown()
        } else {
          nextStep()
        }
        return true
      }
    }
    return false
  }

  override fun startTimer() {
    count = MAX_COUNT
    HandlerHelper.create(this, this)
    countDown()
  }

  override fun countDown() {
    view.showCount("${count}秒后跳过")
    HandlerHelper.whatDelayed(this, COUNT_DOWN, 1000)
  }

  override fun nextStep() {
    HandlerHelper.remove(this, COUNT_DOWN)
    HandlerHelper.destory(this)
    UIHelper.quickTo(FirstActivity::class.java)
    (view as Activity).finish()
  }
}