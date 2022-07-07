package com.example.practiceproject.app.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TestEntity(
    @PrimaryKey
    val key: Int,
    @ColumnInfo
    val nameL: String
)