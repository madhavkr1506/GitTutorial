package com.example.githubtutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubtutorial.databinding.RewritinggithistoryBinding

class RewritingGitHistory : AppCompatActivity() {
    private val binding : RewritinggithistoryBinding by lazy{
        RewritinggithistoryBinding.inflate(layoutInflater);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(binding.root);

        val commandList = listOf(" git commit --amend","git rebase <base>", "git reflog");
        val commandDescription = listOf("Replace the last commit with the staged changes and last commit \n" +
                "combined. Use with nothing staged to edit the last commit’s message.","Rebase the current branch onto <base>. <base> can be a commit ID,  \n" +
                "a branch name, a tag, or a relative reference to HEAD.", "Show a log of changes to the local repository’s HEAD. Add --relative-date flag to show date info or --all to show all refs.");

        val adapter = CustomAdapterGitBasic(this,commandList,commandDescription);
        binding.GitHistory.adapter = adapter;



    }
}