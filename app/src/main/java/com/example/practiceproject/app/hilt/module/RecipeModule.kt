package com.example.practiceproject.app.hilt.module

import com.example.practiceproject.data.recipe.repo.RecipeRepo
import com.example.practiceproject.data.recipe.repo.RecipeRepoImp
import com.example.practiceproject.domain.recipe.RecipeInteractor
import com.example.practiceproject.domain.recipe.RecipeInteractorImp
import com.example.practiceproject.remote.recipe.RecipeApi
import com.example.practiceproject.remote.recipe.RecipeApiImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RecipeModule {

    @Binds
    abstract fun provideRecipeApi(recipeApiImp: RecipeApiImp): RecipeApi

    @Binds
    abstract fun provideRecipeRepo(recipeRepoImp: RecipeRepoImp): RecipeRepo

    @Binds
    abstract fun provideRecipeInteractor(recipeInteractorImp: RecipeInteractorImp): RecipeInteractor
}