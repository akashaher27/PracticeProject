package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.data.recipe.model.RecipeDataModel
import io.reactivex.rxjava3.core.Flowable

interface RecipeRepo {

    fun getRecipe(hasInternet:Boolean):Flowable<RecipeDataModel>

    fun getRecipeByNutrients(hasInternet:Boolean):Flowable<RecipeDataModel>
}