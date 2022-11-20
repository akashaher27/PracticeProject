package com.example.practiceproject.domain.recipe

import com.example.practiceproject.data.recipe.model.toRecipeDomainModel
import com.example.practiceproject.data.recipe.repo.RecipeRepo
import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class RecipeInteractorImp @Inject constructor(var repo: RecipeRepo, var mapper: RecipeMapper) :
    RecipeInteractor {

    override fun getRecipe(): Flowable<RecipeDomainModel> {
        return repo.getRecipe().map {it.toRecipeDomainModel() }
    }

    override fun getRecipeByNutrients(): Flowable<RecipeDomainModel> {
        return repo.getRecipeByNutrients().map {
            mapper.map(it)
        }
    }

}