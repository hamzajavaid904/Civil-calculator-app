package com.example.construction_calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

var costofsand          : Int =0
var costofsteel         : Int =0
var costofcement        : Int =0
var costaggregate       : Int =0
var costoffittings      : Int =0
var quantityofsand      : Int =0
var costoffinishers     : Int =0
var quantityofcement    : Int =0
var quantityofsteel     : Int =0
var quantityofpaint     : Int =0
var quantityofbricks    : Int =0
var quantityofflooring  : Int =0
var quantityofaggregate : Int =0
var firstmonthcost      : Int =0
var secondmonthcost     : Int =0
var thirdmonthcost      : Int =0
var fourthmonthcost     : Int =0
var fifthmonthcost      : Int =0
var sixthmonthcost      : Int =0
var  approximatecost    : Int =0
var quantityofmaterial  : Int =0
lateinit var btn             : Button
lateinit var txt1            : TextView
lateinit var bckimg          : ImageView
lateinit var barchart        : BarChart
lateinit var txtreset        : TextView
lateinit var txtappcc        : TextView
lateinit var listView1       : ListView
lateinit var listview2       : ListView
lateinit var listview3       : ListView
lateinit var roundchart      : PieChart
lateinit var Arrayimg        : Array<Int>
lateinit var Arraycalcu      : Array<Int>
lateinit var Arrayimgqom     : Array<Int>
lateinit var Arrayimgcolor   : Array<Int>
lateinit var Arraycalcuqom   : Array<Int>
lateinit var Arraycalcumon   : Array<Int>
lateinit var layout          : LinearLayout
lateinit var Arraytxt        : Array<String>
lateinit var Arraytxt_unit   : Array<String>
lateinit var Arraytxtqom     : Array<String>
lateinit var Arraytxtmonth   : Array<String>
lateinit var Arraytxtqomunit : Array<String>
lateinit var entries2        : ArrayList<BarEntry>
lateinit var chartdata       : ArrayList<PieEntry>
private lateinit var items1  : MutableList<ListItem>
private lateinit var items2  : MutableList<ListItem>
private lateinit var items3  : MutableList<ListItem>
lateinit var Arealay_CC    : TextInputLayout
lateinit var Areaedt_CC    : TextInputEditText
lateinit var costlay_CC    : TextInputLayout
lateinit var costedt_CC    : TextInputEditText


class Constrution_Cost : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.construction_cost)



        btn        = findViewById(R.id.btncal)
        txt1       = findViewById(R.id.txtqom)
        layout     = findViewById(R.id.linearlayout1)
        bckimg     = findViewById(R.id.backbtn)
        barchart   = findViewById(R.id.chart2)
        txtappcc   = findViewById(R.id.txtappCC)
        txtreset   = findViewById(R.id.txtreset)
        listView1  = findViewById(R.id.listviewCC)
        listview2  = findViewById(R.id.listviewCCQM)
        listview3  = findViewById(R.id.listviewbarchart)
        roundchart = findViewById(R.id.pieChart)
        Arealay_CC  = findViewById(R.id.txtinputlaybuilduparea)
        costlay_CC  = findViewById(R.id.txtinputlaycostpersqf)
        Areaedt_CC = findViewById(R.id.edtbuilduparea)
        costedt_CC  = findViewById(R.id.edtcostpersqf)

        btn.setOnClickListener {
            val builduparea_sqf = Areaedt_CC.text.toString()
            val costper_sqf = costedt_CC.text.toString()
            var isvalid = true
            if (builduparea_sqf.isEmpty()) {
                Arealay_CC.error = "please enter the value"
                isvalid = false
            } else {
                Arealay_CC.error = null
            }
            if (costper_sqf.isEmpty()) {
                costlay_CC.error = "please enter the value"
                isvalid = false
            } else {
                costlay_CC.error = null
            }

            if (isvalid == true) {
                layout.visibility = View.VISIBLE


                val Area = builduparea_sqf.toInt()
                val cost = costper_sqf.toInt()

                quantityofsand = (Area * 0.816).toInt()
                quantityofsteel = Area * 4
                quantityofpaint = (Area * 0.18).toInt()
                quantityofbricks = Area * 8
                quantityofcement = (Area * 0.4).toInt()
                quantityofflooring = (Area * 1.3).toInt()
                quantityofaggregate = (Area *0.608).toInt()

                costofsand = ((12.3/100) * approximatecost).toInt()
                costofsteel = ((24.6 / 100) * approximatecost).toInt()
                costofcement = ((16.4 / 100) * approximatecost).toInt()
                costaggregate = ((7.4 / 100) * approximatecost).toInt()
                costoffittings = ((22.8 / 100) * approximatecost).toInt()
                costoffinishers = ((16.5 / 100) * approximatecost).toInt()


                firstmonthcost = ((21.9 / 100)* approximatecost).toInt()
                thirdmonthcost = ((11.1 / 100) * approximatecost).toInt()
                fifthmonthcost = ((17.8 / 100) * approximatecost).toInt()
                sixthmonthcost = ((13.9 / 100) * approximatecost).toInt()
                fourthmonthcost = ((16.9 / 100) * approximatecost).toInt()
                secondmonthcost = ((18.4 / 100) * approximatecost).toInt()

                approximatecost = Area * cost
                quantityofmaterial = Area

                txtappcc.setText("Approximate Cost :" + approximatecost)
                txt1.setText("Quantaty of materials required for " + quantityofmaterial + " Ft²")


                Arrayimg = arrayOf(
                    R.drawable.airconditioner,
                    R.drawable.areagraph1,
                    R.drawable.blocks1,
                    R.drawable.blocks1,
                    R.drawable.blocks1,
                    R.drawable.blocks1
                )
                Arraytxt = arrayOf("cement(16.4%)", "Sand(12.3%)", "aggregate(7.4%)", "Steel(24.6%)", "Finishers(16.5%)(Paint(4.1%)+Tiles(8.0%)+Bricks(4.4%))", "Fittings(22.8%)(Window(3.0%)+Doors(3.4%)Plumbing(5.5%)+Electrical(6.8%)+Sanitary(4.1%))")
                Arraycalcu = arrayOf(costofcement, costofsand, costaggregate, costofsteel, costoffinishers, costoffittings)
                Arraytxt_unit = arrayOf("Rs","Rs","Rs","Rs","Rs","Rs")
                Arraytxtqom = arrayOf("cement", "Sand", "aggregate", "Steel", "Paint", "Brikcs", "Flooring")
                Arrayimgqom = arrayOf(
                    R.drawable.airconditioner,
                    R.drawable.airconditioner,
                    R.drawable.areagraph1,
                    R.drawable.blocks1,
                    R.drawable.blocks1,
                    R.drawable.blocks1,
                    R.drawable.blocks1
                )
                Arraycalcuqom = arrayOf(
                    quantityofcement,
                    quantityofsand,
                    quantityofaggregate,
                    quantityofsteel,
                    quantityofpaint,
                    quantityofbricks,
                    quantityofflooring
                )
                Arraycalcumon = arrayOf(
                    firstmonthcost,
                    secondmonthcost,
                    thirdmonthcost,
                    fourthmonthcost,
                    fifthmonthcost,
                    sixthmonthcost
                )
                Arrayimgcolor = arrayOf(
                    R.drawable.month1,
                    R.drawable.month2,
                    R.drawable.month3,
                    R.drawable.month4,
                    R.drawable.month5,
                    R.drawable.month6
                )
                Arraytxtmonth = arrayOf(
                    "1\u02E2\u1D57 Month(21.9%)",
                    "2\u207F\u1D48 Month(18.4%)",
                    "3\u02B3\u1D48 Month(11.1%)",
                    "4\u1D57\u02B0 Month(16.9%)",
                    "5\u1D57\u02B0 Month(17.8%)",
                    "6\u1D57\u02B0 Month(13.9%)"
                )
                Arraytxtqomunit = arrayOf("Bags", "Tan", "Tan", "Kg", "Ltrs", "Pcs", "Ft\u00B2")

                items1 = mutableListOf()
                for (i in Arrayimg.indices) {
                    val newItem = ListItem(Arrayimg[i], Arraytxt[i], Arraycalcu[i], Arraytxt_unit[i])
                    items1.add(newItem)
                }
                val adapter = AdapterListview(this, items1)
                listView1.adapter = adapter

                // Notify the adapter to update the ListView
                adapter.notifyDataSetChanged()

                items2 = mutableListOf()
                for (i in Arraytxtqom.indices) {
                    val newItem2 = ListItem(Arrayimgqom[i], Arraytxtqom[i], Arraycalcuqom[i], Arraytxtqomunit[i])
                    items2.add(newItem2)
                }
                val adapter2 = AdapterListview(this, items2)
                listview2.adapter = adapter2

                // Notify the adapter to update the ListView
                adapter2.notifyDataSetChanged()

                items3 = mutableListOf()
                for (i in Arraytxt.indices) {
                    val newItem3 = ListItem(Arrayimgcolor[i], Arraytxtmonth[i], Arraycalcumon[i], "R.s")
                    items3.add(newItem3)
                }
                val adapter3 = Adapterlistviewmonth(this, items3)
                listview3.adapter = adapter3

                // Notify the adapter to update the ListView
                adapter3.notifyDataSetChanged()

                //piechart
                chartdata = ArrayList()
                chartdata.add(PieEntry(costofsand.toFloat(), "Sand"))
                chartdata.add(PieEntry(costofsteel.toFloat(), "Steel"))
                chartdata.add(PieEntry(costofcement.toFloat(), "Cement"))
                chartdata.add(PieEntry(costoffittings.toFloat(), "Fitting"))
                chartdata.add(PieEntry(costaggregate.toFloat(), "Aggregate"))
                chartdata.add(PieEntry(costoffinishers.toFloat(), "Finisher"))

                val dataSet = PieDataSet(chartdata, "Construction Cost")
                dataSet.colors = listOf(
                    Color.parseColor("#FF8A80"), // Aggregate
                    Color.parseColor("#FF8A65"), // Cement
                    Color.parseColor("#FFAB40"), // Steel
                    Color.parseColor("#C5E1A5"), // Fitting
                    Color.parseColor("#81D4FA"), // Sand
                    Color.parseColor("#A1887F")  // Finisher
                )

                val data = PieData(dataSet)
                roundchart.data = data
                roundchart.description.isEnabled = false

                // Customize chart
                roundchart.holeRadius = 58f
                roundchart.centerText = "Construction Cost"
                roundchart.isDrawHoleEnabled = true
                roundchart.transparentCircleRadius = 61f
                roundchart.invalidate()
                roundchart.setDrawCenterText(true)
                roundchart.animateY(1400)
                roundchart.setHoleColor(R.color.white)
                roundchart.setTransparentCircleAlpha(110)

                //barchart
                entries2 = ArrayList()
                entries2.add(BarEntry(1f, firstmonthcost.toFloat()))
                entries2.add(BarEntry(2f, secondmonthcost.toFloat()))
                entries2.add(BarEntry(3f, thirdmonthcost.toFloat()))
                entries2.add(BarEntry(4f, fourthmonthcost.toFloat()))
                entries2.add(BarEntry(5f, fifthmonthcost.toFloat()))
                entries2.add(BarEntry(6f, sixthmonthcost.toFloat()))

                val barDataSet = BarDataSet(entries2, "Construction Cost1")
                // Set colors for the bars
                barDataSet.colors = listOf(
                    Color.parseColor("#FF8A80"), // Aggregate
                    Color.parseColor("#FF8A65"), // Cement
                    Color.parseColor("#FFAB40"), // Steel
                    Color.parseColor("#C5E1A5"), // Fitting
                    Color.parseColor("#81D4FA"), // Sand
                    Color.parseColor("#A1887F")
                )


                //  barDataSet.setDrawValues(true)

                // Prepare BarData with the BarDataSet
                val data2 = BarData(barDataSet)
                // Set data to the chart
                barchart.data = data2
                data2.barWidth = 0.4f

                // Customize the chart
                val description = Description()
                description.text = "Cost Over Time"
                barchart.description.isEnabled = true

                barchart.animateY(1000) // Animation
                barchart.invalidate() // Refresh the chart
            }
        }
        bckimg.setOnClickListener {
            val intent = Intent(this@Constrution_Cost,Home_Screen::class.java)
            startActivity(intent)
        }
        txtreset.setOnClickListener{
            Areaedt_CC.setText("")
            costedt_CC.setText("")
           layout.visibility = View.INVISIBLE
        }

    }

}

