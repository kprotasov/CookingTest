package com.kprotasov.test.data.model

import com.google.gson.annotations.SerializedName

/*
Информация о лайках к записи, объект с полями:

    count (integer) — число пользователей, которым понравилась запись;
    user_likes* (integer, [0,1]) — наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
    can_like* (integer, [0,1]) — информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);
    can_publish* (integer, [0,1]) — информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).
 */
data class LikesModel(
    val count: Int,
    @SerializedName("user_likes") val userLikes: Int? = null,
    @SerializedName("can_like") val canLike: Int? = null,
    @SerializedName("can_publish") val canPublish: Int? = null
)