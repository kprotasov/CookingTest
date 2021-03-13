package com.kprotasov.test.cooking.di

import com.kprotasov.test.cooking.navigation.MainRouter
import com.kprotasov.test.presentation.navigation.Navigator
import com.kprotasov.test.presentation.navigation.Router
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface NavigationModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun providesMainRouter(): MainRouter = MainRouter()
    }

    @Binds
    @Singleton
    fun bindRouter(router: MainRouter): Router

    @Binds
    @Singleton
    fun bindNavigator(router: MainRouter): Navigator

}