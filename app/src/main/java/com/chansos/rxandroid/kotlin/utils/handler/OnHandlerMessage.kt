package com.chansos.rxandroid.kotlin.utils.handler

import android.os.Message

@Suppress("UNCHECKED_CAST", "MemberVisibilityCanBePrivate", "unused")
interface OnHandlerMessage {
    fun onMessage(msg: Message): Boolean
}