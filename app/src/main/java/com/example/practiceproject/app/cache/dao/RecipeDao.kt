package com.example.practiceproject.app.cache.dao

import androidx.room.*
import com.example.practiceproject.app.cache.entity.RecipeEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe_detail")
    fun getRecipe(): Maybe<List<RecipeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipeList(recipeList: List<RecipeEntity>)

    @Query("DELETE FROM recipe_detail")
    fun deleteAllRecipe()
}