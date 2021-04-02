package com.kprotasov.test.data.datasource

import com.kprotasov.test.data.model.RecipeResultModel
import com.kprotasov.test.newsreader.data.api.RecipesApi
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RecipeDataSource @Inject constructor(
    private val recipesApi: RecipesApi
) {

    fun getRecipeByUuid(uuid: String): Single<RecipeResultModel> =
        recipesApi.getRecipe(uuid).subscribeOn(Schedulers.io())

}