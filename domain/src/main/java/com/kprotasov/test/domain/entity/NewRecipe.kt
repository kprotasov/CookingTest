package com.kprotasov.test.domain.entity

import com.kprotasov.test.domain.entity.media.BaseMedia

data class NewRecipe(
    val id: Int,
    val ownerId: Int? = null,
    val fromId: Int? = null,
    val createdBy: Int? = null,
    val date: Int? = null,
    val text: String? = null,
    val replyOwnerId: Int? = null,
    val replyPostId: Int? = null,
    val friendsOnly: Boolean = false,
    val comments: Comments? = null,
    val copyright: Copyright? = null,
    val likes: Likes? = null,
    val reposts: Reposts? = null,
    val views: Views? = null,
    val postType: String? = null,
    val attachments: List<BaseMedia>? = null,
    val makeAsAds: Int? = null,
    val isDonut: Boolean = false
)