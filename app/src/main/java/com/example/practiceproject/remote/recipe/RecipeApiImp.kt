package com.example.practiceproject.remote.recipe

import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import com.example.practiceproject.remote.recipe.service.RecipeService
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import javax.inject.Inject

class RecipeApiImp @Inject constructor(val client: Retrofit) : RecipeApi {

    override fun getRecipe(): Single<RecipeRemoteModel> {
        return client.create(RecipeService::class.java)
            .getRecipe("99dd4d7c0cd046f4bc0e220b005534c1", "pasta", 25, 2)
    }
}