package com.example.construction_calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.get
import androidx.core.view.isInvisible
import androidx.core.view.marginBottom
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

lateinit var btnadd  : Button
lateinit var spinner : Spinner
lateinit var imgback : ImageView
var Totalcarpetarea               : Float = 0.0f
var Total_builthup_area           : Float = 0.0f
var Total_super_builthup_area     : Float = 0.0f
lateinit var carpetadapter        : Adapterlistviewca
lateinit var lentfeetlay          : TextInputLayout
lateinit var edtlenfeet           : TextInputEditText
lateinit var lentinclay           : TextInputLayout
lateinit var edtleninch           : TextInputEditText
lateinit var breadthfeetlay       : TextInputLayout
lateinit var edtbrefeet           : TextInputEditText
lateinit var breadthinclay        : TextInputLayout
lateinit var edtbreinch           : TextInputEditText
lateinit var txt_carpetarea       : TextView
lateinit var txt_builtuparea      : TextView
lateinit var txt_superbuiltuparea : TextView
lateinit var listviewcarpetarea   : ListView
lateinit var layoutcarpet         : LinearLayout
lateinit var adapter              : ArrayAdapter<CharSequence>
lateinit var itemca               : MutableList<ListItem2>

class Carpet_Area : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carpet_area)


        itemca = mutableListOf()
        btnadd = findViewById(R.id.addbtn)
        spinner = findViewById(R.id.spinner)
        imgback = findViewById(R.id.backbtnCA)
        lentfeetlay = findViewById(R.id.txtinputlaylenfeet)
        edtlenfeet = findViewById(R.id.edtlenfeet)
        lentinclay = findViewById(R.id.txtinputlayleninches)
        edtleninch = findViewById(R.id.edtleninches)
        breadthfeetlay = findViewById(R.id.txtinputlaylenbreadht)
        edtbrefeet = findViewById(R.id.edtbrefeet)
        breadthinclay = findViewById(R.id.txtinputlaybreinches)
        edtbreinch = findViewById(R.id.edtbreinches)
        txt_carpetarea = findViewById(R.id.txtcarpetarea)
        txt_builtuparea = findViewById(R.id.txt_builtup_area)
        txt_superbuiltuparea = findViewById(R.id.txt_Super_Buildup_Area)
        listviewcarpetarea = findViewById(R.id.listview_carpetarea)
        layoutcarpet = findViewById(R.id.layout_carpet_area)

        adapter = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        spinner.adapter = adapter
        btnadd.setOnClickListener {
            if (check()) {
                showitemcalculated()
            }
        }
        imgback.setOnClickListener {
            var intent = Intent(this@Carpet_Area, Home_Screen::class.java)
            startActivity(intent)
        }

        // Initialize the adapter
        carpetadapter = Adapterlistviewca(this, itemca) { position ->
            deleteitem(position) // Pass the delete function
        }
        listviewcarpetarea.adapter = carpetadapter

    }


    fun check(): Boolean {
        val lengthfeet = edtlenfeet.text.toString()
        val lengthinches = edtleninch.text.toString()
        val lengthfeetfloat = edtlenfeet.text.toString().toFloatOrNull()
        val lengthinchesfloat = edtleninch.text.toString().toFloatOrNull()

        val breadthfeet = edtbrefeet.text.toString()
        val breadthinches = edtbreinch.text.toString()
        val breadthfeetfloat = edtbrefeet.text.toString().toFloatOrNull()
        val breadthinchesfloat = edtbreinch.text.toString().toFloatOrNull()

        var isvalid = true

        if (lengthfeet.isEmpty()) {
            lentfeetlay.error = "please enter the value"
            isvalid = false
        } else {
            edtlenfeet.setBackgroundResource(R.drawable.spinnerstyle)
            lentfeetlay.error = null
        }
        if (lengthinches.isEmpty() || lengthinchesfloat!! !in 0f..11f) {
            lentinclay.error = "enter value between 0 to 11"
            edtleninch.setBackgroundResource(R.drawable.spinnerstyle)
            isvalid = false
        } else {
            edtleninch.setBackgroundResource(R.drawable.spinnerstyle)
            lentinclay.error = null
        }
        if (breadthfeet.isEmpty()) {
            breadthfeetlay.error = "please enter the value"
            edtbrefeet.setBackgroundResource(R.drawable.spinnerstyle)
            isvalid = false
        } else {
            edtbrefeet.setBackgroundResource(R.drawable.spinnerstyle)
            breadthfeetlay.error = null
        }
        if (breadthinches.isEmpty() || breadthinchesfloat!! !in 0f..11f) {
            breadthinclay.error = "enter value between 0 to 11"
            edtbreinch.setBackgroundResource(R.drawable.spinnerstyle)
            isvalid = false
        } else {
            edtbreinch.setBackgroundResource(R.drawable.spinnerstyle)
            breadthinclay.error = null
        }


        return isvalid
    }

    fun showitemcalculated() {
        layoutcarpet.visibility = View.VISIBLE


        val selectedroom = spinner.selectedItem.toString()
        var total_len =
            (edtlenfeet.text.toString().toFloatOrNull() ?: 0f) + (edtleninch.text.toString()
                .toFloatOrNull() ?: 0f) / 12
        val total_bre =
            (edtbrefeet.text.toString().toFloatOrNull() ?: 0f) + (edtbreinch.text.toString()
                .toFloatOrNull() ?: 0f) / 12

        val total_len_formatted = String.format("%.2f", total_len)
        val total_bre_formatted = String.format("%.2f", total_bre)

        val area = total_len * total_bre

        var carpetarea = 0f
        var builtuparea = 0f
        var superbuiltuparea = 0f
        when (selectedroom) {
            "Bedroom", "Living", "Dining", "Kitchen", "Bathroom" -> {
                carpetarea = area
                builtuparea = carpetarea * 1.20f  // 20% more
                superbuiltuparea = carpetarea * 1.20f  // 20% more (same as built-up)
            }

            "Balcony" -> {
                carpetarea = area
                builtuparea = carpetarea * 1.20f  // 20% more
                superbuiltuparea = carpetarea * 2.20f  // 120% more
            }

            "Passage", "Duct", "Garden", "Lobby", "Lift", "Gym", "Swimming Pool", "Terrace", "Staircase" -> {
                carpetarea = 0f
                builtuparea = 0f
                superbuiltuparea = area  // Use the entire area as super built-up
            }
        }
        Totalcarpetarea += carpetarea
        Total_builthup_area += builtuparea
        Total_super_builthup_area += superbuiltuparea

        updateFields()


        val newItem = ListItem2(
            selectedroom,
            "(${total_len_formatted} x ${total_bre_formatted})",superbuiltuparea.toFloat()
        )
        // Add the new item to the list
        itemca.add(newItem)
        carpetadapter.notifyDataSetChanged()

        /* when (selectedroom)
        {
            "Bedroom", "Living", "Dining", "Kitchen", "Bathroom" -> {
                val carpetarea = area
                val carpetarea_formatted = String.format("%.2f", carpetarea)
                Totalcarpetarea += carpetarea
                val Totalcarpetarea_formatted = String.format("%.2f", Totalcarpetarea)
                val builtupareaval = carpetarea * 1.20f
                val builtupareaval_formatted = String.format("%.2f", builtupareaval)
                Total_builthup_area += builtupareaval
                val Total_builthup_area_formatted = String.format("%.2f", Total_builthup_area)
                val superbuiltupareaval = carpetarea * 1.20f
                val superbuiltupareaval_formatted = String.format("%.2f", superbuiltupareaval)
                Total_super_builthup_area += superbuiltupareaval
                val Total_super_builthup_area_formatted =
                    String.format("%.2f", Total_super_builthup_area)
                txt_carpetarea.setText(Totalcarpetarea_formatted.toString() + "ft²")
                txt_builtuparea.setText(Total_builthup_area_formatted.toString() + " ft²")
                txt_superbuiltuparea.setText(Total_super_builthup_area_formatted.toString() + " ft²")

                val newItem = ListItem2(
                    selectedroom,
                    "(${total_len_formatted} x ${total_bre_formatted})",
                    superbuiltupareaval_formatted.toFloat()
                )
                // Add the new item to the list
                itemca.add(newItem)
                carpetadapter = Adapterlistviewca(this, itemca)
                listviewcarpetarea.adapter = carpetadapter
                adapter.notifyDataSetChanged()
            }
            "Balcony" -> {
                val carpetarea = area
                val carpetarea_formatted = String.format("%.2f", carpetarea)
                Totalcarpetarea += carpetarea
                val Totalcarpetarea_formatted = String.format("%.2f", Totalcarpetarea)
                val builtupareaval = carpetarea * 1.20f
                val builtupareaval_formatted = String.format("%.2f", builtupareaval)
                Total_builthup_area += builtupareaval
                val Total_builthup_area_formatted = String.format("%.2f", Total_builthup_area)
                val superbuiltupareaval = carpetarea * 2.20f
                val superbuiltupareaval_formatted = String.format("%.2f", superbuiltupareaval)
                Total_super_builthup_area += superbuiltupareaval
                val Total_super_builthup_area_formatted =
                    String.format("%.2f", Total_super_builthup_area)
                txt_carpetarea.setText(Totalcarpetarea_formatted.toString() + "ft²")
                txt_builtuparea.setText(Total_builthup_area_formatted.toString() + " ft²")
                txt_superbuiltuparea.setText(Total_super_builthup_area_formatted.toString() + " ft²")

                val newItem = ListItem2(
                    selectedroom,
                    "(${total_len_formatted} x ${total_bre_formatted})",
                    superbuiltupareaval_formatted.toFloat()
                )
                // Add the new item to the list
                itemca.add(newItem)
                carpetadapter = Adapterlistviewca(this, itemca)
                listviewcarpetarea.adapter = carpetadapter
                adapter.notifyDataSetChanged()
            }
            "Passage", "Duct", "Garden", "Lobby", "Lift", "Gym", "Swimming Pool", "Terrace", "Staircase" -> {
                val carpetArea = 0
                val builtupareaval = 0
                val superbuiltupareaval = area
                val superbuiltupareaval_formatted = String.format("%.2f", superbuiltupareaval)
                Total_super_builthup_area += superbuiltupareaval
                val Total_super_builthup_area_formatted = String.format("%.2f", Total_super_builthup_area)

                txt_carpetarea.setText(carpetArea.toString() + "ft²")
                txt_builtuparea.setText(builtupareaval.toString() + " ft²")
                txt_superbuiltuparea.setText(Total_super_builthup_area_formatted.toString() + " ft²")

                val newItem = ListItem2(
                    selectedroom,
                    "(${total_len_formatted} x ${total_bre_formatted})",
                    superbuiltupareaval_formatted.toFloat()
                )
                // Add the new item to the list
                itemca.add(newItem)
                carpetadapter = Adapterlistviewca(this, itemca)
                listviewcarpetarea.adapter = carpetadapter
                adapter.notifyDataSetChanged()
            }
        }*/
        edtlenfeet.setText("")
        edtleninch.setText("")
        edtbrefeet.setText("")
        edtbreinch.setText("")
        spinner.setSelection(0)
    }

    @SuppressLint("SuspiciousIndentation")
    fun deleteitem(position: Int) {
        // Ensure valid position
        if (position < 0 || position >= itemca.size) return

        val deleteditem = itemca[position]

        // Subtract the total areas based on the deleted item's type (room category)
        when (deleteditem.name) {
            "Bedroom", "Living", "Dining", "Kitchen", "Bathroom" -> {
                val superbuiltupArea = deleteditem.totalarea
                val builtUpArea = superbuiltupArea / 1.00f // Since the superbuiltupArea = builtUpArea * 1.20
                val carpetArea = superbuiltupArea / 1.20f       // Since the builtUpArea = carpetArea * 1.20

                // Subtract from the totals
                Total_super_builthup_area -= superbuiltupArea
                Total_builthup_area -= builtUpArea
                Totalcarpetarea -= carpetArea
            }
            "Balcony" -> {
                val superbuiltupArea = deleteditem.totalarea
                val builtUpArea = superbuiltupArea / 2.0f // Balcony uses 2.20 multiplier
                val carpetArea = superbuiltupArea / 2.20f       // Built-up area uses 1.20 multiplier

                // Subtract from the totals
                Total_super_builthup_area -= superbuiltupArea
                Total_builthup_area -= builtUpArea
                Totalcarpetarea -= carpetArea
            }
            else -> {
                // For other rooms, only the super built-up area matters
                Total_super_builthup_area -= deleteditem.totalarea
            }
        }

        // Remove the item from the list
        itemca.removeAt(position)
        carpetadapter.notifyDataSetChanged()

        // Update the displayed totals
        updateFields()
        }
    fun updateFields() {
        txt_carpetarea.text = String.format("%.2f ft²", Totalcarpetarea)
        txt_builtuparea.text = String.format("%.2f ft²", Total_builthup_area)
        txt_superbuiltuparea.text = String.format("%.2f ft²", Total_super_builthup_area)
    }


}

