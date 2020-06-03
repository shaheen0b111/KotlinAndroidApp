package com.example.finalkotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.finalkotlinproject.CustomZoom.ZoomCenter
import com.example.finalkotlinproject.Model.CustomTeams
import com.example.finalkotlinproject.TeamAdapter.TeamAdapter
import kotlinx.android.synthetic.main.activity_team_explore.*

class ExploreTeams : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_explore)

        val layoutManager = ZoomCenter(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerview_main.layoutManager = layoutManager

        //Auto Center Views
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerview_main)
        recyclerview_main.isNestedScrollingEnabled = false

        val teamsList = TeamsList()

        // give this teamsList to Recyclerview
        recyclerview_main.adapter = TeamAdapter(this, teamsList)
    }

fun TeamsList() : ArrayList<CustomTeams> {
    val t = ArrayList<CustomTeams>()
    t.add(CustomTeams("India",
        "Total Cases: 201009","Current Cases: 98,847 ","Recovered Cases: 96,534","https://i.pinimg.com/564x/92/58/4c/92584c8883e87014ef890f812654df7f.jpg"))
    t.add(CustomTeams("SriLanka",
        "Total Cases: 1643","Current Cases: 809","Recovered Cases: 823","https://i.pinimg.com/originals/2b/d6/5c/2bd65ca788b510211d047ad7658ade47.jpg"))
    t.add(CustomTeams("U.S",
        "Total Cases: 1862091","Current Cases: 1,139,376","Recovered Cases: 615,654","https://i.pinimg.com/originals/f1/4e/4e/f14e4ee48f33665bd9bbc0f003769d66.jpg"))
    t.add(CustomTeams("Italy",
        "Total Cases: 233197","Current Cases: 41,367","Recovered Cases: 158,355 \t","https://i.pinimg.com/originals/a7/ff/51/a7ff515d5f080047bf49f00f8611ead5.jpg"))
    t.add(CustomTeams("Jamaica",
        "Total Cases: 588","Current Cases: 257","Recovered Cases: 322","https://i.pinimg.com/originals/85/f1/eb/85f1eb5c12b612c0a2f688da93f8c20a.jpg"))
    return t
    }
}
