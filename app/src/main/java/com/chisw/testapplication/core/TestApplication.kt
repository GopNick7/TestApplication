package com.chisw.testapplication.core

import android.app.Application
import com.chisw.testapplication.data.net.ApiManager
import com.chisw.testapplication.data.net.RestAPI

/**
 * Created by Nikita R. on 22.12.2018.
 */
class TestApplication : Application() {

    companion object {
        lateinit var instance: TestApplication
    }

    private lateinit var netManager: RestAPI

    override fun onCreate() {
        super.onCreate()
        instance = this

        /**Retrofit*/
        netManager = ApiManager()
    }

    fun getRetrofit(): RestAPI {
        return netManager
    }
}