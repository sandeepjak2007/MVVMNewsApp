package com.sandeepjtk.mvvmnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androiddevs.mvvmnewsapp.R
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sandeepjtk.mvvmnewsapp.db.ArticleDatabase
import com.sandeepjtk.mvvmnewsapp.ui.NewsViewModel
import com.sandeepjtk.mvvmnewsapp.ui.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel =ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)
        setContentView(R.layout.activity_news)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}
