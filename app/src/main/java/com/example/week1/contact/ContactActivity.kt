package com.example.week1.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week1.R
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {
    lateinit var profileAdapter: ProfileAdapter
    val data = mutableListOf<ProfileData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        initRecycler()
    }

    private fun initRecycler() {
        profileAdapter = ProfileAdapter(this)
        rv_profile.adapter = profileAdapter
        rv_profile.addItemDecoration(VerticalItemDecorator(20))
        rv_profile.addItemDecoration(HorizontalItemDecorator(10))

        data.apply {
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "mary", age = 24))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "jenny", age = 26))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "jhon", age = 27))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "ruby", age = 21))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "yuna", age = 23))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "mary", age = 24))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "jenny", age = 26))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "jhon", age = 27))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "ruby", age = 21))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "yuna", age = 23))


            profileAdapter.data = data
            profileAdapter.notifyDataSetChanged()
        }
    }
}