package com.kprotasov.test.cooking.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.kprotasov.test.cooking.view.image.RecipeImageFragment
import com.kprotasov.test.cooking.view.details.RecipeDetailsFragment
import com.kprotasov.test.cooking.view.recipes.RecipesFragment
import com.kprotasov.test.presentation.navigation.*
import javax.inject.Inject

class MainRouter @Inject constructor() : Router, Navigator {

    @IdRes
    private var containerId: Int = 0
    private var isFirstFragment = true
    private var fragmentManager: FragmentManager? = null

    override fun setContainer(@IdRes containerId: Int) {
        this.containerId = containerId
    }

    override fun attach(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager
    }

    override fun detach() {
        fragmentManager = null
    }

    override fun moveTo(screen: String, data: Any?) {
        fragmentManager
            ?.takeIf { it.fragmentNotExist(screen) }
            ?.let { moveToScreen(screen, data, it) }
    }

    private fun moveToScreen(screen: String, data: Any?, fragmentManager: FragmentManager) {
        val fragment = getFragment(screen, data)

        fragmentManager.beginTransaction()
            .injectFragment(fragment, screen)
            .commit()
    }

    private fun FragmentManager.fragmentNotExist(fragmentTag: String): Boolean =
        findFragmentByTag(fragmentTag) == null

    private fun getFragment(screen: String, data: Any?): Fragment =
        when (screen) {
            RECIPES_SCREEN -> RecipesFragment.newInstance()
            RECIPE_DETAILS_SCREEN -> RecipeDetailsFragment.newInstance(data as String)
            IMAGE_SCREEN -> RecipeImageFragment.newInstance(data as String)
            else -> throw Throwable("Attempt to move to non-existent screen - ($screen)")
        }

    private fun FragmentTransaction.injectFragment(
        fragment: Fragment,
        fragmentTag: String
    ): FragmentTransaction =
        if (isFirstFragment) {
            isFirstFragment = false
            add(containerId, fragment, fragmentTag)
        } else {
            replace(containerId, fragment, fragmentTag)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            addToBackStack(fragmentTag)
        }

    override fun popTo(screen: String) {
        fragmentManager?.let { popToScreen(screen, it) }
    }

    private fun popToScreen(screen: String, fragmentManager: FragmentManager) {
        while (getCurrentScreen(fragmentManager) != screen) {
            fragmentManager.popBackStackImmediate()
        }
    }

    private fun getCurrentScreen(fragmentManager: FragmentManager): String? =
        fragmentManager.getBackStackEntryAt(fragmentManager.backStackEntryCount - 1).name

}