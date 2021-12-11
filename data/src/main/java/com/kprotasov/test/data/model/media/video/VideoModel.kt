package com.kprotasov.test.data.model.media.video

import com.google.gson.annotations.SerializedName
import com.kprotasov.test.data.model.media.BaseMediaModel
import com.kprotasov.test.data.model.media.MediaTypes

data class VideoModel(
    val id: Int,
    val title: String? = null,
    val description: String? = null,
    val duration: Int,
    @SerializedName("image") val images: List<ImageModel>? = null,
    @SerializedName("first_frame") val firstFrame: List<ImageModel>? = null,
    val date: Int,
    @SerializedName("adding_date") val addingDate: Int,
    val views: Int,
    @SerializedName("local_views") val localViews: Int? = null,
    val comments: Int,
    @SerializedName("can_comment") val canComment: Int,
    @SerializedName("can_like") val canLike: Int
): BaseMediaModel(MediaTypes.TYPE_VIDEO)
