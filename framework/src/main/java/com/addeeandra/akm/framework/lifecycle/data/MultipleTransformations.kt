package com.addeeandra.akm.framework.lifecycle.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

/**
 * An alternatives uses of androidx.lifecycle.Transformations and androidx.lifecycle.MediatorLiveData
 * but with multiple LiveData(s).
 *
 * @param liveData      the LiveData(s) to map from.
 * @param onAnyChanged  when any given LiveData(s) changed, it will be called. The parameters type is
 *                      a List<Any?> which the items are sequentially identical with the given LiveData(s).
 *
 * @see androidx.lifecycle.Transformations
 * @see androidx.lifecycle.MediatorLiveData
 * @see androidx.lifecycle.LiveData
 */
class MultipleTransformations<T>(
    vararg liveData: LiveData<*>,
    private val onAnyChanged: (data: List<Any?>) -> T
) : MediatorLiveData<T>() {

    private val mLiveDataList: MutableList<Any?> = MutableList(liveData.size) { null }

    init {
        liveData.forEachIndexed { index, liveDatum ->
            super.addSource(liveDatum) { datum ->
                mLiveDataList[index] = datum
                value = onAnyChanged(mLiveDataList)
            }
        }
    }

}