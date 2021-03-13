package com.kprotasov.test.cooking.service

import android.app.DownloadManager
import android.content.Intent
import android.app.IntentService
import android.content.Context
import android.net.Uri
import android.os.Environment

class DownloadService : IntentService("DownloadSongService") {

    companion object {

        private val DOWNLOAD_PATH =
            "com.kprotasov.test.cooking.androiddownloadmanager_DownloadService_Download_path"
        private val DESTINATION_PATH =
            "com.kprotasov.test.cooking.androiddownloadmanager_DownloadService_Destination_path"

        fun getDownloadService(context: Context, downloadPath: String): Intent {
            val downloadDirectory = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)
            downloadDirectory?.mkdir()

            return Intent(context, DownloadService::class.java)
                .putExtra(DOWNLOAD_PATH, downloadPath)
                .putExtra(DESTINATION_PATH, downloadDirectory)
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        val downloadPath = intent?.getStringExtra(DOWNLOAD_PATH)
        startDownload(downloadPath)
    }

    private fun startDownload(downloadPath: String?) {
        val uri = Uri.parse(downloadPath)
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

        (getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager).enqueue(request)
    }

}