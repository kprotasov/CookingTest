package com.kprotasov.test.cooking.di.ui

import androidx.lifecycle.ViewModel
import com.kprotasov.test.cooking.ui.mvvm.di.ViewModelKey
import com.kprotasov.test.cooking.view.image.RecipeImageFragment
import com.kprotasov.test.presentation.viewmodel.image.RecipeImageViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface RecipeImagePresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecipeImageViewModel::class)
    fun bindViewModel(viewModel: RecipeImageViewModel): ViewModel

}

@Module
interface RecipeImageModule {

    @ContributesAndroidInjector(modules = [
        RecipeImagePresentationModule::class
    ])
    fun provideImageFragment(): RecipeImageFragment

}