package com.example.githubtutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubtutorial.databinding.RemoterepositoriesBinding

class RemoteRepositories : AppCompatActivity() {
    private val binding : RemoterepositoriesBinding by lazy {
        RemoterepositoriesBinding.inflate(layoutInflater);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(binding.root);

        val commandList = listOf("git remote add \n" +
                "<name> <url>","git fetch \n" +
                "<remote> <branch>"," git pull <remote>","git push \n" +
                "<remote> <branch>");
        val commandDescription = listOf("Create a new connection to a remote repo. After adding a remote, \n" +
                "you can use <name> as a shortcut for <url> in other commands"," Fetches a specific <branch>, from the repo. Leave off <branch> to \n" +
                "fetch all remote refs."," Fetch the specified remote’s copy of current branch and immediately \n" +
                "merge it into the local copy."," Push the branch to <remote>, along with necessary commits and \n" +
                "objects. Creates named branch in the remote repo if it doesn’t exist.");

        val adapter = CustomAdapterGitBasic(this,commandList,commandDescription);
        binding.RemoteRepositories.adapter = adapter;
    }
}