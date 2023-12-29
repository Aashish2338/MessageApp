package com.message.messageapp.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0015J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"2\u0006\u0010#\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/message/messageapp/activities/CreateMessageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "allNumbers", "", "mContext", "Landroid/content/Context;", "mobileNumber_Tv", "Landroid/widget/TextView;", "numbers", "", "[Ljava/lang/String;", "sendMsgBtn", "Landroidx/appcompat/widget/AppCompatButton;", "separator", "strMessage", "strMobileNumber", "strName", "userSession", "Lcom/message/messageapp/utilities/UserSession;", "writeMsg_Et", "Landroid/widget/EditText;", "getLayoutUiIdFind", "", "getSavedNumbers", "idNumber", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseJsonArray", "", "jsonArrayString", "app_debug"})
public final class CreateMessageActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    private android.content.Context mContext;
    private com.message.messageapp.utilities.UserSession userSession;
    private java.lang.String strName = "";
    private java.lang.String strMobileNumber = "";
    private java.lang.String strMessage = "";
    private android.widget.TextView mobileNumber_Tv;
    private android.widget.EditText writeMsg_Et;
    private androidx.appcompat.widget.AppCompatButton sendMsgBtn;
    private java.lang.String separator = "; ";
    private java.lang.String allNumbers = "";
    private java.lang.String[] numbers = {};
    
    public CreateMessageActivity() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getSavedNumbers(java.lang.String idNumber) {
    }
    
    private final java.util.List<java.lang.String> parseJsonArray(java.lang.String jsonArrayString) {
        return null;
    }
    
    private final void getLayoutUiIdFind() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
}