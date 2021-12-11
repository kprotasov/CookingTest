package com.kprotasov.test.domain.entity

import java.util.*

data class VideoMedia(
    val id: Int,
    val title: String? = null,
    val description: String? = null,
    val duration: Int,
    val images: List<Image>? = null,
    val firstFrame: List<Image>? = null,
    val date: Date,
    val addingDate: Date,
    val views: Int,
    val localViews: Int? = null,
    val comments: Int,
    val canComment: Boolean,
    val canLike: Boolean
): BaseMedia()