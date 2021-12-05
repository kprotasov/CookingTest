package com.kprotasov.test.cooking.di

import com.kprotasov.test.data.converters.Converter
import com.kprotasov.test.data.datasource.RecipeDataSource
import com.kprotasov.test.data.datasource.RecipesDataSource
import com.kprotasov.test.data.datasource.StoreDataSource
import com.kprotasov.test.data.model.RecipeModel
import com.kprotasov.test.data.repository.RecipeRepositoryImpl
import com.kprotasov.test.data.repository.RecipesRepositoryImpl
import com.kprotasov.test.data.repository.StoreRepositoryImpl
import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.domain.repository.RecipeRepository
import com.kprotasov.test.domain.repository.RecipesRepository
import com.kprotasov.test.domain.repository.StoreRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideRecipesRepository(
        recipeConverter: Converter<RecipeModel, Recipe>,
        recipesDataSource: RecipesDataSource
    ): RecipesRepository =
        RecipesRepositoryImpl(recipeConverter, recipesDataSource)

    @Provides
    fun provideRecipeRepository (
        recipeConverter: Converter<RecipeModel, Recipe>,
        recipeDateSource: RecipeDataSource
    ): RecipeRepository =
        RecipeRepositoryImpl(recipeConverter, recipeDateSource)

    @Provides
    fun provideStoreRepository (
        storeDateSource: StoreDataSource
    ): StoreRepository =
        StoreRepositoryImpl(storeDateSource)
}