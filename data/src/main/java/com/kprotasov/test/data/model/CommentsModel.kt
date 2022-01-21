package com.kprotasov.test.data.model

import com.google.gson.annotations.SerializedName

/*
Информация о комментариях к записи, объект с полями:

    count (integer) — количество комментариев;
    can_post* (integer, [0,1]) — информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
    groups_can_post (integer, [0,1]) — информация о том, могут ли сообщества комментировать запись;
    can_close(boolean) — может ли текущий пользователь закрыть комментарии к записи;
    can_open(boolean) — может ли текущий пользователь открыть комментарии к записи.
 */
data class CommentsModel(
    val count: Int,
    @SerializedName("can_post") val canPost: Int,
    @SerializedName("groups_can_post") val groupsCanPost: Boolean = false,
    @SerializedName("can_close") val canClose: Boolean,
    @SerializedName("can_open") val canOpen: Boolean
)