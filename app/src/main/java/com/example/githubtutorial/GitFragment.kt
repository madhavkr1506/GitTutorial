package com.example.githubtutorial

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class GitFragment : Fragment() {
    private var detailedText: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragmentlayout, container, false)
        view.findViewById<TextView>(R.id.DetailedTextView).text = detailedText.toString();

        val closeButton = view.findViewById<Button>(R.id.CloseFragment);
        closeButton?.setOnClickListener{
            when(val parentActivity = activity){
                is GitBasic -> {
                    Log.d("Git Fragment","Closing Git Basic");
                    parentActivity.hideFragment();
                }
                is GitBranches -> {
                    Log.d("Git Fragment","Closing Git Branches");
                    parentActivity.hideFragment();
                }

                else -> {
                    Log.d("Git Fragment","Activity type not recognised");
                }
            }

        }

        return view
    }

    fun updateContent(content : String){
        detailedText = content;
    }


}