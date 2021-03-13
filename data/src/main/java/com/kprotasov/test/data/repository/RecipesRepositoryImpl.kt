package com.kprotasov.test.data.repository

import com.kprotasov.test.data.converters.Converter
import com.kprotasov.test.data.datasource.RecipesDataSource
import com.kprotasov.test.data.model.RecipeModel
import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.domain.repository.RecipesRepository
import io.reactivex.Single
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val recipeListConverter: Converter<RecipeModel, Recipe>,
    private val recipesDataSource: RecipesDataSource
) : RecipesRepository {

    override fun get(): Single<List<Recipe>> =
        recipesDataSource.getRecipes()
            .map {
                val recipeModelList = it.recipes
                recipeModelList.map { recipeListConverter.convert(it) }
            }
}