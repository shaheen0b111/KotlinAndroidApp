package com.example.finalkotlinproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.precaution_main.*

class PrecautionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.precaution_main)

        precaution_text.text = "*To prevent the spread of COVID-19:\n\n" +
                "*Clean your hands often. Use soap and water, or an alcohol-based hand rub.\n\n" +
                "*Maintain a safe distance from anyone who is coughing or sneezing.\n\n" +
                "*Don’t touch your eyes, nose or mouth.\n\n" +
                "*Cover your nose and mouth with your bent elbow or a tissue when you cough or sneeze.\n\n" +
                "*Stay home if you feel unwell.\n\n" +
                "*If you have a fever, cough and difficulty breathing, seek medical attention. Call in advance.\n\n" +
                "*Follow the directions of your local health authority.\n\n" +
                "*Avoiding unneeded visits to medical facilities allows healthcare systems to operate more effectively, therefore protecting you and others."
    }
}