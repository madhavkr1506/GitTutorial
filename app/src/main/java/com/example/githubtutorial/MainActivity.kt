package com.example.githubtutorial

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.githubtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(binding.root);

        val animation : Animation = AnimationUtils.loadAnimation(this,R.anim.zoomanimation);
        binding.GitHubFrontPage.startAnimation(animation);

        binding.MoveToGitIndex.setOnClickListener{
            startActivity(Intent(this,GitIndex::class.java));
        }
    }
}