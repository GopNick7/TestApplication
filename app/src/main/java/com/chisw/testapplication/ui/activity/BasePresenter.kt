package com.chisw.testapplication.ui.activity

/**
 * Created by Nikita R. on 22.12.2018.
 */
interface BasePresenter<T : BaseView> {

    fun bindView(view: T)

    fun unbindView()

    fun onDestroy()

}