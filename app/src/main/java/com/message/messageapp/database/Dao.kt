package com.message.messageapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.message.messageapp.models.ContactsModal

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContactNumber(contactsModal: ContactsModal)

    @Query("SELECT * FROM contact_data")
    suspend fun getAllContactNumber(): List<ContactsModal>

    @Query("SELECT * FROM contact_data WHERE contactNumber = :contactNumber")
    fun isDataExist(contactNumber: String): Boolean

}