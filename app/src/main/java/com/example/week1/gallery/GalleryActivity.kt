package com.example.week1.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week1.R
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_gallery.*
import kotlinx.android.synthetic.main.activity_main.*

class GalleryActivity : AppCompatActivity() {

    private lateinit var  galleryAdapter: gallery_adapter
    private var dataList = mutableListOf<gallery_data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)


//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        recyclerView.layoutManager = layoutManager
//
//        val adapter = HobbyAdapter(this, Supplier.hobbies)
//        recyclerView.adapter = adapter

        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        galleryAdapter = gallery_adapter(applicationContext)
        recyclerView.adapter = galleryAdapter

        dataList.add(gallery_data(R.drawable.cat1))
        dataList.add(gallery_data(R.drawable.cat2))
        dataList.add(gallery_data(R.drawable.cat3))
        dataList.add(gallery_data(R.drawable.cat4))

        galleryAdapter.setDataList(dataList)


    }
}