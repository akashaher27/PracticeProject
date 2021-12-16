package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Single

interface RecipeRepo {

    fun getRecipe():Single<RecipeRemoteModel>

    fun getRecipeByNutrients():Single<RecipeRemoteModel>
}