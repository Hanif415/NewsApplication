package com.example.newsapplication.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

@Entity(tableName = "searchNews")
@Parcelize
data class SearchNewsEntity(
    @PrimaryKey @ColumnInfo(name = "newsId") var id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "publishedAt") var publishedAt: String,
    @ColumnInfo(name = "author") var author: String,
    @ColumnInfo(name = "urlToImage") var urlToImage: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "source") var source: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "url") var url: String,
    @ColumnInfo(name = "content") var content: String
) : Parcelable