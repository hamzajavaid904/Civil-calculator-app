package com.example.construction_calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import kotlin.math.roundToInt

lateinit var imgback_CBC          : ImageView
lateinit var button_feetinch_CBC   : Button
lateinit var button_metercm_CBC    : Button
lateinit var button_calculator_CBC : Button
lateinit var button_reset_CBC      : Button
lateinit var spinner1_CBC       : Spinner
lateinit var spinner2_CBC       : Spinner
lateinit var txttotalbricksreq_CBC  : TextView
lateinit var txttotalvolume_CBC  : TextView
lateinit var listview_CBC      : ListView
lateinit var pieChart_CBC      : PieChart
lateinit var lenfeetlay_CBC    : TextInputLayout
lateinit var lenfeetedt_CBC    : TextInputEditText
lateinit var leninchlay_CBC    : TextInputLayout
lateinit var leninchedt_CBC    : TextInputEditText
lateinit var widthfeetlay_CBC  : TextInputLayout
lateinit var widthfeetedt_CBC  : TextInputEditText
lateinit var widthinchlay_CBC  : TextInputLayout
lateinit var widthinchedt_CBC  : TextInputEditText
lateinit var lenmeterlay_CBC  : TextInputLayout
lateinit var lenmeteredt_CBC   : TextInputEditText
lateinit var lencmlay_CBC          : TextInputLayout
lateinit var lencmedt_CBC          : TextInputEditText
lateinit var widthmeterlay_CBC     : TextInputLayout
lateinit var widthmeteredt_CBC     : TextInputEditText
lateinit var widthcmlay_CBC        : TextInputLayout
lateinit var widthcmedt_CBC        : TextInputEditText
lateinit var partitioncmlay_CBC        : TextInputLayout
lateinit var partitioncmedt_CBC        : TextInputEditText
lateinit var sizeofbricklencmlay_CBC        : TextInputLayout
lateinit var sizeofbricklencmedt_CBC        : TextInputEditText
lateinit var sizeofbrickwidthcmlay_CBC        : TextInputLayout
lateinit var sizeofbrickwidthcmedt_CBC        : TextInputEditText
lateinit var sizeofbrickheightcmlay_CBC        : TextInputLayout
lateinit var sizeofbrickheightcmedt_CBC        : TextInputEditText
lateinit var linearlayfeetinch_CBC : LinearLayout
lateinit var linearlaymetercm_CBC  : LinearLayout
lateinit var linearlayall_CBC      : LinearLayout
lateinit var linearlaypartition_CBC      : LinearLayout
lateinit var adapter1_CBC           : ArrayAdapter<CharSequence>
lateinit var adapter2_CBC           : ArrayAdapter<CharSequence>
private lateinit var items1_CBC  : MutableList<ListItem>
lateinit var Arrayimg_CBC        : Array<Int>
lateinit var Arraycalcu_CBC      : Array<Int>
lateinit var Arraytxt_CBC        : Array<String>
lateinit var Arrayunit_CBC        : Array<String>
lateinit var chartdata_CBC       : ArrayList<PieEntry>

class Concrete_Block_Calculator : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concrete_block_calculator)
        imgback_CBC = findViewById(R.id.backbtnCBC)
        spinner1_CBC = findViewById(R.id.spinnerwallthicknessCBC)
        spinner2_CBC = findViewById(R.id.spinner2RatioCBC)
        listview_CBC = findViewById(R.id.listviewCBC)
        pieChart_CBC = findViewById(R.id.piechartCBC)
        txttotalbricksreq_CBC = findViewById(R.id.txttotalbricksrequiredCBC)
        txttotalvolume_CBC = findViewById(R.id.txttotalvolumeCBC)
        linearlayfeetinch_CBC = findViewById(R.id.linearlayoutfeetinchCBC)
        linearlaymetercm_CBC = findViewById(R.id.linearlayoutMetercmCBC)
        linearlayall_CBC = findViewById(R.id.linearlayallCBC)
        button_feetinch_CBC = findViewById(R.id.buttonfeetinchCBC)
        button_metercm_CBC = findViewById(R.id.buttonmetercmCBC)
        button_calculator_CBC = findViewById(R.id.buttoncalculatorCBC)
        button_reset_CBC = findViewById(R.id.buttonresetCBC)
        lenfeetlay_CBC = findViewById(R.id.txtinputlaylenfeetCBC)
        leninchlay_CBC = findViewById(R.id.txtinputlayleninchesCBC)
        lenmeterlay_CBC = findViewById(R.id.txtinputlaylenmeterCBC)
        lencmlay_CBC = findViewById(R.id.txtinputlaylencmCBC)
        lenfeetedt_CBC = findViewById(R.id.edtlenfeetCBC)
        leninchedt_CBC = findViewById(R.id.edtleninchesCBC)
        lenmeteredt_CBC = findViewById(R.id.edtlenmeterCBC)
        lencmedt_CBC = findViewById(R.id.edtlencmCBC)
        widthfeetlay_CBC = findViewById(R.id.txtinputlaywidthfeetCBC)
        widthinchlay_CBC = findViewById(R.id.txtinputlaywidthinchesCBC)
        widthmeterlay_CBC = findViewById(R.id.txtinputlaywidthmeterCBC)
        widthcmlay_CBC = findViewById(R.id.txtinputlaywidthcmCBC)
        widthfeetedt_CBC = findViewById(R.id.edtwidthfeetCBC)
        widthinchedt_CBC = findViewById(R.id.edtwidthinchesCBC)
        widthmeteredt_CBC = findViewById(R.id.edtwidthmeterCBC)
        widthcmedt_CBC = findViewById(R.id.edtwidthcmCBC)
        sizeofbricklencmlay_CBC = findViewById(R.id.txtinputlaysizeofbrick_lenghtCBC)
        sizeofbrickwidthcmlay_CBC = findViewById(R.id.txtinputlaysizeofbrick_widthCBC)
        sizeofbrickheightcmlay_CBC = findViewById(R.id.txtinputlaysizeofbrick_heightCBC)
        sizeofbricklencmedt_CBC = findViewById(R.id.edtlensizeofbrickCBC)
        sizeofbrickwidthcmedt_CBC = findViewById(R.id.edtwidthsizeofbrickCBC)
        sizeofbrickheightcmedt_CBC = findViewById(R.id.edtheightsizeofbrickCBC)
        partitioncmlay_CBC = findViewById(R.id.txtinputlaypartitionCBC)
        partitioncmedt_CBC = findViewById(R.id.edtpartitionCBC)
        linearlaypartition_CBC = findViewById(R.id.layoutpartitionCBC)


        //this is for wall thickness spinner
        adapter1_CBC = ArrayAdapter.createFromResource(
            this,
            R.array.SpinnerwallthicknessBM,
            android.R.layout.simple_spinner_item
        )
        adapter1_CBC.setDropDownViewResource(android.R.layout.simple_list_item_1)
        spinner1_CBC.adapter = adapter1_CBC

        //this is for ratio spinner
        adapter2_CBC = ArrayAdapter.createFromResource(
            this,
            R.array.SpinnerratioBM,
            android.R.layout.simple_spinner_item
        )
        adapter2_CBC.setDropDownViewResource(android.R.layout.simple_list_item_1)
        spinner2_CBC.adapter = adapter2_CBC

        spinner1_CBC.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                showpartition()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        button_calculator_CBC.setOnClickListener {
            if (checkCBC()) {
                showitemcalculatedCBC()

            }
        }
        button_feetinch_CBC.setOnClickListener {
            showfeetinclayCBC()
            button_feetinch_CBC.setBackgroundResource(R.drawable.spinnerstyle)
            button_metercm_CBC.setBackgroundResource(R.drawable.btnstyle)
            button_feetinch_CBC.setTextColor(Color.BLACK)
            button_metercm_CBC.setTextColor(Color.WHITE)
        }
        button_metercm_CBC.setOnClickListener {
            showmetercmlayCBC()
            button_feetinch_CBC.setBackgroundResource(R.drawable.btnstyle)
            button_metercm_CBC.setBackgroundResource(R.drawable.spinnerstyle)
            button_metercm_CBC.setTextColor(Color.BLACK)
            button_feetinch_CBC.setTextColor(Color.WHITE)
        }
        imgback_CBC.setOnClickListener {
            var intent = Intent(this@Concrete_Block_Calculator, Home_Screen::class.java)
            startActivity(intent)
        }
        button_reset_CBC.setOnClickListener {
            invisiblelayoutCBC()
            sizeofbricklencmedt_CBC.setText("")
            sizeofbrickwidthcmedt_CBC.setText("")
            sizeofbrickheightcmedt_CBC.setText("")
            if (linearlayfeetinch_CBC.visibility == View.VISIBLE) {
                lenfeetedt_CBC.setText("")
                leninchedt_CBC.setText("")
                widthfeetedt_CBC.setText("")
                widthinchedt_CBC.setText("")
            }
            if (linearlaymetercm_CBC.visibility == View.VISIBLE) {
                lenmeteredt_CBC.setText("")
                lencmedt_CBC.setText("")
                widthmeteredt_CBC.setText("")
                widthcmedt_CBC.setText("")
            }
        }
    }
    fun checkCBC(): Boolean {
        var isvalid = true

        var lengthfeet = lenfeetedt_CBC.text.toString()
        var lengthinch = leninchedt_CBC.text.toString()
        var widthfeet = widthfeetedt_CBC.text.toString()
        var widthinch = widthinchedt_CBC.text.toString()
        var lengthbricksize = sizeofbricklencmedt_CBC.text.toString()
        var widthbricksize = sizeofbrickwidthcmedt_CBC.text.toString()
        var heigthbricksize = sizeofbrickheightcmedt_CBC.text.toString()
        var partitionval = partitioncmedt_CBC.text.toString()

        val lengthfeet_float = lenfeetedt_CBC.text.toString().toFloatOrNull()
        val lengthinch_float = leninchedt_CBC.text.toString().toFloatOrNull()
        val widthfeet_float = widthfeetedt_CBC.text.toString().toFloatOrNull()
        val widthinch_float = widthinchedt_CBC.text.toString().toFloatOrNull()
        val partitionval_float = partitioncmedt_CBC.toString().toFloatOrNull()


        if (linearlaypartition_CBC.visibility == View.VISIBLE){
            if (partitionval.isEmpty() || partitionval_float == null || partitionval_float !in 0f..99f) {
                partitioncmlay_CBC.error = "please enter the..."
                isvalid = false
            } else {
                partitioncmlay_CBC.error = null
            }

        }

        if (lengthbricksize.isEmpty()) {
            sizeofbricklencmlay_CBC.error = "please enter the..."
            isvalid = false
        } else {
            sizeofbricklencmlay_CBC.error = null
        }

        if (widthbricksize.isEmpty()) {
            sizeofbrickwidthcmlay_CBC.error = "please enter the..."
            isvalid = false
        } else {
            sizeofbrickwidthcmlay_CBC.error = null
        }
        if (heigthbricksize.isEmpty()) {
            sizeofbrickheightcmlay_CBC.error = "please enter the..."
            isvalid = false
        } else {
            sizeofbrickheightcmlay_CBC.error = null
        }

        if (linearlayfeetinch_CBC.visibility == View.VISIBLE) {

            if (lengthfeet.isEmpty()) {
                lenfeetlay_CBC.error = "please enter the value"
                isvalid = false
            } else {
                lenfeetlay_CBC.error = null
            }

            if (lengthinch.isEmpty() || lengthinch_float!! !in 0f..11f) {
                leninchlay_CBC.error = "please enter the value"
                isvalid = false
            } else {
                leninchlay_CBC.error = null
            }

            if (widthfeet.isEmpty()) {
                widthfeetlay_CBC.error = "please enter the value"
                isvalid = false
            } else {
                widthfeetlay_CBC.error = null
            }
            if (widthinch.isEmpty() || widthinch_float!! !in 0f..11f) {
                widthinchlay_CBC.error = "please enter the value"
                isvalid = false
            } else {
                widthinchlay_CBC.error = null
            }
        }
        if (linearlaymetercm_CBC.visibility == View.VISIBLE) {
            var lengthmeter = lenmeteredt_CBC.text.toString()
            var lengthcm = lencmedt_CBC.text.toString()
            var widthmeter = widthmeteredt_CBC.text.toString()
            var widthcm = widthcmedt_CBC.text.toString()

            val lengthmeter_float = lenmeteredt_CBC.text.toString().toFloatOrNull()
            val lengthcm_float = lencmedt_CBC.text.toString().toFloatOrNull()
            val widthmeter_float = widthmeteredt_CBC.text.toString().toFloatOrNull()
            val widthcm_float = widthcmedt_CBC.text.toString().toFloatOrNull()


            if (lengthmeter.isEmpty()) {
                lenmeterlay_CBC.error = "please enter the value"
                isvalid = false
            } else {
                lenmeterlay_CBC.error = null
            }

            if (lengthcm.isEmpty() || lengthcm_float!! !in 0f..99f) {
                lencmlay_CBC.error = "please enter the value"
                isvalid = false
            } else {
                lencmlay_CBC.error = null
            }

            if (widthmeter.isEmpty()) {
                widthmeterlay_CBC.error = "please enter the value"
                isvalid = false
            } else {
                widthmeterlay_CBC.error = null
            }
            if (widthcm.isEmpty() || widthcm_float!! !in 0f..99f) {
                widthcmlay_CBC.error = "please enter the value"
                isvalid = false
            } else {
                widthcmlay_CBC.error = null
            }
        }
        return isvalid
    }
    fun showfeetinclayCBC() {
        linearlayfeetinch_CBC.visibility = View.VISIBLE
        linearlaymetercm_CBC.visibility = View.INVISIBLE
    }
    fun showmetercmlayCBC() {
        linearlayfeetinch_CBC.visibility = View.INVISIBLE
        linearlaymetercm_CBC.visibility = View.VISIBLE
    }
    fun invisiblelayoutCBC() {
        linearlayall_CBC.visibility = View.INVISIBLE
    }

    fun showitemcalculatedCBC() {
        linearlayall_CBC.visibility = View.VISIBLE
        var selecteditemCBC1 = spinner2_CBC.selectedItem.toString()
        var selecteditemCBC2 = spinner2_CBC.selectedItem.toString()
        var lengthofblock = (sizeofbricklencmedt_CBC.text.toString().toFloatOrNull() ?: 0f ) * 0.0254f
        var widthofblock = (sizeofbrickwidthcmedt_CBC.text.toString().toFloatOrNull() ?: 0f ) * 0.0254f
        var heightofblock = (sizeofbrickheightcmedt_CBC.text.toString().toFloatOrNull() ?:0f ) * 0.0254f

        var lengthofblock1 = lengthofblock + 0.015f
        var widthofblock1 = widthofblock + 0.015f
        var heightofblock1 = heightofblock + 0.015f

        var size_of_block = lengthofblock1 * widthofblock1 * heightofblock1

        if (linearlayfeetinch_CBC.visibility == View.VISIBLE) {
            var total_length_feet = (lenfeetedt_CBC.text.toString().toFloatOrNull()
                ?: 0f) + (leninchedt_CBC.text.toString().toFloatOrNull() ?: 0f) / 12
            var total_width_feet = (widthfeetedt_CBC.text.toString().toFloatOrNull()
                ?: 0f) + (widthinchedt_CBC.text.toString().toFloatOrNull() ?: 0f) / 12


            // Check if "Other Partition" is selected in the spinner
            if (spinner1_CBC.selectedItem.toString() == "Other Partition") {
                // Directly get the value from the TextInputEditText (no validation)
                wallThicknessCm = partitioncmedt_CBC.text.toString().toFloatOrNull() ?: 0f
            } else {
                // Extract the wall thickness from the spinner selection
                wallThicknessCm = spinner1_CBC.selectedItem.toString()
                    .split(" ")[0].toFloatOrNull() ?: 0f
            }

            val wall_thickness_feet = wallThicknessCm / 30.48f // Convert CM to Feet
            var wall_thickness_formated = String.format("%.2f", wall_thickness_feet)

            var volume_feetcube = total_length_feet * total_width_feet * wall_thickness_feet //calculation for feet cube
            var feetcube_formatted = String.format("%.2f", volume_feetcube)
            var volume_metercube = volume_feetcube * 0.0283168f//calculation for meter cube
            var metercube_formatted = String.format("%.2f", volume_metercube)

            var noofblocks = volume_metercube / size_of_block
            var noofblocksformat = noofblocks.roundToInt()
            var actuallvolumeofbricksmortar = noofblocks * (lengthofblock * widthofblock * heightofblock)
            var quantity_of_mortar = volume_metercube - actuallvolumeofbricksmortar
            var quantity_of_mortar_15 = quantity_of_mortar + (quantity_of_mortar * 15 / 100)
            var quantity_of_mortar_25 = quantity_of_mortar_15 + (quantity_of_mortar_15 * 25 / 100)

            txttotalbricksreq_CBC.setText(noofblocksformat.toString())
            txttotalvolume_CBC.setText(metercube_formatted + " m³ or " + feetcube_formatted + "  ft³ ")


            when (selecteditemCBC2) {
                "C.M 1:3" -> {
                    val cement = (1f/4f) * quantity_of_mortar_25
                    val noofcementbags = cement /0.035f

                    val sand = (3f/4f) * quantity_of_mortar_25
                    val sandinkg = sand * 1550f
                    val sandinton = sandinkg/1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:4" -> {
                    val cement = (1f/5f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (4f/5f) * quantity_of_mortar_25
                    val sandinkg = sand * 1550f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:5" -> {
                    val cement = (1f/6f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (5f/6f) * quantity_of_mortar_25
                    val sandinkg = sand * 1550f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:6" -> {
                    val cement = (1f/7f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (6f/7f) * quantity_of_mortar_25
                    val sandinkg = sand * 1550f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:7" -> {
                    val cement = (1f/8f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (7f/8f) * quantity_of_mortar_25
                    val sandinkg = sand * 1550f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:8" -> {
                    val cement = (1f/9f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (8f/9f) * quantity_of_mortar_25
                    val sandinkg = sand * 1550f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:9" -> {
                    val cement = (1f/10f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (9f/10f) * quantity_of_mortar_25
                    val sandinkg = sand * 1550f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }
            }
        }
        if (linearlaymetercm_CBC.visibility == View.VISIBLE) {

            var total_length_meter = (lenmeteredt_CBC.text.toString().toFloatOrNull() ?: 0f) + (lencmedt_CBC.text.toString().toFloatOrNull() ?: 0f) / 100
            var total_width_meter = (widthmeteredt_CBC.text.toString().toFloatOrNull() ?: 0f) + (widthcmedt_CBC.text.toString().toFloatOrNull() ?: 0f) / 100


            // Check if "Other Partition" is selected in the spinner
            if (spinner1_CBC.selectedItem.toString() == "Other Partition") {
                // Directly get the value from the TextInputEditText (no validation)
                wallThicknessCm = partitioncmedt_CBC.text.toString().toFloatOrNull() ?: 0f
            } else {
                // Extract the wall thickness from the spinner selection
                wallThicknessCm = spinner1_CBC.selectedItem.toString()
                    .split(" ")[0].toFloatOrNull() ?: 0f
            }

            val wall_thickness_feet = wallThicknessCm / 100 // Convert CM to meter
            var wall_thickness_formated = String.format("%.2f", wall_thickness_feet)

            var metercube = total_length_meter * total_width_meter * wall_thickness_feet
            var metercube_formatted = String.format("%.2f", metercube)
            var volume_feetcube = metercube * 35.3147
            var feetcube_formatted = String.format("%.2f", volume_feetcube)


            var noofblocks = metercube / size_of_block
            var noofblocksformat = noofblocks.roundToInt()
            var actuallvolumeofbricksmortar = noofblocks * (lengthofblock * widthofblock * heightofblock)
            var quantity_of_mortar = metercube - actuallvolumeofbricksmortar
            var quantity_of_mortar_15 = quantity_of_mortar + (quantity_of_mortar * 15 / 100)
            var quantity_of_mortar_25 = quantity_of_mortar_15 + (quantity_of_mortar_15 * 25 / 100)


            txttotalbricksreq_CBC.setText(noofblocksformat.toString())
            txttotalvolume_CBC.setText(metercube_formatted +" m³ or "+ feetcube_formatted + " ft³")

            when (selecteditemCBC2) {
                "C.M 1:3" -> {
                    val cement = (1f/4f) * quantity_of_mortar_25
                    val noofcementbags = cement /0.035f

                    val sand = (3f/4f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg/1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:4" -> {
                    val cement = (1f/5f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (4f/5f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:5" -> {
                    val cement = (1f/6f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (5f/6f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:6" -> {
                    val cement = (1f/7f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (6f/7f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:7" -> {
                    val cement = (1f/8f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (7f/8f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:8" -> {
                    val cement = (1f/9f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (8f/9f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }

                "C.M 1:9" -> {
                    val cement = (1f/10f) * quantity_of_mortar_25
                    val noofcementbags = cement / 0.035f

                    val sand = (9f/10f) * quantity_of_mortar_25
                    val sandinkg = sand * 1500f
                    val sandinton = sandinkg / 1000f

                    updateMaterialList(noofcementbags, sandinton, noofblocksformat)
                }
            }
        }
    }

    fun showpartition() {
        var selecteditem3 = spinner1_CBC.selectedItem.toString()
        when (selecteditem3) {
            "other Partition" -> {
                if (linearlaypartition_CBC.visibility == View.GONE) {
                    linearlaypartition_CBC.visibility = View.VISIBLE
                }
            }

            "23 CM Wall" -> {
                if (linearlaypartition_CBC.visibility == View.VISIBLE) {
                    linearlaypartition_CBC.visibility = View.GONE
                }
            }

            "10 CM Wall" -> {
                if (linearlaypartition_CBC.visibility == View.VISIBLE) {
                    linearlaypartition_CBC.visibility = View.GONE
                }
            }
        }
    }
    fun updateMaterialList(cement: Float, sand: Float ,bricks:Int)
    {
        val cementBags = cement.roundToInt()  // Example calculation for bags of cement
        val sandTons = sand.roundToInt()  // Example conversion to tons
        val bricksreq = bricks

        Arrayimg_CBC = arrayOf(R.drawable.airconditioner, R.drawable.areagraph1,R.drawable.brickwall1)
        Arraytxt_CBC = arrayOf("cement", "sand","blocks")
        Arraycalcu_CBC = arrayOf(cementBags, sandTons , bricksreq )
        Arrayunit_CBC = arrayOf("Bags","Ton","Nos.")
        items1_CBC = mutableListOf()
        for (i in Arraytxt_CBC.indices) {
            val newItem = ListItem(Arrayimg_CBC[i], Arraytxt_CBC[i], Arraycalcu_CBC[i], Arrayunit_CBC[i])
            items1_CBC.add(newItem)
        }
        val adapter_CBC = AdapterListview(this, items1_CBC)
        listview_CBC.adapter = adapter_CBC

        updatePieChart(cementBags.toFloat(), sandTons.toFloat(), bricksreq.toFloat())
    }

    fun updatePieChart(cementValue: Float, sandValue: Float , bricksreqvalue: Float) {
        //piechart
        chartdata_CBC = ArrayList()
        chartdata_CBC.add(PieEntry(cementValue, "cement"))
        chartdata_CBC.add(PieEntry(sandValue, "Sand"))
        chartdata_CBC.add(PieEntry(bricksreqvalue, "blocks"))


        val dataSet_CBC = PieDataSet(chartdata_CBC, "Materails")
        dataSet_CBC.colors = listOf(
            Color.parseColor("#FF8A65"), // Cement
            Color.parseColor("#FFAB40"), // Steel
            Color.parseColor("#FFAB40"), // Steel
        )

        val data_CBC = PieData(dataSet_CBC)
        pieChart_CBC.data = data_CBC
        pieChart_CBC.description.isEnabled = false

        // Customize chart
        pieChart_CBC.holeRadius = 58f
        pieChart_CBC.centerText = "Materials"
        pieChart_CBC.isDrawHoleEnabled = true
        pieChart_CBC.transparentCircleRadius = 61f
        pieChart_CBC.invalidate()
        pieChart_CBC.setDrawCenterText(true)
        pieChart_CBC.animateY(1400)
        pieChart_CBC.setHoleColor(R.color.white)
        pieChart_CBC.setTransparentCircleAlpha(110)
    }
}