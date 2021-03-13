package com.kprotasov.test.presentation.navigation

interface Router {

    fun moveTo(screen: String, data: Any? = null)

    fun popTo(screen: String)

}