package com.kprotasov.test.newsreadertest.di

import com.kprotasov.test.data.converters.Converter
import com.kprotasov.test.data.converters.DateConverter
import com.kprotasov.test.data.converters.RecipeConverter
import com.kprotasov.test.data.model.RecipeModel
import com.kprotasov.test.domain.entity.Recipe
import dagger.Module
import dagger.Provides
import java.util.*

@Module
class ConverterModule {

    @Provides
    fun provideDateConverter(): Converter<Long, Date> =
        DateConverter()

    @Provides
    fun provideRecipeConverter(dateConverter: Converter<Long, Date>): Converter<RecipeModel, Recipe> =
        RecipeConverter(dateConverter)

}