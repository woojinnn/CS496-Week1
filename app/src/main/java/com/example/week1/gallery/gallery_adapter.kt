package com.example.week1.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.R

class gallery_adapter(var context: Context) : RecyclerView.Adapter<gallery_adapter.ViewHolder>() {

    var dataList = emptyList<gallery_data>()

    internal fun setDataList(dataList: List<gallery_data>) {
        this.dataList = dataList
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView

        init {
            image = itemView.findViewById(R.id.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): gallery_adapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: gallery_adapter.ViewHolder, position: Int) {
        var data = dataList[position]
        holder.image.setImageResource(data.img)
    }

    override fun getItemCount() = dataList.size
}