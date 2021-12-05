package com.kprotasov.test.cooking

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.kprotasov.test.cooking.di.AppComponent
import com.kprotasov.test.cooking.di.DaggerAppComponent
import com.kprotasov.test.cooking.di.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    companion object {
        lateinit var appComponent: AppComponent
            private set

        private fun initInjector(application: App) {
            appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(application))
                .build()
            appComponent.inject(application)
        }
    }

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    //val navigatorHolder get() = cicerone.navigatorHolder

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> =
        AndroidInjector { activityInjector.maybeInject(it) }

    override fun onCreate() {
        super.onCreate()

        initInjector(this)
    }
}