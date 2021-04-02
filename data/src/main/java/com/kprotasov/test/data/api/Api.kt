package com.kprotasov.test.newsreader.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class Api @Inject constructor() {

    private var logging = HttpLoggingInterceptor()
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(logging)

    init {
        logging.level = HttpLoggingInterceptor.Level.BODY
    }

    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())
        .baseUrl("https://test.kode-t.ru")
        .build()

    private val retrofitRecipesApi = retrofit.create(RecipesApi::class.java)

    fun getRecipesApi(): RecipesApi =
        retrofitRecipesApi

}