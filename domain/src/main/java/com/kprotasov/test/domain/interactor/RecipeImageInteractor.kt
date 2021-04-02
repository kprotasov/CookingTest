package com.kprotasov.test.domain.interactor

import com.kprotasov.test.domain.repository.StoreRepository
import javax.inject.Inject

class RecipeImageInteractor @Inject constructor(
    private val storeRepository: StoreRepository
) {

    companion object {
        private const val IMAGE_DOWNLOADING_TITLE = "Download recipe image"
    }

    fun downloadImageFromUrl(imageUrl: String) {
        storeRepository.downloadFromUrl(imageUrl, IMAGE_DOWNLOADING_TITLE)
    }

}