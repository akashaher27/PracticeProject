package com.example.practiceproject.remote.recipe

import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import retrofit2.Call
import retrofit2.Retrofit

class RecipeApiImp(var client:Retrofit):RecipeApi {

    override fun getRecipe(): Call<RecipeRemoteModel> {
        TODO("Not yet implemented")
    }
}