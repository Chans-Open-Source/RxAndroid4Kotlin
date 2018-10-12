package com.chansos.rxandroid.kotlin.utils.handler

import android.os.Message

interface OnHandlerMessage {
  fun onMessage(msg: Message): Boolean
}