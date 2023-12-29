package com.message.messageapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_data")
data class ContactsModal(
    @PrimaryKey
    @ColumnInfo(name = "userName") var userName: String,
    @ColumnInfo(name = "contactNumber") var contactNumber: String
)
