package com.kprotasov.test.data.model.media.audio

import com.google.gson.annotations.SerializedName
import com.kprotasov.test.data.model.media.BaseMediaModel
import com.kprotasov.test.data.model.media.MediaTypes

/*
id
integer 	Идентификатор аудиозаписи.
owner_id
integer 	Идентификатор владельца аудиозаписи.
artist
string 	Исполнитель.
title
string 	Название композиции.
duration
integer 	Длительность аудиозаписи в секундах.
url
string 	Ссылка на mp3.
lyrics_id
integer 	Идентификатор текста аудиозаписи (если доступно).
album_id
integer 	Идентификатор альбома, в котором находится аудиозапись (если присвоен).
genre_id
integer 	Идентификатор жанра из списка аудио жанров.
datem
integer 	Дата добавления.
no_search
integer, [1] 	1, если включена опция «Не выводить при поиске». Если опция отключена, поле не возвращается.
is_hq
integer, [1] 	1, если аудио в высоком качестве.
 */
data class AudioModel(
    val id: Int,
    @SerializedName("owner_id") val ownerId: Int,
    val artist: String? = null,
    val title: String? = null,
    val duration: Int,
    val url: String,
    val date: Int
) : BaseMediaModel(MediaTypes.TYPE_AUDIO)
