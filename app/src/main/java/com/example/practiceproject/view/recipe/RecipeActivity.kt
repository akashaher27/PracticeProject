package com.example.practiceproject.view.recipe

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseproject.view.PostLoginActivity
import com.example.common.util.isInternetConnected
import com.example.common.view.recyclerview.EmptyErrorView
import com.example.practiceproject.MainActivity
import com.example.practiceproject.databinding.ActivityRecipeBinding
import com.example.practiceproject.presenter.recipe.RecipeViewModel
import com.example.practiceproject.app.remote.retrofit.Loading
import com.example.practiceproject.app.remote.retrofit.OnError
import com.example.practiceproject.app.remote.retrofit.Success
import com.example.practiceproject.view.recipe.adapter.RecipeAdapter
import com.example.practiceproject.view.recipe.adapter.RecipeModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_recipe.*


@AndroidEntryPoint
class RecipeActivity() : PostLoginActivity() {

    var TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityRecipeBinding
    private val viewModel: RecipeViewModel by viewModels()
    private lateinit var adapter: RecipeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
    }

    private fun initialiseView() {
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arvRecipeList.initRecyclerView {
            it.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            adapter = RecipeAdapter(mutableListOf())
            it.adapter = adapter
        }
        arvRecipeList.addErrorView(EmptyErrorView(this))
        makeNetworkCall()
        setupObserver()
    }

    private fun makeNetworkCall() {

        viewModel.fetchRecipe(isInternetConnected())
    }

    private fun setupObserver() {
        viewModel.getRecipe().observe(this, Observer { it ->
            when (it) {
                is Loading -> {
                    SkProgressBar.visibility = View.VISIBLE
                }
                is Success -> {
                    SkProgressBar.visibility = View.GONE
                    it.data?.recipeList?.let {
                        adapter.addItems(it)
                    }
                }
                is OnError -> {
                    SkProgressBar.visibility = View.GONE
                }
            }
        })
    }
}