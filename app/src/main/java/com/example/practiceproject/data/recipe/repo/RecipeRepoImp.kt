package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.remote.recipe.RecipeApi
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import javax.inject.Inject

class RecipeRepoImp @Inject constructor(var api:RecipeApi) : RecipeRepo {

    override fun getRecipe(): Single<RecipeRemoteModel> {
        return api.getRecipe()
    }
}
