package com.example.practiceproject.domain.recipe.model

import com.example.practiceproject.presenter.recipe.model.RecipePresenterModel
import com.example.practiceproject.remote.recipe.model.RecipeDetail

data class RecipeDomainModel(
    var results: List<RecipeDetail>?
)

fun RecipeDomainModel.toRecipePresentationModel() = RecipePresenterModel(this.results)
