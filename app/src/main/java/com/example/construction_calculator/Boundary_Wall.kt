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
import android.widget.ListView
import android.widget.SimpleAdapter
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.math.roundToLong

lateinit var button_reset_BW                 : Button
lateinit var button_feetinch_BW              : Button
lateinit var button_metercm_BW               : Button
lateinit var button_calculator_BW            : Button
lateinit var imgback_BW                      : ImageView
lateinit var listview_spaceBW                : ListView
lateinit var listview_nospaceBW              : ListView
lateinit var linearlayall_BW                 : LinearLayout
lateinit var linearlaymetercm_BW             : LinearLayout
lateinit var linearlayfeetinch_BW            : LinearLayout
lateinit var lencmlay_precastwallBW          : TextInputLayout
lateinit var lenfeetlay_precastwallBW        : TextInputLayout
lateinit var lencmlay_horizontalbarBW        : TextInputLayout
lateinit var leninchlay_precastwallBW        : TextInputLayout
lateinit var lenmeterlay_precastwallBW       : TextInputLayout
lateinit var hieghtcmlay_precastwallBW       : TextInputLayout
lateinit var leninchlay_horizontalbarBW      : TextInputLayout
lateinit var lenfeetlay_horizontalbarBW      : TextInputLayout
lateinit var hieghtinchlay_precastwallBW     : TextInputLayout
lateinit var hieghtcmlay_horizontalbarBW     : TextInputLayout
lateinit var lenmeterlay_horizontalbarBW     : TextInputLayout
lateinit var hieghtfeetlay_precastwallBW     : TextInputLayout
lateinit var hieghtmeterlay_precastwallBW    : TextInputLayout
lateinit var hieghtinchlay_horizontalbarBW   : TextInputLayout
lateinit var hieghtfeetlay_horizontalbarBW   : TextInputLayout
lateinit var hieghtmeterlay_horizontalbarBW  : TextInputLayout

lateinit var lencmedt_precastwallBW            : TextInputEditText
lateinit var lencmedt_horizontalbarBW          : TextInputEditText
lateinit var lenfeetedt_precastwallBW          : TextInputEditText
lateinit var leninchedt_precastwallBW          : TextInputEditText
lateinit var hieghtcmedt_precastwallBW         : TextInputEditText
lateinit var lenmeteredt_precastwallBW         : TextInputEditText
lateinit var lenfeetedt_horizontalbarBW        : TextInputEditText
lateinit var leninchedt_horizontalbarBW        : TextInputEditText
lateinit var lenmeteredt_horizontalbarBW       : TextInputEditText
lateinit var hieghtfeetedt_precastwallBW       : TextInputEditText
lateinit var hieghtinchedt_precastwallBW       : TextInputEditText
lateinit var hieghtcmedt_horizontalbarBW       : TextInputEditText
lateinit var hieghtmeteredt_precastwallBW      : TextInputEditText
lateinit var hieghtfeetedt_horizontalbarBW     : TextInputEditText
lateinit var hieghtinchedt_horizontalbarBW     : TextInputEditText
lateinit var hieghtmeteredt_horizontalbarBW    : TextInputEditText

class Boundary_Wall : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boundary_wall)


        imgback_BW                     = findViewById(R.id.backbtnBW)
        button_reset_BW                = findViewById(R.id.buttonresetBW)
        linearlayall_BW                = findViewById(R.id.linearlayallBW)
        listview_spaceBW               = findViewById(R.id.listviewspaceBW)
        button_metercm_BW              = findViewById(R.id.buttonmetercmBW)
        button_feetinch_BW             = findViewById(R.id.buttonfeetinchBW)
        listview_nospaceBW             = findViewById(R.id.listviewnospaceBW)
        linearlaymetercm_BW            = findViewById(R.id.linearlayoutMetercmBW)
        linearlayfeetinch_BW           = findViewById(R.id.linearlayoutfeetinchBW)
        button_calculator_BW           = findViewById(R.id.buttoncalculatorBW)
        lencmedt_precastwallBW         = findViewById(R.id.edtlencm_precastwallBW)
        lencmlay_precastwallBW         = findViewById(R.id.txtinputlaylencm_precastwallBW)
        lenfeetedt_precastwallBW       = findViewById(R.id.edtlenfeet_precastwallBW)
        leninchedt_precastwallBW       = findViewById(R.id.edtleninches_precastwallBW)
        lencmedt_horizontalbarBW       = findViewById(R.id.edtlencm_horizontalbarBW)
        lenfeetlay_precastwallBW       = findViewById(R.id.txtinputlaylenfeet_precastwallBW)
        leninchlay_precastwallBW       = findViewById(R.id.txtinputlayleninches_precastwallBW)
        lencmlay_horizontalbarBW       = findViewById(R.id.txtinputlaylencm_horizontalbarBW)
        lenmeterlay_precastwallBW      = findViewById(R.id.txtinputlaylenmeter_precastwallBW)
        hieghtcmlay_precastwallBW      = findViewById(R.id.txtinputlayHeightcm_precastwallBW)
        lenmeteredt_precastwallBW      = findViewById(R.id.edtlenmeter_precastwallBW)
        hieghtcmedt_precastwallBW      = findViewById(R.id.edtHeightcm_precastwallBW)
        lenfeetlay_horizontalbarBW     = findViewById(R.id.txtinputlaylenfeet_horizontalbarBW)
        leninchlay_horizontalbarBW     = findViewById(R.id.txtinputlayleninches_horizontalbarBW)
        lenfeetedt_horizontalbarBW     = findViewById(R.id.edtlenfeet_horizotalbarBW)
        leninchedt_horizontalbarBW     = findViewById(R.id.edtleninches_horizontalbarBW)
        hieghtfeetedt_precastwallBW    = findViewById(R.id.edtHeigthfeet_precastwallBW)
        hieghtcmedt_horizontalbarBW    = findViewById(R.id.edtHeightcm_horizontalbarBW)
        hieghtinchedt_precastwallBW    = findViewById(R.id.edtHeigthinches_precastwallBW)
        hieghtfeetlay_precastwallBW    = findViewById(R.id.txtinputlayHeightfeet_precastwallBW)
        hieghtinchlay_precastwallBW    = findViewById(R.id.txtinputlayHeightinches_precastwallBW)
        lenmeterlay_horizontalbarBW    = findViewById(R.id.txtinputlaylenmeter_horizontalbarBW)
        hieghtcmlay_horizontalbarBW    = findViewById(R.id.txtinputlayHeightcm_horizontalbarBW)
        lenmeteredt_horizontalbarBW    = findViewById(R.id.edtlenmeter_horizontalbarBW)
        hieghtmeteredt_precastwallBW   = findViewById(R.id.edtHeightmeter_precastwallBW)
        hieghtmeterlay_precastwallBW   = findViewById(R.id.txtinputlayHeightmeter_precastwallBW)
        hieghtfeetedt_horizontalbarBW  = findViewById(R.id.edtHeightfeet_horizontalbarBW)
        hieghtinchedt_horizontalbarBW  = findViewById(R.id.edtHeightinches_horizontalbarBW)
        hieghtfeetlay_horizontalbarBW  = findViewById(R.id.txtinputlayHeigthfeet_horizontalbarBW)
        hieghtinchlay_horizontalbarBW  = findViewById(R.id.txtinputlayHeightinches_horizontalbarBW)
        hieghtmeterlay_horizontalbarBW = findViewById(R.id.txtinputlayHeightmeter_horizontalbarBW)
        hieghtmeteredt_horizontalbarBW = findViewById(R.id.edtHeightmeter_horizontalbarBW)


        imgback_BW.setOnClickListener {
            var intent = Intent(this@Boundary_Wall, Home_Screen::class.java)
            startActivity(intent)
        }
        button_reset_BW.setOnClickListener {
            invisiblelayoutBW()
            if (linearlayfeetinch_BW.visibility == View.VISIBLE) {
                lenfeetedt_precastwallBW.setText("")
                leninchedt_precastwallBW.setText("")
                hieghtfeetedt_precastwallBW.setText("")
                hieghtinchedt_precastwallBW.setText("")
                lenfeetedt_horizontalbarBW.setText("")
                leninchedt_horizontalbarBW.setText("")
                hieghtfeetedt_horizontalbarBW.setText("")
                hieghtinchedt_horizontalbarBW.setText("")

            }
            if (linearlaymetercm_BW.visibility == View.VISIBLE) {
                lenmeteredt_precastwallBW.setText("")
                lencmedt_precastwallBW.setText("")
                hieghtmeteredt_precastwallBW.setText("")
                hieghtcmedt_precastwallBW.setText("")
                lenmeteredt_horizontalbarBW.setText("")
                lencmedt_horizontalbarBW.setText("")
                hieghtmeteredt_horizontalbarBW.setText("")
                hieghtcmedt_horizontalbarBW.setText("")
            }
        }
        button_metercm_BW.setOnClickListener {
            showmetercmlayBW()
            button_feetinch_BW.setBackgroundResource(R.drawable.btnstyle)
            button_metercm_BW.setBackgroundResource(R.drawable.spinnerstyle)
            button_metercm_BW.setTextColor(Color.BLACK)
            button_feetinch_BW.setTextColor(Color.WHITE)
        }
        button_feetinch_BW.setOnClickListener {
            showfeetinclayBW()
            button_feetinch_BW.setBackgroundResource(R.drawable.spinnerstyle)
            button_metercm_BW.setBackgroundResource(R.drawable.btnstyle)
            button_feetinch_BW.setTextColor(Color.BLACK)
            button_metercm_BW.setTextColor(Color.WHITE)
        }
        button_calculator_BW.setOnClickListener {
            if (checkBW()) {
                showitemcalculatedBW()
            }
        }
    }

    fun checkBW(): Boolean {
        var isvalid = true

        var lengthfeet_precatwall = lenfeetedt_precastwallBW.text.toString()
        var lengthinch_precastwall = leninchedt_precastwallBW.text.toString()
        var heightfeet_prcastwall = hieghtfeetedt_precastwallBW.text.toString()
        var heightinch_precastwall = hieghtinchedt_precastwallBW.text.toString()
        var lengthfeet_horizontalbar = lenfeetedt_horizontalbarBW.text.toString()
        var lengthinch_horizontalbar = leninchedt_horizontalbarBW.text.toString()
        var heightfeet_horizontalbar = hieghtfeetedt_horizontalbarBW.text.toString()
        var heightinch_horizontalbar = hieghtinchedt_horizontalbarBW.text.toString()

        val lengthinch_precastwall_float = leninchedt_precastwallBW.text.toString().toFloatOrNull()
        val heightinch_precastwall_float =
            hieghtinchedt_precastwallBW.text.toString().toFloatOrNull()
        val lengthinch_horizontalbar_float =
            leninchedt_horizontalbarBW.text.toString().toFloatOrNull()
        val heightinch_horizontalbar_float =
            hieghtinchedt_horizontalbarBW.text.toString().toFloatOrNull()

        if (linearlayfeetinch_BW.visibility == View.VISIBLE) {

            if (lengthfeet_precatwall.isEmpty()) {
                lenfeetlay_precastwallBW.error = "please enter the value"
                isvalid = false
            } else {
                lenfeetlay_precastwallBW.error = null
            }

            if (lengthinch_precastwall.isEmpty() || lengthinch_precastwall_float!! !in 0f..11f) {
                leninchlay_precastwallBW.error = "please enter the value"
                isvalid = false
            } else {
                leninchlay_precastwallBW.error = null
            }

            if (heightfeet_prcastwall.isEmpty()) {
                hieghtfeetlay_precastwallBW.error = "please enter the value"
                isvalid = false
            } else {
                hieghtfeetlay_precastwallBW.error = null
            }
            if (heightinch_precastwall.isEmpty() || heightinch_precastwall_float!! !in 0f..11f) {
                hieghtinchlay_precastwallBW.error = "please enter the value"
                isvalid = false
            } else {
                hieghtinchlay_precastwallBW.error = null
            }
            if (lengthfeet_horizontalbar.isEmpty()) {
                lenfeetlay_horizontalbarBW.error = "please enter the value"
                isvalid = false
            } else {
                lenfeetlay_horizontalbarBW.error = null
            }

            if (lengthinch_horizontalbar.isEmpty() || lengthinch_horizontalbar_float!! !in 0f..11f) {
                leninchlay_horizontalbarBW.error = "please enter the value"
                isvalid = false
            } else {
                leninchlay_horizontalbarBW.error = null
            }

            if (heightfeet_horizontalbar.isEmpty()) {
                hieghtfeetlay_horizontalbarBW.error = "please enter the value"
                isvalid = false
            } else {
                hieghtfeetlay_horizontalbarBW.error = null
            }
            if (heightinch_horizontalbar.isEmpty() || heightinch_horizontalbar_float!! !in 0f..11f) {
                hieghtinchlay_horizontalbarBW.error = "please enter the value"
                isvalid = false
            } else {
                hieghtinchlay_horizontalbarBW.error = null
            }

        }
        if (linearlaymetercm_BW.visibility == View.VISIBLE) {
            var lengthmeter_precatwall = lenmeteredt_precastwallBW.text.toString()
            var lengthcm_precastwall = lencmedt_precastwallBW.text.toString()
            var heightmeter_prcastwall = hieghtmeteredt_precastwallBW.text.toString()
            var heightcm_precastwall = hieghtcmedt_precastwallBW.text.toString()
            var lengthmeter_horizontalbar = lenmeteredt_horizontalbarBW.text.toString()
            var lengthcm_horizontalbar = lencmedt_horizontalbarBW.text.toString()
            var heightmeter_horizontalbar = hieghtmeteredt_horizontalbarBW.text.toString()
            var heightcm_horizontalbar = hieghtcmedt_horizontalbarBW.text.toString()

            val lengthcm_precastwall_float = lencmedt_precastwallBW.text.toString().toFloatOrNull()
            val heightcm_precastwall_float =
                hieghtcmedt_precastwallBW.text.toString().toFloatOrNull()
            val lengthcm_horizontalbar_float =
                lencmedt_horizontalbarBW.text.toString().toFloatOrNull()
            val heightcm_horizontalbar_float =
                hieghtcmedt_horizontalbarBW.text.toString().toFloatOrNull()
            if (lengthmeter_precatwall.isEmpty()) {
                lenmeterlay_precastwallBW.error = "please enter the value"
                isvalid = false
            } else {
                lenmeterlay_precastwallBW.error = null
            }

            if (lengthcm_precastwall.isEmpty() || lengthcm_precastwall_float!! !in 0f..99f) {
                lencmlay_precastwallBW.error = "please enter the value"
                isvalid = false
            } else {
                lencmlay_precastwallBW.error = null
            }

            if (heightmeter_prcastwall.isEmpty()) {
                hieghtmeterlay_precastwallBW.error = "please enter the value"
                isvalid = false
            } else {
                hieghtmeterlay_precastwallBW.error = null
            }
            if (heightcm_precastwall.isEmpty() || heightcm_precastwall_float!! !in 0f..99f) {
                hieghtcmlay_precastwallBW.error = "please enter the value"
                isvalid = false
            } else {
                hieghtcmlay_precastwallBW.error = null
            }
            if (lengthmeter_horizontalbar.isEmpty()) {
                lenmeterlay_horizontalbarBW.error = "please enter the value"
                isvalid = false
            } else {
                lenmeterlay_horizontalbarBW.error = null
            }

            if (lengthcm_horizontalbar.isEmpty() || lengthcm_horizontalbar_float!! !in 0f..99f) {
                lencmlay_horizontalbarBW.error = "please enter the value"
                isvalid = false
            } else {
                lencmlay_horizontalbarBW.error = null
            }

            if (heightmeter_horizontalbar.isEmpty()) {
                hieghtmeterlay_horizontalbarBW.error = "please enter the value"
                isvalid = false
            } else {
                hieghtmeterlay_horizontalbarBW.error = null
            }
            if (heightcm_horizontalbar.isEmpty() || heightcm_horizontalbar_float!! !in 0f..99f) {
                hieghtcmlay_horizontalbarBW.error = "please enter the value"
                isvalid = false
            } else {
                hieghtcmlay_horizontalbarBW.error = null
            }
        }
        return isvalid
    }
    fun showfeetinclayBW() {
        linearlayfeetinch_BW.visibility = View.VISIBLE
        linearlaymetercm_BW.visibility = View.INVISIBLE
    }
    fun showmetercmlayBW() {
        linearlayfeetinch_BW.visibility = View.INVISIBLE
        linearlaymetercm_BW.visibility = View.VISIBLE
    }
    fun invisiblelayoutBW() {
        linearlayall_BW.visibility = View.INVISIBLE
    }
    fun showitemcalculatedBW() {
        linearlayall_BW.visibility = View.VISIBLE
        if (linearlayfeetinch_BW.visibility == View.VISIBLE)
        {
            var length_of_Area = (lenfeetedt_precastwallBW.text.toString().toFloatOrNull() ?: 0f) + (leninchedt_precastwallBW.text.toString().toFloatOrNull() ?: 0f) / 10
            var height_of_Area = (hieghtfeetedt_precastwallBW.text.toString().toFloatOrNull() ?: 0f) + (hieghtinchedt_precastwallBW.text.toString().toFloatOrNull() ?: 0f) / 10
            var length_of_bar = (lenfeetedt_horizontalbarBW.text.toString().toFloatOrNull() ?: 0f) + (leninchedt_horizontalbarBW.text.toString().toFloatOrNull() ?: 0f) / 10
            var heigth_of_bar = (hieghtfeetedt_horizontalbarBW.text.toString().toFloatOrNull() ?: 0f) + (hieghtinchedt_horizontalbarBW.text.toString().toFloatOrNull() ?: 0f) / 10

            var actuall_area = length_of_Area - (length_of_Area * 0.15) / (length_of_bar)

            var horizontalbar_withspace = (actuall_area * height_of_Area )/ (length_of_bar * heigth_of_bar) //calculation of horizontal bars with space
            var verticalpost_withspace = (length_of_Area/length_of_bar) + 1 //calulation of vertiical post with space
            var horizontalbar_withoutspace = ((length_of_Area * height_of_Area) / (length_of_bar * heigth_of_bar)) //calculation of horizontal bars without space
            var verticalpost_withoutspace = (length_of_Area / length_of_bar) + 1 //calulation of vertiical post without space




            // Data for the first list (with space)
            val list1Data = ArrayList<HashMap<String, String>>()
            val item1 = HashMap<String, String>()
            item1["material"] = "1 Horizontal Bar"
            item1["quantity"] = "%.0f".format(horizontalbar_withspace)
            list1Data.add(item1)

            val item2 = HashMap<String, String>()
            item2["material"] = "2 Vertical Post"
            item2["quantity"] = "%.0f".format(verticalpost_withspace)
            list1Data.add(item2)

            // Data for the second list (without space)
            val list2Data = ArrayList<HashMap<String, String>>()
            val item3 = HashMap<String, String>()
            item3["material"] = "1 Horizontal Bar"
            item3["quantity"] = "%.0f".format(horizontalbar_withoutspace)
            list2Data.add(item3)

            val item4 = HashMap<String, String>()
            item4["material"] = "2 Vertical Post"
            item4["quantity"] = "%.0f".format(verticalpost_withoutspace)
            list2Data.add(item4)

            // List Adapters
            val from = arrayOf("material", "quantity")
            val to = intArrayOf(R.id.material, R.id.quantity)

            val adapter1 = SimpleAdapter(this, list1Data, R.layout.listitem, from, to)
            val adapter2 = SimpleAdapter(this, list2Data, R.layout.listitem, from, to)

            listview_spaceBW.adapter = adapter1
            listview_nospaceBW.adapter = adapter2
        }

        if (linearlaymetercm_BW.visibility == View.VISIBLE){
            var length_of_Area = (lenmeteredt_precastwallBW.text.toString().toFloatOrNull() ?: 0f) + (lencmedt_precastwallBW.text.toString().toFloatOrNull() ?: 0f) / 10
            var  height_of_Area  = (hieghtmeteredt_precastwallBW.text.toString().toFloatOrNull() ?: 0f) + (hieghtcmedt_precastwallBW.text.toString().toFloatOrNull() ?: 0f) / 10
            var length_of_bar = (lenmeteredt_horizontalbarBW.text.toString().toFloatOrNull() ?: 0f) + (lencmedt_horizontalbarBW.text.toString().toFloatOrNull() ?: 0f) / 10
            var heigth_of_bar = (hieghtmeteredt_horizontalbarBW.text.toString().toFloatOrNull() ?: 0f) + (hieghtcmedt_horizontalbarBW.text.toString().toFloatOrNull() ?: 0f) / 10


            var actuall_area = length_of_Area - (length_of_Area * 0.15) / (length_of_bar)

            var horizontalbar_withspace = (actuall_area * height_of_Area )/ (length_of_bar * heigth_of_bar) //calculation of horizontal bars with space
            var verticalpost_withspace = (length_of_Area/length_of_bar) + 1 //calulation of vertiical post with space
            var horizontalbar_withoutspace = ((length_of_Area * height_of_Area) / (length_of_bar * heigth_of_bar)) //calculation of horizontal bars without space
            var verticalpost_withoutspace = (length_of_Area / length_of_bar) + 1 //calulation of vertiical post without space

            // Data for the first list (with space)
            val list1Data = ArrayList<HashMap<String, String>>()
            val item1 = HashMap<String, String>()
            item1["material"] = "1 Horizontal Bar"
            item1["quantity"] = "%.0f".format(horizontalbar_withspace)
            list1Data.add(item1)

            val item2 = HashMap<String, String>()
            item2["material"] = "2 Vertical Post"
            item2["quantity"] = "%.0f".format(verticalpost_withspace)
            list1Data.add(item2)

            // Data for the second list (without space)
            val list2Data = ArrayList<HashMap<String, String>>()
            val item3 = HashMap<String, String>()
            item3["material"] = "1 Horizontal Bar"
            item3["quantity"] = "%.0f".format(horizontalbar_withoutspace)
            list2Data.add(item3)

            val item4 = HashMap<String, String>()
            item4["material"] = "2 Vertical Post"
            item4["quantity"] = "%.0f".format(verticalpost_withoutspace)
            list2Data.add(item4)

            // List Adapters
            val from = arrayOf("material", "quantity")
            val to = intArrayOf(R.id.material, R.id.quantity)

            val adapter1 = SimpleAdapter(this, list1Data, R.layout.listitem, from, to)
            val adapter2 = SimpleAdapter(this, list2Data, R.layout.listitem, from, to)

            listview_spaceBW.adapter = adapter1
            listview_nospaceBW.adapter = adapter2
        }
    }
}