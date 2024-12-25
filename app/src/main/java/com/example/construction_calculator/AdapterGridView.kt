package com.example.construction_calculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeLifecycleOwner

lateinit var layoutInflater: LayoutInflater
lateinit var icnimg : ImageView
lateinit var icnname : TextView
class AdapterGridView(var iconlist: List<GridViewModel>,var context: Context): BaseAdapter() {
    override fun getCount(): Int {
    return iconlist.size
    }

    override fun getItem(position: Int): Any? {
return null
    }

    override fun getItemId(position: Int): Long {

        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView

        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        convertView = layoutInflater!!.inflate(R.layout.gridviewdesign,null)


        icnimg =convertView!!.findViewById(R.id.imgicon)
        icnname = convertView!!.findViewById(R.id.iconname)

        icnimg.setImageResource(iconlist.get(position).iconimage)
        icnname.setText(iconlist.get(position).textname)

return convertView

    }
}