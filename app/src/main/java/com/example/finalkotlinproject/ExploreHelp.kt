package com.example.finalkotlinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalkotlinproject.HelpAdapter.HelpAdapter
import com.example.finalkotlinproject.Model.HelpNumbers
import kotlinx.android.synthetic.main.help_main.*

class ExploreHelp : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.help_main)
        val linearLayoutManager = LinearLayoutManager(this)
        help_recyclerview_main.layoutManager = linearLayoutManager

        val numberList = NumberList()
        help_recyclerview_main.adapter = HelpAdapter(this,numberList)
    }
    fun NumberList() : ArrayList<HelpNumbers> {
        val n = ArrayList<HelpNumbers>()
        n.add(HelpNumbers("Arunachal Pradesh","9436055743"))
        n.add(HelpNumbers("Assam","6913347770"))
        n.add(HelpNumbers("Gujarat","104"))
        n.add(HelpNumbers("Maharashtra","020-26127394"))
        n.add(HelpNumbers("Rajasthan","0141-2225624"))
        n.add(HelpNumbers("Uttar Pradesh","18001805145"))
        n.add(HelpNumbers("Chandigarh","9779558282"))
        n.add(HelpNumbers("Delhi","011-22307145"))
        n.add(HelpNumbers("Jammu","01912520982"))
        n.add(HelpNumbers("Haryana","8558893911"))
        n.add(HelpNumbers("Himachal Pradesh","104"))
        n.add(HelpNumbers("Jharkhand","104"))
        n.add(HelpNumbers("Karnataka"," 080-46848600"))
        n.add(HelpNumbers("Meghalaya","108"))
        n.add(HelpNumbers("Nagaland","7005539653"))
        n.add(HelpNumbers("Odisha","9439994859"))
        n.add(HelpNumbers("Sikkim","104"))
        n.add(HelpNumbers("Tamil Nadu","044-29510500"))
        n.add(HelpNumbers("Tripura","0381-2315879"))
        n.add(HelpNumbers("Goa","104"))
        n.add(HelpNumbers("Andhra Pradesh","0866-2410978"))
        n.add(HelpNumbers("Telangana","104"))
        n.add(HelpNumbers("West Bengal","3323412600"))
        n.add(HelpNumbers("Ladakh","01982256462"))
        n.add(HelpNumbers("Lakshadweep","104"))
        n.add(HelpNumbers("Puducherry","104"))
        n.add(HelpNumbers("Madhya Pradesh","0755-2527177"))
        return n
    }
}