package com.kprotasov.test.cooking

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.kprotasov.test.presentation.navigation.GlobalRouter
import com.kprotasov.test.presentation.navigation.Screens
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.exceptions.VKAuthException
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var router: GlobalRouter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var screens: Screens

    private val navigator: Navigator = AppNavigator(this, R.id.container)

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> =
        androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        //router.newRootScreen(screens.authorizeScreen())
        router.newRootScreen(screens.recipesScreen())
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object: VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                // User passed authorization
                Log.v("AuthorizeFragment", "ma authorize $token")
                router.newRootScreen(screens.recipesScreen())
            }

            override fun onLoginFailed(authException: VKAuthException) {
                // User didn't pass authorization
                Log.v("AuthorizeFragment", "ma error ${authException.authError}")
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
            Log.v("AuthorizeFragment", "ma data is null")
        }
    }
}
