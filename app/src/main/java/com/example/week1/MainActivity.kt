package com.example.week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week1.gallery.GalleryActivity
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_a.setOnClickListener{
            var intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)
        }
    }
}