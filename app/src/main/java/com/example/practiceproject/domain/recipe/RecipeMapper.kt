package com.example.practiceproject.domain.recipe

import com.example.practiceproject.app.common.Mapper
import com.example.practiceproject.data.recipe.model.RecipeDataModel
import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import com.example.practiceproject.remote.recipe.model.RecipeDetail
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import javax.inject.Inject

class RecipeMapper @Inject constructor() : Mapper<RecipeDomainModel, RecipeDataModel> {

    override fun map(model: RecipeDataModel): RecipeDomainModel {
        return RecipeDomainModel(model.results)
    }
}