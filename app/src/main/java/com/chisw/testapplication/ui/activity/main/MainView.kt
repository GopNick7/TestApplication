package com.chisw.testapplication.ui.activity.main

import com.chisw.testapplication.data.net.model.Hit
import com.chisw.testapplication.model.SelectableModel
import com.chisw.testapplication.ui.activity.BaseView

/**
 * Created by Nikita R. on 22.12.2018.
 */
interface MainView : BaseView {
    fun showItems(data: List<SelectableModel<Hit>>)
}