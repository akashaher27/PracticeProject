package com.example.practiceproject.app.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_detail")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    val key: Int = 0,
    @ColumnInfo(name = "recipe_name")
    var recipeName: String?,
    @ColumnInfo(name = "recipe_url")
    var url: String?
)
