package com.kprotasov.test.newsreadertest.di

import com.kprotasov.test.cooking.MainActivity
import com.kprotasov.test.cooking.di.*
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(includes = [
    AndroidSupportInjectionModule::class,
    RepositoriesModule::class,
    ConverterModule::class,
    AndroidInjectionModule::class,
    RecipeImageModule::class,
    ApiModule::class
])
interface AppModule {

    @Singleton
    @ContributesAndroidInjector(modules = [NavigationModule::class, RecipesModule::class, RecipeDetailsModule::class])
    fun provideMainActivity(): MainActivity

}