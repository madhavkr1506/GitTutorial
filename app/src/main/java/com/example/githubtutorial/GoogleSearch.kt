package com.example.githubtutorial

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.githubtutorial.databinding.GooglesearchBinding

class GoogleSearch : AppCompatActivity() {

    private val binding : GooglesearchBinding by lazy {
        GooglesearchBinding.inflate(layoutInflater);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(binding.root);
        binding.searchIcon.setOnClickListener{
            val userid = binding.searchBar.text.toString();
            simplehttpserver(userid);
        }
    }

    private fun simplehttpserver(userid : String){
        try{
            val intent = Intent(Intent.ACTION_VIEW);
            intent.data = Uri.parse("https://github.com/$userid");
            startActivity(intent);
        }catch (e : Exception){
            Toast.makeText(this,"No user found",Toast.LENGTH_LONG).show();
        }
    }
}