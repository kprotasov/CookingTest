package com.kprotasov.test.data.converters

class IntToBooleanConverter : Converter<Int, Boolean> {

    override fun convert(from: Int): Boolean = from == 1
}