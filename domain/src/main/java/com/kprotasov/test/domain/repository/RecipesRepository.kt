package com.kprotasov.test.domain.repository

import com.kprotasov.test.domain.entity.Recipe
import io.reactivex.Single

interface RecipesRepository {

    fun get(): Single<List<Recipe>>

}