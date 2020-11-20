package com.addeeandra.akm.framework.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.addeeandra.akm.framework.lifecycle.AKMViewModel

abstract class AKMFragment<out T : ViewDataBinding, out V : AKMViewModel>(resource: Int) :
    Fragment() {

    protected abstract val viewModel: V

    private val viewBinding: T by lazy {
        DataBindingUtil.inflate(
            layoutInflater,
            resource,
            null,
            false
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewBehavior.init(this, viewBinding, viewModel)
    }
}