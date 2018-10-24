/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.rx.support

/**
 * 添加根Url
 * */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class BaseUrl(val value: String = "/")
