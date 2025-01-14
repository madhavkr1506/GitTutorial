package com.example.githubtutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubtutorial.databinding.GitlogBinding

class GitLog : AppCompatActivity() {
    private val binding : GitlogBinding by lazy {
        GitlogBinding.inflate(layoutInflater);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root);

        val commandList = listOf(" git log -<limit>","git log --oneline"," git log -p","git log --stat"," git log --author= \n" +
                "<pattern>"," git log --grep=”<pattern>”"," git log --grep=”<pattern>”"," git log \n" +
                "<since>..<until>","git log -- <file>","git log --graph --decorate");

        val commandDescription = listOf("Limit number of commits by <limit>. E.g. git log -5 will limit to 5 \n" +
                "commits.","Condense each commit to a single line."," Display the full diff of each commit.","Include which files were altered and the relative number of lines \n" +
                "that were added or deleted from each of them.","Search for commits by a particular author","Search for commits with a commit message that matches <pattern>","Show commits that occur between <since> and <until>. Args can be a \n" +
                "commit ID, branch name, HEAD, or any other kind of revision reference.","Only display commits that have the specified file.","--graph flag draws a text based graph of commits on left side of commit \n" +
                "msgs. --decorate adds names of branches or tags of commits shown.");

        val adapter = CustomAdapterGitBasic(this,commandList,commandDescription);
        binding.GitLog.adapter = adapter;
    }
}