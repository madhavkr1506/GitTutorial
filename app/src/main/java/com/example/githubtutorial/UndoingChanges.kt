package com.example.githubtutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubtutorial.databinding.UndoingchangesBinding

class UndoingChanges : AppCompatActivity() {

    private val binding : UndoingchangesBinding by lazy {
        UndoingchangesBinding.inflate(layoutInflater);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(binding.root);

        val commandList = listOf(" git revert  \n" +
                "<commit>","git reset <file>","git clean -n");
        val commandDescription = listOf(" Create new commit that undoes all of the changes made in \n" +
                "<commit>, then apply it to the current branch.","Remove <file> from the staging area, but leave the working directory \n" +
                "unchanged. This unstages a file without overwriting any changes."," Shows which files would be removed from working directory. Use \n" +
                "the -f flag in place of the -n flag to execute the clean.");

        val adapter = CustomAdapterGitBasic(this,commandList,commandDescription);
        binding.UndoingChanges.adapter = adapter;

    }


}