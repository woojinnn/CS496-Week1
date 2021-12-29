package com.example.week1.contact.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week1.R
import com.example.week1.contact.db.ProfileData
import kotlinx.android.synthetic.main.activity_profile_detail.*

class ProfileDetailActivity : AppCompatActivity() {
    lateinit var data: ProfileData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        data = intent.getSerializableExtra("data") as ProfileData

        tv_name.text = data.name
    }
}