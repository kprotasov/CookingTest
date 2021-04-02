package com.kprotasov.test.domain.repository

import com.kprotasov.test.domain.entity.Recipe
import io.reactivex.Single

interface RecipeRepository {

    fun get(uuid: String): Single<Recipe>

}