package com.example.surfeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels


class SpotActivity : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spot)

         // Har satt denne aktivititeten sin parent som MainActivity i Android Manifest, slik at man kommer tilbake til den
         // ved å trykke på denne
         supportActionBar?.setDisplayHomeAsUpEnabled(true)

         //Denne siden skal vise et valgt surfespot. (V)

         val viewModel: SpotActivityViewModel by viewModels()

         val tekstBolge = findViewById<TextView>(R.id.bolgeTekst)
         val tekstVind = findViewById<TextView>(R.id.vindTekst)
         val tekstTemp = findViewById<TextView>(R.id.tempTekst)
         val tekstBes = findViewById<TextView>(R.id.besTekst)



         viewModel.getSurfespots().observe(this) {
             tekstBolge.text = "Sett"
             tekstVind.text = "Sett"
             tekstTemp.text = "Sett"
             tekstBes.text = it.list[0].description.toString()
         }


         viewModel.fetchSurfespots(applicationContext)


    }
}