package com.kprotasov.test.presentation.viewmodel

import com.kprotasov.test.presentation.BaseViewModel
import com.kprotasov.test.presentation.navigation.GlobalRouter
import com.kprotasov.test.presentation.navigation.Screens
import javax.inject.Inject

class AuthorizeViewModel @Inject constructor(
    private val router: GlobalRouter,
    private val screens: Screens
) : BaseViewModel() {

    fun openRecipesScreen() {
        router.navigateTo(screens.recipesScreen())
    }
}