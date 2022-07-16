package com.kprotasov.test.domain.entity.media

import com.kprotasov.test.domain.entity.MediaTypes
import java.util.*

data class PhotoMedia(
    val id: Int,
    val albumId: Int? = null,
    val ownerId: Int? = null,
    val userId: Int? = null,
    val text: String? = null,
    val date: Date,
    val sizes: List<PhotoSize>? = null,
    val width: Int? = null,
    val height: Int? = null
) : BaseMedia(MediaTypes.TYPE_PHOTO), ViewableMedia