package com.chisw.testapplication.ui.activity.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chisw.testapplication.R
import com.chisw.testapplication.data.net.model.Hit
import com.chisw.testapplication.model.SelectableModel
import com.chisw.testapplication.ui.activity.BaseActivity
import com.chisw.testapplication.ui.adapter.StoryAdapter
import com.chisw.testapplication.utils.PaginationListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity<MainPresenter, MainView>(), MainView,
        (SelectableModel<Hit>, Int) -> Unit {

    override fun providePresenter(): MainPresenter = MainPresenterImpl()
    override fun provideLayout(): Int = R.layout.activity_main

    private val adapterStory: StoryAdapter by lazy { StoryAdapter(this) }
    private var paginationListener = ScrollListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvCount.text = String.format(resources.getString(R.string.cout_switch), adapterStory.getChecked())

        initAdapter()

        presenter.loadStory(1)
    }

    private fun initAdapter() {

        rv_stories.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = adapterStory
            paginationListener.attach(this)
        }
    }

    override fun invoke(data: SelectableModel<Hit>, position: Int) {
        if (data.isSwitched) {
            adapterStory.setChecked(
                SelectableModel(
                    Hit(title = data.data.title, createdAt = data.data.createdAt),
                    isSwitched = false
                ), position
            )
        } else {
            adapterStory.setChecked(
                SelectableModel(
                    Hit(title = data.data.title, createdAt = data.data.createdAt),
                    isSwitched = true
                ), position
            )
        }
        tvCount.text = String.format(resources.getString(R.string.cout_switch), adapterStory.getChecked())
    }

    override fun showItems(data: List<SelectableModel<Hit>>) {
        adapterStory.showAllStory(data)
        paginationListener.setPaused(false)
    }

    private inner class ScrollListener : PaginationListener() {
        var page: Int = 1

        override fun lastItemVisible() {
            page++
            paginationListener.setPaused(true)
            presenter.loadStory(page)
        }
    }
}
