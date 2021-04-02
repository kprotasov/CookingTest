package com.kprotasov.test.data.converters

import com.kprotasov.test.data.model.RecipeModel
import com.kprotasov.test.domain.entity.Recipe
import java.util.*
import javax.inject.Inject

class RecipeConverter @Inject constructor(
    private val dateConverter: Converter<Long, Date>
) : Converter<RecipeModel, Recipe> {

    override fun convert(from: RecipeModel): Recipe =
        Recipe(
            from.uuid,
            from.name,
            from.images,
            dateConverter.convert(from.lastUpdated),
            from.description ?: "",
            from.instructions,
            from.difficulty
        )
}