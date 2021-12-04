package com.example.practiceproject.remote.recipe

import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import retrofit2.Call
import retrofit2.Retrofit

 interface RecipeApi{

    fun getRecipe():Call<RecipeRemoteModel>
}