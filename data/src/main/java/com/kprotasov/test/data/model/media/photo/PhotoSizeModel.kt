package com.kprotasov.test.data.model.media.photo

/*
    type (string) — тип копии. См. Формат описания размеров фотографии.
    url (string) — URL копии.
    width (integer) — высота в px.
    height (integer) — ширина в px.
 */
data class PhotoSizeModel(
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)