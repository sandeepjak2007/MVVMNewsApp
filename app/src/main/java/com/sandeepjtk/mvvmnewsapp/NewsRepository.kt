package com.sandeepjtk.mvvmnewsapp

import com.sandeepjtk.mvvmnewsapp.api.RetrofitInstance
import com.sandeepjtk.mvvmnewsapp.db.ArticleDatabase
import com.sandeepjtk.mvvmnewsapp.model.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(
        countryCode: String,
        pageSize: Int
    ) = RetrofitInstance.api.getBreakingNews(countryCode, pageSize)

    suspend fun searchNewsResponse(
        searchQuery: String,
        pageSize: Int
    ) = RetrofitInstance.api.searchForNews(searchQuery, pageSize)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}