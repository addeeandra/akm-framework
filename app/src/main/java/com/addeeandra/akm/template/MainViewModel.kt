package com.addeeandra.akm.template

import androidx.lifecycle.MutableLiveData
import com.addeeandra.akm.framework.lifecycle.AKMViewModel
import com.addeeandra.akm.framework.lifecycle.event.LiveEvent
import com.addeeandra.akm.framework.lifecycle.event.MutableLiveEvent

class MainViewModel : AKMViewModel() {

    // an example of Single Action Event
    private val _onButtonTappedEvent by lazy { MutableLiveEvent<String>() }
    val onButtonTappedEvent: LiveEvent<String> = _onButtonTappedEvent

    // an example of data-binding
    val awesomeText by lazy { MutableLiveData("Tap meee!") }

    fun onTap() {
        awesomeText.value = "Woow!! I'm tapped!"
        _onButtonTappedEvent.push("Uwooooo!")
    }
}