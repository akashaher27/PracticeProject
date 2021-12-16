package com.example.practiceproject.remote.recipe

import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Single

interface RecipeApi {

    fun getRecipe(): Single<RecipeRemoteModel>

    fun getRecipeByNutrient(): Single<RecipeRemoteModel>

}