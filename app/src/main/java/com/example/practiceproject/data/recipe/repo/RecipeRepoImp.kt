package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.data.recipe.model.RecipeDataModel
import com.example.practiceproject.remote.recipe.RecipeApi
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import com.example.practiceproject.remote.recipe.model.toRecipeDataModel
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class RecipeRepoImp @Inject constructor(private val api: RecipeApi) : RecipeRepo {

    override fun getRecipe(): Flowable<RecipeDataModel> {
        return api.getRecipe().map { it.toRecipeDataModel() }.toFlowable()
    }

    override fun getRecipeByNutrients(): Flowable<RecipeDataModel> {
        return api.getRecipeByNutrient().map {
            RecipeDataModel(it.results)
        }.toFlowable()
    }
}
