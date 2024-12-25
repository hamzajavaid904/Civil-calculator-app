package com.example.construction_calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

lateinit var imgback_TVC          : ImageView
lateinit var button_feetinch_TVC   : Button
lateinit var button_metercm_TVC    : Button
lateinit var button_calculator_TVC : Button
lateinit var button_reset_TVC      : Button
lateinit var txtcapacityofwater_TVC  : TextView
lateinit var txttotalvolume_TVC  : TextView
lateinit var lenfeetlay_TVC    : TextInputLayout
lateinit var lenfeetedt_TVC    : TextInputEditText
lateinit var leninchlay_TVC    : TextInputLayout
lateinit var leninchedt_TVC    : TextInputEditText
lateinit var widthfeetlay_TVC  : TextInputLayout
lateinit var widthfeetedt_TVC  : TextInputEditText
lateinit var widthinchlay_TVC  : TextInputLayout
lateinit var widthinchedt_TVC  : TextInputEditText
lateinit var depthfeetlay_TVC  : TextInputLayout
lateinit var depthfeetedt_TVC  : TextInputEditText
lateinit var depthinchlay_TVC  : TextInputLayout
lateinit var depthinchedt_TVC  : TextInputEditText
lateinit var lenmeterlay_TVC   : TextInputLayout
lateinit var lenmeteredt_TVC   : TextInputEditText
lateinit var lencmlay_TVC          : TextInputLayout
lateinit var lencmedt_TVC          : TextInputEditText
lateinit var widthmeterlay_TVC     : TextInputLayout
lateinit var widthmeteredt_TVC     : TextInputEditText
lateinit var widthcmlay_TVC        : TextInputLayout
lateinit var widthcmedt_TVC        : TextInputEditText
lateinit var depthmeterlay_TVC     : TextInputLayout
lateinit var depthmeteredt_TVC     : TextInputEditText
lateinit var depthcmlay_TVC        : TextInputLayout
lateinit var depthcmedt_TVC        : TextInputEditText
lateinit var linearlayfeetinch_TVC : LinearLayout
lateinit var linearlaymetercm_TVC  : LinearLayout
lateinit var linearlayall_TVC      : LinearLayout


class Tank_volume_calculator : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tank_volume_calculator)

        linearlayfeetinch_TVC = findViewById(R.id.linearlayoutfeetinchTVC)
        linearlaymetercm_TVC = findViewById(R.id.linearlayoutMetercmTVC)
        linearlayall_TVC = findViewById(R.id.linearlayallTVC)
        button_feetinch_TVC = findViewById(R.id.buttonfeetinchTVC)
        button_metercm_TVC = findViewById(R.id.buttonmetercmTVC)
        button_calculator_TVC = findViewById(R.id.buttoncalculatorTVC)
        button_reset_TVC = findViewById(R.id.buttonresetTVC)
        imgback_TVC = findViewById(R.id.backbtnTVC)
        lenfeetlay_TVC = findViewById(R.id.txtinputlaylenfeetTVC)
        leninchlay_TVC = findViewById(R.id.txtinputlayleninchesTVC)
        lenmeterlay_TVC = findViewById(R.id.txtinputlaylenmeterTVC)
        lencmlay_TVC = findViewById(R.id.txtinputlaylencmTVC)
        lenfeetedt_TVC = findViewById(R.id.edtlenfeetTVC)
        leninchedt_TVC = findViewById(R.id.edtleninchesTVC)
        lenmeteredt_TVC = findViewById(R.id.edtlenmeterTVC)
        lencmedt_TVC = findViewById(R.id.edtlencmTVC)
        widthfeetlay_TVC = findViewById(R.id.txtinputlaywidthfeetTVC)
        widthinchlay_TVC = findViewById(R.id.txtinputlaywidthinchesTVC)
        widthmeterlay_TVC = findViewById(R.id.txtinputlaywidthmeterTVC)
        widthcmlay_TVC = findViewById(R.id.txtinputlaywidthcmTVC)
        widthfeetedt_TVC = findViewById(R.id.edtwidthfeetTVC)
        widthinchedt_TVC = findViewById(R.id.edtwidthinchesTVC)
        widthmeteredt_TVC = findViewById(R.id.edtwidthmeterTVC)
        widthcmedt_TVC = findViewById(R.id.edtwidthcmTVC)
        depthfeetlay_TVC = findViewById(R.id.txtinputlaydepthfeetTVC)
        depthinchlay_TVC = findViewById(R.id.txtinputlaydepthinchesTVC)
        depthmeterlay_TVC = findViewById(R.id.txtinputlaydepthmeterTVC)
        depthcmlay_TVC = findViewById(R.id.txtinputlaydepthcmTVC)
        depthfeetedt_TVC = findViewById(R.id.edtdepthfeetTVC)
        depthinchedt_TVC = findViewById(R.id.edtdepthinchesTVC)
        depthmeteredt_TVC = findViewById(R.id.edtdepthmeterTVC)
        depthcmedt_TVC = findViewById(R.id.edtdepthcmTVC)
        txtcapacityofwater_TVC = findViewById(R.id.txtcapacityofwaterTVC)
        txttotalvolume_TVC = findViewById(R.id.txttotalvolumeTVC)

        imgback_TVC.setOnClickListener {
            var intent = Intent(this@Tank_volume_calculator, Home_Screen::class.java)
            startActivity(intent)
        }
        button_feetinch_TVC.setOnClickListener {
            showfeetinclayTVC()

        }
        button_metercm_TVC.setOnClickListener {
            showmetercmTVC()

        }
        button_calculator_TVC.setOnClickListener {
            if (checkTVC()) {
                showitemcalculatedTVC()
            }
        }
        button_reset_TVC.setOnClickListener {
            invisiblelayoutTVC()

        }

    }

    fun showfeetinclayTVC() {
        linearlayfeetinch_TVC.visibility = View.VISIBLE
        linearlaymetercm_TVC.visibility = View.INVISIBLE
        button_feetinch_TVC.setBackgroundResource(R.drawable.spinnerstyle)
        button_metercm_TVC.setBackgroundResource(R.drawable.btnstyle)
        button_feetinch_TVC.setTextColor(Color.BLACK)
        button_metercm_TVC.setTextColor(Color.WHITE)
    }

    fun showmetercmTVC() {
        linearlayfeetinch_TVC.visibility = View.INVISIBLE
        linearlaymetercm_TVC.visibility = View.VISIBLE
        button_feetinch_TVC.setBackgroundResource(R.drawable.btnstyle)
        button_metercm_TVC.setBackgroundResource(R.drawable.spinnerstyle)
        button_metercm_TVC.setTextColor(Color.BLACK)
        button_feetinch_TVC.setTextColor(Color.WHITE)
    }

    fun checkTVC(): Boolean {
        var isvalid = true
        var lengthfeet = lenfeetedt_TVC.text.toString()
        var lengthinch = leninchedt_TVC.text.toString()
        var widthfeet = widthfeetedt_TVC.text.toString()
        var widthinch = widthinchedt_TVC.text.toString()
        var depthfeet = depthfeetedt_TVC.text.toString()
        var depthinch = depthinchedt_TVC.text.toString()

        val lengthinch_float = leninchedt_TVC.text.toString().toFloatOrNull()
        val widthinch_float = widthinchedt_TVC.text.toString().toFloatOrNull()
        val depthinch_float = depthinchedt_TVC.text.toString().toFloatOrNull()




        if (linearlayfeetinch_TVC.visibility == View.VISIBLE) {
            if (lengthfeet.isEmpty()) {
                lenfeetlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                lenfeetlay_TVC.error = null
            }

            if (lengthinch.isEmpty() || lengthinch_float!! !in 0f..11f) {
                leninchlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                leninchlay_TVC.error = null
            }

            if (widthfeet.isEmpty()) {
                widthfeetlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                widthfeetlay_TVC.error = null
            }
            if (widthinch.isEmpty() || widthinch_float!! !in 0f..11f) {
                widthinchlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                widthinchlay_TVC.error = null
            }
            if (depthfeet.isEmpty()) {
                depthfeetlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                depthfeetlay_TVC.error = null
            }
            if (depthinch.isEmpty() || depthinch_float!! !in 0f..11f) {
                depthinchlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                depthinchlay_TVC.error = null
            }
        }
        if (linearlaymetercm_TVC.visibility == View.VISIBLE) {
            var lengthmeter = lenmeteredt_TVC.text.toString()
            var lengthcm = lencmedt_TVC.text.toString()
            var widthmeter = widthmeteredt_TVC.text.toString()
            var widthcm = widthcmedt_TVC.text.toString()
            var depthmeter = depthmeteredt_TVC.text.toString()
            var depthcm = depthcmedt_TVC.text.toString()

            val lengthcm_float = lencmedt_TVC.text.toString().toFloatOrNull()
            val widthcm_float = widthcmedt_TVC.text.toString().toFloatOrNull()
            val depthcm_float = depthcmedt_TVC.text.toString().toFloatOrNull()


            if (lengthmeter.isEmpty()) {
                lenmeterlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                lenmeterlay_TVC.error = null

            }

            if (lengthcm.isEmpty() || lengthcm_float!! !in 0f..99f) {
                lencmlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                lencmlay_TVC.error = null
            }

            if (widthmeter.isEmpty()) {
                widthmeterlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                widthmeterlay_TVC.error = null
            }
            if (widthcm.isEmpty() || widthcm_float!! !in 0f..99f) {
                widthcmlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                widthcmlay_TVC.error = null
            }
            if (depthmeter.isEmpty()) {
                depthmeterlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                depthmeterlay_TVC.error = null
            }
            if (depthcm.isEmpty() || depthcm_float!! !in 0f..11f) {
                depthcmlay_TVC.error = "please enter the value"
                isvalid = false
            } else {
                depthcmlay_TVC.error = null
            }
        }
        return isvalid
    }

    fun invisiblelayoutTVC() {
        linearlayall_TVC.visibility = View.INVISIBLE
        if (linearlayfeetinch_TVC.visibility == View.VISIBLE) {
            lenfeetedt_TVC.setText("")
            leninchedt_TVC.setText("")
            widthfeetedt_TVC.setText("")
            widthinchedt_TVC.setText("")
            depthfeetedt_TVC.setText("")
            depthinchedt_TVC.setText("")


        }
        if (linearlaymetercm_TVC.visibility == View.VISIBLE) {
            lenmeteredt_TVC.setText("")
            lencmedt_TVC.setText("")
            widthmeteredt_TVC.setText("")
            widthcmedt_TVC.setText("")
            depthmeteredt_TVC.setText("")
            depthcmedt_TVC.setText("")

        }
    }

    fun showitemcalculatedTVC() {

        linearlayall_TVC.visibility = View.VISIBLE

        if (linearlayfeetinch_TVC.visibility == View.VISIBLE) {


            var total_length_feet = (lenfeetedt_TVC.text.toString().toFloatOrNull()
                ?: 0f) + (leninchedt_TVC.text.toString().toFloatOrNull() ?: 0f) / 10
            var total_width_feet = (widthfeetedt_TVC.text.toString().toFloatOrNull()
                ?: 0f) + (widthinchedt_TVC.text.toString().toFloatOrNull() ?: 0f) / 10
            var total_depth_feet = (depthfeetedt_TVC.text.toString().toFloatOrNull()
                ?: 0f) + (depthinchedt_TVC.text.toString().toFloatOrNull() ?: 0f) / 10

            var feetcube = total_length_feet * total_width_feet * total_depth_feet
            var feetcube_formatted = String.format("%.2f", feetcube)
            var metercube = feetcube * 0.0283168
            var metercube_formatted = String.format("%.2f", metercube)
            var capacityofwater = metercube_formatted.toString().toFloatOrNull()!! * 1000

            txtcapacityofwater_TVC.setText(capacityofwater.toString() + " lt")
            txttotalvolume_TVC.setText(metercube_formatted.toString() + " m³ or " + feetcube_formatted.toString()+" ft³ ")
        }
        if (linearlaymetercm_TVC.visibility == View.VISIBLE) {


            var total_length_feet = (lenmeteredt_TVC.text.toString().toFloatOrNull()
                ?: 0f) + (lencmedt_TVC.text.toString().toFloatOrNull() ?: 0f) / 10
            var total_width_feet = (widthmeteredt_TVC.text.toString().toFloatOrNull()
                ?: 0f) + (widthcmedt_TVC.text.toString().toFloatOrNull() ?: 0f) / 10
            var total_depth_feet = (depthmeteredt_TVC.text.toString().toFloatOrNull()
                ?: 0f) + (depthcmedt_TVC.text.toString().toFloatOrNull() ?: 0f) / 10

            var metercube = total_length_feet * total_width_feet * total_depth_feet
            var metercube_formatted = String.format("%.2f", metercube)
            var feetcube = metercube * 35.3147
            var feetcube_formatted = String.format("%.2f", feetcube)
            var capacityofwater = metercube_formatted.toString().toFloatOrNull()!! * 1000

            txtcapacityofwater_TVC.setText(capacityofwater.toString() + " Liters")
            txttotalvolume_TVC.setText(metercube_formatted.toString() + " m³ or " + feetcube_formatted.toString()+" ft³ ")
        }
    }
}