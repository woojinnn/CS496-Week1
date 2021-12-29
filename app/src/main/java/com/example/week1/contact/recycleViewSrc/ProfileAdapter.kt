package com.example.week1.contact.recycleViewSrc

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week1.R
import com.example.week1.contact.ProfileData
import com.example.week1.contact.detail.ProfileDetailActivity

class ProfileAdapter(private val context: Context): RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {
    var data = mutableListOf<ProfileData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtName: TextView = itemView.findViewById(R.id.tv_rv_name)
        private val txtNumber: TextView = itemView.findViewById(R.id.tv_rv_number)
        private val imgProfile: ImageView = itemView.findViewById(R.id.img_rv_photo)

        fun bind(item: ProfileData) {
            txtName.text = item.name
            txtNumber.text = item.number
            Glide.with(itemView).load(item.img).into(imgProfile)

            itemView.setOnClickListener {
                Intent(context, ProfileDetailActivity::class.java).apply {
                    putExtra("data", item)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }
        }
    }

}