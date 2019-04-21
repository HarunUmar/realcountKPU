package com.bungkus.shop.bungkus



import com.suaratech.pilpres.jagakpu.data.Response
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


public interface ApiInterface {

    @GET("count") abstract fun getApiKpu(): Call<Response>

}