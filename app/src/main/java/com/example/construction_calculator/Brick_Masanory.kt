package com.example.construction_calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
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
import kotlin.math.log
import kotlin.math.roundToInt

lateinit var imgback_BM          : ImageView
lateinit var button_feetinch_BM   : Button
lateinit var button_metercm_BM    : Button
lateinit var button_calculator_BM : Button
lateinit var button_reset_BM      : Button
lateinit var spinner1_BM       : Spinner
lateinit var spinner2_BM       : Spinner
lateinit var txttotalbricksreq_BM  : TextView
lateinit var txttotalvolume_BM  : TextView
lateinit var listview_BM      : ListView
lateinit var pieChart_BM      : PieChart
lateinit var lenfeetlay_BM    : TextInputLayout
lateinit var lenfeetedt_BM    : TextInputEditText
lateinit var leninchlay_BM    : TextInputLayout
lateinit var leninchedt_BM    : TextInputEditText
lateinit var widthfeetlay_BM  : TextInputLayout
lateinit var widthfeetedt_BM  : TextInputEditText
lateinit var widthinchlay_BM  : TextInputLayout
lateinit var widthinchedt_BM  : TextInputEditText
lateinit var lenmeterlay_BM  : TextInputLayout
lateinit var lenmeteredt_BM   : TextInputEditText
lateinit var lencmlay_BM          : TextInputLayout
lateinit var lencmedt_BM          : TextInputEditText
lateinit var widthmeterlay_BM     : TextInputLayout
lateinit var widthmeteredt_BM     : TextInputEditText
lateinit var widthcmlay_BM        : TextInputLayout
lateinit var widthcmedt_BM        : TextInputEditText
lateinit var partitioncmlay_BM        : TextInputLayout
lateinit var partitioncmedt_BM        : TextInputEditText
lateinit var sizeofbricklencmlay_BM        : TextInputLayout
lateinit var sizeofbricklencmedt_BM        : TextInputEditText
lateinit var sizeofbrickwidthcmlay_BM        : TextInputLayout
lateinit var sizeofbrickwidthcmedt_BM        : TextInputEditText
lateinit var sizeofbrickheightcmlay_BM        : TextInputLayout
lateinit var sizeofbrickheightcmedt_BM        : TextInputEditText
lateinit var linearlayfeetinch_BM : LinearLayout
lateinit var linearlaymetercm_BM  : LinearLayout
lateinit var linearlayall_BM      : LinearLayout
lateinit var linearlaypartition_BM      : LinearLayout
lateinit var adapter1_BM           : ArrayAdapter<CharSequence>
lateinit var adapter2_BM           : ArrayAdapter<CharSequence>
private lateinit var items1_BM  : MutableList<ListItem>
lateinit var Arrayimg_BM        : Array<Int>
lateinit var Arraycalcu_BM      : Array<Int>
lateinit var Arraytxt_BM        : Array<String>
lateinit var Arrayunit_BM        : Array<String>
lateinit var chartdata_BM       : ArrayList<PieEntry>
 var wallThicknessCm : Float = 0.0f

class Brick_Masanory : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brick_masanory)


        imgback_BM = findViewById(R.id.backbtnBM)
        spinner1_BM = findViewById(R.id.spinnerwallthicknessBM)
        spinner2_BM = findViewById(R.id.spinner2RatioBM)
        listview_BM = findViewById(R.id.listviewBM)
        pieChart_BM = findViewById(R.id.piechartBM)
        txttotalbricksreq_BM = findViewById(R.id.txttotalbricksrequiredBM)
        txttotalvolume_BM = findViewById(R.id.txttotalvolumeBM)
        linearlayfeetinch_BM = findViewById(R.id.linearlayoutfeetinchBM)
        linearlaymetercm_BM = findViewById(R.id.linearlayoutMetercmBM)
        linearlayall_BM = findViewById(R.id.linearlayallBM)
        button_feetinch_BM = findViewById(R.id.buttonfeetinchBM)
        button_metercm_BM = findViewById(R.id.buttonmetercmBM)
        button_calculator_BM = findViewById(R.id.buttoncalculatorBM)
        button_reset_BM = findViewById(R.id.buttonresetBM)
        lenfeetlay_BM = findViewById(R.id.txtinputlaylenfeetBM)
        leninchlay_BM = findViewById(R.id.txtinputlayleninchesBM)
        lenmeterlay_BM = findViewById(R.id.txtinputlaylenmeterBM)
        lencmlay_BM = findViewById(R.id.txtinputlaylencmBM)
        lenfeetedt_BM = findViewById(R.id.edtlenfeetBM)
        leninchedt_BM = findViewById(R.id.edtleninchesBM)
        lenmeteredt_BM = findViewById(R.id.edtlenmeterBM)
        lencmedt_BM = findViewById(R.id.edtlencmBM)
        widthfeetlay_BM = findViewById(R.id.txtinputlaywidthfeetBM)
        widthinchlay_BM = findViewById(R.id.txtinputlaywidthinchesBM)
        widthmeterlay_BM = findViewById(R.id.txtinputlaywidthmeterBM)
        widthcmlay_BM = findViewById(R.id.txtinputlaywidthcmBM)
        widthfeetedt_BM = findViewById(R.id.edtwidthfeetBM)
        widthinchedt_BM = findViewById(R.id.edtwidthinchesBM)
        widthmeteredt_BM = findViewById(R.id.edtwidthmeterBM)
        widthcmedt_BM = findViewById(R.id.edtwidthcmBM)
        sizeofbricklencmlay_BM = findViewById(R.id.txtinputlaysizeofbrick_lenghtBM)
        sizeofbrickwidthcmlay_BM = findViewById(R.id.txtinputlaysizeofbrick_widthBM)
        sizeofbrickheightcmlay_BM = findViewById(R.id.txtinputlaysizeofbrick_heightBM)
        sizeofbricklencmedt_BM = findViewById(R.id.edtlensizeofbrickBM)
        sizeofbrickwidthcmedt_BM = findViewById(R.id.edtwidthsizeofbrickBM)
        sizeofbrickheightcmedt_BM = findViewById(R.id.edtheightsizeofbrickBM)
        partitioncmlay_BM = findViewById(R.id.txtinputlaypartitionBM)
        partitioncmedt_BM = findViewById(R.id.edtpartitionBM)
        linearlaypartition_BM = findViewById(R.id.layoutpartition)


        //this is for wall thickness spinner
        adapter1_BM = ArrayAdapter.createFromResource(
            this,
            R.array.SpinnerwallthicknessBM,
            android.R.layout.simple_spinner_item
        )
        adapter1_BM.setDropDownViewResource(android.R.layout.simple_list_item_1)
        spinner1_BM.adapter = adapter1_BM

        //this is for ratio spinner
        adapter2_BM = ArrayAdapter.createFromResource(
            this,
            R.array.SpinnerratioBM,
            android.R.layout.simple_spinner_item
        )
        adapter2_BM.setDropDownViewResource(android.R.layout.simple_list_item_1)
        spinner2_BM.adapter = adapter2_BM

        spinner1_BM.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                showpartition()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        button_calculator_BM.setOnClickListener {
            if (checkBM()) {
                showitemcalculatedBM()

            }
        }
        button_feetinch_BM.setOnClickListener {
            showfeetinclayBM()
            button_feetinch_BM.setBackgroundResource(R.drawable.spinnerstyle)
            button_metercm_BM.setBackgroundResource(R.drawable.btnstyle)
            button_feetinch_BM.setTextColor(Color.BLACK)
            button_metercm_BM.setTextColor(Color.WHITE)
        }
        button_metercm_BM.setOnClickListener {
            showmetercmlayBM()
            button_feetinch_BM.setBackgroundResource(R.drawable.btnstyle)
            button_metercm_BM.setBackgroundResource(R.drawable.spinnerstyle)
            button_metercm_BM.setTextColor(Color.BLACK)
            button_feetinch_BM.setTextColor(Color.WHITE)
        }
        imgback_BM.setOnClickListener {
            var intent = Intent(this@Brick_Masanory, Home_Screen::class.java)
            startActivity(intent)
        }
        button_reset_BM.setOnClickListener {
            invisiblelayoutBM()
            sizeofbricklencmedt_BM.setText("")
            sizeofbrickwidthcmedt_BM.setText("")
            sizeofbrickheightcmedt_BM.setText("")
            if (linearlayfeetinch_BM.visibility == View.VISIBLE) {
                lenfeetedt_BM.setText("")
                leninchedt_BM.setText("")
                widthfeetedt_BM.setText("")
                widthinchedt_BM.setText("")
            }
            if (linearlaymetercm_BM.visibility == View.VISIBLE) {
                lenmeteredt_BM.setText("")
                lencmedt_BM.setText("")
                widthmeteredt_BM.setText("")
                widthcmedt_BM.setText("")

            }
        }
    }

    fun checkBM(): Boolean {
        var isvalid = true

        var lengthfeet = lenfeetedt_BM.text.toString()
        var lengthinch = leninchedt_BM.text.toString()
        var widthfeet = widthfeetedt_BM.text.toString()
        var widthinch = widthinchedt_BM.text.toString()
        var lengthbricksize = sizeofbricklencmedt_BM.text.toString()
        var widthbricksize = sizeofbrickwidthcmedt_BM.text.toString()
        var heigthbricksize = sizeofbrickheightcmedt_BM.text.toString()
        var partitionval = partitioncmedt_BM.text.toString()

        val lengthfeet_float = lenfeetedt_BM.text.toString().toFloatOrNull()
        val lengthinch_float = leninchedt_BM.text.toString().toFloatOrNull()
        val widthfeet_float = widthfeetedt_BM.text.toString().toFloatOrNull()
        val widthinch_float = widthinchedt_BM.text.toString().toFloatOrNull()
        val partitionval_float = partitioncmedt_BM.text.toString().toFloatOrNull()

        if (linearlaypartition_BM.visibility == View.VISIBLE){
            if (partitionval.isEmpty() || partitionval_float!! !in 0f..99f) {
                partitioncmlay_BM.error = "please enter the..."
                isvalid = false
            } else {
                partitioncmlay_BM.error = null
            }

        }

        if (lengthbricksize.isEmpty()) {
            sizeofbricklencmlay_BM.error = "please enter the..."
            isvalid = false
        } else {
            sizeofbricklencmlay_BM.error = null
        }

        if (widthbricksize.isEmpty()) {
            sizeofbrickwidthcmlay_BM.error = "please enter the..."
            isvalid = false
        } else {
            sizeofbrickwidthcmlay_BM.error = null
        }
        if (heigthbricksize.isEmpty()) {
            sizeofbrickheightcmlay_BM.error = "please enter the..."
            isvalid = false
        } else {
            sizeofbrickheightcmlay_BM.error = null
        }

        if (linearlayfeetinch_BM.visibility == View.VISIBLE) {

            if (lengthfeet.isEmpty()) {
                lenfeetlay_BM.error = "please enter the value"
                isvalid = false
            } else {
                lenfeetlay_BM.error = null
            }

            if (lengthinch.isEmpty() || lengthinch_float!! !in 0f..11f) {
                leninchlay_BM.error = "please enter the value"
                isvalid = false
            } else {
                leninchlay_BM.error = null
            }

            if (widthfeet.isEmpty()) {
                widthfeetlay_BM.error = "please enter the value"
                isvalid = false
            } else {
                widthfeetlay_BM.error = null
            }
            if (widthinch.isEmpty() || widthinch_float!! !in 0f..11f) {
                widthinchlay_BM.error = "please enter the value"
                isvalid = false
            } else {
                widthinchlay_BM.error = null
            }
        }
        if (linearlaymetercm_BM.visibility == View.VISIBLE) {
            var lengthmeter = lenmeteredt_BM.text.toString()
            var lengthcm = lencmedt_BM.text.toString()
            var widthmeter = widthmeteredt_BM.text.toString()
            var widthcm = widthcmedt_BM.text.toString()

            val lengthmeter_float = lenmeteredt_BM.text.toString().toFloatOrNull()
            val lengthcm_float = lencmedt_BM.text.toString().toFloatOrNull()
            val widthmeter_float = widthmeteredt_BM.text.toString().toFloatOrNull()
            val widthcm_float = widthcmedt_BM.text.toString().toFloatOrNull()


            if (lengthmeter.isEmpty()) {
                lenmeterlay_BM.error = "please enter the value"
                isvalid = false
            } else {
                lenmeterlay_BM.error = null
            }

            if (lengthcm.isEmpty() || lengthcm_float!! !in 0f..99f) {
                lencmlay_BM.error = "please enter the value"
                isvalid = false
            } else {
                lencmlay_BM.error = null
            }

            if (widthmeter.isEmpty()) {
                widthmeterlay_BM.error = "please enter the value"
                isvalid = false
            } else {
                widthmeterlay_BM.error = null
            }
            if (widthcm.isEmpty() || widthcm_float!! !in 0f..99f) {
                widthcmlay_BM.error = "please enter the value"
                isvalid = false
            } else {
                widthcmlay_BM.error = null
            }
        }
        return isvalid
    }

    fun showfeetinclayBM() {
        linearlayfeetinch_BM.visibility = View.VISIBLE
        linearlaymetercm_BM.visibility = View.INVISIBLE
    }

    fun showmetercmlayBM() {
        linearlayfeetinch_BM.visibility = View.INVISIBLE
        linearlaymetercm_BM.visibility = View.VISIBLE
    }

    fun invisiblelayoutBM() {
        linearlayall_BM.visibility = View.INVISIBLE
    }

    fun showitemcalculatedBM() {
        linearlayall_BM.visibility = View.VISIBLE

        var selecteditembm2 = spinner2_BM.selectedItem.toString()
        var lengthofbrick = (sizeofbricklencmedt_BM.text.toString().toFloatOrNull() ?: 0f) / 100
        var widthofbrick = (sizeofbrickwidthcmedt_BM.text.toString().toFloatOrNull() ?: 0f) / 100
        var heightofbrick = (sizeofbrickheightcmedt_BM.text.toString().toFloatOrNull() ?: 0f) / 100

        var lengthofbrick1 = lengthofbrick + 0.01f
        var widthofbrick1 = widthofbrick + 0.01f
        var heightofbrick1 = heightofbrick + 0.01f

        var size_of_brick = lengthofbrick1 * widthofbrick1 * heightofbrick1

        if (linearlayfeetinch_BM.visibility == View.VISIBLE) {
            val lengthFeet = lenfeetedt_BM.text.toString().toFloatOrNull() ?: 0f
            val lengthInches = leninchedt_BM.text.toString().toFloatOrNull() ?: 0f
            val total_length_feet = lengthFeet + lengthInches / 12f // Convert inches to feet

            val widthFeet = widthfeetedt_BM.text.toString().toFloatOrNull() ?: 0f
            val widthInches = widthinchedt_BM.text.toString().toFloatOrNull() ?: 0f
            val total_width_feet = widthFeet + widthInches / 12f // Convert inches to feet


            // Check if "Other Partition" is selected in the spinner
            if (spinner1_BM.selectedItem.toString() == "Other Partition") {
                // Directly get the value from the TextInputEditText (no validation)
                wallThicknessCm = partitioncmedt_BM.text.toString().toFloatOrNull() ?: 0f
            } else {
                // Extract the wall thickness from the spinner selection
                wallThicknessCm = spinner1_BM.selectedItem.toString()
                    .split(" ")[0].toFloatOrNull() ?: 0f
            }

            val wall_thickness_feet = wallThicknessCm / 30.48f // Convert CM to Feet
            var wall_thickness_formated = String.format("%.2f", wall_thickness_feet)


            var volume_feetcube = total_length_feet * total_width_feet * wall_thickness_feet //calculation for feet cube
            var feetcube_formatted = String.format("%.2f", volume_feetcube)
            var volume_metercube = volume_feetcube * 0.0283168f//calculation for meter cube
            var metercube_formatted = String.format("%.2f", volume_metercube)

            var noofbricks = volume_metercube / size_of_brick
            var noofbricksformat = noofbricks.roundToInt()
            var actuallvolumeofbricksmortar = noofbricks * (lengthofbrick * widthofbrick * heightofbrick)
            var quantity_of_mortar = volume_metercube - actuallvolumeofbricksmortar
            var quantity_of_mortar_15 = quantity_of_mortar + (quantity_of_mortar * 15 / 100)
            var quantity_of_mortar_25 = quantity_of_mortar_15 + (quantity_of_mortar_15 * 25 / 100)

            txttotalbricksreq_BM.setText(noofbricksformat.toString())
            txttotalvolume_BM.setText(metercube_formatted + " m³ or " + feetcube_formatted + "  ft³ ")

            when (selecteditembm2) {
                "C.M 1:3" -> {
                    val cement = (1f/4f) * quantity_of_mortar_25
                    val noofcementbags = cement /0.035f

                    val sand = (3f/4f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg/1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:4" -> {
                    val cement = (1f/5f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (4f/5f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:5" -> {
                    val cement = (1f/6f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (5f/6f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:6" -> {
                    val cement = (1f/7f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (6f/7f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:7" -> {
                    val cement = (1f/8f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (7f/8f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:8" -> {
                    val cement = (1f/9f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (8f/9f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:9" -> {
                    val cement = (1f/10f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (9f/10f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }
            }

        }
        if (linearlaymetercm_BM.visibility == View.VISIBLE) {

            var total_length_meter = (lenmeteredt_BM.text.toString().toFloatOrNull() ?: 0f) + (lencmedt_BM.text.toString().toFloatOrNull() ?: 0f) / 100
            var total_width_meter = (widthmeteredt_BM.text.toString().toFloatOrNull() ?: 0f) + (widthcmedt_BM.text.toString().toFloatOrNull() ?: 0f) / 100


            // Check if "Other Partition" is selected in the spinner
            if (spinner1_BM.selectedItem.toString() == "Other Partition") {
                // Directly get the value from the TextInputEditText (no validation)
                wallThicknessCm = partitioncmedt_BM.text.toString().toFloatOrNull() ?: 0f
            } else {
                // Extract the wall thickness from the spinner selection
                wallThicknessCm = spinner1_BM.selectedItem.toString()
                    .split(" ")[0].toFloatOrNull() ?: 0f
            }

            val wall_thickness_feet = wallThicknessCm / 100 // Convert CM to meter
            var wall_thickness_formated = String.format("%.2f", wall_thickness_feet)

            var metercube = total_length_meter * total_width_meter * wall_thickness_feet
            var metercube_formatted = String.format("%.2f", metercube)
            var volume_feetcube = metercube * 35.3147
            var feetcube_formatted = String.format("%.2f", volume_feetcube)


            var noofbricks = metercube / size_of_brick
            var noofbricksformat = noofbricks.roundToInt()
            var actuallvolumeofbricksmortar = noofbricks * (lengthofbrick * widthofbrick * heightofbrick)
            var quantity_of_mortar = metercube - actuallvolumeofbricksmortar
            var quantity_of_mortar_15 = quantity_of_mortar + (quantity_of_mortar * 15 / 100)
            var quantity_of_mortar_25 = quantity_of_mortar_15 + (quantity_of_mortar_15 * 25 / 100)


            txttotalbricksreq_BM.setText(noofbricksformat.toString())
            txttotalvolume_BM.setText(metercube_formatted +" m³ or "+ feetcube_formatted + " ft³")

            when (selecteditembm2) {
                "C.M 1:3" -> {
                    val cement = (1f/4f) * quantity_of_mortar_25
                    val noofcementbags = cement /0.035f

                    val sand = (3f/4f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg/1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:4" -> {
                    val cement = (1f/5f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (4f/5f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:5" -> {
                    val cement = (1f/6f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (5f/6f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:6" -> {
                    val cement = (1f/7f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (6f/7f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:7" -> {
                    val cement = (1f/8f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (7f/8f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:8" -> {
                    val cement = (1f/9f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (8f/9f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }

                "C.M 1:9" -> {
                    val cement = (1f/10f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (9f/10f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofbricksformat)
                }
            }
        }
    }

    fun showpartition() {
        var selecteditem3 = spinner1_BM.selectedItem.toString()
        when (selecteditem3) {
            "other Partition" -> {
                if (linearlaypartition_BM.visibility == View.GONE) {
                    linearlaypartition_BM.visibility = View.VISIBLE
                }
            }

            "23 CM Wall" -> {
                if (linearlaypartition_BM.visibility == View.VISIBLE) {
                    linearlaypartition_BM.visibility = View.GONE
                }
            }

            "10 CM Wall" -> {
                if (linearlaypartition_BM.visibility == View.VISIBLE) {
                    linearlaypartition_BM.visibility = View.GONE
                }
            }
        }
    }
    fun updateMaterialList(cement: Float, sand: Float ,bricks:Int)
    {
        val cementBags = cement.roundToInt()  // Example calculation for bags of cement
        val sandTons = sand.roundToInt()  // Example conversion to tons
        val bricksreq = bricks

        Arrayimg_BM = arrayOf(R.drawable.airconditioner, R.drawable.areagraph1,R.drawable.brickwall1)
        Arraytxt_BM = arrayOf("cement", "sand","Bricks")
        Arrayunit_BM = arrayOf("Bags", "Ton","Nos.")
        Arraycalcu_BM = arrayOf(cementBags, sandTons , bricksreq )
        items1_BM = mutableListOf()
        for (i in Arraytxt_BM.indices) {
            val newItem = ListItem(Arrayimg_BM[i], Arraytxt_BM[i], Arraycalcu_BM[i], Arrayunit_BM[i])
            items1_BM.add(newItem)
        }
        val adapter_BM = AdapterListview(this, items1_BM)
        listview_BM.adapter = adapter_BM

        updatePieChart(cementBags.toFloat(), sandTons.toFloat(), bricksreq.toFloat())
    }

    fun updatePieChart(cementValue: Float, sandValue: Float , bricksreqvalue: Float) {
        //piechart
        chartdata_BM = ArrayList()
        chartdata_BM.add(PieEntry(cementValue, "cement"))
        chartdata_BM.add(PieEntry(sandValue, "Sand"))
        chartdata_BM.add(PieEntry(bricksreqvalue, "bricks"))


        val dataSet_BM = PieDataSet(chartdata_BM, "Materails")
        dataSet_BM.colors = listOf(
            Color.parseColor("#FF8A65"), // Cement
            Color.parseColor("#FFAB40"), // Steel
            Color.parseColor("#FFAB40"), // Steel
            )

        val data_BM = PieData(dataSet_BM)
        pieChart_BM.data = data_BM
        pieChart_BM.description.isEnabled = false

        // Customize chart
        pieChart_BM.holeRadius = 58f
        pieChart_BM.centerText = "Materials"
        pieChart_BM.isDrawHoleEnabled = true
        pieChart_BM.transparentCircleRadius = 61f
        pieChart_BM.invalidate()
        pieChart_BM.setDrawCenterText(true)
        pieChart_BM.animateY(1400)
        pieChart_BM.setHoleColor(R.color.white)
        pieChart_BM.setTransparentCircleAlpha(110)
    }
}