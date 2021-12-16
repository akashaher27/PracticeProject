package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.remote.recipe.RecipeApi
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RecipeRepoImp @Inject constructor(private val api: RecipeApi) : RecipeRepo {

    override fun getRecipe(): Single<RecipeRemoteModel> {
        return api.getRecipe()
    }

    override fun getRecipeByNutrients(): Single<RecipeRemoteModel> {
        return api.getRecipeByNutrient()
    }
}
