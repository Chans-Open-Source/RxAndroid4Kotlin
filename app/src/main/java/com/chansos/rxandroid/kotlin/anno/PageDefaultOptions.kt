package com.chansos.rxandroid.kotlin.anno

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(RUNTIME)
annotation class PageDefaultOptions(val orientation: Int = -0x4, val theme: Int = -0x4)
