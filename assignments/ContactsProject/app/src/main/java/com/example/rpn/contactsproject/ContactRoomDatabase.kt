package com.example.rpn.contactsproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Room database for storing contact data.
@Database(entities = [(Contact::class)], version = 1)
abstract class ContactRoomDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao  // Provides access to ContactDao.

    companion object {
        private var INSTANCE: ContactRoomDatabase? = null  // Singleton instance.

        // Get the database instance.
        internal fun getDatabase(context: Context): ContactRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder<ContactRoomDatabase>(
                            context.applicationContext,
                            ContactRoomDatabase::class.java,
                            "contact_database"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
