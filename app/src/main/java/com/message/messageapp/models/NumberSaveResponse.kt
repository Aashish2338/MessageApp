package com.message.messageapp.models

import com.google.gson.annotations.SerializedName

data class NumberSaveResponse(
    @SerializedName("numbers") var numbers: ArrayList<String> = arrayListOf(),
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("__v") var _v: Int? = null
)
