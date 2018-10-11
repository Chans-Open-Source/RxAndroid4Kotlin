/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.anno

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(RUNTIME)
annotation class AutowirePresent(val path: String)
