package com.example.practiceproject.presenter.recipe

import com.example.practiceproject.app.common.Mapper
import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import com.example.practiceproject.presenter.recipe.model.RecipePresenterModel
import javax.inject.Inject

class RecipeMapper @Inject constructor() : Mapper<RecipePresenterModel, RecipeDomainModel> {
    override fun map(model: RecipeDomainModel): RecipePresenterModel {
        return RecipePresenterModel(model.results)
    }

}