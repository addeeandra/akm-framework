package com.addeeandra.akm.framework.lifecycle.event

/**
 * A wrapper class of a LiveData that implement a Single Action Event with the ability to `push`
 * or `trigger` an event. This MutableLiveEvent should be dispatched in ViewModel.
 * <p>
 * The one observed in Activity / Fragment or Views are the LiveEvent<T> to retain mechanical
 * consistency between the View and ViewModel.
 *
 * @see ActionEvent
 * @see LiveEvent
 */
class MutableLiveEvent<T> : LiveEvent<T>() {

    var value
        get() = action.value
        set(newValue) {
            action.postValue(newValue)
        }

    /**
     * Push a new Action's value.
     */
    fun push(value: T) {
        this.value = ActionEvent(value)
    }

}