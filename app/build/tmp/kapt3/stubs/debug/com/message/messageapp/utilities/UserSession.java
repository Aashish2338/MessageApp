package com.message.messageapp.utilities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/message/messageapp/utilities/UserSession;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "KEY_MESSAGE", "", "KEY_NUMBERS", "PREF_NAME", "PRIVATE_MODE", "", "_context", "editor", "Landroid/content/SharedPreferences$Editor;", "pref", "Landroid/content/SharedPreferences;", "getMessage", "getMobileNumber", "getName", "setMessage", "", "message", "setMobileNumber", "mobileNumber", "setName", "name", "app_debug"})
public final class UserSession {
    private android.content.SharedPreferences pref;
    private android.content.SharedPreferences.Editor editor;
    private android.content.Context _context;
    private final int PRIVATE_MODE = 0;
    private final java.lang.String PREF_NAME = "Greenusys";
    private final java.lang.String KEY_NUMBERS = "numbers";
    private final java.lang.String KEY_MESSAGE = "message";
    
    public UserSession(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext) {
        super();
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setMobileNumber(@org.jetbrains.annotations.Nullable()
    java.lang.String mobileNumber) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMobileNumber() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
}