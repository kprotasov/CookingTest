package com.kprotasov.test.domain.interactor

import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.domain.repository.RecipeRepository
import io.reactivex.Single
import javax.inject.Inject

class RecipeDetailsInteractor @Inject constructor(
    private val recipeRepository: RecipeRepository
) {

    fun getRecipeByUuid(uuid: String): Single<Recipe> =
        recipeRepository.get(uuid)

}