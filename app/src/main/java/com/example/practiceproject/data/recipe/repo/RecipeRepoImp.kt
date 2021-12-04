package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.remote.recipe.RecipeApi
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import retrofit2.Call
import javax.inject.Inject

class RecipeRepoImp @Inject constructor(var api:RecipeApi) : RecipeRepo {

    override fun getRecipe(): Call<RecipeRemoteModel> {
        return api.getRecipe()
    }
}
