package com.kprotasov.test.domain.entity

import java.util.*

data class Photo (
    val id: Int,
    val albumId: Int? = null,
    val ownerId: Int? = null,
    val userId: Int? = null,
    val text: String? = null,
    val date: Date,
    val sizes: List<PhotoSize>,
    val width: Int? = null,
    val height: Int? = null
)