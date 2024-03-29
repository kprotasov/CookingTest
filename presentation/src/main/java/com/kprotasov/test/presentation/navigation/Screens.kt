package com.kprotasov.test.presentation.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen

interface Screens {

    fun authorizeScreen(): FragmentScreen

    fun recipesScreen(): FragmentScreen

    fun recipeDetailsScreen(recipeUuid: String): FragmentScreen

    fun recipeImageScreen(imageUrl: String): FragmentScreen
}