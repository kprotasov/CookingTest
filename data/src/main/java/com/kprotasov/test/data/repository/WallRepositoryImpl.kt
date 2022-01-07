package com.kprotasov.test.data.repository

import com.kprotasov.test.data.datasource.VkWallDataSource
import com.kprotasov.test.domain.entity.NewRecipe
import com.kprotasov.test.domain.repository.WallRepository
import io.reactivex.Observable
import javax.inject.Inject

class WallRepositoryImpl @Inject constructor(
    private val wallDataSource: VkWallDataSource
): WallRepository {

    override fun getWallById(
        ownerId: String,
        offset: Int,
        count: Int
    ): Observable<List<NewRecipe>> {
        TODO("Not yet implemented")
    }
}