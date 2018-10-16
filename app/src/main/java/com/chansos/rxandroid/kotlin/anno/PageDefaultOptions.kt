package com.chansos.rxandroid.kotlin.anno

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class PageDefaultOptions(val orientation: Int = -0x4, val theme: Int = -0x4, val title: String = "", val titleResId: Int = -0x4)
