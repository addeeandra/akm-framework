package com.addeeandra.akm.framework.lifecycle.event

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * A wrapper class of a LiveData that implement a Single Action Event.
 *
 * @see ActionEvent
 * @see MutableLiveEvent
 */
open class LiveEvent<T> {

    protected val action: MutableLiveData<ActionEvent<T>> = MutableLiveData()

    fun observe(lifecycleOwner: LifecycleOwner, callback: (data: T) -> Unit) {
        action.observe(lifecycleOwner, Observer {
            action.value ?: return@Observer
            callback(it.getContentIfNotUsed() ?: it.peekContent())
        })
    }

}