package com.kprotasov.test.data.converters

import com.kprotasov.test.data.model.CommentsModel
import com.kprotasov.test.domain.entity.Comments
import javax.inject.Inject

class CommentsConverter @Inject constructor(
    private val intToBooleanConverter: IntToBooleanConverter
): Converter<CommentsModel?, Comments?> {

    override fun convert(from: CommentsModel?): Comments? =
        from?.let { model ->
            Comments(
                count = model.count,
                canPost = intToBooleanConverter.convert(model.canPost),
                groupsCanPost = intToBooleanConverter.convert(model.groupsCanPost ?: 0),
                canClose = model.canClose,
                canOpen = model.canOpen
            )
        }
}