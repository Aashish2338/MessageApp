package com.message.messageapp.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \'2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\'()B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001eH\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u0012\u0010&\u001a\u00020\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/message/messageapp/adapters/ContactListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/message/messageapp/adapters/ContactListAdapter$ContactListViewHolder;", "mContext", "Landroid/content/Context;", "data", "", "Lcom/message/messageapp/models/ContactsModal;", "onClickInterface", "Lcom/message/messageapp/activities/ContactListActivity;", "(Landroid/content/Context;Ljava/util/List;Lcom/message/messageapp/activities/ContactListActivity;)V", "filteredList", "Ljava/util/ArrayList;", "getOnClickInterface", "()Lcom/message/messageapp/activities/ContactListActivity;", "setOnClickInterface", "(Lcom/message/messageapp/activities/ContactListActivity;)V", "selected", "", "selectedItems", "Landroid/util/SparseBooleanArray;", "userSession", "Lcom/message/messageapp/utilities/UserSession;", "apiJsonSign", "Lcom/google/gson/JsonObject;", "jsonArray", "filterList", "", "filterer", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "saveSelectedNumber", "Companion", "ContactListViewHolder", "OnClickInterface", "app_debug"})
public final class ContactListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.message.messageapp.adapters.ContactListAdapter.ContactListViewHolder> {
    private java.util.List<com.message.messageapp.models.ContactsModal> data;
    @org.jetbrains.annotations.NotNull()
    private com.message.messageapp.activities.ContactListActivity onClickInterface;
    private com.message.messageapp.utilities.UserSession userSession;
    private java.util.ArrayList<java.lang.String> selected;
    private java.util.ArrayList<com.message.messageapp.models.ContactsModal> filteredList;
    private android.util.SparseBooleanArray selectedItems;
    @org.jetbrains.annotations.NotNull()
    public static final com.message.messageapp.adapters.ContactListAdapter.Companion Companion = null;
    @org.jetbrains.annotations.Nullable()
    private static com.message.messageapp.adapters.ContactListAdapter.OnClickInterface onClickCheckButton;
    
    public ContactListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    java.util.List<com.message.messageapp.models.ContactsModal> data, @org.jetbrains.annotations.NotNull()
    com.message.messageapp.activities.ContactListActivity onClickInterface) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.message.messageapp.activities.ContactListActivity getOnClickInterface() {
        return null;
    }
    
    public final void setOnClickInterface(@org.jetbrains.annotations.NotNull()
    com.message.messageapp.activities.ContactListActivity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.message.messageapp.adapters.ContactListAdapter.ContactListViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.message.messageapp.adapters.ContactListAdapter.ContactListViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void filterList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.message.messageapp.models.ContactsModal> filterer) {
    }
    
    private final void saveSelectedNumber(com.google.gson.JsonObject apiJsonSign) {
    }
    
    private final com.google.gson.JsonObject apiJsonSign(java.lang.String jsonArray) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/message/messageapp/adapters/ContactListAdapter$ContactListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ItemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkNumber", "Landroidx/appcompat/widget/AppCompatCheckBox;", "getCheckNumber", "()Landroidx/appcompat/widget/AppCompatCheckBox;", "conImage", "Landroid/widget/ImageView;", "getConImage", "()Landroid/widget/ImageView;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "number", "getNumber", "showDetails", "Landroid/widget/LinearLayout;", "getShowDetails", "()Landroid/widget/LinearLayout;", "app_debug"})
    public static final class ContactListViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView conImage = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView name = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView number = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.appcompat.widget.AppCompatCheckBox checkNumber = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout showDetails = null;
        
        public ContactListViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View ItemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getConImage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatCheckBox getCheckNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getShowDetails() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/message/messageapp/adapters/ContactListAdapter$OnClickInterface;", "", "onClickCreateMessage", "", "position", "", "app_debug"})
    public static abstract interface OnClickInterface {
        
        public abstract void onClickCreateMessage(int position);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/message/messageapp/adapters/ContactListAdapter$Companion;", "", "()V", "onClickCheckButton", "Lcom/message/messageapp/adapters/ContactListAdapter$OnClickInterface;", "getOnClickCheckButton", "()Lcom/message/messageapp/adapters/ContactListAdapter$OnClickInterface;", "setOnClickCheckButton", "(Lcom/message/messageapp/adapters/ContactListAdapter$OnClickInterface;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.message.messageapp.adapters.ContactListAdapter.OnClickInterface getOnClickCheckButton() {
            return null;
        }
        
        public final void setOnClickCheckButton(@org.jetbrains.annotations.Nullable()
        com.message.messageapp.adapters.ContactListAdapter.OnClickInterface p0) {
        }
    }
}