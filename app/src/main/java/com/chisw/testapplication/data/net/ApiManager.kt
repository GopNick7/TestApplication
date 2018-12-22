package com.chisw.testapplication.data.net

import com.chisw.testapplication.data.net.model.StoryModel
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Nikita R. on 22.12.2018.
 */
class ApiManager : RestAPI {

    private var appRetrofit: RestAPI = NetManager.restApi()

    override fun getStory(page: Int, story: String): Observable<StoryModel> {
        return appRetrofit.getStory(page, story)
    }
}