package com.kprotasov.test.data.model

import com.google.gson.annotations.SerializedName
import com.kprotasov.test.data.model.media.BaseMediaModel

data class NewRecipeModel(
    val id: Int,
    @SerializedName("owner_id") val ownerId: Int? = null,
    @SerializedName("from_id") val fromId: Int? = null,
    @SerializedName("created_by") val createdBy: Int? = null,
    @SerializedName("date") val date: Int? = null,
    @SerializedName("text") val text: String? = null,
    @SerializedName("reply_owner_id") val replyOwnerId: Int? = null,
    @SerializedName("reply_post_id") val replyPostId: Int? = null,
    @SerializedName("friends_only") val friendsOnly: Int? = null,
    val comments: CommentsModel? = null,
    val copyright: CopyrightModel? = null,
    val likes: LikesModel? = null,
    val reposts: RepostsModel? = null,
    val views: ViewsModel? = null,
    @SerializedName("post_type") val postType: String? = null,
    val attachments: List<BaseMediaModel>? = null,
    @SerializedName("marked_as_ads") val makeAsAds: Int? = null,
    val donut: DonutModel? = null
)