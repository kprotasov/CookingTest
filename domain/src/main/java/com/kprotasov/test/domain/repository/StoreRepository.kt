package com.kprotasov.test.domain.repository

interface StoreRepository {

    fun downloadFromUrl(urlLink: String, downloadingTitle: String)

}