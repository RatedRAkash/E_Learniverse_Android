package com.example.e_learniverse_android.kotlin_code.kotlin_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_learniverse_android.R
import com.example.e_learniverse_android.kotlin_code.model.ContactModel
import kotlinx.android.synthetic.main.row_item.view.authorIDTextView
import kotlinx.android.synthetic.main.row_item.view.imageId
import kotlinx.android.synthetic.main.row_item.view.rowCountAgeTextView
import kotlinx.android.synthetic.main.row_item.view.textViewName


// here we are using "()"... because in kotlin "Constructor" is Invoked in during "Class Declaration"
class RecyclerContactAdapter(val context: Context, val arrContact: ArrayList<ContactModel>): RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgContact = itemView.imageId
        val txtName = itemView.textViewName
        val txtNumber = itemView.rowCountAgeTextView
        val txtAuthorId = itemView.authorIDTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item, parent,false))
    }

    override fun getItemCount(): Int {
        return arrContact.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgContact.setImageResource(arrContact[position].img)
        holder.txtName.text = arrContact[position].name
        holder.txtNumber.text = arrContact[position].number.toString()
        holder.txtAuthorId.visibility = View.GONE
    }
}