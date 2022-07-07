package com.example.practiceproject.data.recipe.model

import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import com.example.practiceproject.app.remote.recipe.model.RecipeDetail

data class RecipeDataModel(
    var results: MutableList<RecipeDetail>
)

fun RecipeDataModel.toRecipeDomainModel() = RecipeDomainModel(this.results)