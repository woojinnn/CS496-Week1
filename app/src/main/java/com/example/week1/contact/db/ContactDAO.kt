package com.example.week1.contact.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ContactDAO {
    @Insert(onConflict = REPLACE)
    fun insert(contact: ProfileData)

    @Query("SELECT * FROM contact")
    fun getAll(): List<ProfileData>

    @Delete
    fun delete(contact: ProfileData)
}