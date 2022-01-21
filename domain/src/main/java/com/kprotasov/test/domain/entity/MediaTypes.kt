package com.kprotasov.test.domain.entity

enum class MediaTypes(val type: String) {
    TYPE_PHOTO("photo"),
    TYPE_VIDEO("video"),
    TYPE_AUDIO("audio"),
    TYPE_UNKNOWN("unknown")
}