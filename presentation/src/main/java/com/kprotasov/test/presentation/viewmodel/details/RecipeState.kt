package com.kprotasov.test.presentation.viewmodel.details

import com.kprotasov.test.domain.entity.Recipe

sealed class RecipeState {

    object InProgress : RecipeState()

    data class Error(val message: String?) : RecipeState()

    data class RecipeResult(val recipe: Recipe) : RecipeState()

}