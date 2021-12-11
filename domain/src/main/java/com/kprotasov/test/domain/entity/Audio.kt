package com.kprotasov.test.domain.entity

import java.util.*

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String? = null,
    val title: String? = null,
    val duration: Int,
    val url: String,
    val date: Date
) : BaseMedia()