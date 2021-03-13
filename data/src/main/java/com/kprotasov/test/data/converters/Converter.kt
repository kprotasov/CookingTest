package com.kprotasov.test.data.converters

interface Converter<F, T> {

    fun convert(from: F): T

}