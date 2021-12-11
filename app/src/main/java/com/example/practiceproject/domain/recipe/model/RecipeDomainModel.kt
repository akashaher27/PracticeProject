package com.example.practiceproject.domain.recipe.model

data class RecipeDomainModel(
    var results: List<RecipeDetail>?
)

data class RecipeDetail(
    var title: String?,
    var image: String?,
    var imageType: String?
)