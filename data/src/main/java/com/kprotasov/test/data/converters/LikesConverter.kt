package com.kprotasov.test.data.converters

import com.kprotasov.test.data.model.LikesModel
import com.kprotasov.test.domain.entity.Likes
import javax.inject.Inject

class LikesConverter @Inject constructor(
    private val intToBooleanConverter: IntToBooleanConverter
): Converter<LikesModel?, Likes?> {

    override fun convert(from: LikesModel?): Likes? =
        from?.let { model ->
            Likes(
                count = model.count,
                userLikes = intToBooleanConverter.convert(model.userLikes ?: 0),
                canLike = intToBooleanConverter.convert(model.canLike ?: 0),
                canPublish = intToBooleanConverter.convert(model.canPublish ?: 0)
            )
        }
}