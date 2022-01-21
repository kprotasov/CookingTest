package com.kprotasov.test.data.converters

import javax.inject.Inject

class IntToBooleanConverter @Inject constructor(): Converter<Int, Boolean> {

    override fun convert(from: Int): Boolean = from == 1
}