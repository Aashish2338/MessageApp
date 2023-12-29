package com.message.messageapp.utilities

import com.google.gson.JsonObject
import com.message.messageapp.models.NumberResponse
import com.message.messageapp.models.NumberSaveResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

    @POST("numbers")
    fun numberSaveData(@Body jsonObject: JsonObject?): Call<NumberSaveResponse?>

    @GET("numbers/{id}")
    fun getSaveNumberData(@Path("id") strId: String?): Call<NumberResponse?>
}