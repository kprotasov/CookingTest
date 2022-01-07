package com.kprotasov.test.data.converters

import com.kprotasov.test.data.model.NewRecipeModel
import com.kprotasov.test.domain.entity.NewRecipe
import javax.inject.Inject

class NewRecipeConverter @Inject constructor(
    private val intToBooleanConverter: IntToBooleanConverter,
    private val commentsConverter: CommentsConverter,
    private val copyrightConverter: CopyrightConverter,
    private val likesConverter: LikesConverter,
    private val repostsConverter: RepostsConverter,
    private val viewsConverter: ViewsConverter
) : Converter<List<NewRecipeModel>, List<NewRecipe>> {

    override fun convert(from: List<NewRecipeModel>): List<NewRecipe> =
        from.map {

        }

    private fun convertModelToEntity(model: NewRecipeModel): NewRecipe {
        return NewRecipe(
            id = model.id,
            ownerId = model.ownerId,
            fromId = model.fromId,
            createdBy = model.createdBy,
            date = model.date,
            text = model.text,
            replyOwnerId = model.replyOwnerId,
            replyPostId = model.replyPostId,
            friendsOnly = intToBooleanConverter.convert(model.friendsOnly ?: 0),
            comments = commentsConverter.convert(model.comments),
            copyright = copyrightConverter.convert(model.copyright),
            likes = likesConverter.convert(model.likes),
            reposts = repostsConverter.convert(model.reposts),
            views = viewsConverter.convert(model.views),
            postType = model.postType,
            attachments =
        )
    }


}