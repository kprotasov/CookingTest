package com.kprotasov.test.cooking.view.image

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kprotasov.test.cooking.R
import com.kprotasov.test.cooking.ui.extensions.args
import com.kprotasov.test.cooking.ui.mvvm.MvvmFragment
import com.kprotasov.test.cooking.ui.mvvm.delegates.viewModels
import com.kprotasov.test.presentation.viewmodel.image.RecipeImageViewModel
import com.squareup.picasso.Picasso
import dagger.android.DispatchingAndroidInjector
import kotlinx.android.synthetic.main.image_fragment.*
import javax.inject.Inject

private const val IMAGE_URL = "IMAGE_URL"
var Bundle.imageUrl: String
    get() = getString(IMAGE_URL) as String
    set(value) = putString(IMAGE_URL, value)

class RecipeImageFragment : MvvmFragment(), View.OnClickListener {

    companion object {
        fun newInstance(imageUrl: String): Fragment = RecipeImageFragment().args {
            this.imageUrl = imageUrl
        }
    }

    override val contentLayout: Int = R.layout.image_fragment
    private val viewModel: RecipeImageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        downloadButton.setOnClickListener(this)
        Picasso.get()
            .load(args.imageUrl)
            .placeholder(R.drawable.image_placeholder)
            .into(imageView)
    }

    override fun onClick(v: View) {
        viewModel.downloadImage(args.imageUrl)
    }

}