package com.kprotasov.test.cooking.ui.mvvm.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <T> LiveData<T>.subscribeSafe(owner: LifecycleOwner, crossinline observer: (T) -> Unit) {
    observe(
        owner,
        Observer<T?> {t ->
            if (t != null) {
                observer(t)
            }
        }
    )
}