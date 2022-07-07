package com.example.practiceproject.domain.recipe.model

import com.example.practiceproject.presenter.recipe.model.RecipePresenterModel
import com.example.practiceproject.app.remote.recipe.model.RecipeDetail
import com.example.practiceproject.view.recipe.adapter.RecipeModel

data class RecipeDomainModel(
    var results: MutableList<RecipeDetail>?
)

fun RecipeDomainModel.toRecipePresentationModel(): RecipePresenterModel {
    val list = mutableListOf<RecipeModel>()
    this.results?.forEach { model ->
        list.add(RecipeModel(model.title, model.imageType, model.image))
    }
    return RecipePresenterModel(list)
}
