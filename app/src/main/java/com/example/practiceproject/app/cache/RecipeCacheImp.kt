package com.example.practiceproject.app.cache

import com.example.practiceproject.app.cache.entity.RecipeEntity
import com.example.practiceproject.app.remote.recipe.model.RecipeRemoteModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class RecipeCacheImp @Inject constructor(private val localDatabase: LocalDatabase) : RecipeCache {

    override fun getRecipe(): Flowable<List<RecipeEntity>> {
        return localDatabase.recipeDao().getRecipe().toFlowable()
    }

    override fun saveRecipe(recipeRemoteModel: RecipeRemoteModel): Completable {
        return Completable.fromAction {
            localDatabase.recipeDao().deleteAllRecipe()
            localDatabase.recipeDao()
                .insertRecipeList(mapToEntity(recipeRemoteModel))
        }
    }

    private fun mapToEntity(recipeRemoteModel: RecipeRemoteModel): List<RecipeEntity> {
        return recipeRemoteModel.results.map {
            RecipeEntity(recipeName = it.title, url = it.image)
        }
    }
}