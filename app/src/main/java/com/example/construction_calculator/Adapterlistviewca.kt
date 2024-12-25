package com.example.construction_calculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

lateinit var totalarea : TextView
lateinit var   Name : TextView
lateinit var   carpetarea : TextView
lateinit var imgdlt : ImageView
class Adapterlistviewca (context: Context, val datasource: List<ListItem2> ,  val deleteItemCallback: (Int) -> Unit) : BaseAdapter() {

    val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

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

        val row = inflater.inflate(R.layout.listview_carpetarea_style, parent, false)


        Name = row.findViewById(R.id.txtname)
        carpetarea = row.findViewById(R.id.txtarea)
        totalarea = row.findViewById(R.id.txttotalarea)
        imgdlt = row.findViewById(R.id.deleteimg)

        val currentitem = itemca[position]
        val item = getItem(position) as ListItem2

        Name.text = item.name
        carpetarea.text = item.area.toString()
        totalarea.text = item.totalarea.toString()

imgdlt.setOnClickListener {

    deleteItemCallback(position)
}
        return row
    }
}

