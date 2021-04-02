package com.kprotasov.test.data.repository

import com.kprotasov.test.data.datasource.StoreDataSource
import com.kprotasov.test.domain.repository.StoreRepository
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val storeDataSource: StoreDataSource
) : StoreRepository {

    override fun downloadFromUrl(urlLink: String, downloadingTitle: String) {
        storeDataSource.downloadFromUrl(urlLink, downloadingTitle)
    }

}