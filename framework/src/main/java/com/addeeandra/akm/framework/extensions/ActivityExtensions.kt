package com.addeeandra.akm.framework.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment

inline fun <reified T> Context.startActivity(extra: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(extra))
}

inline fun <reified T> Activity.startActivity(extra: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(extra))
}

inline fun <reified T> Activity.replaceActivity(extra: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(extra))
    finish()
}

inline fun <reified T> Fragment.startActivity(extra: Intent.() -> Unit = {}) {
    startActivity(Intent(requireContext(), T::class.java).apply(extra))
}

inline fun <reified T> Activity.startActivityAsNewTask(extra: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(extra).apply {
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    })
}

inline fun <reified T> Fragment.startActivityAsNewTask(extra: Intent.() -> Unit = {}) {
    startActivity(Intent(requireContext(), T::class.java).apply(extra).apply {
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    })
}

inline fun <reified T> Activity.startActivityForResult(
    requestCode: Int = 20,
    extra: Intent.() -> Unit = {}
) {
    startActivityForResult(Intent(this, T::class.java).apply(extra), requestCode)
}

inline fun <reified T> Fragment.startActivityForResult(
    requestCode: Int = 20,
    extra: Intent.() -> Unit = {}
) {
    startActivityForResult(Intent(requireContext(), T::class.java).apply(extra), requestCode)
}

fun Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Activity.toast(message: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}