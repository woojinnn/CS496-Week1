package com.example.week1.contact.main

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week1.R
import com.example.week1.contact.db.ContactDatabase
import com.example.week1.contact.db.ProfileData
import com.example.week1.contact.recyclerViewSrc.OnDeleteListener
import com.example.week1.contact.recyclerViewSrc.ProfileAdapter
import kotlinx.android.synthetic.main.activity_contact.*

@SuppressLint("StaticFieldLeak")
class ContactActivity : AppCompatActivity(), OnDeleteListener {
    lateinit var db: ContactDatabase
    var contactList = listOf<ProfileData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        db = ContactDatabase.getInstance(this)!!

        btn_add_contact.setOnClickListener {
            val contact = ProfileData(id = null,
                                    name = et_add_contact.text.toString(),
                                    favorite = R.drawable.empty_star,
                                    img = R.drawable.ic_launcher_foreground,
                                    number = "010-1111-1111")
            et_add_contact.setText("")
            insertContact(contact)
        }

        getAllContacts()
    }

    fun insertContact(contact: ProfileData){
        // MainThread(UI thread) vs WorkerThread(Background Thread)
        val insertTask = object : AsyncTask<Unit,Unit,Unit>() {
            override fun doInBackground(vararg p0: Unit?) {
                db.contactDAO().insert(contact)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllContacts()
            }
        }
        insertTask.execute()
    }

    fun getAllContacts() {
        val getTask = object: AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg p0: Unit?) {
                contactList = db.contactDAO().getAll()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                setRecyclerView(contactList)
            }
        }

        getTask.execute()
    }

    fun deleteContact(contact: ProfileData) {
        val deleteTask = object: AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg p0: Unit?) {
                db.contactDAO().delete(contact)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllContacts()
            }
        }

        deleteTask.execute()
    }

    fun setRecyclerView(contactList: List<ProfileData>) {
        rv_profile.adapter = ProfileAdapter(this, contactList, this)
    }

    override fun onDeleteListener(contact: ProfileData) {
        deleteContact(contact)
    }
}