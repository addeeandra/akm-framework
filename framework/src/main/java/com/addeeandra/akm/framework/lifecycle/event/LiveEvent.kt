package com.addeeandra.akm.framework.lifecycle.event

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * A wrapper class of a LiveData that implement a Single Action Event.
 *
 * @see ActionEvent
 * @see MutableLiveEvent
 */
open class LiveEvent<T> {

    protected val action: MutableLiveData<ActionEvent<T>> = MutableLiveData()
    protected val pending: AtomicBoolean = AtomicBoolean(false)

    fun observe(lifecycleOwner: LifecycleOwner, callback: (data: T) -> Unit) {
        action.observe(lifecycleOwner, Observer {
            if (pending.compareAndSet(true, false)) {
                action.value ?: return@Observer
                callback(it.getContentIfNotUsed() ?: it.peekContent())
            }
        })
    }

}