package com.kprotasov.test.presentation.viewmodel.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kprotasov.test.domain.entity.Recipe
import com.kprotasov.test.presentation.BaseViewModel
import com.kprotasov.test.presentation.navigation.IMAGE_SCREEN
import com.kprotasov.test.presentation.navigation.Router
import javax.inject.Inject

class RecipeDetailsViewModel @Inject constructor(
    private val router: Router,
    recipe: Recipe
) : BaseViewModel() {

    private val _images = MutableLiveData<List<String>>()
    val images: LiveData<List<String>> = _images

    init {
        _images.value = recipe.images
    }

    fun openImage(imageLink: String) {
        router.moveTo(IMAGE_SCREEN, imageLink)
    }

}