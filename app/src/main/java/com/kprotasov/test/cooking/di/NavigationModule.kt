package com.kprotasov.test.cooking.di

import com.github.terrakok.cicerone.Cicerone
import com.kprotasov.test.cooking.navigation.ScreensImpl
import com.kprotasov.test.presentation.navigation.GlobalRouter
import com.kprotasov.test.presentation.navigation.Screens
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    private val cicerone: Cicerone<GlobalRouter> = Cicerone.create(GlobalRouter())

    @Provides
    @Singleton
    fun provideGlobalRouter(): GlobalRouter = cicerone.router

    @Provides
    @Singleton
    fun provideGlobalNavigatorHolder() = cicerone.getNavigatorHolder()

    @Provides
    @Singleton
    fun provideNewScreens(): Screens = ScreensImpl()
}

