package com.addeeandra.akm.framework.app

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.addeeandra.akm.framework.AKM
import com.addeeandra.akm.framework.app.contracts.HasBindings
import com.addeeandra.akm.framework.app.contracts.HasObservers
import com.addeeandra.akm.framework.app.contracts.HasViewModel
import com.addeeandra.akm.framework.app.contracts.HasViews
import com.addeeandra.akm.framework.lifecycle.AKMViewModel

class ViewBehavior(viewModel: AKMViewModel) {

    companion object {

        fun <VDB : ViewDataBinding, VM : AKMViewModel> init(
            context: LifecycleOwner,
            viewBinding: VDB,
            viewModel: VM
        ) {
            viewBinding.lifecycleOwner = context // to initialize the viewBinding lazy delegate

            // bindings
            if (context is HasViewModel) viewBinding.setVariable(context.brViewModelId, viewModel)
            else AKM.getViewModelBindingId()?.let { id -> viewBinding.setVariable(id, viewModel) }

            if (context is HasBindings) context.setupBindings()
            if (context is HasViewModel || context is HasBindings) viewBinding.executePendingBindings()

            // setup / preparation related
            if (context is HasViews) context.setupViews()
            if (context is HasObservers) context.setupObservers()
        }

    }

}