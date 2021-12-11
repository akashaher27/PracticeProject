package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call

interface RecipeRepo {

    fun getRecipe():Single<RecipeRemoteModel>
}