package com.kprotasov.test.cooking.di

import com.kprotasov.test.cooking.di.ui.AuthorizeModule
import com.kprotasov.test.cooking.di.ui.RecipeDetailsModule
import com.kprotasov.test.cooking.di.ui.RecipeImageModule
import com.kprotasov.test.cooking.di.ui.RecipesModule
import dagger.Module

@Module(
    includes = [
        AuthorizeModule::class,
        RecipeImageModule::class,
        RecipesModule::class,
        RecipeDetailsModule::class
    ]
)
interface FragmentModule