package com.kprotasov.test.cooking.ui.mvvm

import com.kprotasov.test.cooking.ui.fragment.BaseFragment
import com.kprotasov.test.cooking.ui.mvvm.lifecycle.ViewModelFactory
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class MvvmFragment : BaseFragment() {

    @Inject
    override lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

}