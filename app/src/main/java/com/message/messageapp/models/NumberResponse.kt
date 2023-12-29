package com.message.messageapp.models

import com.google.gson.annotations.SerializedName

data class NumberResponse(
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("numbers") var numbers: ArrayList<String> = arrayListOf(),
    @SerializedName("__v") var _v: Int? = null
)
