package com.example.e_learniverse_android.kotlin_code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_learniverse_android.R
import com.example.e_learniverse_android.kotlin_code.kotlin_adapter.RecyclerContactAdapter
import com.example.e_learniverse_android.kotlin_code.model.ContactModel
import kotlinx.android.synthetic.main.activity_kotlin_recycler_view.myRecyclerviewId

class KotlinRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_recycler_view)

        val arrContact = ArrayList<ContactModel>()

        // in Kotlin there is No Need for "new" keyword to create object
        arrContact.add(ContactModel(R.drawable.sergio_ramos, "Sergio Ramos", 4))
        arrContact.add(ContactModel(R.drawable.sergio_ramos, "Lionel Messi", 10))
        arrContact.add(ContactModel(R.drawable.sergio_ramos, "Cristiano Ronaldo", 7))

        myRecyclerviewId.layoutManager = LinearLayoutManager(this)

        val myRecyclerContactAdapter = RecyclerContactAdapter(this, arrContact)

        myRecyclerviewId.adapter = myRecyclerContactAdapter
    }
}