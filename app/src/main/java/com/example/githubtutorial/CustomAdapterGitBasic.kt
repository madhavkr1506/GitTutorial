package com.example.githubtutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapterGitBasic(context : Context, private val commandList : List<String>, private val descriptionList : List<String>) : ArrayAdapter<String>(context,android.R.layout.simple_list_item_1, commandList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context);
        val rowView = convertView ?: inflater.inflate(R.layout.gitbasiclistlayout,parent,false);

        val command = rowView.findViewById<TextView>(R.id.Text);
        val cmdDescription = rowView.findViewById<TextView>(R.id.Description);

        command.text = commandList[position];
        cmdDescription.text = descriptionList[position];

        return rowView;
    }

}