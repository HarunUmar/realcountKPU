package com.bungkus.shop.bungkus

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class ApiClient {


    //public static final String BASE_URL = "http://muslimsalat.com/";
    val BASE_URL = "https://kpu.nyandev.id/api/v1/"
    private var retrofit: Retrofit? = null


    val client: Retrofit
        get() {

            val client = OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS).build()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL).client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!
        }



}
