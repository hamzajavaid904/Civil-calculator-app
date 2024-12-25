package com.example.construction_calculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

lateinit var dropdownmenuSWH : AutoCompleteTextView
lateinit var imgback_SWH          : ImageView
lateinit var button_calculator_SWH : Button
lateinit var button_reset_SWH      : Button
lateinit var noofpersons : TextInputLayout
lateinit var edtnoofpersons : TextInputEditText
lateinit var linearlayall_SWH      : LinearLayout
lateinit var txtsizeofSWH : TextView
lateinit var adapterSWH           : ArrayAdapter<CharSequence>


class Solar_Water_Heater : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solar_water_heater)

        dropdownmenuSWH = findViewById(R.id.dropdown_menuSWH)
        imgback_SWH = findViewById(R.id.backbtnSWH)
        button_reset_SWH = findViewById(R.id.buttonresetSWH)
        button_calculator_SWH = findViewById(R.id.buttoncalculatorSWH)
        noofpersons = findViewById(R.id.txtinputlayunitsSWH)
        edtnoofpersons = findViewById(R.id.edtunitsSWH)
        linearlayall_SWH = findViewById(R.id.linearlayallSWH)
        txtsizeofSWH = findViewById(R.id.txtLiters)

        adapterSWH = ArrayAdapter.createFromResource(
            this,
            R.array.dropdownSWH,
            android.R.layout.simple_dropdown_item_1line
        )
        dropdownmenuSWH.setAdapter(adapterSWH)

        imgback_SWH.setOnClickListener {
            var intent = Intent(this@Solar_Water_Heater, Home_Screen::class.java)
            startActivity(intent)
        }
        button_reset_SWH.setOnClickListener {
            edtnoofpersons.setText("")
            linearlayall_SWH.visibility = View.INVISIBLE


        }
        button_calculator_SWH.setOnClickListener {
            if (checkSWH()) {
                linearlayall_SWH.visibility = View.VISIBLE
                calculateSWH()

            }
        }

    }
    fun checkSWH(): Boolean {
        var isvalid = true
        var unitchecks = edtnoofpersons.text.toString()
        if (unitchecks.isEmpty()) {
            noofpersons.error = "enter value"
            isvalid = false
        } else {
            noofpersons.error = null
        }
        return isvalid
    }

    fun calculateSWH() {
        var itemselected = dropdownmenuSWH.text.toString()
        linearlayall_SWH.visibility = View.VISIBLE

        var noofpersons = edtnoofpersons.text.toString().toFloatOrNull()

        when (itemselected) {
            "YES" -> {

                var liters = noofpersons!! * 80f
                txtsizeofSWH.setText(liters.toString())
            }

            "NO" -> {
              var liters =   noofpersons!! * 50f
                txtsizeofSWH.setText(liters.toString())
            }
        }
    }
}