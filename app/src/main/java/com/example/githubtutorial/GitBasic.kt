package com.example.githubtutorial

import android.graphics.Insets.add
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit;
import androidx.fragment.app.replace
import com.example.githubtutorial.databinding.BasicgitBinding

class GitBasic : AppCompatActivity() {
    private val binding : BasicgitBinding by lazy{
        BasicgitBinding.inflate(layoutInflater);
    }

    private val fm : FragmentManager = supportFragmentManager;
//    private val ft : FragmentTransaction = fm.beginTransaction();
    private val fragment : GitFragment = GitFragment();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(binding.root);

        val listOfCommands = listOf("git init <directory>","git clone <repo>","git config user.name <name>","git add <directory>","git commit -m \"<message>\"","git status","git log","git diff");
        val commandDescription = listOf("Create empty git repository in specified directory. Run with no arguments o initialize the current directory as git repository.","Clone repo located at <repo> onto local machine.","Define author name to be used for all commits in current repo.","Stage all changes in <directory> for the next commit. Replace <directory> with a <file> to change a specific file.","Commit the staged snapshot.","List which files are staged, unstaged and untracked.","Display the entire commit history.","Show unstaged changes between your index and working directory.");

        val adapter = CustomAdapterGitBasic(this,listOfCommands,commandDescription);
        binding.BasicGit.adapter = adapter;

        binding.BasicGit.setOnItemClickListener{_, _, position, _ ->
            Toast.makeText(this,"selected: ${listOfCommands[position]}",Toast.LENGTH_SHORT).show();
            val description = commandDescription[position];
            showFragment(description);
        }

//        val layoutView = LayoutInflater.from(this).inflate(R.layout.fragmentlayout,null);
//        val closeButton = layoutView.findViewById<Button>(R.id.CloseFragment);

//        closeButton.setOnClickListener{
//            if(fragment.isAdded){
//                hideFragment();
//            }
//        }
//        binding.root.setOnClickListener{
//            if(fragment.isAdded){
//                hideFragment();
//            }
//        }

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
        binding.BasicGit.isEnabled = false
    }

    fun hideFragment(){
        val ft : FragmentTransaction = fm.beginTransaction();

        if(fragment.isAdded ){
            ft.remove(fragment);
            ft.commitNow();
        }
        binding.BasicGit.isEnabled = true


    }




}