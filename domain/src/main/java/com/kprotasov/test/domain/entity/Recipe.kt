package com.kprotasov.test.domain.entity

import java.io.Serializable
import java.util.*

data class Recipe(
    val uuid: String,
    val name: String,
    val images: List<String>,
    val lastUpdated: Date,
    val description: String,
    val instructions: String,
    val difficulty: Int
) : Serializable