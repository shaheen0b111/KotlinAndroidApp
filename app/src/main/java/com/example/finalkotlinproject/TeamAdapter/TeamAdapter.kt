package com.example.finalkotlinproject.TeamAdapter

import android.content.Context
import android.graphics.Color
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.finalkotlinproject.Model.CustomTeams
import com.example.finalkotlinproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_team_explore.view.*
import kotlinx.android.synthetic.main.popup_main.view.*
import kotlinx.android.synthetic.main.team_layout.view.*

class TeamAdapter(val context:Context,private val teams:ArrayList<CustomTeams>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var mParent : ViewGroup? = null
    // return the single item view of the list in the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //create layout inflator which inflate the layout of team_layout.xml using R class
//        val li = LayoutInflater.from(parent.context)
//        val singleItem = li.inflate(R.layout.team_layout,parent,false)
        mParent = parent
        val singleItem = parent.inflate(R.layout.team_layout)
        return CustomViewHolder(singleItem)

    }
    //extension function , giving ViewGroup inflating ability
    //here class: ViewGroup , inflate is extention function
    fun ViewGroup.inflate(layoutR: Int) : View = LayoutInflater.from(context).inflate(layoutR,this,false)

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //binding view and data in teams array
        Picasso.get().load(teams[position].team_url).into(holder.itemView.teamImage)
        //Animation
        holder.itemView.teamImage.resume()
        holder.itemView.teamName.text = teams[position].team_name
        holder.itemView.description1.text = teams[position].description1
        holder.itemView.description2.text = teams[position].description2
        holder.itemView.description3.text = teams[position].description3
        holder.itemView.title_button.setOnClickListener{
            showPopUp(context,mParent,holder)
        }
    }
    public fun showPopUp(context: Context, sParent : ViewGroup?, h : RecyclerView.ViewHolder) {
        val popupItem = LayoutInflater.from(context).inflate(R.layout.popup_main,sParent,false)
        val popupWindow = PopupWindow(popupItem,LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        popupItem.closeButton.setOnClickListener{popupWindow.dismiss()}
        //PopUp the Window
        val totalCase  = h.itemView.description1.text.toString().filter { it.isDigit() }
        var name = h.itemView.teamName.text.toString()
        if (totalCase.toInt() > 20000) {
            name = "$name : CRITICAL STATE"
            popupItem.statusText.text =  name
            popupItem.statusText.setTextColor(Color.RED)
        }
        else{
            name = "$name : NOT CRITICAL STATE"
            popupItem.statusText.text =  name
            popupItem.statusText.setTextColor(Color.BLUE)
        }
        TransitionManager.beginDelayedTransition(sParent)
        popupWindow.showAtLocation(sParent,Gravity.CENTER,0,0)
    }
    class CustomViewHolder(val vi : View?) : RecyclerView.ViewHolder(vi!!), View.OnClickListener {
        // View cannot be null
        override fun onClick(vi: View?) {
        }
        init {
            itemView.setOnClickListener(this)
        }
    }

}

