package com.example.practiceproject.domain.recipe

import com.example.practiceproject.data.recipe.repo.RecipeRepo
import com.example.practiceproject.domain.recipe.model.RecipeDomainModel
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import javax.inject.Inject

class RecipeInteractorImp @Inject constructor(var repo: RecipeRepo, var mapper: RecipeMapper) :
    RecipeInteractor {

    override fun getRecipe(): Single<RecipeDomainModel> {
        return repo.getRecipe()
            .map {
                mapper.map(it)
            }
    }

}