package com.example.practiceproject.app.remote.recipe.model

import com.example.practiceproject.data.recipe.model.RecipeDataModel

data class RecipeRemoteModel(
    var results: MutableList<RecipeDetail>
)

data class RecipeDetail(
    var title: String? = null,
    var image: String? = null,
    var imageType: String? = null
)

fun RecipeRemoteModel.toRecipeDataModel() = RecipeDataModel(this.results)


