package com.kprotasov.test.cooking.di

import dagger.Module

@Module(
    includes = [
        RecipeImageModule::class,
        RecipesModule::class,
        RecipeDetailsModule::class
    ]
)
interface FragmentModule