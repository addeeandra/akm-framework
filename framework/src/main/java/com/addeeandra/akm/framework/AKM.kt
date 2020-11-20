package com.addeeandra.akm.framework

object AKM {

    private var mViewModelBindingId: Int? = null

    /**
     * Pass the default generated viewmodel binding ID, better placed in onCreate Application
     * lifecycle.
     *
     * Example :
     *
     * AKM.init(BR.vm)
     *
     * @see com.addeeandra.akm.framework.app.AKMActivity
     */
    fun init(viewModelBindingId: Int) {
        mViewModelBindingId = viewModelBindingId
    }

    fun getViewModelBindingId() = mViewModelBindingId

}