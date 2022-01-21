package com.kprotasov.test.data.converters

import com.kprotasov.test.data.model.media.video.ImageModel
import com.kprotasov.test.domain.entity.Image
import javax.inject.Inject

class ImageConverter @Inject constructor(): Converter<ImageModel, Image> {

    override fun convert(from: ImageModel): Image =
        Image(
            width = from.width,
            height = from.height,
            url = from.url
        )
}