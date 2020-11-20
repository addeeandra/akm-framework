package com.addeeandra.akm.template

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.addeeandra.akm.framework.app.AKMActivity
import com.addeeandra.akm.framework.app.contracts.HasBindings
import com.addeeandra.akm.framework.app.contracts.HasObservers
import com.addeeandra.akm.framework.app.contracts.HasViews
import com.addeeandra.akm.template.databinding.ActivityMainBinding

class MainActivity : AKMActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main),
    HasViews, HasBindings, HasObservers {

    /**
     * Depends on your pattern, you can instead using Dependency Injection to make the ViewModel.
     */
    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun setupViews() {
        // if you have any views to setup i.e. recyclerView or else, you should implements the HasViews
        // and do some works here.
        viewBinding.textBelow.text = "I'm a text from setupViews"
    }

    override fun setupBindings() {
        // when u need some custom bindings into your layout, you can implements the HasBindings interface
        viewBinding.title = "I'm from the awesome setupBindings!"

        // NOTE: this function would rarely be used because ViewModel bindings are preferred to be used instead.
    }

    override fun setupObservers() {
        viewModel.onButtonTappedEvent.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

}