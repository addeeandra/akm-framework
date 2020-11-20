package com.addeeandra.akm.framework.lifecycle.event

/**
 * A wrapper class to a data type for a Single Action Event.
 *
 * Single Action Event is an event value that can only be taken by one observer.
 * If there are multiple observers are observing a LiveData or MutableLiveData, the first one who
 * observe the LiveData will take the value, and the next observer of the LiveData SHOULD NOT be
 * taking the value.
 * <p>
 * This concept will prevent a multi-event actions and ensure that only 1 LiveData handling 1 Action.
 */
class ActionEvent<out T>(private val content: T) {

    var hasBeenUsed = false
        private set

    fun getContentIfNotUsed(): T? {
        return if (hasBeenUsed) null else {
            hasBeenUsed = true
            content
        }
    }

    fun peekContent(): T = content

}