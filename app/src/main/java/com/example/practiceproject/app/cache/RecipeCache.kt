package com.example.practiceproject.app.cache

import com.example.practiceproject.app.cache.entity.RecipeEntity
import com.example.practiceproject.app.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface RecipeCache {

    fun getRecipe(): Flowable<List<RecipeEntity>>

    fun saveRecipe(recipeRemoteModel: RecipeRemoteModel): Completable
}