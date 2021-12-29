package com.example.week1.contact.recyclerViewSrc

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.R
import com.example.week1.contact.db.ProfileData
import com.example.week1.contact.detail.ProfileDetailActivity

class ProfileAdapter(val context: Context,
                     var list: List<ProfileData>, var onDeleteListener: OnDeleteListener): RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {
    interface OnItemClickListener{
        fun onItemClick(v:View, data: ProfileData, pos : Int)
    }

    private var listener : OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = list[position]
        holder.bind(contact)
        holder.root.setOnLongClickListener(object: View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                onDeleteListener.onDeleteListener(contact)
                return true
            }
        })
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root: ConstraintLayout = itemView.findViewById(R.id.root)
        val txtName: TextView = itemView.findViewById(R.id.tv_rv_name)
        val imgProfile: ImageView = itemView.findViewById(R.id.img_rv_photo)

        fun bind(item: ProfileData) {
            txtName.text = item.name

            itemView.setOnClickListener {
                Intent(context, ProfileDetailActivity::class.java).apply {
                    putExtra("data", item)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }

            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView, item, pos)
                }
            }
        }


    }
}