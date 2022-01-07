package com.kprotasov.test.data.model.media

import com.google.gson.annotations.SerializedName

open class BaseMediaModel(
    // audio model
    val id: Int,
    @SerializedName("owner_id") val ownerId: Int,
    val artist: String? = null,
    val title: String? = null,
    val duration: Int,
    val url: String,
    val date: Int
    open val type: String,
)