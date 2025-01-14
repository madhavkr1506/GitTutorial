package com.example.githubtutorial

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.githubtutorial.databinding.ActivityMainBinding
import com.example.githubtutorial.databinding.GittutorialindexBinding

class GitIndex : AppCompatActivity() {
    private val binding : GittutorialindexBinding by lazy {
        GittutorialindexBinding.inflate(layoutInflater);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(binding.root);
        val gitIndex = listOf("Git Basic", "Undoing Changes", "Rewriting Git History", "Git Branches", "Remote Repositories", "Git Config", "Git Log", "Git Diff", "Git Reset", "Git Rebase", "Git Pull", "Git Push");


        val adapter = CustomAdapter(this,gitIndex);
        binding.GitIndex.adapter = adapter;

        binding.GitIndex.setOnItemClickListener{adapterView, view, position, id ->
            val selectedItem = gitIndex[position];
            if(selectedItem.equals("Git Basic",true)){
                startActivity(Intent(this,GitBasic::class.java));
            }
            else if(selectedItem.equals("Undoing Changes",true)){
                startActivity(Intent(this,UndoingChanges::class.java));
            }
            else if(selectedItem.equals("Remote Repositories",true)){
                startActivity(Intent(this,RemoteRepositories::class.java));
            }
            else if(selectedItem.equals("Rewriting Git History",true)){
                startActivity(Intent(this,RewritingGitHistory::class.java));
            }
            else if(selectedItem.equals("Git Branches",true)){
                startActivity(Intent(this,GitBranches::class.java));
            }
            else if(selectedItem.equals("Git Config",true)){
                startActivity(Intent(this,GitConfig::class.java));
            }
            else if(selectedItem.equals("Git Log",true)){
                startActivity(Intent(this,GitLog::class.java));
            }
        }


    }
}