package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Flowable

interface RecipeRepo {

    fun getRecipe():Flowable<RecipeRemoteModel>

    fun getRecipeByNutrients():Flowable<RecipeRemoteModel>
}