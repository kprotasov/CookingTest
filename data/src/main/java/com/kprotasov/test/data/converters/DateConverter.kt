package com.kprotasov.test.data.converters

import java.util.*
import javax.inject.Inject

class DateConverter @Inject constructor() : Converter<Long, Date> {

    override fun convert(from: Long): Date =
        Date(from)
}