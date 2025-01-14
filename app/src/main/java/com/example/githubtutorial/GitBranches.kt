package com.example.githubtutorial

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.githubtutorial.databinding.GitbranchesBinding

class GitBranches : AppCompatActivity() {

    private val binding : GitbranchesBinding by lazy {
        GitbranchesBinding.inflate(layoutInflater);
    }

    private val fm : FragmentManager = supportFragmentManager;
    //    private val ft : FragmentTransaction = fm.beginTransaction();
    private val fragment : GitFragment = GitFragment();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(binding.root);

        val commandList = listOf("  git branch"," git checkout -b \n" +
                "<branch>", " git merge <branch>");
        val commandDescription = listOf(" List all of the branches in your repo. Add a <branch> argument to \n" +
                "create a new branch with the name <branch>.","Create and check out a new branch named <branch>. Drop the -b \n" +
                "flag to checkout an existing branch.", "Merge <branch> into the current branch.");

        val adapter = CustomAdapterGitBasic(this,commandList,commandDescription);
        binding.GitBranches.adapter = adapter;

        binding.GitBranches.setOnItemClickListener{_, _, position, _ ->
            Toast.makeText(this,"selected: ${commandDescription[position]}", Toast.LENGTH_SHORT).show();
            val description = commandDescription[position];
            showFragment(description);
        }
    }

    fun showFragment(description : String){
        fragment.updateContent(description);
        val ft : FragmentTransaction = fm.beginTransaction();
        if(fragment.isAdded){
            ft.replace(R.id.container,fragment);
        }else{
            ft.add(R.id.container,fragment);
        }
        ft.commit();
        binding.GitBranches.isEnabled = false
    }

    fun hideFragment(){
        val ft : FragmentTransaction = fm.beginTransaction();

        if(fragment.isAdded ){
            ft.remove(fragment);
            ft.commitNow();
        }
        binding.GitBranches.isEnabled = true


    }
}