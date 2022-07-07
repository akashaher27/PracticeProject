package com.example.practiceproject.domain.recipe

import com.example.practiceproject.data.recipe.model.toRecipeDomainModel
import com.example.practiceproject.data.recipe.repo.RecipeRepo
import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class RecipeInteractorImp @Inject constructor(var repo: RecipeRepo) :
    RecipeInteractor {

    override fun getRecipe(hasInternet: Boolean): Flowable<RecipeDomainModel> {
        return repo.getRecipe(hasInternet).map { it.toRecipeDomainModel() }
    }

    override fun getRecipeByNutrients(hasInternet: Boolean): Flowable<RecipeDomainModel> {
        return Flowable.never()
    }
}
