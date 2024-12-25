package com.example.construction_calculator

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.roundToInt

lateinit var imgback_PC          : ImageView
lateinit var button_feetinch_PC   : Button
lateinit var button_metercm_PC    : Button
lateinit var button_calculator_PC : Button
lateinit var button_reset_PC      : Button
lateinit var spinner1_PC       : Spinner
lateinit var spinner2_PC       : Spinner
lateinit var txttotalvalue_PC  : TextView
lateinit var listview_PC      : ListView
lateinit var pieChart_PC      : PieChart
lateinit var lenfeetlay_PC    : TextInputLayout
lateinit var lenfeetedt_PC    : TextInputEditText
lateinit var leninchlay_PC    : TextInputLayout
lateinit var leninchedt_PC    : TextInputEditText
lateinit var widthfeetlay_PC  : TextInputLayout
lateinit var widthfeetedt_PC  : TextInputEditText
lateinit var widthinchlay_PC  : TextInputLayout
lateinit var widthinchedt_PC  : TextInputEditText
lateinit var lenmeterlay_PC   : TextInputLayout
lateinit var lenmeteredt_PC   : TextInputEditText
lateinit var lencmlay_PC          : TextInputLayout
lateinit var lencmedt_PC          : TextInputEditText
lateinit var widthmeterlay_PC     : TextInputLayout
lateinit var widthmeteredt_PC     : TextInputEditText
lateinit var widthcmlay_PC        : TextInputLayout
lateinit var widthcmedt_PC        : TextInputEditText
lateinit var linearlayfeetinch_PC : LinearLayout
lateinit var linearlaymetercm_PC  : LinearLayout
lateinit var linearlayall_PC      : LinearLayout
lateinit var adapter1_PC           : ArrayAdapter<CharSequence>
lateinit var adapter2_PC           : ArrayAdapter<CharSequence>
private lateinit var items1_PC  : MutableList<ListItem>
lateinit var Arrayimg_PC        : Array<Int>
lateinit var Arraycalcu_PC      : Array<Int>
lateinit var Arraytxt_PC        : Array<String>
lateinit var Arrayunit_PC        : Array<String>
lateinit var chartdata_PC       : ArrayList<PieEntry>




class Plaster_calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plaster_calculator)

        imgback_PC = findViewById(R.id.backbtnPC)
        spinner1_PC = findViewById(R.id.spinnerplastertypePC)
        spinner2_PC = findViewById(R.id.spinner2gradeoffootingPC)
        listview_PC = findViewById(R.id.listviewPC)
        pieChart_PC = findViewById(R.id.piechartPC)
        txttotalvalue_PC = findViewById(R.id.txttotalvaluePC)
        linearlayfeetinch_PC = findViewById(R.id.linearlayoutfeetinchPC)
        linearlaymetercm_PC = findViewById(R.id.linearlayoutMetercmPC)
        linearlayall_PC = findViewById(R.id.linearlayallPC)
        button_feetinch_PC = findViewById(R.id.buttonfeetinchPC)
        button_metercm_PC = findViewById(R.id.buttonmetercmPC)
        button_calculator_PC = findViewById(R.id.buttoncalculatorPC)
        button_reset_PC = findViewById(R.id.buttonresetPC)
        lenfeetlay_PC = findViewById(R.id.txtinputlaylenfeetPC)
        leninchlay_PC = findViewById(R.id.txtinputlayleninchesPC)
        lenmeterlay_PC = findViewById(R.id.txtinputlaylenmeterPC)
        lencmlay_PC = findViewById(R.id.txtinputlaylencmPC)
        lenfeetedt_PC = findViewById(R.id.edtlenfeetPC)
        leninchedt_PC = findViewById(R.id.edtleninchesPC)
        lenmeteredt_PC = findViewById(R.id.edtlenmeterPC)
        lencmedt_PC = findViewById(R.id.edtlencmPC)
        widthfeetlay_PC = findViewById(R.id.txtinputlaywidthfeetPC)
        widthinchlay_PC = findViewById(R.id.txtinputlaywidthinchesPC)
        widthmeterlay_PC = findViewById(R.id.txtinputlaywidthmeterPC)
        widthcmlay_PC = findViewById(R.id.txtinputlaywidthcmPC)
        widthfeetedt_PC = findViewById(R.id.edtwidthfeetPC)
        widthinchedt_PC = findViewById(R.id.edtwidthinchesPC)
        widthmeteredt_PC = findViewById(R.id.edtwidthmeterPC)
        widthcmedt_PC = findViewById(R.id.edtwidthcmPC)


        //this is for plaster type spinner
        adapter1_PC = ArrayAdapter.createFromResource(
            this,
            R.array.Spinner1_items_PC,
            android.R.layout.simple_spinner_item
        )
        adapter1_PC.setDropDownViewResource(android.R.layout.simple_list_item_1)
        spinner1_PC.adapter = adapter1_PC

        //this is for grade of footing spinner
        adapter2_PC = ArrayAdapter.createFromResource(
            this,
            R.array.Spinner2_items_PC,
            android.R.layout.simple_spinner_item
        )
        adapter2_PC.setDropDownViewResource(android.R.layout.simple_list_item_1)
        spinner2_PC.adapter = adapter2_PC

        button_calculator_PC.setOnClickListener {
            if (check()) {
                showitemcalculatedPC()

            }
        }
        button_feetinch_PC.setOnClickListener {
            showfeetinclayPC()
            button_feetinch_PC.setBackgroundResource(R.drawable.spinnerstyle)
            button_metercm_PC.setBackgroundResource(R.drawable.btnstyle)
            button_feetinch_PC.setTextColor(Color.BLACK)
            button_metercm_PC.setTextColor(Color.WHITE)
        }
        button_metercm_PC.setOnClickListener {
            showmetercmlayPC()
            button_feetinch_PC.setBackgroundResource(R.drawable.btnstyle)
            button_metercm_PC.setBackgroundResource(R.drawable.spinnerstyle)
            button_metercm_PC.setTextColor(Color.BLACK)
            button_feetinch_PC.setTextColor(Color.WHITE)
        }
        imgback_PC.setOnClickListener {
            var intent = Intent(this@Plaster_calculator, Home_Screen::class.java)
            startActivity(intent)
        }
        button_reset_PC.setOnClickListener {
            invisiblelayoutPC()
            if (linearlayfeetinch_PC.visibility == View.VISIBLE) {
                lenfeetedt_PC.setText("")
                leninchedt_PC.setText("")
                widthfeetedt_PC.setText("")
                widthinchedt_PC.setText("")
            }
            if (linearlaymetercm_PC.visibility == View.VISIBLE) {
                lenmeteredt_PC.setText("")
                lencmedt_PC.setText("")
                widthmeteredt_PC.setText("")
                widthcmedt_PC.setText("")

            }
        }

    }

    fun check(): Boolean {
        var isvalid = true

        var lengthfeet = lenfeetedt_PC.text.toString()
        var lengthinch = leninchedt_PC.text.toString()
        var widthfeet = widthfeetedt_PC.text.toString()
        var widthinch = widthinchedt_PC.text.toString()

        val lengthfeet_float = lenfeetedt_PC.text.toString().toFloatOrNull()
        val lengthinch_float = leninchedt_PC.text.toString().toFloatOrNull()
        val widthfeet_float = widthfeetedt_PC.text.toString().toFloatOrNull()
        val widthinch_float = widthinchedt_PC.text.toString().toFloatOrNull()


        if (linearlayfeetinch_PC.visibility == View.VISIBLE) {

            if (lengthfeet.isEmpty()) {
                lenfeetlay_PC.error = "please enter the value"
                isvalid = false
            } else {
                lenfeetlay_PC.error = null
            }

            if (lengthinch.isEmpty() || lengthinch_float!! !in 0f..11f) {
                leninchlay_PC.error = "please enter the value"
                isvalid = false
            } else {
                leninchlay_PC.error = null
            }

            if (widthfeet.isEmpty()) {
                widthfeetlay_PC.error = "please enter the value"
                isvalid = false
            } else {
                widthfeetlay_PC.error = null
            }
            if (widthinch.isEmpty() || widthinch_float!! !in 0f..11f) {
                widthinchlay_PC.error = "please enter the value"
                isvalid = false
            } else {
                widthinchlay_PC.error = null
            }
        }
        if (linearlaymetercm_PC.visibility == View.VISIBLE) {
            var lengthmeter = lenmeteredt_PC.text.toString()
            var lengthcm = lencmedt_PC.text.toString()
            var widthmeter = widthmeteredt_PC.text.toString()
            var widthcm = widthcmedt_PC.text.toString()

            val lengthmeter_float = lenmeteredt_PC.text.toString().toFloatOrNull()
            val lengthcm_float = lencmedt_PC.text.toString().toFloatOrNull()
            val widthmeter_float = widthmeteredt_PC.text.toString().toFloatOrNull()
            val widthcm_float = widthcmedt_PC.text.toString().toFloatOrNull()


            if (lengthmeter.isEmpty()) {
                lenmeterlay_PC.error = "please enter the value"
                isvalid = false
            } else {
                lenmeterlay_PC.error = null
            }

            if (lengthcm.isEmpty() || lengthcm_float!! !in 0f..99f) {
                lencmlay_PC.error = "please enter the value"
                isvalid = false
            } else {
                lencmlay_PC.error = null
            }

            if (widthmeter.isEmpty()) {
                widthmeterlay_PC.error = "please enter the value"
                isvalid = false
            } else {
                widthmeterlay_PC.error = null
            }
            if (widthcm.isEmpty() || widthcm_float!! !in 0f..99f) {
                widthcmlay_PC.error = "please enter the value"
                isvalid = false
            } else {
                widthcmlay_PC.error = null
            }
        }
        return isvalid
    }

    fun showfeetinclayPC() {
        linearlayfeetinch_PC.visibility = View.VISIBLE
        linearlaymetercm_PC.visibility = View.INVISIBLE
    }

    fun showmetercmlayPC() {
        linearlayfeetinch_PC.visibility = View.INVISIBLE
        linearlaymetercm_PC.visibility = View.VISIBLE
    }

    fun invisiblelayoutPC() {
        linearlayall_PC.visibility = View.INVISIBLE
    }

    fun showitemcalculatedPC() {
        linearlayall_PC.visibility = View.VISIBLE
        var selecteditemPC1 = spinner1_PC.selectedItem.toString()
        var selecteditemPC2 = spinner2_PC.selectedItem.toString()

        if (linearlayfeetinch_PC.visibility == View.VISIBLE) {
            var total_length_feet = (lenfeetedt_PC.text.toString().toFloatOrNull()
                ?: 0f) + (leninchedt_PC.text.toString().toFloatOrNull() ?: 0f) / 10
            var total_width_feet = (widthfeetedt_PC.text.toString().toFloatOrNull()
                ?: 0f) + (widthinchedt_PC.text.toString().toFloatOrNull() ?: 0f) / 10

            var feetcube = total_length_feet * total_width_feet
            var feetcube_formatted = String.format("%.2f", feetcube)
            var metercube = feetcube * 0.092903f
            var metercube_formatted = String.format("%.2f", metercube)


            txttotalvalue_PC.setText(metercube_formatted.toString() + " m² or " + feetcube_formatted.toString()+ " ft²")


            when (selecteditemPC1) {
                "12 MM" -> {
                    // calculation
                    val volumeofmortar = metercube * 0.012f
                    val volumeofmortar2 = volumeofmortar + (volumeofmortar * 0.3f)
                    val dryvolumeofmortar = volumeofmortar2 + (volumeofmortar2 * 0.25f)

                    when (selecteditemPC2) {
                        "C.M 1:3" -> {
                            val cement = (dryvolumeofmortar * 1f) / 4f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 3f) / 4f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:4" -> {
                            val cement = (dryvolumeofmortar * 1f) / 5f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 4f) / 5f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:5" -> {
                            val cement = (dryvolumeofmortar * 1f) / 6f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 5f) / 6f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:6" -> {
                            val cement = (dryvolumeofmortar * 1f) / 7f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 6f) / 7f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }
                    }

                }

                "15 MM" -> {
                    val volumeofmortar = metercube * 0.015f
                    val volumeofmortar2 = volumeofmortar + (volumeofmortar * 0.3f)
                    val dryvolumeofmortar = volumeofmortar2 + (volumeofmortar2 * 0.25f)
                    when (selecteditemPC2) {
                        "C.M 1:3" -> {
                            val cement = (dryvolumeofmortar * 1f) / 4f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 3f) / 4f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:4" -> {
                            val cement = (dryvolumeofmortar * 1f) / 5f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 4f) / 5f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:5" -> {
                            val cement = (dryvolumeofmortar * 1f) / 6f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 5f) / 6f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:6" -> {
                            val cement = (dryvolumeofmortar * 1f) / 7f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 6f) / 7f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }
                    }
                }

                "18 MM" -> {
                    val volumeofmortar = metercube * 0.018f
                    val volumeofmortar2 = volumeofmortar + (volumeofmortar * 0.3f)
                    val dryvolumeofmortar = volumeofmortar2 + (volumeofmortar2 * 0.25f)
                    when (selecteditemPC2) {
                        "C.M 1:3" -> {
                            val cement = (dryvolumeofmortar * 1f) / 4f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 3f) / 4f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:4" -> {
                            val cement = (dryvolumeofmortar * 1f) / 5f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 4f) / 5f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:5" -> {
                            val cement = (dryvolumeofmortar * 1f) / 6f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 5f) / 6f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:6" -> {
                            val cement = (dryvolumeofmortar * 1f) / 7f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 6f) / 7f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }
                    }

                }

                "20 MM" -> {
                    val volumeofmortar = metercube * 0.020f
                    val volumeofmortar2 = volumeofmortar + (volumeofmortar * 0.3f)
                    val dryvolumeofmortar = volumeofmortar2 + (volumeofmortar2 * 0.25f)
                    when (selecteditemPC2) {
                        "C.M 1:3" -> {
                            val cement = (dryvolumeofmortar * 1f) / 4f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 3f) / 4f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:4" -> {
                            val cement = (dryvolumeofmortar * 1f) / 5f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 4f) / 5f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:5" -> {
                            val cement = (dryvolumeofmortar * 1f) / 6f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 5f) / 6f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:6" -> {
                            val cement = (dryvolumeofmortar * 1f) / 7f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 6f) / 7f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }
                    }
                }
            }
        }
        if (linearlaymetercm_PC.visibility == View.VISIBLE) {

            var total_length_meter = (lenmeteredt_PC.text.toString().toFloatOrNull()
                ?: 0f) + (lencmedt_PC.text.toString().toFloatOrNull() ?: 0f) / 10
            var total_width_meter = (widthmeteredt_PC.text.toString().toFloatOrNull()
                ?: 0f) + (widthcmedt_PC.text.toString().toFloatOrNull() ?: 0f) / 10


            var metercube = total_length_meter * total_width_meter
            var metercube_formatted = String.format("%.2f", metercube)
            var feetcube = metercube * 10.7639
            var feetcube_formatted = String.format("%.2f", feetcube)

            txttotalvalue_PC.setText(metercube_formatted.toString() + " m² or " + feetcube_formatted.toString()+ " ft²")

            when (selecteditemPC1) {
                "12 MM" -> {
                    // calculation
                    val volumeofmortar = metercube * 0.012f
                    val volumeofmortar2 = volumeofmortar + (volumeofmortar * 0.3f)
                    val dryvolumeofmortar = volumeofmortar2 + (volumeofmortar2 * 0.25f)

                    when (selecteditemPC2) {
                        "C.M 1:3" -> {
                            val cement = (dryvolumeofmortar * 1f) / 4f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 3f) / 4f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:4" -> {
                            val cement = (dryvolumeofmortar * 1f) / 5f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 4f) / 5f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:5" -> {
                            val cement = (dryvolumeofmortar * 1f) / 6f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 5f) / 6f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:6" -> {
                            val cement = (dryvolumeofmortar * 1f) / 7f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 6f) / 7f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }
                    }

                }

                "15 MM" -> {
                    val volumeofmortar = metercube * 0.015f
                    val volumeofmortar2 = volumeofmortar + (volumeofmortar * 0.3f)
                    val dryvolumeofmortar = volumeofmortar2 + (volumeofmortar2 * 0.25f)
                    when (selecteditemPC2) {
                        "C.M 1:3" -> {
                            val cement = (dryvolumeofmortar * 1f) / 4f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 3f) / 4f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:4" -> {
                            val cement = (dryvolumeofmortar * 1f) / 5f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 4f) / 5f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:5" -> {
                            val cement = (dryvolumeofmortar * 1f) / 6f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 5f) / 6f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:6" -> {
                            val cement = (dryvolumeofmortar * 1f) / 7f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 6f) / 7f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }
                    }
                }

                "18 MM" -> {
                    val volumeofmortar = metercube * 0.018f
                    val volumeofmortar2 = volumeofmortar + (volumeofmortar * 0.3f)
                    val dryvolumeofmortar = volumeofmortar2 + (volumeofmortar2 * 0.25f)
                    when (selecteditemPC2) {
                        "C.M 1:3" -> {
                            val cement = (dryvolumeofmortar * 1f) / 4f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 3f) / 4f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:4" -> {
                            val cement = (dryvolumeofmortar * 1f) / 5f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 4f) / 5f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:5" -> {
                            val cement = (dryvolumeofmortar * 1f) / 6f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 5f) / 6f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:6" -> {
                            val cement = (dryvolumeofmortar * 1f) / 7f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 6f) / 7f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }
                    }

                }

                "20 MM" -> {
                    val volumeofmortar = metercube * 0.020f
                    val volumeofmortar2 = volumeofmortar + (volumeofmortar * 0.3f)
                    val dryvolumeofmortar = volumeofmortar2 + (volumeofmortar2 * 0.25f)
                    when (selecteditemPC2) {
                        "C.M 1:3" -> {
                            val cement = (dryvolumeofmortar * 1f) / 4f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 3f) / 4f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:4" -> {
                            val cement = (dryvolumeofmortar * 1f) / 5f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 4f) / 5f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:5" -> {
                            val cement = (dryvolumeofmortar * 1f) / 6f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 5f) / 6f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }

                        "C.M 1:6" -> {
                            val cement = (dryvolumeofmortar * 1f) / 7f
                            val no_of_cementbags = cement / 0.035f
                            val sand = ((dryvolumeofmortar * 6f) / 7f) * 1550f
                            val sand_in_tons = sand / 1000f
                            updateMaterialList(no_of_cementbags.toFloat(), sand_in_tons.toFloat())
                        }
                    }
                }
            }
        }
    }

    fun updateMaterialList(cement: Float, sand: Float) {
        val cementBags = cement.roundToInt()  // Example calculation for bags of cement
        val sandTons = sand.roundToInt()  // Example conversion to tons

        Arrayimg_PC = arrayOf(R.drawable.airconditioner, R.drawable.areagraph1)
        Arraytxt_PC = arrayOf("cement", "sand")
        Arraycalcu_PC = arrayOf(cementBags, sandTons)
        Arrayunit_PC = arrayOf("Bags","Ton")
        items1_PC = mutableListOf()
        for (i in Arraytxt_PC.indices) {
            val newItem = ListItem(Arrayimg_PC[i], Arraytxt_PC[i], Arraycalcu_PC[i], Arrayunit_PC[i])
            items1_PC.add(newItem)
        }
        val adapter_PC = AdapterListview(this, items1_PC)
        listview_PC.adapter = adapter_PC


        updatePieChart(cementBags.toFloat(), sandTons.toFloat())


    }

    fun updatePieChart(cementValue: Float, sandValue: Float) {
        //piechart
        chartdata_PC = ArrayList()
        chartdata_PC.add(PieEntry(cementValue, "cement"))
        chartdata_PC.add(PieEntry(sandValue, "Sand"))


        val dataSet_PC = PieDataSet(chartdata_PC, "Materails")
        dataSet_PC.colors = listOf(
            Color.parseColor("#FF8A65"), // Cement
            Color.parseColor("#FFAB40"), // Steel

        )

        val data_PC = PieData(dataSet_PC)
        pieChart_PC.data = data_PC
        pieChart_PC.description.isEnabled = false

        // Customize chart
        pieChart_PC.holeRadius = 58f
        pieChart_PC.centerText = "Materials"
        pieChart_PC.isDrawHoleEnabled = true
        pieChart_PC.transparentCircleRadius = 61f
        pieChart_PC.invalidate()
        pieChart_PC.setDrawCenterText(true)
        pieChart_PC.animateY(1400)
        pieChart_PC.setHoleColor(R.color.white)
        pieChart_PC.setTransparentCircleAlpha(110)

    }
}

