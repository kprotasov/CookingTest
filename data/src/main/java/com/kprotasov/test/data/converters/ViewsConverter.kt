package com.kprotasov.test.data.converters

import com.kprotasov.test.data.model.ViewsModel
import com.kprotasov.test.domain.entity.Views
import javax.inject.Inject

class ViewsConverter @Inject constructor(): Converter<ViewsModel?, Views?> {

    override fun convert(from: ViewsModel?): Views? =
        from?.let { model ->
            Views(
                model.count
            )
        }
}