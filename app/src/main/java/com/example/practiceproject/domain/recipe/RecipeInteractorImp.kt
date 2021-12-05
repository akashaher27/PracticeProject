package com.example.practiceproject.domain.recipe

import com.example.practiceproject.data.recipe.repo.RecipeRepo
import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import retrofit2.Call
import javax.inject.Inject

class RecipeInteractorImp @Inject constructor(var repo: RecipeRepo) : RecipeInteractor{

    override fun getRecipe(): Call<RecipeRemoteModel> {
        return repo.getRecipe()
    }

}