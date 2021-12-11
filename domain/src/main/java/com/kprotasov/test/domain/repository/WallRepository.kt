package com.kprotasov.test.domain.repository

import com.kprotasov.test.domain.entity.NewRecipe
import io.reactivex.Observable

interface WallRepository {

    fun getWallById(ownerId: String, offset: Int, count: Int): Observable<List<NewRecipe>>
}