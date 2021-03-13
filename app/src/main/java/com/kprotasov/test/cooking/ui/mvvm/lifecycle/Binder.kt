package com.kprotasov.test.cooking.ui.mvvm.lifecycle

import android.widget.RadioGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class Binder<T>(
    owner: LifecycleOwner,
    private val liveData: MutableLiveData<T>,
    private val setter: (T) -> Unit
) {

    private var settingValue = false

    init {
        liveData.observe(owner, Observer { value ->
            if(!settingValue) {
                settingValue = true
                setter(value)
                settingValue = false
            }
        })
    }

    fun setValue(value: T) {
        if (!settingValue) {
            settingValue = true
            liveData.value = value
            settingValue = false
        }
    }

}

fun <T> MutableLiveData<T>.bind(owner: LifecycleOwner, setter: (T) -> Unit): Binder<T> =
    Binder(owner, this, setter)

fun MutableLiveData<Int>.bind(owner: LifecycleOwner, radioGroup: RadioGroup) {
    val binder = bind(owner, radioGroup::check)
    radioGroup.setOnCheckedChangeListener { _, checkedId ->
        binder.setValue(checkedId)
    }
}