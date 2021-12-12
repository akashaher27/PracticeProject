package com.example.practiceproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.network.Error
import com.example.network.Loading
import com.example.network.Response
import com.example.network.Success
import com.example.practiceproject.presenter.recipe.RecipeViewModel
import com.example.practiceproject.presenter.recipe.model.RecipePresenterModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var TAG = MainActivity::class.java.simpleName
    private val viewModel by viewModels<RecipeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getRecipe().observe(this, {
            handleGetRecipeResponse(it)
        })
    }

    private fun handleGetRecipeResponse(response: Response<RecipePresenterModel>) {
        when (response) {
            is Loading -> {
            }
            is Success -> {
            }
            is Error -> {
            }
        }
    }

}