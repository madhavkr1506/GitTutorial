package com.example.githubtutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapter(context : Context, private val itemList : List<String>) : ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,itemList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context);
        val rowView = convertView ?:  inflater.inflate(R.layout.gitindexlistlayout,parent,false);
        val listText = rowView.findViewById<TextView>(R.id.Text);
        listText.text = itemList[position];
        return rowView;
    }
}