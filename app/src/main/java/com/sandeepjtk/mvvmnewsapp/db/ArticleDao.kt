package com.sandeepjtk.mvvmnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.sandeepjtk.mvvmnewsapp.model.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = REPLACE)
    suspend fun upsert(article: Article):Long

    @Query("select * from articles")
    fun getAllArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}