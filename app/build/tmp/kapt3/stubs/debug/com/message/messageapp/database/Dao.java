package com.message.messageapp.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/message/messageapp/database/Dao;", "", "addContactNumber", "", "contactsModal", "Lcom/message/messageapp/models/ContactsModal;", "(Lcom/message/messageapp/models/ContactsModal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllContactNumber", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDataExist", "", "contactNumber", "", "app_debug"})
public abstract interface Dao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 5)
    public abstract java.lang.Object addContactNumber(@org.jetbrains.annotations.NotNull()
    com.message.messageapp.models.ContactsModal contactsModal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM contact_data")
    public abstract java.lang.Object getAllContactNumber(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.message.messageapp.models.ContactsModal>> continuation);
    
    @androidx.room.Query(value = "SELECT * FROM contact_data WHERE contactNumber = :contactNumber")
    public abstract boolean isDataExist(@org.jetbrains.annotations.NotNull()
    java.lang.String contactNumber);
}