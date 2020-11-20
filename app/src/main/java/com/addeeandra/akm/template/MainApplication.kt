package com.addeeandra.akm.template

import android.app.Application
import com.addeeandra.akm.framework.AKM

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // it'll let the AKM Framework know the binding of your viewModel
        // if this initiation not used, you should manually implements the
        // com.addeeandra.akm.framework.app.contracts.HasViewModel contracts.
        AKM.init(BR.viewmodel)
    }

}