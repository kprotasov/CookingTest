package com.kprotasov.test.cooking.view.image

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.fragment.app.Fragment
import com.kprotasov.test.cooking.R
import com.kprotasov.test.cooking.ui.extensions.args
import com.kprotasov.test.cooking.ui.fragment.BaseFragment
import com.squareup.picasso.Picasso
import dagger.android.DispatchingAndroidInjector
import kotlinx.android.synthetic.main.image_fragment.*
import javax.inject.Inject

private const val IMAGE_URL = "IMAGE_URL"
var Bundle.imageUrl: String
    get() = getString(IMAGE_URL) as String
    set(value) = putString(IMAGE_URL, value)

class ImageFragment : BaseFragment(), View.OnClickListener {


    companion object {
        fun newInstance(imageUrl: String): Fragment = ImageFragment().args {
            this.imageUrl = imageUrl
        }
    }

    override val contentLayout: Int = R.layout.image_fragment

    @Inject
    override lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        downloadButton.setOnClickListener(this)
        Picasso.get()
            .load(args.imageUrl)
            .placeholder(R.drawable.image_placeholder)
            .into(imageView)
    }

    override fun onClick(v: View) {
        downloadImage(args.imageUrl)
    }

    private fun downloadImage(imageUrl: String) {
        val downloadDirectory = context?.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
        downloadDirectory?.mkdir()

        val uri = Uri.parse(imageUrl)
        val request = DownloadManager.Request(uri)

        request.setAllowedNetworkTypes(
            DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI
        )
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setTitle("Downloading recipe image")
        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            uri.getLastPathSegment()
        )

        (context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager).enqueue(request)
    }

}