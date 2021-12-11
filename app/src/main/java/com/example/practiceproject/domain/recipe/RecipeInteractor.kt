package com.example.practiceproject.domain.recipe

import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call

interface RecipeInteractor {

    fun getRecipe(): Single<RecipeDomainModel>
}