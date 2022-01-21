package com.kprotasov.test.domain.interactor

import com.kprotasov.test.domain.entity.NewRecipe
import com.kprotasov.test.domain.repository.WallRepository
import io.reactivex.Observable
import javax.inject.Inject

class NewRecipeInteractor @Inject constructor(
    private val wallRepository: WallRepository
) {

    fun getWallById(
        ownerId: String,
        offset: Int,
        count: Int
    ): Observable<List<NewRecipe>> =
        wallRepository.getWallById(
            ownerId,
            offset,
            count
        )
}