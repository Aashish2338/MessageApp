package com.message.messageapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.message.messageapp.models.ContactsModal

@Database(entities = [ContactsModal::class], version = 1, exportSchema = true)
abstract class ContactNumberDatabase : RoomDatabase() {

    abstract fun repoDao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: ContactNumberDatabase? = null
        fun getDatabase(context: Context): ContactNumberDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): ContactNumberDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ContactNumberDatabase::class.java,
                "contact_data"
            ).build()
        }
    }
}