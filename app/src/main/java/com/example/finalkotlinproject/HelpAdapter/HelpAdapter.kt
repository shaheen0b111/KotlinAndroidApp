package com.example.finalkotlinproject.HelpAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalkotlinproject.Model.HelpNumbers
import com.example.finalkotlinproject.R
import kotlinx.android.synthetic.main.helpnumber_layout.view.*

class HelpAdapter(val context: Context, private val helpnumbers:ArrayList<HelpNumbers>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val singleItem = parent.inflate(R.layout.helpnumber_layout)
        return HelpViewHolder(singleItem)
    }
    fun ViewGroup.inflate(layoutR: Int) : View = LayoutInflater.from(context).inflate(layoutR,this,false)
    override fun getItemCount(): Int = helpnumbers.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.help_name.text = helpnumbers[position].hName
        holder.itemView.help_number.text = helpnumbers[position].hNumber

    }
    class HelpViewHolder(val vi : View?) : RecyclerView.ViewHolder(vi!!), View.OnClickListener {
        override fun onClick(v: View?) {
        }
    }
}