package com.addeeandra.akm.framework.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.addeeandra.akm.framework.lifecycle.AKMViewModel

abstract class AKMActivity<out T : ViewDataBinding, out V : AKMViewModel>(resource: Int) : AppCompatActivity() {

    protected abstract val viewModel: V

    protected val viewBinding: T by lazy { DataBindingUtil.setContentView(this, resource) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewBehavior.init(this, viewBinding, viewModel)
    }

}