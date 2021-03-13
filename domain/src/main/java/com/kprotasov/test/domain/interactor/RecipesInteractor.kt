package com.kprotasov.test.domain.interactor

import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.domain.repository.RecipesRepository
import io.reactivex.Single
import javax.inject.Inject

class RecipesInteractor @Inject constructor(
    private val recipesRepository: RecipesRepository
) {

    fun getRecipes(): Single<List<Recipe>> =
        recipesRepository.get()

}