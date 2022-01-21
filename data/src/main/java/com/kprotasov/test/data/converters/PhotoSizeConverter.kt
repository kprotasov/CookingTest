package com.kprotasov.test.data.converters

import com.kprotasov.test.data.model.media.photo.PhotoSizeModel
import com.kprotasov.test.domain.entity.PhotoSize
import javax.inject.Inject

class PhotoSizeConverter @Inject constructor(): Converter<PhotoSizeModel, PhotoSize> {

    override fun convert(from: PhotoSizeModel): PhotoSize =
        PhotoSize(
            type = from.type,
            url = from.url,
            width = from.width,
            height = from.height
        )
}