package com.addeeandra.akm.framework.extensions

import android.annotation.SuppressLint
import android.content.res.Resources
import android.util.DisplayMetrics
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat

/**
 * Run the apply block if conditions are met.
 */
inline fun <T> T.applyIf(predicate: Boolean, block: T.() -> Unit): T {
    apply { if (predicate) block() }
    return this
}


/**
 * Use the given value if null.
 */
fun Int?.orDefault(value: Int = 0): Int = this ?: value


/**
 * Use the given value if null.
 */
fun Long?.orDefault(value: Long = 0L): Long = this ?: value


/**
 * Use the given value if null.
 */
fun Double?.orDefault(value: Double = 0.0): Double = this ?: value


/**
 * Use the given value if null.
 */
fun Float?.orDefault(value: Float = 0F): Float = this ?: value

/**
 * This extensions helps you format a small or a large number with it's decimal and group separator.
 * You can use prefix to format it as currency or else.
 *
 * @param groupSeparator
 * @param decimalSeparator
 * @param prefix                a string that placed at front of the digit
 * @param suffix                a string that placed at behind of the digit
 */
fun Number.asDigitFormat(
    groupSeparator: Char = '.',
    decimalSeparator: Char = ',',
    prefix: String = "",
    suffix: String = ""
): String {
    val decimalFormat = DecimalFormat().apply {
        decimalFormatSymbols = DecimalFormatSymbols.getInstance().apply {
            this.groupingSeparator = groupSeparator
            this.decimalSeparator = decimalSeparator
        }
    }
    return "$prefix${decimalFormat.format(this)}$suffix"
}

/**
 * Convert a date string to a new date string format.
 */
@SuppressLint("SimpleDateFormat")
fun String.asDateFormat(
    newFormat: String = "dd MMM yyyy HH:mm",
    oldFormat: String = "yyyy-MM-dd'T'HH:mm:ssZZZZZ"
): String {
    val inSdf = SimpleDateFormat(oldFormat)
    val outSdf = SimpleDateFormat(newFormat)
    val date = inSdf.parse(this)
    return outSdf.format(date!!)
}

/**
 * Convert a Float to a Pixel.
 */
fun Float.asPx(): Float {
    val metrics = Resources.getSystem().displayMetrics
    return this * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

/**
 * Convert a Pixel to a DP.
 */
fun Float.asDp(): Float {
    val metrics = Resources.getSystem().displayMetrics
    return this / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}