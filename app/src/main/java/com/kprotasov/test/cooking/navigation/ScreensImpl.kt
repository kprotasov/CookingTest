package com.kprotasov.test.cooking.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kprotasov.test.cooking.view.authorize.AuthorizeFragment
import com.kprotasov.test.cooking.view.details.RecipeDetailsFragment
import com.kprotasov.test.cooking.view.image.RecipeImageFragment
import com.kprotasov.test.cooking.view.recipes.RecipesFragment
import com.kprotasov.test.presentation.navigation.Screens

class ScreensImpl : Screens {

    override fun authorizeScreen() = FragmentScreen {
        AuthorizeFragment.newInstance()
    }

    override fun recipesScreen() = FragmentScreen {
        RecipesFragment.newInstance()
    }

    override fun recipeDetailsScreen(recipeUuid: String) = FragmentScreen {
        RecipeDetailsFragment.newInstance(recipeUuid)
    }

    override fun recipeImageScreen(imageUrl: String) = FragmentScreen {
        RecipeImageFragment.newInstance(imageUrl)
    }
}