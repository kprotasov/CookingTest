package com.kprotasov.test.cooking.di

import com.kprotasov.test.cooking.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityModule::class,
        AppModule::class,
        AndroidSupportInjectionModule::class,
        RepositoriesModule::class,
        ConverterModule::class,
        AndroidInjectionModule::class,
        ApiModule::class,
        NavigationModule::class
    ]
)
interface AppComponent {

    fun inject(application: App)
}
