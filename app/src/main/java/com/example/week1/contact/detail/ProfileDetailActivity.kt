package com.example.week1.contact.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.week1.R
import com.example.week1.contact.ProfileData
import kotlinx.android.synthetic.main.activity_profile_detail.*

class ProfileDetailActivity : AppCompatActivity() {
    lateinit var data: ProfileData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        data = intent.getSerializableExtra("data") as ProfileData

        Glide.with(this).load(data.img).into(img_profile)
        tv_name.text = data.name
    }
}