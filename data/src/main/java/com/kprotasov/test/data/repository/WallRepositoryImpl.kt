package com.kprotasov.test.data.repository

import android.util.Log
import com.kprotasov.test.data.converters.NewRecipeConverter
import com.kprotasov.test.data.datasource.VkWallDataSource
import com.kprotasov.test.domain.entity.NewRecipe
import com.kprotasov.test.domain.repository.WallRepository
import io.reactivex.Observable
import javax.inject.Inject

class WallRepositoryImpl @Inject constructor(
    private val wallDataSource: VkWallDataSource,
    private val newRecipeConverter: NewRecipeConverter
): WallRepository {

    override fun getWallById(
        ownerId: String,
        offset: Int,
        count: Int
    ): Observable<List<NewRecipe>> =
        wallDataSource.getWallById(ownerId, offset, count)
            .map {
                Log.v("WallRepositoryTest", "${it.map { it.attachments }}")
                newRecipeConverter.convert(it)
            }
}