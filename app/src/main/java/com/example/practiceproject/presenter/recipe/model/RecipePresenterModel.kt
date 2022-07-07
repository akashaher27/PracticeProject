package com.example.practiceproject.presenter.recipe.model

import com.example.practiceproject.app.remote.recipe.model.RecipeDetail
import com.example.practiceproject.view.recipe.adapter.RecipeModel

data class RecipePresenterModel(
    var recipeList: List<RecipeModel> = emptyList()
)

