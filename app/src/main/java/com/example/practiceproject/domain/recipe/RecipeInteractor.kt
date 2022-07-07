package com.example.practiceproject.domain.recipe

import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import io.reactivex.rxjava3.core.Flowable

interface RecipeInteractor {

    fun getRecipe(hasInternet:Boolean): Flowable<RecipeDomainModel>

    fun getRecipeByNutrients(hasInternet:Boolean): Flowable<RecipeDomainModel>
}