package br.com.cwi.hearthstonecards.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitConfig {

    private val hearthstoneHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val request = it.request().newBuilder()
                .addHeader("X-RapidAPI-key", "46a6c9a772msh6c43af9d0d79d99p1adb1cjsn3c818b2de751")
                .addHeader("X-RapidAPI-Host", "omgvamp-hearthstone-v1.p.rapidapi.com")
            it.proceed(request.build())
        }
        .build()

    val hearthstoneService: HearthstoneApi = Retrofit.Builder()
        .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
        .client(hearthstoneHttpClient)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()
        .create(HearthstoneApi::class.java)
}