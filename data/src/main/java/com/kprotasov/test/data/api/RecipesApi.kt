package com.kprotasov.test.newsreader.data.api

import com.kprotasov.test.data.model.RecipesModel
import io.reactivex.Single
import retrofit2.http.GET

interface RecipesApi {

    @GET("/recipes")
    fun getRecipes(): Single<RecipesModel>
}