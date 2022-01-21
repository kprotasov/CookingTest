package com.kprotasov.test.cooking.di.ui

import androidx.lifecycle.ViewModel
import com.kprotasov.test.cooking.ui.extensions.args
import com.kprotasov.test.cooking.ui.mvvm.di.ViewModelKey
import com.kprotasov.test.cooking.view.details.RecipeDetailsFragment
import com.kprotasov.test.cooking.view.details.recipeUuid
import com.kprotasov.test.presentation.viewmodel.details.RecipeDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface RecipeDetailsPresentationModule {

    companion object {

        @Provides
        fun provideRecipeUuid(recipesDetailsFragment: RecipeDetailsFragment): String =
            recipesDetailsFragment.args.recipeUuid
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