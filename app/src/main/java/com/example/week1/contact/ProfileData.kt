package com.example.week1.contact

import java.io.Serializable

data class ProfileData(
    val img: Int,
    val name: String,
    val number: String,
    val instagram: String = "No Instagram"
): Serializable
