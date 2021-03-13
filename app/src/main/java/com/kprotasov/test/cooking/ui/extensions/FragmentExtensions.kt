package com.kprotasov.test.cooking.ui.extensions

import android.os.Bundle
import androidx.fragment.app.Fragment

val Fragment.args: Bundle
    get() = arguments
        ?: throw IllegalArgumentException("Fragment has no arguments")

fun Fragment.args(block: Bundle.() -> Unit): Fragment {
    arguments = Bundle().apply(block)
    return this
}