package com.kprotasov.test.presentation.viewmodel.image

import com.kprotasov.test.domain.interactor.RecipeImageInteractor
import com.kprotasov.test.presentation.BaseViewModel
import javax.inject.Inject

class RecipeImageViewModel @Inject constructor(
    private val recipeImageInteractor: RecipeImageInteractor
) : BaseViewModel() {

    fun downloadImage(imageUrl: String) {
        recipeImageInteractor.downloadImageFromUrl(imageUrl)
    }

}