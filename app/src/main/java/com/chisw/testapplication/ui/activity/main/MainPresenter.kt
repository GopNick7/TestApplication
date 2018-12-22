package com.chisw.testapplication.ui.activity.main

import com.chisw.testapplication.ui.activity.BasePresenter

/**
 * Created by Nikita R. on 22.12.2018.
 */
interface MainPresenter : BasePresenter<MainView> {
    fun loadStory(page: Int)

}