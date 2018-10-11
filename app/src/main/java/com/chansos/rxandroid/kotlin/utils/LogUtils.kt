/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.utils

import android.util.Log

/**
 * 日志工具
 * */
class LogUtils {
    companion object {
        /**
         * 日志标识
         * */
        private const val TAG = "Log"

        /**
         * 日志类型
         * */
        enum class Type() {
            Info("i"), Error("i"), Debug("i");

            lateinit var k: String

            constructor(k: String) {
                this.k = k
            }
        }

        /**
         * 输出信息日志
         * */
        fun i(message: String) {
            log(message, Type.Info)
        }

        fun e(err: Throwable) {
            err.printStackTrace()
            e(err.message!!)
        }

        /**
         * 输出错误日志
         * */
        fun e(message: String) {
            log(message, Type.Error)
        }

        /**
         * 输出调试日志
         * */
        fun d(message: String) {
            log(message, Type.Debug)
        }

        /**
         * 封装日志输出
         * */
        private fun log(message: String, type: Type) {
            when (type) {
                Type.Info -> {
                    Log.i(TAG, message)
                }
                Type.Error -> {
                    Log.e(TAG, message)
                }
                Type.Debug -> {
                    Log.d(TAG, message)
                }
            }
        }

        /**
         * 在终端打印
         * */
        fun p(message: String) {
            println("$TAG: $message")
        }
    }
}

