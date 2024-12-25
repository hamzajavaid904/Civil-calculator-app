package com.example.construction_calculator

import android.annotation.SuppressLint
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
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.roundToInt

lateinit var imgback_CCC           : ImageView
lateinit var button_feetinch_CCC   : Button
lateinit var button_metercm_CCC    : Button
lateinit var button_calculator_CCC : Button
lateinit var button_reset_CCC      : Button
lateinit var spinner_CCC       : Spinner
lateinit var txttotalvalue_CCC : TextView
lateinit var listview_CCC      : ListView
lateinit var pieChart_CCC      : PieChart
lateinit var lenfeetlay_CCC    : TextInputLayout
lateinit var lenfeetedt_CCC    : TextInputEditText
lateinit var leninchlay_CCC    : TextInputLayout
lateinit var leninchedt_CCC    : TextInputEditText
lateinit var widthfeetlay_CCC  : TextInputLayout
lateinit var widthfeetedt_CCC  : TextInputEditText
lateinit var widthinchlay_CCC  : TextInputLayout
lateinit var widthinchedt_CCC  : TextInputEditText
lateinit var depthfeetlay_CCC  : TextInputLayout
lateinit var depthfeetedt_CCC  : TextInputEditText
lateinit var depthinchlay_CCC  : TextInputLayout
lateinit var depthinchedt_CCC  : TextInputEditText
lateinit var lenmeterlay_CCC   : TextInputLayout
lateinit var lenmeteredt_CCC   : TextInputEditText
lateinit var lencmlay_CCC          : TextInputLayout
lateinit var lencmedt_CCC          : TextInputEditText
lateinit var widthmeterlay_CCC     : TextInputLayout
lateinit var widthmeteredt_CCC     : TextInputEditText
lateinit var widthcmlay_CCC        : TextInputLayout
lateinit var widthcmedt_CCC        : TextInputEditText
lateinit var depthmeterlay_CCC     : TextInputLayout
lateinit var depthmeteredt_CCC     : TextInputEditText
lateinit var depthcmlay_CCC        : TextInputLayout
lateinit var depthcmedt_CCC        : TextInputEditText
lateinit var linearlayfeetinch_CCC : LinearLayout
lateinit var linearlaymetercm_CCC  : LinearLayout
lateinit var linearlayall_CCC      : LinearLayout
lateinit var adapter_CCC           : ArrayAdapter<CharSequence>
private lateinit var items1_CCC  : MutableList<ListItem>
lateinit var Arrayimg_CCC        : Array<Int>
lateinit var Arraycalcu_CCC      : Array<Int>
lateinit var Arraytxt_CCC        : Array<String>
lateinit var ArrayUnit_CCC        : Array<String>
lateinit var chartdata_CCC       : ArrayList<PieEntry>

class Cement_Concrete_Calculator : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cement_concrete_calculator)

        spinner_CCC = findViewById(R.id.spinnerCCC)
        listview_CCC = findViewById(R.id.listviewCCC)
        pieChart_CCC = findViewById(R.id.piechartCCC)
        txttotalvalue_CCC = findViewById(R.id.txttotalvalueCCC)
        linearlayfeetinch_CCC = findViewById(R.id.linearlayoutfeetinchCCC)
        linearlaymetercm_CCC = findViewById(R.id.linearlayoutMetercmCCC)
        linearlayall_CCC = findViewById(R.id.linearlayallCCC)
        button_feetinch_CCC = findViewById(R.id.buttonfeetinchCCC)
        button_metercm_CCC = findViewById(R.id.buttonmetercmCCC)
        button_calculator_CCC = findViewById(R.id.buttoncalculatorCCC)
        button_reset_CCC = findViewById(R.id.buttonresetCCC)
        imgback_CCC = findViewById(R.id.backbtnCCC)
        lenfeetlay_CCC = findViewById(R.id.txtinputlaylenfeetCCC)
        leninchlay_CCC = findViewById(R.id.txtinputlayleninchesCCC)
        lenmeterlay_CCC = findViewById(R.id.txtinputlaylenmeterCCC)
        lencmlay_CCC = findViewById(R.id.txtinputlaylencmCCC)
        lenfeetedt_CCC = findViewById(R.id.edtlenfeetCCC)
        leninchedt_CCC = findViewById(R.id.edtleninchesCCC)
        lenmeteredt_CCC = findViewById(R.id.edtlenmeterCCC)
        lencmedt_CCC = findViewById(R.id.edtlencmCCC)
        widthfeetlay_CCC = findViewById(R.id.txtinputlaywidthfeetCCC)
        widthinchlay_CCC = findViewById(R.id.txtinputlaywidthinchesCCC)
        widthmeterlay_CCC = findViewById(R.id.txtinputlaywidthmeterCCC)
        widthcmlay_CCC = findViewById(R.id.txtinputlaywidthcmCCC)
        widthfeetedt_CCC = findViewById(R.id.edtwidthfeetCCC)
        widthinchedt_CCC = findViewById(R.id.edtwidthinchesCCC)
        widthmeteredt_CCC = findViewById(R.id.edtwidthmeterCCC)
        widthcmedt_CCC = findViewById(R.id.edtwidthcmCCC)
        depthfeetlay_CCC = findViewById(R.id.txtinputlaydepthfeetCCC)
        depthinchlay_CCC = findViewById(R.id.txtinputlaydepthinchesCCC)
        depthmeterlay_CCC = findViewById(R.id.txtinputlaydepthmeterCCC)
        depthcmlay_CCC = findViewById(R.id.txtinputlaydepthcmCCC)
        depthfeetedt_CCC = findViewById(R.id.edtdepthfeetCCC)
        depthinchedt_CCC = findViewById(R.id.edtdepthinchesCCC)
        depthmeteredt_CCC = findViewById(R.id.edtdepthmeterCCC)
        depthcmedt_CCC = findViewById(R.id.edtdepthcmCCC)




        adapter_CCC = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_items_CCC,
            android.R.layout.simple_spinner_item
        )
        adapter_CCC.setDropDownViewResource(android.R.layout.simple_list_item_1)
        spinner_CCC.adapter = adapter_CCC


        button_calculator_CCC.setOnClickListener {

            if (check()) {
                showitemcalculated()

            }

        }

        button_reset_CCC.setOnClickListener {
            invisiblelayout()
            if (linearlayfeetinch_CCC.visibility == View.VISIBLE) {
                lenfeetedt_CCC.setText("")
                leninchedt_CCC.setText("")
                widthfeetedt_CCC.setText("")
                widthinchedt_CCC.setText("")
                depthfeetedt_CCC.setText("")
                depthinchedt_CCC.setText("")
            }
            if (linearlaymetercm_CCC.visibility == View.VISIBLE){
                lenmeteredt_CCC.setText("")
                lencmedt_CCC.setText("")
                widthmeteredt_CCC.setText("")
                widthcmedt_CCC.setText("")
                depthmeteredt_CCC.setText("")
                depthcmedt_CCC.setText("")
            }
        }
        button_feetinch_CCC.setOnClickListener {
            showfeetinclay()
            button_feetinch_CCC.setBackgroundResource(R.drawable.spinnerstyle)
            button_metercm_CCC.setBackgroundResource(R.drawable.btnstyle)
            button_feetinch_CCC.setTextColor(Color.BLACK)
            button_metercm_CCC.setTextColor(Color.WHITE)
        }
        button_metercm_CCC.setOnClickListener {
            showmetercm()
            button_feetinch_CCC.setBackgroundResource(R.drawable.btnstyle)
            button_metercm_CCC.setBackgroundResource(R.drawable.spinnerstyle)
            button_metercm_CCC.setTextColor(Color.BLACK)
            button_feetinch_CCC.setTextColor(Color.WHITE)
        }
        imgback_CCC.setOnClickListener {
            var intent = Intent(this@Cement_Concrete_Calculator, Home_Screen::class.java)
            startActivity(intent)
        }
    }

    fun showfeetinclay() {
        linearlayfeetinch_CCC.visibility = View.VISIBLE
        linearlaymetercm_CCC.visibility = View.INVISIBLE

    }
    fun showmetercm() {
        linearlayfeetinch_CCC.visibility = View.INVISIBLE
        linearlaymetercm_CCC.visibility = View.VISIBLE
    }
    fun showitemcalculated() {

        linearlayall_CCC.visibility = View.VISIBLE
        var selecteditem = spinner_CCC.selectedItem.toString()

        if (linearlayfeetinch_CCC.visibility == View.VISIBLE) {


            var total_length_feet = (lenfeetedt_CCC.text.toString().toFloatOrNull()
                ?: 0f) + (leninchedt_CCC.text.toString().toFloatOrNull() ?: 0f) / 12
            var total_width_feet = (widthfeetedt_CCC.text.toString().toFloatOrNull()
                ?: 0f) + (widthinchedt_CCC.text.toString().toFloatOrNull() ?: 0f) / 12
            var total_depth_feet = (depthfeetedt_CCC.text.toString().toFloatOrNull()
                ?: 0f) + (depthinchedt_CCC.text.toString().toFloatOrNull() ?: 0f) / 12

            var feetcube = total_length_feet * total_width_feet * total_depth_feet
            var feetcube_formatted = String.format("%.2f",feetcube)
            var metercube = feetcube * 0.0283168f
            var metercube_formatted = String.format("%.2f",metercube)

            txttotalvalue_CCC.setText(metercube_formatted.toString() + " m\u00b3 or " + feetcube_formatted.toString()+" ft³")

            val wet_volume = metercube + (metercube * 0.524f)

            when (selecteditem) {
                "M20 (1:1.5:3)" -> {
                    // calculation
                    val cement = 1f/5.5f * wet_volume
                    val no_of_cementbags = cement/0.035f
                    val sand = 1.5f/5.5f * wet_volume
                    val sand_in_kg = sand * 1550f
                    val sand_in_ton = sand_in_kg / 1000f
                    val aggregate = 3 /5.5f * wet_volume
                    val aggregate_in_kg = aggregate * 1350f
                    val aggregate_in_ton = aggregate_in_kg / 1000f
                    updateMaterialList(no_of_cementbags.toFloat(), sand_in_ton.toFloat(), aggregate_in_ton.toFloat())
                }

                "M15 (1:2:4)" -> {
                    val cement = 1f/7f * wet_volume
                    val no_of_cementbags = cement/0.035f
                    val sand = 2f/7f * wet_volume
                    val sand_in_kg = sand * 1550f
                    val sand_in_ton = sand_in_kg / 1000f
                    val aggregate = 4f/7f * wet_volume
                    val aggregate_in_kg = aggregate * 1350f
                    val aggregate_in_ton = aggregate_in_kg / 1000f
                    updateMaterialList(no_of_cementbags.toFloat(), sand_in_ton.toFloat(), aggregate_in_ton.toFloat())
                }

                "M10 (1:3:6)" -> {
                    val cement = 1f/10f * wet_volume
                    val no_of_cementbags = cement/0.035f
                    val sand = 3f/10f * wet_volume
                    val sand_in_kg = sand * 1550f
                    val sand_in_ton = sand_in_kg / 1000f
                    val aggregate = 6f/10f * wet_volume
                    val aggregate_in_kg = aggregate * 1350f
                    val aggregate_in_ton = aggregate_in_kg / 1000f
                    updateMaterialList(no_of_cementbags.toFloat(), sand_in_ton.toFloat(), aggregate_in_ton.toFloat())
                }

                "M7.5 (1:4:8)" -> {
                    val cement = 1f/13f * wet_volume
                    val no_of_cementbags = cement/0.035f
                    val sand = 4f/13f * wet_volume
                    val sand_in_kg = sand * 1550f
                    val sand_in_ton = sand_in_kg / 1000f
                    val aggregate = 8f /13f * wet_volume
                    val aggregate_in_kg = aggregate * 1350f
                    val aggregate_in_ton = aggregate_in_kg / 1000f
                    updateMaterialList(no_of_cementbags.toFloat(), sand_in_ton.toFloat(), aggregate_in_ton.toFloat())
                }
            }
        }
        if (linearlaymetercm_CCC.visibility == View.VISIBLE){

            var total_length_meter = (lenmeteredt_CCC.text.toString().toFloatOrNull()
                ?: 0f) + (lencmedt_CCC.text.toString().toFloatOrNull() ?: 0f) / 100
            var total_width_meter = (widthmeteredt_CCC.text.toString().toFloatOrNull()
                ?: 0f) + (widthcmedt_CCC.text.toString().toFloatOrNull() ?: 0f) / 100
            var total_depth_meter = (depthmeteredt_CCC.text.toString().toFloatOrNull()
                ?: 0f) + (depthcmedt_CCC.text.toString().toFloatOrNull() ?: 0f) / 100

            var metercube = total_length_meter * total_width_meter * total_depth_meter
            var metercube_formatted = String.format("%.2f",metercube)
            var feetcube = metercube * 35.3147
            var feetcube_formatted = String.format("%.2f",feetcube)

            val wet_volume = metercube + (metercube * 0.524)
            txttotalvalue_CCC.setText(metercube_formatted.toString() + " m³ or " + feetcube_formatted.toString()+ " ft³")

            when (selecteditem) {
                "M20 (1:1.5:3)" -> {
                    // calculation
                    val cement = 1f/5.5f * wet_volume
                    val no_of_cementbags = cement/0.035f
                    val sand = 1.5f/5.5f * wet_volume
                    val sand_in_kg = sand * 1550f
                    val sand_in_ton = sand_in_kg / 1000f
                    val aggregate = 3 /5.5f * wet_volume
                    val aggregate_in_kg = aggregate * 1350f
                    val aggregate_in_ton = aggregate_in_kg / 1000f
                    updateMaterialList(no_of_cementbags.toFloat(), sand_in_ton.toFloat(), aggregate_in_ton.toFloat())
                }

                "M15 (1:2:4)" -> {
                    val cement = 1f/7f * wet_volume
                    val no_of_cementbags = cement/0.035f
                    val sand = 2f/7f * wet_volume
                    val sand_in_kg = sand * 1550f
                    val sand_in_ton = sand_in_kg / 1000f
                    val aggregate = 4f/7f * wet_volume
                    val aggregate_in_kg = aggregate * 1350f
                    val aggregate_in_ton = aggregate_in_kg / 1000f
                    updateMaterialList(no_of_cementbags.toFloat(), sand_in_ton.toFloat(), aggregate_in_ton.toFloat())
                }

                "M10 (1:3:6)" -> {
                    val cement = 1f/10f * wet_volume
                    val no_of_cementbags = cement/0.035f
                    val sand = 3f/10f * wet_volume
                    val sand_in_kg = sand * 1550f
                    val sand_in_ton = sand_in_kg / 1000f
                    val aggregate = 6f/10f * wet_volume
                    val aggregate_in_kg = aggregate * 1350f
                    val aggregate_in_ton = aggregate_in_kg / 1000f
                    updateMaterialList(no_of_cementbags.toFloat(), sand_in_ton.toFloat(), aggregate_in_ton.toFloat())
                }

                "M7.5 (1:4:8)" -> {
                    val cement = 1f/13f * wet_volume
                    val no_of_cementbags = cement/0.035f
                    val sand = 4f/13f * wet_volume
                    val sand_in_kg = sand * 1550f
                    val sand_in_ton = sand_in_kg / 1000f
                    val aggregate = 8f /13f * wet_volume
                    val aggregate_in_kg = aggregate * 1350f
                    val aggregate_in_ton = aggregate_in_kg / 1000f
                    updateMaterialList(no_of_cementbags.toFloat(), sand_in_ton.toFloat(), aggregate_in_ton.toFloat())
                }
            }
        }
    }

    fun invisiblelayout() {
        linearlayall_CCC.visibility = View.INVISIBLE

    }
    fun check(): Boolean {
        var isvalid = true

        var lengthfeet = lenfeetedt_CCC.text.toString()
        var lengthinch = leninchedt_CCC.text.toString()
        var widthfeet = widthfeetedt_CCC.text.toString()
        var widthinch = widthinchedt_CCC.text.toString()
        var depthfeet = depthfeetedt_CCC.text.toString()
        var depthinch = depthinchedt_CCC.text.toString()

        val lengthfeet_float = lenfeetedt_CCC.text.toString().toFloatOrNull()
        val lengthinch_float = leninchedt_CCC.text.toString().toFloatOrNull()
        val widthfeet_float = widthfeetedt_CCC.text.toString().toFloatOrNull()
        val widthinch_float = widthinchedt_CCC.text.toString().toFloatOrNull()
        val depthfeet_float = depthfeetedt_CCC.text.toString().toFloatOrNull()
        val depthinch_float = depthinchedt_CCC.text.toString().toFloatOrNull()

        if (linearlayfeetinch_CCC.visibility == View.VISIBLE) {


            if (lengthfeet.isEmpty()) {
                lenfeetlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                lenfeetlay_CCC.error = null
            }

            if (lengthinch.isEmpty() || lengthinch_float!! !in 0f..11f) {
                leninchlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                leninchlay_CCC.error = null
            }

            if (widthfeet.isEmpty()) {
                widthfeetlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                widthfeetlay_CCC.error = null
            }
            if (widthinch.isEmpty() || widthinch_float!! !in 0f..11f) {
                widthinchlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                widthinchlay_CCC.error = null
            }

            if (depthfeet.isEmpty()) {
                depthfeetlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                depthfeetlay_CCC.error = null
            }
            if (depthinch.isEmpty() || depthinch_float!! !in 0f..11f) {
                depthinchlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                depthinchlay_CCC.error = null
            }
        }
        if (linearlaymetercm_CCC.visibility == View.VISIBLE) {
            var lengthmeter = lenmeteredt_CCC.text.toString()
            var lengthcm = lencmedt_CCC.text.toString()
            var widthmeter = widthmeteredt_CCC.text.toString()
            var widthcm = widthcmedt_CCC.text.toString()
            var depthmeter = depthmeteredt_CCC.text.toString()
            var depthcm = depthcmedt_CCC.text.toString()

            val lengthmeter_float = lenmeteredt_CCC.text.toString().toFloatOrNull()
            val lengthcm_float = lencmedt_CCC.text.toString().toFloatOrNull()
            val widthmeter_float = widthmeteredt_CCC.text.toString().toFloatOrNull()
            val widthcm_float = widthcmedt_CCC.text.toString().toFloatOrNull()
            val depthmeter_float = depthmeteredt_CCC.text.toString().toFloatOrNull()
            val depthcm_float = depthcmedt_CCC.text.toString().toFloatOrNull()

            if (lengthmeter.isEmpty()) {
                lenmeterlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                lenmeterlay_CCC.error = null
            }

            if (lengthcm.isEmpty() || lengthcm_float!! !in 0f..99f) {
                lencmlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                lencmlay_CCC.error = null
            }

            if (widthmeter.isEmpty()) {
                widthmeterlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                widthmeterlay_CCC.error = null
            }
            if (widthcm.isEmpty() || widthcm_float!! !in 0f..99f) {
                widthcmlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                widthcmlay_CCC.error = null
            }

            if (depthmeter.isEmpty()) {
                depthmeterlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                depthmeterlay_CCC.error = null
            }
            if (depthcm.isEmpty() || depthcm_float!! !in 0f..99f) {
                depthcmlay_CCC.error = "please enter the value"
                isvalid = false
            } else {
                depthcmlay_CCC.error = null
            }

        }
        return isvalid
    }
    fun updateMaterialList(cement: Float, sand: Float, aggregate: Float) {
        val cementBags = cement.roundToInt()  // Example calculation for bags of cement
        val sandTons = sand.roundToInt()  // Example conversion to tons
        val aggregateTons = aggregate.roundToInt()  // Example conversion to tons

        Arrayimg_CCC        = arrayOf(R.drawable.cement1,R.drawable.brickwall1,R.drawable.blocks1)
        Arraytxt_CCC        = arrayOf("cement","sand","aggregate")
        Arraycalcu_CCC      = arrayOf(cementBags,sandTons,aggregateTons)
        ArrayUnit_CCC       = arrayOf("Bags","Ton","Ton")

        items1_CCC = mutableListOf()
        for (i in Arraytxt_CCC.indices) {
            val newItem = ListItem(Arrayimg_CCC[i], Arraytxt_CCC[i],Arraycalcu_CCC[i], ArrayUnit_CCC[i])
            items1_CCC.add(newItem)
        }
        val adapter = AdapterListview(this, items1_CCC)
        listview_CCC.adapter = adapter


        updatePieChart(cementBags.toFloat(), sandTons.toFloat(), aggregateTons.toFloat())


    }








    fun updatePieChart(cementValue: Float, sandValue: Float, aggregateValue: Float) {
        //piechart
        chartdata_CCC = ArrayList()
        chartdata_CCC.add(PieEntry(cementValue, "cement"))
        chartdata_CCC.add(PieEntry(sandValue, "Sand"))
        chartdata_CCC.add(PieEntry(aggregateValue, "Aggregate"))


        val dataSet_CCC = PieDataSet(chartdata_CCC, "Materails")
        dataSet_CCC.colors = listOf(
            Color.parseColor("#FF8A80"), // Aggregate
            Color.parseColor("#FF8A65"), // Cement
            Color.parseColor("#FFAB40"), // Steel

        )

        val data_CCC = PieData(dataSet_CCC)
        pieChart_CCC.data = data_CCC
        pieChart_CCC.description.isEnabled = false

        // Customize chart
        pieChart_CCC.holeRadius              = 58f
        pieChart_CCC.centerText              = "Materials"
        pieChart_CCC.isDrawHoleEnabled       = true
        pieChart_CCC.transparentCircleRadius = 61f
        pieChart_CCC.invalidate()
        pieChart_CCC.setDrawCenterText(true)
        pieChart_CCC.animateY(1400)
        pieChart_CCC.setHoleColor(R.color.white)
        pieChart_CCC.setTransparentCircleAlpha(110)

    }
}