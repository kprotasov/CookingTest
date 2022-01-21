package com.kprotasov.test.cooking.di

import com.kprotasov.test.data.converters.*
import com.kprotasov.test.data.model.*
import com.kprotasov.test.data.model.media.BaseAttachmentModel
import com.kprotasov.test.data.model.media.BaseMediaModel
import com.kprotasov.test.data.model.media.photo.PhotoSizeModel
import com.kprotasov.test.data.model.media.video.ImageModel
import com.kprotasov.test.domain.entity.*
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

    @Provides
    fun provideAttachmentConverter(
        photoSizeConverter: PhotoSizeConverter,
        imageConverter: ImageConverter,
        intToBooleanConverter: IntToBooleanConverter
    ): Converter<BaseAttachmentModel, BaseMedia> =
        AttachmentConverter(photoSizeConverter, imageConverter, intToBooleanConverter)

    @Provides
    fun providesCommentsConverter(
        intToBooleanConverter: IntToBooleanConverter
    ): Converter<CommentsModel?, Comments?> =
        CommentsConverter(intToBooleanConverter)

    @Provides
    fun providesCopyrightConverter(): Converter<CopyrightModel?, Copyright?> = CopyrightConverter()

    @Provides
    fun providesDonutConverter(): Converter<DonutModel?, Boolean> = DonutConverter()

    @Provides
    fun providesImageConverter(): Converter<ImageModel, Image> = ImageConverter()

    @Provides
    fun providesIntToBooleanConverter(): Converter<Int, Boolean> = IntToBooleanConverter()

    @Provides
    fun providesLikesConverter(
        intToBooleanConverter: IntToBooleanConverter
    ): Converter<LikesModel?, Likes?> = LikesConverter(intToBooleanConverter)

    @Provides
    fun newRecipeConverter(
        intToBooleanConverter: IntToBooleanConverter,
        commentsConverter: CommentsConverter,
        copyrightConverter: CopyrightConverter,
        likesConverter: LikesConverter,
        repostsConverter: RepostsConverter,
        viewsConverter: ViewsConverter,
        attachmentConverter: AttachmentConverter,
        donutConverter: DonutConverter
    ): Converter<List<NewRecipeModel>, List<NewRecipe>> =
        NewRecipeConverter(
            intToBooleanConverter,
            commentsConverter,
            copyrightConverter,
            likesConverter,
            repostsConverter,
            viewsConverter,
            attachmentConverter,
            donutConverter,
        )

    @Provides
    fun providesPhotoSizeConverter(): Converter<PhotoSizeModel, PhotoSize> = PhotoSizeConverter()

    @Provides
    fun providesRepostsConverter(
        intToBooleanConverter: IntToBooleanConverter
    ): Converter<RepostsModel?, Reposts?> = RepostsConverter(intToBooleanConverter)

    @Provides
    fun providesViewsConverter(): Converter<ViewsModel?, Views?> = ViewsConverter()
}