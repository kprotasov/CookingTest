package com.kprotasov.test.cooking.di.ui

import androidx.lifecycle.ViewModel
import com.kprotasov.test.cooking.ui.mvvm.di.ViewModelKey
import com.kprotasov.test.cooking.view.authorize.AuthorizeFragment
import com.kprotasov.test.presentation.viewmodel.AuthorizeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface AuthorizePresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthorizeViewModel::class)
    fun bindViewModel(viewModel: AuthorizeViewModel): ViewModel
}

@Module
interface AuthorizeModule {

    @ContributesAndroidInjector(modules = [
        AuthorizePresentationModule::class
    ])
    fun provideAuthorizeFragment(): AuthorizeFragment
}