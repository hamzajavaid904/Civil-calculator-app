package com.example.construction_calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

lateinit var imgback_FC          : ImageView
lateinit var button_feetinch_FC   : Button
lateinit var button_metercm_FC    : Button
lateinit var button_calculator_FC : Button
lateinit var button_reset_FC      : Button
lateinit var linearlayfeetinch_FC : LinearLayout
lateinit var linearlaymetercm_FC  : LinearLayout
lateinit var linearlayall_FC      : LinearLayout
lateinit var listview_FC      : ListView
lateinit var pieChart_FC      : PieChart
lateinit var txttotalArea_FC : TextView
lateinit var lenfeetlay_FC    : TextInputLayout
lateinit var lenfeetedt_FC    : TextInputEditText
lateinit var leninchlay_FC    : TextInputLayout
lateinit var leninchedt_FC    : TextInputEditText
lateinit var widthfeetlay_FC  : TextInputLayout
lateinit var widthfeetedt_FC  : TextInputEditText
lateinit var widthinchlay_FC  : TextInputLayout
lateinit var widthinchedt_FC  : TextInputEditText
lateinit var lenfeetlay_tilesFC  : TextInputLayout
lateinit var lenfeetedt_tilesFC  : TextInputEditText
lateinit var widthfeetlay_tilesFC  : TextInputLayout
lateinit var widthfeetedt_tilesFC  : TextInputEditText
lateinit var lenmeterlay_FC    : TextInputLayout
lateinit var lenmeteredt_FC    : TextInputEditText
lateinit var lencmlay_FC    : TextInputLayout
lateinit var lencmedt_FC    : TextInputEditText
lateinit var widthmeterlay_FC  : TextInputLayout
lateinit var widthmeteredt_FC  : TextInputEditText
lateinit var widthcmlay_FC  : TextInputLayout
lateinit var widthcmedt_FC  : TextInputEditText



class Flooring_Calculator : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flooring_calculator)

        imgback_FC = findViewById(R.id.backbtnFC)
        button_feetinch_FC = findViewById(R.id.buttonfeetinchFC)
        button_metercm_FC = findViewById(R.id.buttonmetercmFC)
        button_calculator_FC = findViewById(R.id.buttoncalculatorFC)
        button_reset_FC = findViewById(R.id.buttonresetFC)
        linearlayfeetinch_FC = findViewById(R.id.linearlayoutfeetinchFC)
        linearlaymetercm_FC = findViewById(R.id.linearlayoutmetercmFC)
        linearlayall_FC = findViewById(R.id.linearlayallFC)
        listview_FC = findViewById(R.id.listviewFC)
        pieChart_FC = findViewById(R.id.piechartFC)
        txttotalArea_FC = findViewById(R.id.txttotalareaFC)
        lenfeetlay_FC = findViewById(R.id.txtinputlaylenfeetFC)
        lenfeetedt_FC = findViewById(R.id.edtlenfeetFC)
        leninchlay_FC = findViewById(R.id.txtinputlayleninchesFC)
        leninchedt_FC = findViewById(R.id.edtleninchesFC)
        widthfeetlay_FC = findViewById(R.id.txtinputlaywidthfeetFC)
        widthfeetedt_FC = findViewById(R.id.edtwidthfeetFC)
        widthinchlay_FC = findViewById(R.id.txtinputlaywidthinchesFC)
        widthinchedt_FC = findViewById(R.id.edtwidthinchesFC)
        lenfeetlay_tilesFC = findViewById(R.id.txtinputlaylenfeettilesFC)
        lenfeetedt_tilesFC = findViewById(R.id.edtlenfeettilesFC)
        widthfeetlay_tilesFC = findViewById(R.id.txtinputlaywidthfeettilesFC)
        widthfeetedt_tilesFC = findViewById(R.id.edtwidthfeettilesFC)
        lenmeterlay_FC = findViewById(R.id.txtinputlaylenmeterFC)
        lenmeteredt_FC = findViewById(R.id.edtlenmeterFC)
        lencmlay_FC = findViewById(R.id.txtinputlaylencmFC)
        lencmedt_FC = findViewById(R.id.edtlencmFC)
        widthmeterlay_FC = findViewById(R.id.txtinputlaywidthmeterFC)
        widthmeteredt_FC = findViewById(R.id.edtwidthmeterFC)
        widthcmlay_FC = findViewById(R.id.txtinputlaywidthcmFC)
        widthcmedt_FC = findViewById(R.id.edtwidthcmFC)

        imgback_FC.setOnClickListener {
            var intent = Intent(this@Flooring_Calculator, Home_Screen::class.java)
            startActivity(intent)
        }
        button_feetinch_FC.setOnClickListener {
            showfeetinclayFC()

        }
        button_metercm_FC.setOnClickListener {
            showmetercmFC()

        }
        button_calculator_FC.setOnClickListener {
            if (checkFC()) {
                showitemcalculatedFC()
            }
        }
        button_reset_FC.setOnClickListener {
            invisiblelayoutFC()

        }
    }

    fun showfeetinclayFC() {
        linearlayfeetinch_FC.visibility = View.VISIBLE
        linearlaymetercm_FC.visibility = View.INVISIBLE
        button_feetinch_FC.setBackgroundResource(R.drawable.spinnerstyle)
        button_metercm_FC.setBackgroundResource(R.drawable.btnstyle)
        button_feetinch_FC.setTextColor(Color.BLACK)
        button_metercm_FC.setTextColor(Color.WHITE)
    }
    fun showmetercmFC() {
        linearlayfeetinch_FC.visibility = View.INVISIBLE
        linearlaymetercm_FC.visibility = View.VISIBLE
        button_feetinch_FC.setBackgroundResource(R.drawable.btnstyle)
        button_metercm_FC.setBackgroundResource(R.drawable.spinnerstyle)
        button_metercm_FC.setTextColor(Color.BLACK)
        button_feetinch_FC.setTextColor(Color.WHITE)
    }
    fun checkFC(): Boolean {
        var isvalid = true
        var lengthfeet = lenfeetedt_FC.text.toString()
        var lengthinch = leninchedt_FC.text.toString()
        var widthfeet = widthfeetedt_FC.text.toString()
        var widthinch = widthinchedt_FC.text.toString()

        var lengthinch_float = leninchedt_FC.text.toString().toFloatOrNull()
        var widthinch_float = widthinchedt_FC.text.toString().toFloatOrNull()

        var lengthfeet_tiles = lenfeetedt_tilesFC.text.toString()
        var widthfeet_tiles = widthfeetedt_tilesFC.text.toString()

        if (lengthfeet_tiles.isEmpty()) {
            lenfeetlay_tilesFC.error = "please enter the value"
            isvalid = false
        } else {
            lenfeetlay_tilesFC.error = null
        }
        if (widthfeet_tiles.isEmpty()) {
            widthfeetlay_tilesFC.error = "please enter the value"
            isvalid = false
        } else {
            widthfeetlay_tilesFC.error = null
        }



        if (linearlayfeetinch_FC.visibility == View.VISIBLE) {
            if (lengthfeet.isEmpty()) {
                lenfeetlay_FC.error = "please enter the value"
                isvalid = false
            } else {
                lenfeetlay_FC.error = null
            }

            if (lengthinch.isEmpty() || lengthinch_float!! !in 0f..11f) {
                leninchlay_FC.error = "please enter the value"
                isvalid = false
            } else {
                leninchlay_FC.error = null
            }

            if (widthfeet.isEmpty()) {
                widthfeetlay_FC.error = "please enter the value"
                isvalid = false
            } else {
                widthfeetlay_FC.error = null
            }
            if (widthinch.isEmpty() || widthinch_float!! !in 0f..11f) {
                widthinchlay_FC.error = "please enter the value"
                isvalid = false
            } else {
                widthinchlay_FC.error = null
            }
        }
        if (linearlaymetercm_FC.visibility == View.VISIBLE) {
            var lengthmeter = lenmeteredt_FC.text.toString()
            var lengthcm = lencmedt_FC.text.toString()
            var widthmeter = widthmeteredt_FC.text.toString()
            var widthcm = widthcmedt_FC.text.toString()

            val lengthcm_float = lencmedt_FC.text.toString().toFloatOrNull()
            val widthcm_float = widthcmedt_FC.text.toString().toFloatOrNull()

            if (lengthmeter.isEmpty()) {
                lenmeterlay_FC.error = "please enter the value"
                isvalid = false
            } else {
                lenmeterlay_FC.error = null

            }

            if (lengthcm.isEmpty() || lengthcm_float!! !in 0f..99f) {
                lencmlay_FC.error = "please enter the value"
                isvalid = false
            } else {
                lencmlay_FC.error = null
            }

            if (widthmeter.isEmpty()) {
                widthmeterlay_FC.error = "please enter the value"
                isvalid = false
            } else {
                widthmeterlay_FC.error = null
            }
            if (widthcm.isEmpty() || widthcm_float!! !in 0f..99f) {
                widthcmlay_FC.error = "please enter the value"
                isvalid = false
            } else {
                widthcmlay_FC.error = null
            }
        }
        return isvalid
    }
    fun invisiblelayoutFC() {
        linearlayall_FC.visibility = View.INVISIBLE
        if (linearlayfeetinch_FC.visibility == View.VISIBLE) {
            lenfeetedt_FC.setText("")
            leninchedt_FC.setText("")
            widthfeetedt_FC.setText("")
            widthinchedt_FC.setText("")
            lenfeetedt_tilesFC.setText("")
            widthfeetedt_tilesFC.setText("")

        }
        if (linearlaymetercm_FC.visibility == View.VISIBLE) {
            lenmeteredt_FC.setText("")
            lencmedt_FC.setText("")
            widthmeteredt_FC.setText("")
            widthcmedt_FC.setText("")
            lenfeetedt_tilesFC.setText("")
            widthfeetedt_tilesFC.setText("")
        }
    }
    fun showitemcalculatedFC() {
        linearlayall_FC.visibility = View.VISIBLE
        if (linearlayfeetinch_FC.visibility == View.VISIBLE) {
            var total_length_FC = (lenfeetedt_FC.text.toString().toFloatOrNull()
                ?: 0f) + (leninchedt_FC.text.toString().toFloatOrNull() ?: 0f) / 10
            var total_width_FC = (widthfeetedt_FC.text.toString().toFloatOrNull()
                ?: 0f) + (widthinchedt_FC.text.toString().toFloatOrNull() ?: 0f) / 10


            var Area_feetSquare = total_length_FC * total_width_FC //calculation for feet cube
            var feetSquare_formatted = String.format("%.2f", Area_feetSquare)
            var Area_meterSquare = Area_feetSquare * 0.092903  //calculation for meter cube
            var meterSquare_formatted = String.format("%.2f", Area_meterSquare)

            txttotalArea_FC.setText(meterSquare_formatted + " m²" +" or "+ feetSquare_formatted + " ft²")


            var Area_of_tiles = lenfeetedt_tilesFC.text.toString().toFloatOrNull()!! * widthfeetedt_tilesFC.text.toString().toFloatOrNull()!!
            var tiles_reqiured = feetSquare_formatted.toString().toFloatOrNull()!! / Area_of_tiles

            var volume_with_bedding = Area_meterSquare * 0.07

            var cement_volume = (volume_with_bedding * 1)/7
            var no_of_cement_bags = cement_volume / 0.035


            var amount_of_sand = (volume_with_bedding * 6 /7)
            var amountsand  = amount_of_sand * 1550
            var amountsand_intons = amountsand / 1000


            val list1Data = ArrayList<HashMap<String, String>>()

            val item1 = HashMap<String, String>()
            item1["image"] = R.drawable.wood1.toString()
            item1["name"] = "tiles"
            item1["value"] = "%.1f".format(tiles_reqiured)
            item1["unit"] = "No."
            list1Data.add(item1)

           val item2 = HashMap<String, String>()
            item2["image"] = R.drawable.cement1.toString()
            item2["name"] = "cement"
            item2["value"] = "%.2f".format(no_of_cement_bags)
            item2["unit"] = "Bags"
            list1Data.add(item2)

            val item3 = HashMap<String, String>()
            item3["image"] = R.drawable.brickwall1.toString()
            item3["name"] = "sand"
            item3["value"] = "%.2f".format(amountsand_intons)
            item3["unit"] = "Ton"
            list1Data.add(item3)

            val from = arrayOf("image", "name","value","unit")
            val to = intArrayOf(R.id.imagefc, R.id.name, R.id.value,R.id.unit)

            val adapter_fc = SimpleAdapter(this, list1Data, R.layout.list_item_fc, from, to)
            listview_FC.adapter = adapter_fc

            chartdata = ArrayList()
            chartdata.add(PieEntry(no_of_cement_bags.toFloat(), "cement"))
            chartdata.add(PieEntry(amountsand_intons.toFloat(), "Sand"))


            val dataSet = PieDataSet(chartdata, "Construction Cost")
            dataSet.colors = listOf(
                Color.parseColor("#FF8A80"), // Aggregate
                Color.parseColor("#FF8A65"), // Cement
            )
            val data = PieData(dataSet)
            pieChart_FC.data = data
            pieChart_FC.description.isEnabled = false

            // Customize chart
            pieChart_FC.holeRadius              = 58f
            pieChart_FC.centerText              = "Construction Cost"
            pieChart_FC.isDrawHoleEnabled       = true
            pieChart_FC.transparentCircleRadius = 61f
            pieChart_FC.invalidate()
            pieChart_FC.setDrawCenterText(true)
            pieChart_FC.animateY(1400)
            pieChart_FC.setHoleColor(R.color.white)
            pieChart_FC.setTransparentCircleAlpha(110)


        }
      if (linearlaymetercm_FC.visibility == View.VISIBLE) {
          var total_length_FC = (lenmeteredt_FC.text.toString().toFloatOrNull()
              ?: 0f) + (lencmedt_FC.text.toString().toFloatOrNull() ?: 0f) / 10
          var total_width_FC = (widthmeteredt_FC.text.toString().toFloatOrNull()
              ?: 0f) + (widthcmedt_FC.text.toString().toFloatOrNull() ?: 0f) / 10


          var Area_meterSquare = total_length_FC * total_width_FC //calculation for feet cube
          var meterSquare_formatted = String.format("%.2f", Area_meterSquare)
          var Area_feetSquare = Area_meterSquare * 10.7639  //calculation for meter cube
          var feetSquare_formatted = String.format("%.2f", Area_feetSquare)

          txttotalArea_FC.setText(feetSquare_formatted + " ft²" + " or " + meterSquare_formatted + " m²")


          var Area_of_tiles = lenfeetedt_tilesFC.text.toString()
              .toFloatOrNull()!! * widthfeetedt_tilesFC.text.toString().toFloatOrNull()!!
          var tiles_reqiured = feetSquare_formatted.toString().toFloatOrNull()!! / Area_of_tiles

          var volume_with_bedding = Area_meterSquare * 0.07

          var cement_volume = (volume_with_bedding * 1) / 7
          var no_of_cement_bags = cement_volume / 0.035


          var amount_of_sand = (volume_with_bedding * 6 / 7)
          var amountsand = amount_of_sand * 1550
          var amountsand_intons = amountsand / 1000


          val list1Data = ArrayList<HashMap<String, String>>()

          val item1 = HashMap<String, String>()
          item1["image"] = R.drawable.wood1.toString()
          item1["name"] = "tiles"
          item1["value"] = "%.1f".format(tiles_reqiured)
          item1["unit"] = "No."
          list1Data.add(item1)

          val item2 = HashMap<String, String>()
          item2["image"] = R.drawable.cement1.toString()
          item2["name"] = "cement"
          item2["value"] = "%.2f".format(no_of_cement_bags)
          item2["unit"] = "Bags"
          list1Data.add(item2)

          val item3 = HashMap<String, String>()
          item3["image"] = R.drawable.brickwall1.toString()
          item3["name"] = "sand"
          item3["value"] = "%.2f".format(amountsand_intons)
          item3["unit"] = "Ton"
          list1Data.add(item3)

          val from = arrayOf("image", "name", "value", "unit")
          val to = intArrayOf(R.id.imagefc, R.id.name, R.id.value, R.id.unit)

          val adapter_fc = SimpleAdapter(this, list1Data, R.layout.list_item_fc, from, to)
          listview_FC.adapter = adapter_fc

          chartdata = ArrayList()
          chartdata.add(PieEntry(no_of_cement_bags.toFloat(), "cement"))
          chartdata.add(PieEntry(amountsand_intons.toFloat(), "sand"))


          val dataSet = PieDataSet(chartdata, "Construction Cost")
          dataSet.colors = listOf(
              Color.parseColor("#FF8A50"), // Aggregate
              Color.parseColor("#FF1A65"), // Cement
          )
          val data = PieData(dataSet)
          pieChart_FC.data = data
          pieChart_FC.description.isEnabled = false

          // Customize chart
          pieChart_FC.holeRadius = 58f
          pieChart_FC.centerText = "Construction Cost"
          pieChart_FC.isDrawHoleEnabled = true
          pieChart_FC.transparentCircleRadius = 61f
          pieChart_FC.invalidate()
          pieChart_FC.setDrawCenterText(true)
          pieChart_FC.animateY(1400)
          pieChart_FC.setHoleColor(R.color.white)
          pieChart_FC.setTransparentCircleAlpha(110)

      }
}
}