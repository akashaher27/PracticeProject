package com.example.practiceproject.domain.recipe

import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import io.reactivex.rxjava3.core.Single

interface RecipeInteractor {

    fun getRecipe(): Single<RecipeDomainModel>

    fun getRecipeByNutrients(): Single<RecipeDomainModel>
}