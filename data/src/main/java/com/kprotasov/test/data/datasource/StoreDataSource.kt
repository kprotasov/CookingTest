package com.kprotasov.test.data.datasource

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import javax.inject.Inject

class StoreDataSource @Inject constructor(
    private val context: Context
) {

    fun downloadFromUrl(urlLink: String, downloadingTitle: String) {
        val downloadDirectory = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
        downloadDirectory?.mkdir()

        val uri = Uri.parse(urlLink)
        val request = DownloadManager.Request(uri)

        request.setAllowedNetworkTypes(
            DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI
        )
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setTitle(downloadingTitle)
        request.setDestinationInExternalPublicDir(
            Environment.DIRECTORY_DOWNLOADS,
            uri.getLastPathSegment()
        )

        (context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager).enqueue(request)
    }

}