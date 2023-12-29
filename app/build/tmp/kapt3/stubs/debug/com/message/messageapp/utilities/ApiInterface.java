package com.message.messageapp.utilities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'J\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/message/messageapp/utilities/ApiInterface;", "", "getSaveNumberData", "Lretrofit2/Call;", "Lcom/message/messageapp/models/NumberResponse;", "strId", "", "numberSaveData", "Lcom/message/messageapp/models/NumberSaveResponse;", "jsonObject", "Lcom/google/gson/JsonObject;", "app_debug"})
public abstract interface ApiInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "numbers")
    public abstract retrofit2.Call<com.message.messageapp.models.NumberSaveResponse> numberSaveData(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Body()
    com.google.gson.JsonObject jsonObject);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "numbers/{id}")
    public abstract retrofit2.Call<com.message.messageapp.models.NumberResponse> getSaveNumberData(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Path(value = "id")
    java.lang.String strId);
}