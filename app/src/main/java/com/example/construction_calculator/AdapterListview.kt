package com.example.construction_calculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterListview(val context: Context, val datasource: List<ListItem>) : BaseAdapter() {
    lateinit var   calculatedval : TextView
    lateinit var   text : TextView
    lateinit var   unit : TextView
    lateinit var image : ImageView

    val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
       return datasource.size
    }

    override fun getItem(position: Int): Any {
return datasource[position]
    }

    override fun getItemId(position: Int): Long {
return position.toLong()
   }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val row = inflater.inflate(R.layout.constructioncostlistview,parent,false)

        image = row.findViewById(R.id.imgicon)
        text = row.findViewById(R.id.line2)
        unit = row.findViewById(R.id.txtunit)
        calculatedval = row.findViewById(R.id.line3)

        val item = getItem(position) as ListItem

        image.setImageResource(item.imageicon)
        text.text=item.text
        unit.text = item.unit
        calculatedval.text = item.calculatedValue.toString()

        return row
    }
}