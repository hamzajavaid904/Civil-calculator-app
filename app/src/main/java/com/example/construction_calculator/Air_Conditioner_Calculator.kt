package com.example.construction_calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.health.connect.datatypes.HeightRecord
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

lateinit var imgback_AC          : ImageView
lateinit var button_calculator_AC : Button
lateinit var button_reset_AC      : Button
lateinit var linearlayall_AC      : LinearLayout
lateinit var txtsizeofAC : TextView
lateinit var lenfeetlay_AC    : TextInputLayout
lateinit var lenfeetedt_AC    : TextInputEditText
lateinit var leninchlay_AC    : TextInputLayout
lateinit var leninchedt_AC    : TextInputEditText
lateinit var Brefeetlay_AC  : TextInputLayout
lateinit var Brefeetedt_AC  : TextInputEditText
lateinit var Breinchlay_AC  : TextInputLayout
lateinit var Breinchedt_AC  : TextInputEditText
lateinit var Heightfeetlay_AC  : TextInputLayout
lateinit var Heightfeetedt_AC  : TextInputEditText
lateinit var Heightinchlay_AC  : TextInputLayout
lateinit var Heightinchedt_AC  : TextInputEditText
lateinit var noofpersonlay_AC  : TextInputLayout
lateinit var noofpersonedt_AC  : TextInputEditText
lateinit var tempareturelay_AC  : TextInputLayout
lateinit var temparetureedt_AC  : TextInputEditText
class Air_Conditioner_Calculator : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air_conditioner_calculator)

        imgback_AC = findViewById(R.id.backbtnAC)
        button_calculator_AC = findViewById(R.id.buttoncalculatorAC)
        button_reset_AC = findViewById(R.id.buttonresetAC)
        linearlayall_AC = findViewById(R.id.linearlayallAC)
        txtsizeofAC = findViewById(R.id.txtsizeofAC)
        lenfeetlay_AC = findViewById(R.id.txtinputlaylenfeetAC)
        lenfeetedt_AC = findViewById(R.id.edtlenfeetAC)
        leninchlay_AC = findViewById(R.id.txtinputlayleninchesAC)
        leninchedt_AC = findViewById(R.id.edtleninchesAC)
        Brefeetlay_AC = findViewById(R.id.txtinputlayBrefeetAC)
        Brefeetedt_AC = findViewById(R.id.edtBrefeetAC)
        Breinchlay_AC = findViewById(R.id.txtinputlayBreinchesAC)
        Breinchedt_AC = findViewById(R.id.edtBreinchesAC)
        Heightfeetlay_AC = findViewById(R.id.txtinputlayHeightfeetAC)
        Heightfeetedt_AC = findViewById(R.id.edtHeightfeetAC)
        Heightinchlay_AC = findViewById(R.id.txtinputlayHeightinchesAC)
        Heightinchedt_AC = findViewById(R.id.edtdepthinchesAC)
        noofpersonlay_AC = findViewById(R.id.txtinputlaynoofpersonAC)
        noofpersonedt_AC = findViewById(R.id.edtnoofpersonAC)
        tempareturelay_AC = findViewById(R.id.txtinputlaytemperatureAC)
        temparetureedt_AC = findViewById(R.id.edttemperatureAC)



        imgback_AC.setOnClickListener {
            var intent = Intent(this@Air_Conditioner_Calculator, Home_Screen::class.java)
            startActivity(intent)
        }
        button_reset_AC.setOnClickListener {
            invisiblelayoutAC()

        }
        button_calculator_AC.setOnClickListener {

           if (checkAC()){
               calculationAC()
           }
        }
    }

    fun invisiblelayoutAC() {
        linearlayall_AC.visibility = View.INVISIBLE

        lenfeetedt_AC.setText("")
        leninchedt_AC.setText("")
        Brefeetedt_AC.setText("")
        Breinchedt_AC.setText("")
        Heightfeetedt_AC.setText("")
        Heightinchedt_AC.setText("")
        noofpersonedt_AC.setText("")
        temparetureedt_AC.setText("")
    }
    fun checkAC(): Boolean {
        var isvalid = true
        var lengthfeet = lenfeetedt_AC.text.toString()
        var lengthinch = leninchedt_AC.text.toString()
        var Brefeet = Brefeetedt_AC.text.toString()
        var Breinch = Breinchedt_AC.text.toString()
        var Heightfeet = Heightfeetedt_AC.text.toString()
        var Heightinch = Heightinchedt_AC.text.toString()

        var lengthinch_float = leninchedt_AC.text.toString().toFloatOrNull()
        val Breinch_float = Breinchedt_AC.text.toString().toFloatOrNull()
        val Heightinch_float = Heightinchedt_AC.text.toString().toFloatOrNull()


        var noofpersons = noofpersonedt_AC.text.toString()
        var maxtemp = temparetureedt_AC.text.toString()

        if (lengthinch.isEmpty() || lengthinch_float!! !in 0f .. 12f){
            leninchlay_AC.error = "0-12"
            isvalid = false
        }
        else{
            leninchlay_AC.error = null
        }
        if (Breinch.isEmpty() || Breinch_float!! !in 0f..12f){
            Breinchlay_AC.error = "0-12"
            isvalid = false
        }
        else{
            Breinchlay_AC.error = null
        }
        if (Heightinch.isEmpty() || Heightinch_float!! !in 0f..12f){
            Heightinchlay_AC.error = "0-12"
            isvalid = false
        }
        else{
            Heightinchlay_AC.error = null
        }
        if (lengthfeet.isEmpty()) {
            lenfeetlay_AC.error = "please enter the value"
            isvalid = false
        } else {
            lenfeetlay_AC.error = null
        }
        if (Brefeet.isEmpty()) {
            Brefeetlay_AC.error = "please enter the value"
            isvalid = false
        } else {
            Brefeetlay_AC.error = null
        }
        if (Heightfeet.isEmpty()) {
            Heightfeetlay_AC.error = "please enter the value"
            isvalid = false
        } else {
            Heightfeetlay_AC.error = null
        }
        if (noofpersons.isEmpty()) {
            noofpersonlay_AC.error = "please enter the value"
            isvalid = false
        } else {
            noofpersonlay_AC.error = null
        }
        if (maxtemp.isEmpty()) {
            tempareturelay_AC.error = "please enter the value"
            isvalid = false
        } else {
            tempareturelay_AC.error = null
        }
        return isvalid
    }

    fun calculationAC(){
        linearlayall_AC.visibility = View.VISIBLE
        var total_length_AC = (lenfeetedt_AC.text.toString().toFloatOrNull()  ?: 0f) + (leninchedt_AC.text.toString().toFloatOrNull() ?: 0f) / 10
        var total_breadth_AC = (Brefeetedt_AC.text.toString().toFloatOrNull() ?: 0f) + (Breinchedt_AC.text.toString().toFloatOrNull() ?: 0f) / 10
        var total_hiegth_AC = (Heightfeetedt_AC.text.toString().toFloatOrNull() ?: 0f) + (Heightinchedt_AC.text.toString().toFloatOrNull() ?: 0f) / 10
        var totalpersons    = noofpersonedt_AC.text.toString().toFloatOrNull() ?: 0f
        var maxtemp = temparetureedt_AC.text.toString().toFloatOrNull() ?: 0f

        var roomload = (total_length_AC * total_breadth_AC * 20f) / 12000f
        var noofpersons = totalpersons * 0.05f
        var temp = maxtemp - 24f
        var tempvalue = temp * 0.01f
        var heightvalue = (total_hiegth_AC - 10f) / 10f
        var heightvalue2 = heightvalue * 1.2f

        var ACtons = roomload + noofpersons + tempvalue + heightvalue2
        var ACtons_formatted = String.format("%.2f",ACtons)

        txtsizeofAC.setText(ACtons_formatted.toString())
    }
    }