package com.kprotasov.test.data.converters

import com.kprotasov.test.data.model.CopyrightModel
import com.kprotasov.test.domain.entity.Copyright
import javax.inject.Inject

class CopyrightConverter @Inject constructor(): Converter<CopyrightModel?, Copyright?> {

    override fun convert(from: CopyrightModel?): Copyright? =
        from?.let { model ->
            Copyright(
                id = model.id,
                link = model.link,
                name = model.name,
                type = model.type
            )
        }
}