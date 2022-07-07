package com.example.practiceproject.data.recipe.repo

import com.example.practiceproject.app.cache.RecipeCache
import com.example.practiceproject.app.cache.entity.RecipeEntity
import com.example.practiceproject.data.recipe.model.RecipeDataModel
import com.example.practiceproject.app.remote.recipe.RecipeApi
import com.example.practiceproject.app.remote.recipe.model.RecipeDetail
import com.example.practiceproject.app.remote.recipe.model.toRecipeDataModel
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class RecipeRepoImp @Inject constructor(
    private val api: RecipeApi, private val recipeCache: RecipeCache
) : RecipeRepo {

    override fun getRecipe(hasInternet: Boolean): Flowable<RecipeDataModel> {
        return when (hasInternet) {
            true -> api.getRecipe()
                .flatMap {
                    recipeCache.saveRecipe(it).andThen(Flowable.just(it.toRecipeDataModel()))
                }

            false -> recipeCache.getRecipe()
                .map {
                    entityToRecipeDataModel(it)
                }
        }
    }

    override fun getRecipeByNutrients(hasInternet: Boolean): Flowable<RecipeDataModel> {
        return api.getRecipeByNutrient().map {
            RecipeDataModel(it.results)
        }
    }

    private fun entityToRecipeDataModel(list: List<RecipeEntity>): RecipeDataModel {
        val recipeList: MutableList<RecipeDetail> = mutableListOf()
        list.forEach {
            recipeList.add(RecipeDetail(it.recipeName, it.url))
        }
        return RecipeDataModel(recipeList)
    }
}
