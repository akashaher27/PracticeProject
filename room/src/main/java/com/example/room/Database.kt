package com.example.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.entity.TestEntity

@androidx.room.Database(entities = arrayOf(TestEntity::class), version = 1)
abstract class Database() : RoomDatabase() {

    companion object {
        const val databaseName = "PractiseDatabase"

        @Volatile
        private var instance: Database? = null
        fun getInstance(context: Context): Database {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, Database::class.java,
                        databaseName
                    ).build()
                }
            }
            return instance!!
        }
    }


}