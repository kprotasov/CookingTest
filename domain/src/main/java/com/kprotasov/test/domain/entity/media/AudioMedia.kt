package com.kprotasov.test.domain.entity.media

import com.kprotasov.test.domain.entity.MediaTypes
import java.util.*

data class AudioMedia(
    val id: Int,
    val ownerId: Int,
    val artist: String? = null,
    val title: String? = null,
    val duration: Int,
    val url: String,
    val date: Date
) : BaseMedia(MediaTypes.TYPE_AUDIO)