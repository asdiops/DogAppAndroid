package com.example.randomimage.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {
    private var service: DogAPI? = null

    private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    fun initClient() {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        service = retrofit.create(DogAPI::class.java)
    }

    fun getDogImage() {
        service?.getRandomImage()?.enqueue(object : Callback<DogAnswer> {
            override fun onResponse(call: Call<DogAnswer>, response: Response<DogAnswer>) {
                Log.i("Запрос к серверу", "Ответ успешный ${response.body()}")
            }

            override fun onFailure(call: Call<DogAnswer>, t: Throwable) {
                Log.i("Запрос к серверу", "Ответа мы не получили}")
            }
        })

    }
}