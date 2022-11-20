package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.data.recipe.model.RecipeDataModel
import io.reactivex.rxjava3.core.Flowable

interface RecipeRepo {

    fun getRecipe():Flowable<RecipeDataModel>

    fun getRecipeByNutrients():Flowable<RecipeDataModel>
}