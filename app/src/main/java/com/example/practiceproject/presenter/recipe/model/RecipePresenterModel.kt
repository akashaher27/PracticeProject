package com.example.practiceproject.presenter.recipe.model

data class RecipePresenterModel(
    var results: List<RecipeDetail>?
)

data class RecipeDetail(
    var title: String?,
    var image: String?,
    var imageType: String?
)
