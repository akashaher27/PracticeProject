package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import retrofit2.Call

interface RecipeRepo {

    fun getRecipe():Call<RecipeRemoteModel>
}