package com.example.practiceproject.domain.recipe

import com.example.practiceproject.data.recipe.repo.RecipeRepo
import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RecipeInteractorImp @Inject constructor(var repo: RecipeRepo, var mapper: RecipeMapper) :
    RecipeInteractor {

    override fun getRecipe(): Single<RecipeDomainModel> {
        return repo.getRecipe()
            .map {
                mapper.map(it)
            }
    }

    override fun getRecipeByNutrients(): Single<RecipeDomainModel> {
        return repo.getRecipeByNutrients().map {
            mapper.map(it)
        }
    }

}