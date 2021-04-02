package com.kprotasov.test.newsreader.data.api

import com.kprotasov.test.data.model.RecipeResultModel
import com.kprotasov.test.data.model.RecipesResultModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipesApi {

    @GET("/recipes")
    fun getRecipes(): Single<RecipesResultModel>

    @GET("/recipes/{uuid}")
    fun getRecipe(@Path("uuid") uuid: String): Single<RecipeResultModel>
}