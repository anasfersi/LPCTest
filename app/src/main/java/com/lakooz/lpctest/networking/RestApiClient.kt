package com.lakooz.lpctest.networking

import com.google.gson.GsonBuilder
import com.lakooz.lpctest.model.Pot
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestApiClient {

    private const val BASE_URL = "https://recrutement.lepotcommuntest.fr/2019/recruiting/"
    private val instance = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder()
                    .setDateFormat("dd-MM-yyyy  HH:mm:ss")
                    .create()
            )
        )
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(OkHttpClient())
        .build()
        .create(IRestApiClient::class.java)

    fun getPots(): Single<List<Pot>> {

        return instance.getPots()
    }

    fun createPot(category: Int): Single<Pot> {
        return instance.createPot(category)
    }



}