package com.kprotasov.test.data.converters

import com.kprotasov.test.data.model.DonutModel
import javax.inject.Inject

class DonutConverter @Inject constructor(): Converter<DonutModel?, Boolean> {

    override fun convert(from: DonutModel?): Boolean =
        from?.isDonut ?: false
}