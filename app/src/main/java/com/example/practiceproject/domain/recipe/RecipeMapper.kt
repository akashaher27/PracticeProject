package com.example.practiceproject.domain.recipe

import com.example.practiceproject.app.common.Mapper
import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import com.example.practiceproject.remote.recipe.model.RecipeDetail
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import javax.inject.Inject

class RecipeMapper @Inject constructor() : Mapper<RecipeDomainModel, RecipeRemoteModel> {

    override fun map(model: RecipeRemoteModel): RecipeDomainModel {
        return RecipeDomainModel(mapRecipeDetail(model.results))
    }

    private fun mapRecipeDetail(recipes: List<RecipeDetail>?): List<com.example.practiceproject.domain.recipe.model.RecipeDetail> {
        val recipeList =
            mutableListOf<com.example.practiceproject.domain.recipe.model.RecipeDetail>()
        recipes?.forEach {
            recipeList.add(
                com.example.practiceproject.domain.recipe.model.RecipeDetail(
                    it.title,
                    it.image,
                    it.imageType
                )
            )
        }
        return recipeList
    }
}