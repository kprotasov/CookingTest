package com.kprotasov.test.cooking.di

import androidx.lifecycle.ViewModel
import com.kprotasov.test.cooking.ui.mvvm.di.ViewModelKey
import com.kprotasov.test.cooking.view.recipes.RecipesFragment
import com.kprotasov.test.presentation.viewmodel.recipes.RecipesViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface RecipesPresentationModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecipesViewModel::class)
    fun bindViewModel(viewModel: RecipesViewModel): ViewModel
}

@Module
interface RecipesModule {

    @ContributesAndroidInjector(modules = [
        RecipesPresentationModule::class
    ])
    fun provideRecipesFragment(): RecipesFragment
}