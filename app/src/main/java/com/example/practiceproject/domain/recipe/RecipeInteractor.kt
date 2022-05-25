package com.example.practiceproject.domain.recipe

import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import io.reactivex.rxjava3.core.Flowable

interface RecipeInteractor {

    fun getRecipe(): Flowable<RecipeDomainModel>

    fun getRecipeByNutrients(): Flowable<RecipeDomainModel>
}