package com.chansos.rxandroid.kotlin.module.list

class Presenter : Contract.Presenter {
    private lateinit var view: Contract.View
    val imageList: ArrayList<String> by lazy {
        val list = ArrayList<String>()
        for (i in 0..10) {
            list.add("http://static1dev.ddd.co/7823b529f42b4d2f9454731ba9787e4b")
        }
        list
    }

}
