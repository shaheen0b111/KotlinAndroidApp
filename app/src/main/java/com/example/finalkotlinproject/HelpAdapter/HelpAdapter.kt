package com.example.finalkotlinproject.HelpAdapter

import android.content.Context
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.finalkotlinproject.Model.HelpNumbers
import com.example.finalkotlinproject.R
import kotlinx.android.synthetic.main.helpnumber_layout.view.*
import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.example.finalkotlinproject.ExploreHelp as HelpActivity


class HelpAdapter(val context: Context, private val helpnumbers:ArrayList<HelpNumbers>,val requestCall: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),ActivityCompat.OnRequestPermissionsResultCallback {
    private var hParent : ViewGroup? = null
    private var mContext : Context = context
    private var callNumber : String? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        hParent = parent

        val singleItem = parent.inflate(R.layout.helpnumber_layout)
        return HelpViewHolder(singleItem)
    }
    fun ViewGroup.inflate(layoutR: Int) : View = LayoutInflater.from(context).inflate(layoutR,this,false)
    override fun getItemCount(): Int = helpnumbers.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.help_name.text = helpnumbers[position].hName
        holder.itemView.help_number.text = helpnumbers[position].hNumber
        holder.itemView.help_number.setOnClickListener{
            callNumber = holder.itemView.help_number.text.toString()
            if(ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(mContext as Activity, arrayOf(Manifest.permission.CALL_PHONE),requestCall)
            }
            else makeCall()
        }

    }
    @SuppressLint("MissingPermission")
    private fun makeCall(){
        val callIn = Intent(Intent.ACTION_CALL)
        callIn.data = Uri.parse("tel:" + callNumber)
        mContext.startActivity(callIn)
    }


    class HelpViewHolder(val vi : View?) : RecyclerView.ViewHolder(vi!!), View.OnClickListener {
        override fun onClick(v: View?) {
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == requestCall) makeCall()
    }
}