package com.example.practiceproject.remote.recipe.model

import com.example.practiceproject.data.recipe.model.RecipeDataModel

data class RecipeRemoteModel(
    var results: List<RecipeDetail>?
)

data class RecipeDetail(
    var title: String?,
    var image: String?,
    var imageType: String?
)

fun RecipeRemoteModel.toRecipeDataModel() = RecipeDataModel(this.results)


