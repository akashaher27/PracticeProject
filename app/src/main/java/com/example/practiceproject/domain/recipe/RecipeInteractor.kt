package com.example.practiceproject.domain.recipe

import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import retrofit2.Call

interface RecipeInteractor {

    fun getRecipe(): Call<RecipeRemoteModel>
}