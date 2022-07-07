package com.example.practiceproject.app.remote.recipe

import com.example.practiceproject.app.remote.recipe.model.RecipeRemoteModel
import com.example.practiceproject.app.remote.recipe.service.RecipeService
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import javax.inject.Inject

class RecipeApiImp @Inject constructor(private val client: Retrofit) : RecipeApi {

    override fun getRecipe(): Flowable<RecipeRemoteModel> {
        return client.create(RecipeService::class.java)
            .getRecipe("pasta", 25, 15)
            .toFlowable()

    }

    override fun getRecipeByNutrient(): Flowable<RecipeRemoteModel> {
        return client.create(RecipeService::class.java)
            .getRecipeByNutrients("99dd4d7c0cd046f4bc0e220b005534c1", 10, 50, 4)
            .map {
                RecipeRemoteModel(it)
            }
            .toFlowable()
    }
}