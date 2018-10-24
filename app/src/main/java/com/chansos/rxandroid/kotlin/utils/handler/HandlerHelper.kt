package com.chansos.rxandroid.kotlin.utils.handler

import android.os.Handler
import android.os.Message

/**
 * Handler操作工具
 * */
class HandlerHelper {
    companion object {
        private val instance = HandlerSupport()

        /**
         * 为某个对象创建Handler实例
         *
         * @param obj 操作对象
         * @param onHandlerMessage OnHandlerMessage事件实例
         *
         * @return Handler实例
         * */
        fun create(obj: Any, onHandlerMessage: OnHandlerMessage?): Handler? = instance.create(obj, onHandlerMessage)

        /**
         * 发送一个空消息
         *
         * @param obj 操作对象
         * @param what 消息类型
         *
         * @return 是否发送成功
         * */
        fun what(obj: Any, what: Int): Boolean = instance.what(obj, what)

        /**
         * 延时发送一个空消息
         *
         * @param obj 操作对象
         * @param what 消息类型
         * @param delay 延时（毫秒）
         *
         * @return 是否发送成功
         * */
        fun whatDelayed(obj: Any, what: Int, delay: Long): Boolean = instance.whatDelayed(obj, what, delay)

        /**
         * 数毫秒后发送一个空消息
         *
         * @param obj 操作对象
         * @param what 消息类型
         * @param uptime（毫秒）
         *
         * @return 是否发送成功
         * */
        fun whatAtTime(obj: Any, what: Int, uptime: Long): Boolean = instance.whatAtTime(obj, what, uptime)

        /**
         * 发送一个消息
         *
         * @param obj 操作对象
         * @param msg 消息
         *
         * @return 是否发送成功
         * */
        fun send(obj: Any, msg: Message): Boolean = instance.send(obj, msg)

        /**
         * 延时发送一个消息
         *
         * @param obj 操作对象
         * @param msg 消息
         * @param delay 延时（毫秒）
         *
         * @return 是否发送成功
         * */
        fun sendDelayed(obj: Any, msg: Message, delay: Long): Boolean = instance.sendDelayed(obj, msg, delay)

        /**
         * 数毫秒后发送一个消息
         *
         * @param obj 操作对象
         * @param msg 消息
         * @param uptime（毫秒）
         *
         * @return 是否发送成功
         * */
        fun sendAtTime(obj: Any, msg: Message, uptime: Long): Boolean = instance.sendAtTime(obj, msg, uptime)

        /**
         * 最高优先级发送一个消息
         *
         * @param obj 操作对象
         * @param msg 消息
         *
         * @return 是否发送成功
         * */
        fun sendAtFirst(obj: Any, msg: Message): Boolean = instance.sendAtFirst(obj, msg)

        /**
         * 移除某类消息
         *
         * @param obj 操作对象
         * @param what 消息类型
         * */
        fun remove(obj: Any, what: Int) = instance.remove(obj, what)

        /**
         * 摧毁Handler
         *
         * @param obj 操作对象
         * */
        fun destory(obj: Any) = instance.destory(obj)
    }
}