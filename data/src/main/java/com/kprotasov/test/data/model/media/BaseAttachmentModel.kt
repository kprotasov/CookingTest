package com.kprotasov.test.data.model.media

data class BaseAttachmentModel(
    val type: String,
    val audio: BaseMediaModel,
    val photo: BaseMediaModel,
    val video: BaseMediaModel
)