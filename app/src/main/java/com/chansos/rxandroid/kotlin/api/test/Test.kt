/*
 * Copyright (c) 2018. Create and edit by ChangedenChan.
 */

package com.chansos.rxandroid.kotlin.api.test

import com.chansos.libs.rxkotlin.annotations.BaseUrl
import com.chansos.libs.rxkotlin.annotations.Domain
import com.chansos.rxandroid.kotlin.model.ProjectModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


@Domain(com.chansos.rxandroid.kotlin.api.Config.DOMAIN)
@BaseUrl("article/")
interface Test {
    @GET("project")
    fun projectList(@Query("page") page: Int, @Query("size") size: Int, @Query("query") query: String?=""): Observable<ProjectModel>
}