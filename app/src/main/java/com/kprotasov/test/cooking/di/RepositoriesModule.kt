package com.kprotasov.test.newsreadertest.di

import com.kprotasov.test.data.converters.Converter
import com.kprotasov.test.data.datasource.RecipesDataSource
import com.kprotasov.test.data.model.RecipeModel
import com.kprotasov.test.data.repository.RecipesRepositoryImpl
import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.domain.repository.RecipesRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideRecipesRepository(
        recipeListConverter: Converter<RecipeModel, Recipe>,
        recipesDataSource: RecipesDataSource
    ): RecipesRepository =
        RecipesRepositoryImpl(recipeListConverter, recipesDataSource)

}