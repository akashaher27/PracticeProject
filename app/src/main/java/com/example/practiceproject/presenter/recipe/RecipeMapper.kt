package com.example.practiceproject.presenter.recipe

import com.example.practiceproject.app.common.Mapper
import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import com.example.practiceproject.presenter.recipe.model.RecipeDetail
import com.example.practiceproject.presenter.recipe.model.RecipePresenterModel
import javax.inject.Inject

class RecipeMapper @Inject constructor() : Mapper<RecipePresenterModel, RecipeDomainModel> {
    override fun map(model: RecipeDomainModel): RecipePresenterModel {
        return RecipePresenterModel(mapRecipes(model.results))
    }

    private fun mapRecipes(recipes: List<com.example.practiceproject.domain.recipe.model.RecipeDetail>?): List<RecipeDetail> {
        val recipeList = mutableListOf<RecipeDetail>()
        recipes?.forEach {
            recipeList.add(RecipeDetail(it.title, it.image, it.imageType))
        }
        return recipeList
    }
}