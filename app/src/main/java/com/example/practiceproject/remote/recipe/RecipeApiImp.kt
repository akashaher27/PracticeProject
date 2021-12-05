package com.example.practiceproject.remote.recipe

import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import com.example.practiceproject.remote.recipe.service.RecipeService
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

class RecipeApiImp @Inject constructor(var client: Retrofit) : RecipeApi {

    override fun getRecipe(): Call<RecipeRemoteModel> {
        return client.create(RecipeService::class.java)
            .getRecipe("99dd4d7c0cd046f4bc0e220b005534c1", "pasta", 25, 2)
    }
}