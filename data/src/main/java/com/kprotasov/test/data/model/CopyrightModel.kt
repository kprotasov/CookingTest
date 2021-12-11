package com.kprotasov.test.data.model

/*
Источник материала, объект с полями:

    id (integer);
    link* (string);
    name* (string);
    type* (string).
 */
data class CopyrightModel(
    val id: Int,
    val link: String? = null,
    val name: String? = null,
    val type: String? = null
)