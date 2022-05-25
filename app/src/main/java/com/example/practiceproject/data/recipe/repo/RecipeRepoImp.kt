package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.remote.recipe.RecipeApi
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class RecipeRepoImp @Inject constructor(private val api: RecipeApi) : RecipeRepo {

    override fun getRecipe(): Flowable<RecipeRemoteModel> {
        return api.getRecipe().toFlowable()


    }

    override fun getRecipeByNutrients(): Flowable<RecipeRemoteModel> {
        return api.getRecipeByNutrient().toFlowable()
    }
}
