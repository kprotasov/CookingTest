package com.kprotasov.test.data.model.media

import com.google.gson.annotations.SerializedName

/*
"count" (integer) — Счетчик общего количества репостов. Содержит сумму репостов на стену и в личные сообщения.
"wall_count" (integer) — Счетчик репостов на стену.
"mail_count" (integer) — Счетчик репостов в личные сообщения.
"user_reposted" (integer) — Информация о том, сделал ли текущий пользователь репост этого видео.
 */
data class RepostsModel(
    val count: Int,
    @SerializedName("wall_count") val wallCount: Int,
    @SerializedName("mail_count") val mailCount: Int,
    @SerializedName("user_reposted") val userReposted: Int
)
