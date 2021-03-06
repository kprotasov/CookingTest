package com.kprotasov.test.data.datasource

import com.kprotasov.test.data.model.RecipesResultModel
import com.kprotasov.test.newsreader.data.api.RecipesApi
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecipesDataSource @Inject constructor(
    private val recipesApi: RecipesApi
) {

    fun getRecipes(): Single<RecipesResultModel> =
        recipesApi.getRecipes().subscribeOn(Schedulers.io())

}