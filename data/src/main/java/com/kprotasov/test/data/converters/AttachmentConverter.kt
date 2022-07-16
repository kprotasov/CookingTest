package com.kprotasov.test.data.converters

import android.util.Log
import com.kprotasov.test.data.model.media.BaseAttachmentModel
import com.kprotasov.test.domain.entity.MediaTypes
import com.kprotasov.test.domain.entity.media.AudioMedia
import com.kprotasov.test.domain.entity.media.BaseMedia
import com.kprotasov.test.domain.entity.media.PhotoMedia
import com.kprotasov.test.domain.entity.media.VideoMedia
import java.util.*
import javax.inject.Inject

class AttachmentConverter @Inject constructor(
    private val photoSizeConverter: PhotoSizeConverter,
    private val imageConverter: ImageConverter,
    private val intToBooleanConverter: IntToBooleanConverter
) : Converter<BaseAttachmentModel, BaseMedia> {

    override fun convert(model: BaseAttachmentModel): BaseMedia {
        Log.v("AttachmentConverterTest", "from $model")
        return when (model.type) {
            MediaTypes.TYPE_AUDIO.type -> {
                val from = model.audio
                AudioMedia(
                    id = from.id,
                    ownerId = from.ownerId ?: 0,
                    artist = from.artist,
                    title = from.title,
                    duration = from.duration ?: 0,
                    url = from.url ?: "",
                    date = Date(from.date?.toLong() ?: 0)
                )
            }
            MediaTypes.TYPE_PHOTO.type -> {
                val from = model.photo
                PhotoMedia(
                    id = from.id,
                    albumId = from.albumId,
                    ownerId = from.ownerId,
                    userId = from.userId,
                    text = from.text,
                    date = Date(from.date?.toLong() ?: 0),
                    sizes = from.sizes?.map { photoSizeConverter.convert(it) },
                    width = from.width,
                    height = from.height
                )
            }
            MediaTypes.TYPE_VIDEO.type -> {
                val from = model.video
                VideoMedia(
                    id = from.id,
                    title = from.title,
                    description = from.description,
                    duration = from.duration ?: 0,
                    images = from.images?.map { imageConverter.convert(it) },
                    firstFrame = from.firstFrame?.map { imageConverter.convert(it) },
                    date = Date(from.date?.toLong() ?: 0),
                    addingDate = Date(from.addingDate?.toLong() ?: 0),
                    views = from.views ?: 0,
                    localViews = from.localViews,
                    comments = from.comments ?: 0,
                    canComment = intToBooleanConverter.convert(from.canComment),
                    canLike = intToBooleanConverter.convert(from.canLike ?: 0)
                )
            }
            else -> BaseMedia(MediaTypes.TYPE_UNKNOWN)
        }
    }
}