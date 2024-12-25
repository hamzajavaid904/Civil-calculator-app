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
import android.widget.ListView
import android.widget.SimpleAdapter
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

lateinit var dropdownmenu : AutoCompleteTextView
lateinit var adapter1           : ArrayAdapter<CharSequence>
lateinit var imgback_SR          : ImageView
lateinit var button_calculator_SR : Button
lateinit var button_reset_SR      : Button
lateinit var listviewSR : ListView
lateinit var units : TextInputLayout
lateinit var edtunits : TextInputEditText

class Solar_Rooftop : AppCompatActivity() {
    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solar_rooftop)

        dropdownmenu = findViewById(R.id.dropdown_menuSR)
        imgback_SR = findViewById(R.id.backbtnSR)
        button_reset_SR = findViewById(R.id.buttonresetSR)
        button_calculator_SR = findViewById(R.id.buttoncalculatorSR)
        listviewSR = findViewById(R.id.listview_SR)
        units = findViewById(R.id.txtinputlayunitsSR)
        edtunits = findViewById(R.id.edtunitsSR)



        adapter1 = ArrayAdapter.createFromResource(
            this,
            R.array.dropdown,
            android.R.layout.simple_dropdown_item_1line
        )
        dropdownmenu.setAdapter(adapter1)

        imgback_SR.setOnClickListener {
            var intent = Intent(this@Solar_Rooftop, Home_Screen::class.java)
            startActivity(intent)
        }

        button_reset_SR.setOnClickListener {
            edtunits.setText("")
            listviewSR.visibility = View.INVISIBLE
        }

        button_calculator_SR.setOnClickListener {
            if (check()) {
                listviewSR.visibility = View.VISIBLE
                calculate()
            }
        }
    }

    fun check(): Boolean {
        var isvalid = true
        var unitchecks = edtunits.text.toString()
        if (unitchecks.isEmpty())
        {
            units.error = "enter value"
            isvalid = false
        }
        else
        {
            units.error = null
        }
        return isvalid
    }

    fun calculate(){
var itemselected= dropdownmenu.text.toString()

        var Daily_unit_consumption = 0f
        var Kw_system = 0f
        var Number_of_panels = 0f
        var Area_req_rooftop = 0f
        var unitreq = edtunits.text.toString().toFloatOrNull()  ?: 0f

        when(itemselected){
            "Monthly Unit Consumption" ->{
                Daily_unit_consumption = unitreq / 30f
                Kw_system = Daily_unit_consumption / 4.5f
                Number_of_panels = Kw_system * 3f
                Area_req_rooftop = Kw_system * 95f

                itemupdate(Daily_unit_consumption,Kw_system,Number_of_panels,Area_req_rooftop)
            }
            "yearly Unit Consumption" ->
            {

                var monthly_unit_year = unitreq/12f
                 Daily_unit_consumption = monthly_unit_year / 30f
                 Kw_system = Daily_unit_consumption/4.5f
                Number_of_panels = Kw_system *3f
                Area_req_rooftop = Kw_system *95f

                itemupdate(Daily_unit_consumption,Kw_system,Number_of_panels,Area_req_rooftop)

            }
        }



    }

    fun itemupdate (Daily_units : Float , KwSys : Float , panels :Float , area : Float){

        val list1Data = ArrayList<HashMap<String, String>>()
        val item1 = HashMap<String, String>()
        item1["image"] = R.drawable.meter.toString()
        item1["name"] = "Daily_units"
        item1["value"] ="%.2f".format(Daily_units)
        list1Data.add(item1)

        val item2 = HashMap<String, String>()
        item2["image"] = R.drawable.unit.toString()
        item2["name"] = "Kw system reqiured"
        item2["value"] = "%.2f".format(KwSys)
        list1Data.add(item2)

        val item3 = HashMap<String, String>()
        item3["image"] = R.drawable.solarpanel.toString()
        item3["name"] = "panels"
        item3["value"] = "%.0f".format(panels)
        list1Data.add(item3)

        val item4 = HashMap<String, String>()
        item4["image"] = R.drawable.building.toString()
        item4["name"] = "area"
        item4["value"] ="%.2f".format(area)
        list1Data.add(item4)

        val from = arrayOf("image", "name", "value")
        val to = intArrayOf(R.id.materialImageView, R.id.text1, R.id.text2)

        val adapter_fc = SimpleAdapter(this, list1Data, R.layout.solaritemview, from, to)
        listviewSR.adapter = adapter_fc
    }
}

