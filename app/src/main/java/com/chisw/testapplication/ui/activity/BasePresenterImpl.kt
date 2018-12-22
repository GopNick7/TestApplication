package com.chisw.testapplication.ui.activity

import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * Created by Nikita R. on 09.08.2018.
 */
abstract class BasePresenterImpl<T : BaseView> : BasePresenter<T> {

    var viewRef: WeakReference<T>? = null
    var compositeDisposable = CompositeDisposable()

    override fun bindView(view: T) {
        viewRef = WeakReference(view)
        compositeDisposable.let {
            if (it.isDisposed) {
                compositeDisposable = CompositeDisposable()
            }
        }
    }

    override fun unbindView() {
        viewRef = null
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }

    override fun onDestroy() {
        viewRef = null
    }
}