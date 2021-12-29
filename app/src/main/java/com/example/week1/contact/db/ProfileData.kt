package com.example.week1.contact.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.week1.R
import java.io.Serializable

@Entity(tableName = "contact")
data class ProfileData(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    var name: String,
    var favorite: Int = R.drawable.empty_star,
    var img: Int? = null,
    var number: String,
    var instagram: String? = null
): Serializable
