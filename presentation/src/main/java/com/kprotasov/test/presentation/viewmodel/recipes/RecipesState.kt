package com.kprotasov.test.presentation.viewmodel.recipes

import com.kprotasov.test.domain.entity.NewRecipe

sealed class RecipesState  {

    object InProgress : RecipesState()

    data class Error(val message: String?) : RecipesState()

    data class Recipes(val recipesList: List<NewRecipe>) : RecipesState()

}