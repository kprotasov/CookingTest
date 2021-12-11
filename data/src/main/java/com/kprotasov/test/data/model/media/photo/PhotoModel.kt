package com.kprotasov.test.data.model.media.photo

import com.google.gson.annotations.SerializedName

/*
id
integer	Идентификатор фотографии.
album_id
integer 	Идентификатор альбома, в котором находится фотография.
owner_id
integer 	Идентификатор владельца фотографии.
user_id
integer 	Идентификатор пользователя, загрузившего фото (если фотография размещена в сообществе). Для фотографий, размещенных от имени сообщества, user_id = 100.
text
string 	Текст описания фотографии.
date
integer 	Дата добавления в формате Unixtime.
sizes
array 	Массив с копиями изображения в разных размерах. Каждый объект массива содержит следующие поля:

    type (string) — тип копии. См. Формат описания размеров фотографии.
    url (string) — URL копии.
    width (integer) — высота в px.
    height (integer) — ширина в px.

width*
integer 	Ширина оригинала фотографии в пикселах.
height*
integer 	Высота оригинала фотографии в пикселах.
 */
data class PhotoModel(
    val id: Int,
    @SerializedName("album_id") val albumId: Int? = null,
    @SerializedName("owner_id") val ownerId: Int? = null,
    @SerializedName("user_id") val userId: Int? = null,
    val text: String? = null,
    val date: Int,
    val sizes: List<PhotoSizeModel>,
    val width: Int? = null,
    val height: Int? = null
)