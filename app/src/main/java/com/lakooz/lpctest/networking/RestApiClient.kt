package com.lakooz.lpctest.networking

import com.google.gson.GsonBuilder
import com.lakooz.lpctest.model.Pot
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RestApiClient {

    private const val BASE_URL = "https://recrutement.lepotcommuntest.fr/2019/recruiting/"


    object Instance {
        operator fun invoke(): IRestApiClient {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            return  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build())
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
        }
    }

    fun getPots(): Single<List<Pot>> {
        return Instance.invoke().getPots()
    }

    fun createPot(category: Int): Single<Pot> {
        return Instance.invoke().createPot(category)
    }


}