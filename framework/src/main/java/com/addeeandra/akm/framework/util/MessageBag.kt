package com.addeeandra.akm.framework.util

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.IntDef

/**
 * WIP
 */
class MessageBag {

    private var mSnackbarContainer: View? = null

    private var mTitle: String? = null
    private var mMessage: String? = null

    private var mPositiveTextButton: String? = "OK"
    private var mNegativeTextButton: String? = "Cancel"

    private var mCancelable: Boolean? = null
    private var mType: Int = 0

    private var mContext: Context? = null

    fun show() {
        when (mType) {
            TYPE_MSG_TOAST -> {
                Toast.makeText(mContext, mMessage, Toast.LENGTH_SHORT).show()
                return
            }
            TYPE_MSG_SUCCESS -> {
            }
            TYPE_MSG_FAILURE -> {
            }
            TYPE_MSG_ALERT -> {
            }
            TYPE_MSG_CONFIRMATION -> {
            }
        }
    }

    companion object {

        // a simple toast message, which will only shown up at debuggable running apps.
        const val TYPE_MSG_TOAST = 0

        // shows a simple message with SnackBar
        const val TYPE_MSG_SUCCESS = 1

        // shows a simple message with SnackBar
        const val TYPE_MSG_FAILURE = 2

        // shows a dialog with Yes / OK only button
        const val TYPE_MSG_ALERT = 3

        // shows a dialog with Yes / Cancel buttons
        const val TYPE_MSG_CONFIRMATION = 4

    }

    @IntDef(value = [TYPE_MSG_TOAST, TYPE_MSG_SUCCESS, TYPE_MSG_FAILURE, TYPE_MSG_ALERT, TYPE_MSG_CONFIRMATION])
    annotation class MessageType

    interface ToastMessageAdapter {
        fun showToast(containerView: View, message: String, duration: Int = Toast.LENGTH_SHORT)
    }

    interface SuccessMessageAdapter {
        fun showSuccessMessage(
            containerView: View,
            title: String?,
            message: String?,
            confirmText: String?
        )
    }

    interface FailureMessageAdapter {
        fun showFailureMessage(
            containerView: View,
            title: String?,
            message: String?,
            confirmText: String?
        )
    }

    interface AlertMessageAdapter {
        fun showAlertMessage(
            containerView: View,
            title: String?,
            message: String?,
            confirmText: String?
        )
    }

    interface ConfirmationMessageAdapter {
        fun showConfirmMessage(
            containerView: View,
            title: String?,
            message: String?,
            confirmText: String?
        )
    }

    class Builder {

        private val messageBag: MessageBag = MessageBag()

        fun setSnackbarContainer(v: View): Builder {
            messageBag.mSnackbarContainer = v
            return this
        }

        fun setTitle(text: String): Builder {
            messageBag.mTitle = text
            return this
        }

        fun setMessage(text: String): Builder {
            messageBag.mMessage = text
            return this
        }

        fun setCancelable(isCancelable: Boolean): Builder {
            messageBag.mCancelable = isCancelable
            return this
        }

        fun setPositiveTextButton(text: String): Builder {
            messageBag.mPositiveTextButton = text
            return this
        }

        fun setNegativeTextButton(text: String): Builder {
            messageBag.mNegativeTextButton = text
            return this
        }

        fun setMessageType(@MessageType type: Int): Builder {
            messageBag.mType = type
            return this
        }

        fun build(): MessageBag {
            return messageBag
        }

    }

}