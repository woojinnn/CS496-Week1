package com.example.week1.contact.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProfileData::class], version = 1)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDAO(): ContactDAO

    companion object {
        var INSTANCE: ContactDatabase? = null
        fun getInstance(context: Context) : ContactDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, ContactDatabase::class.java, "contact.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return INSTANCE
        }
    }
}