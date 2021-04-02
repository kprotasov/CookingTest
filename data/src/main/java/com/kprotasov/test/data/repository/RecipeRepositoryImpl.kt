package com.kprotasov.test.data.repository

import com.kprotasov.test.data.converters.Converter
import com.kprotasov.test.data.datasource.RecipeDataSource
import com.kprotasov.test.data.model.RecipeModel
import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.domain.repository.RecipeRepository
import io.reactivex.Single
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeConverter: Converter<RecipeModel, Recipe>,
    private val recipeDataSource: RecipeDataSource
) : RecipeRepository {

    override fun get(uuid: String): Single<Recipe> =
        recipeDataSource.getRecipeByUuid(uuid)
            .map {
                recipeConverter.convert(it.recipe)
            }
}