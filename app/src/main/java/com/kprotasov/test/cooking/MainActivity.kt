package com.kprotasov.test.cooking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kprotasov.test.presentation.navigation.Navigator
import com.kprotasov.test.presentation.navigation.RECIPES_SCREEN
import com.kprotasov.test.presentation.navigation.Router
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> =
        androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navigator.setContainer(R.id.container)
    }

    override fun onStart() {
        super.onStart()
        navigator.attach(supportFragmentManager)
        router.moveTo(RECIPES_SCREEN)
    }

    override fun onStop() {
        navigator.detach()
        super.onStop()
    }

}
