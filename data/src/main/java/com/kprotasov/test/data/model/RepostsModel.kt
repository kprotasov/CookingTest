package com.kprotasov.test.data.model

import com.google.gson.annotations.SerializedName

/*
Информация о репостах записи («Рассказать друзьям»), объект с полями:

    count (integer) — число пользователей, скопировавших запись;
    user_reposted* (integer, [0,1]) — наличие репоста от текущего пользователя (1 — есть, 0 — нет).
 */
data class RepostsModel(
    val count: Int,
    @SerializedName("user_reposted") val userReposted: Int
)