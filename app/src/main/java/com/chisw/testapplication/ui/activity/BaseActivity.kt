package com.chisw.testapplication.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Nikita R. on 22.12.2018.
 */
abstract class BaseActivity<T : BasePresenter<V>, V : BaseView> : AppCompatActivity(), BaseView {

    lateinit var presenter: T

    abstract fun providePresenter(): T

    abstract fun provideLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayout())
        presenter = providePresenter()
        presenter.bindView(this as V)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        presenter.unbindView()
        super.onDestroy()
    }

}