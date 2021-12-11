package com.example.practiceproject.remote.recipe.model

data class RecipeRemoteModel(
    var results: List<RecipeDetail>?
)

data class RecipeDetail(
    var title: String?,
    var image: String?,
    var imageType: String?
)
