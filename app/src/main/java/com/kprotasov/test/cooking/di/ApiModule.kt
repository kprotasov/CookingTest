package com.kprotasov.test.cooking.di

import com.kprotasov.test.newsreader.data.api.Api
import com.kprotasov.test.newsreader.data.api.RecipesApi
import dagger.Module
import dagger.Provides

@Module
class ApiModule {

    @Provides
    fun provideRecipesApi(api: Api): RecipesApi =
        api.getRecipesApi()
}