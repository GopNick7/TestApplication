package com.chisw.testapplication.ui.activity.main

import android.util.Log
import com.chisw.testapplication.core.TestApplication
import com.chisw.testapplication.data.net.model.Hit
import com.chisw.testapplication.model.SelectableModel
import com.chisw.testapplication.ui.activity.BasePresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Nikita R. on 22.12.2018.
 */
class MainPresenterImpl : BasePresenterImpl<MainView>(), MainPresenter {

    private val STORY = "story"
    private val TAG = MainPresenterImpl::class.java.simpleName

    override fun loadStory(page: Int) {
        compositeDisposable.add(
            TestApplication.instance.getRetrofit().getStory(page, STORY)
                .map { it.hits }
                .flatMapIterable { it }
                .map { SelectableModel(it) }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { viewRef?.get()?.showItems(it) },
                    { t -> Log.e(TAG, "ERROR: $t") })
        )
    }
}