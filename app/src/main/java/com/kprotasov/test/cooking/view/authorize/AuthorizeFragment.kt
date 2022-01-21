package com.kprotasov.test.cooking.view.authorize

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kprotasov.test.cooking.R
import com.kprotasov.test.cooking.ui.mvvm.MvvmFragment
import com.kprotasov.test.cooking.ui.mvvm.delegates.viewModels
import com.kprotasov.test.presentation.viewmodel.AuthorizeViewModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope

class AuthorizeFragment : MvvmFragment() {

    companion object {
        fun newInstance(): Fragment = AuthorizeFragment()
    }

    override val contentLayout: Int = R.layout.authorize_fragment
    private val viewModel: AuthorizeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        VK.login(activity!!, arrayListOf(VKScope.WALL, VKScope.PHOTOS))
    }
}