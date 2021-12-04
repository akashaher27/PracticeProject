package com.example.practiceproject.remote.recipe.service

import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    @GET("recipes/complexSearch")
    fun getRecipe(@Query("apiKey")apiKey:String,@Query("query")query:String,@Query("maxFat")maxFat:Long,@Query("number")number:Long): Call<RecipeRemoteModel>
}