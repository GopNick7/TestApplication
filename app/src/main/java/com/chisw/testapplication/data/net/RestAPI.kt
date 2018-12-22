package com.chisw.testapplication.data.net

import com.chisw.testapplication.data.net.model.StoryModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Nikita R. on 22.12.2018.
 */
interface RestAPI {

    @GET("search_by_date")
    fun getStory(
        @Query("page") page: Int,
        @Query("tags") story: String): Observable<StoryModel>

}