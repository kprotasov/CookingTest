package com.kprotasov.test.cooking.di

import com.kprotasov.test.cooking.view.image.ImageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface RecipeImageModule {

    @ContributesAndroidInjector()
    fun provideImageFragment(): ImageFragment

}