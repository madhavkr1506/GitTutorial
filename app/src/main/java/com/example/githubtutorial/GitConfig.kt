package com.example.githubtutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubtutorial.databinding.GitconfigBinding

class GitConfig : AppCompatActivity() {
    private val binding : GitconfigBinding by lazy {
        GitconfigBinding.inflate(layoutInflater);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root);

        val commandList = listOf("git config --global \n" +
                "user.name <name>","git config --global \n" +
                "user.email <email>"," git config --global \n" +
                "alias. <alias-name> \n" +
                "<git-command>"," git config --system \n" +
                "core.editor <editor>"," git config  --global --edit");

        val commandDescription = listOf("Define the author name to be used for all commits by the current user."," Define the author email to be used for all commits by the current user."," Create shortcut for a Git command. E.g. alias.glog log --graph --oneline will set git glog equivalent to git log --graph --oneline.","Set text editor used by commands for all users on the machine. <editor> \n" +
                "arg should be the command that launches the desired editor (e.g., vi).","Open the global configuration file in a text editor for manual editing.");

        val adapter = CustomAdapterGitBasic(this,commandList,commandDescription);
        binding.GitConfig.adapter = adapter;
    }
}