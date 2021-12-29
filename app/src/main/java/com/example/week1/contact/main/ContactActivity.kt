package com.example.week1.contact.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week1.R
import com.example.week1.contact.ProfileData
import com.example.week1.contact.recycleViewSrc.HorizontalItemDecorator
import com.example.week1.contact.recycleViewSrc.ProfileAdapter
import com.example.week1.contact.recycleViewSrc.VerticalItemDecorator
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
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "mary", number = "010-1111-1111"))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "jenny", number = "010-1111-1111"))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "jhon", number = "010-1111-1111"))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "ruby", number = "010-1111-1111"))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "yuna", number = "010-1111-1111"))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "mary", number = "010-1111-1111"))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "jenny", number = "010-1111-1111"))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "jhon", number = "010-1111-1111"))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "ruby", number = "010-1111-1111"))
            add(ProfileData(img = R.drawable.ic_launcher_foreground, name = "yuna", number = "010-1111-1111"))


            profileAdapter.data = data
            profileAdapter.notifyDataSetChanged()
        }
    }
}