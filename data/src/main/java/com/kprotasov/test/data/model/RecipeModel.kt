package com.kprotasov.test.data.model

data class RecipeModel (
    val uuid: String,
    val name: String,
    val images: List<String>,
    val lastUpdated: Long,
    val description: String?,
    val instructions: String,
    val difficulty: Int
)