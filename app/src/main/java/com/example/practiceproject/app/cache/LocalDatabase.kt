package com.example.practiceproject.app.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practiceproject.app.cache.dao.RecipeDao
import com.example.practiceproject.app.cache.entity.RecipeEntity

@Database(entities = arrayOf(RecipeEntity::class), version = VERSION_1)
abstract class LocalDatabase() : RoomDatabase() {

    companion object {

        @Volatile
        private var instance: LocalDatabase? = null
        fun getInstance(context: Context): LocalDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        DATABASE_NAME
                    )
                        .build()
                }
            }
            return instance!!
        }
    }

    abstract fun recipeDao(): RecipeDao
}