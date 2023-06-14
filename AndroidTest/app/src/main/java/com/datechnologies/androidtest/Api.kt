package com.datechnologies.androidtest

import com.datechnologies.androidtest.api.ChatData
import com.datechnologies.androidtest.api.LogIn
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface Api {

    //urls
    @POST("chat_log.php")
    fun getDataFromURL(): Call<ChatData>?

    @FormUrlEncoded
    @POST("login.php")
    fun getLoginJSON(@Field("email") email: String?, @Field("password") password: String?): Call<LogIn>?

}