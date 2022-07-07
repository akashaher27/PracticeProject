package com.example.practiceproject.app.remote.recipe

import com.example.practiceproject.app.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface RecipeApi {

    fun getRecipe(): Flowable<RecipeRemoteModel>

    fun getRecipeByNutrient(): Flowable<RecipeRemoteModel>

}