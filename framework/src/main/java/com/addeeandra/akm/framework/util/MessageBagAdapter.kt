package com.addeeandra.akm.framework.util

import android.view.View
import android.widget.Toast

/**
 * WIP
 */
class MessageBagAdapter : MessageBag.AlertMessageAdapter,
    MessageBag.ConfirmationMessageAdapter, MessageBag.FailureMessageAdapter,
    MessageBag.SuccessMessageAdapter, MessageBag.ToastMessageAdapter {

    override fun showToast(containerView: View, message: String, duration: Int) {
        Toast.makeText(containerView.context, message, duration).show()
    }

    override fun showSuccessMessage(
        containerView: View,
        title: String?,
        message: String?,
        confirmText: String?
    ) {
        Toast.makeText(containerView.context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showFailureMessage(
        containerView: View,
        title: String?,
        message: String?,
        confirmText: String?
    ) {
        Toast.makeText(containerView.context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showAlertMessage(
        containerView: View,
        title: String?,
        message: String?,
        confirmText: String?
    ) {
        Toast.makeText(containerView.context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showConfirmMessage(
        containerView: View,
        title: String?,
        message: String?,
        confirmText: String?
    ) {
        Toast.makeText(containerView.context, message, Toast.LENGTH_SHORT).show()
    }


}