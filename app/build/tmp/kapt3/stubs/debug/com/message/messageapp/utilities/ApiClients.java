package com.message.messageapp.utilities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/message/messageapp/utilities/ApiClients;", "", "()V", "BASE_URL", "", "retrofit", "Lretrofit2/Retrofit;", "getClient", "app_debug"})
public final class ApiClients {
    @org.jetbrains.annotations.NotNull()
    public static final com.message.messageapp.utilities.ApiClients INSTANCE = null;
    private static final java.lang.String BASE_URL = "https://messageapp-vii7.onrender.com/";
    private static retrofit2.Retrofit retrofit;
    
    private ApiClients() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final retrofit2.Retrofit getClient() {
        return null;
    }
}