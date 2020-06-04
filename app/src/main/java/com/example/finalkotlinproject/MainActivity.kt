package com.example.finalkotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        discover_button.setOnClickListener(){
            val discover_intent = Intent(this,ExploreTeams::class.java)
            startActivity(discover_intent)
        }
        precaution_button.setOnClickListener(){
            val precaution_intent = Intent(this,PrecautionActivity::class.java )
            startActivity(precaution_intent)
        }
        help_button.setOnClickListener(){
            val help_intent = Intent(this,ExploreHelp::class.java)
            startActivity(help_intent)
        }
    }
}
