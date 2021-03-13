package com.kprotasov.test.cooking.di

import androidx.lifecycle.ViewModel
import com.kprotasov.test.cooking.ui.extensions.args
import com.kprotasov.test.cooking.ui.mvvm.di.ViewModelKey
import com.kprotasov.test.cooking.view.details.RecipeDetailsFragment
import com.kprotasov.test.cooking.view.details.recipe
import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.presentation.viewmodel.details.RecipeDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface RecipeDetailsPresentationModule {

    @Module
    companion object {

        @Provides
        fun provideRecipesList(recipesDetailsFragment: RecipeDetailsFragment): Recipe =
            recipesDetailsFragment.args.recipe

    }

    @Binds
    @IntoMap
    @ViewModelKey(RecipeDetailsViewModel::class)
    fun bindViewModel(viewModel: RecipeDetailsViewModel): ViewModel

}

@Module
interface RecipeDetailsModule {

    @ContributesAndroidInjector(modules = [
        RecipeDetailsPresentationModule::class
    ])
    fun provideRecipeDetailsFragment(): RecipeDetailsFragment

}