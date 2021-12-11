package com.kprotasov.test.data.model.media.photo

import com.kprotasov.test.data.model.media.BaseMediaModel
import com.kprotasov.test.data.model.media.MediaTypes

data class PhotoMediaModel(
    val photo: PhotoModel
) : BaseMediaModel(MediaTypes.TYPE_PHOTO)