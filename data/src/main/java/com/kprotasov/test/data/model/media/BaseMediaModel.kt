package com.kprotasov.test.data.model.media

import com.google.gson.annotations.SerializedName
import com.kprotasov.test.data.model.media.photo.PhotoSizeModel
import com.kprotasov.test.data.model.media.video.ImageModel
import com.kprotasov.test.domain.entity.MediaTypes

data class BaseMediaModel(
    // audio model
    val id: Int,
    @SerializedName("owner_id") val ownerId: Int? = null,
    val artist: String? = null,
    val title: String? = null,
    val duration: Int? = null,
    val url: String? = null,
    val date: Int? = null,
    // photo model
    @SerializedName("album_id") val albumId: Int? = null,
    @SerializedName("user_id") val userId: Int? = null,
    val text: String? = null,
    val sizes: List<PhotoSizeModel>? = null,
    val width: Int? = null,
    val height: Int? = null,
    // video model
    val description: String? = null,
    @SerializedName("image") val images: List<ImageModel>? = null,
    @SerializedName("first_frame") val firstFrame: List<ImageModel>? = null,
    @SerializedName("adding_date") val addingDate: Int,
    val views: Int? = null,
    @SerializedName("local_views") val localViews: Int? = null,
    val comments: Int? = null,
    @SerializedName("can_comment") val canComment: Int,
    @SerializedName("can_like") val canLike: Int? = null,
    val player: String? = null
) {

    fun getType(): MediaTypes =
        if (artist != null && title != null && url?.isNotEmpty() == true) {
            MediaTypes.TYPE_AUDIO
        } else if (sizes != null) {
            MediaTypes.TYPE_PHOTO
        } else if (duration != null && firstFrame != null && player?.isNotEmpty() == true) {
            MediaTypes.TYPE_VIDEO
        } else {
            MediaTypes.TYPE_UNKNOWN
        }
}