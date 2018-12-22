package com.chisw.testapplication.model

/**
 * Created by Nikita R. on 22.12.2018.
 */
data class SelectableModel<T>(val data: T,
                              var isSwitched: Boolean = false)