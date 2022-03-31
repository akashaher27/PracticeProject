package com.example.practiceproject.view.recipe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baseproject.view.PostLoginActivity
import com.example.common.view.recyclerview.EmptyErrorView
import com.example.network.Error
import com.example.network.Loading
import com.example.network.Response
import com.example.network.Success
import com.example.practiceproject.MainActivity
import com.example.practiceproject.R
import com.example.practiceproject.databinding.ActivityRecipeBinding
import com.example.practiceproject.presenter.recipe.RecipeViewModel
import com.example.practiceproject.view.recipe.adapter.RecipeAdapter
import com.example.practiceproject.view.recipe.adapter.RecipeModel
import com.github.ybq.android.spinkit.style.Wave
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_recipe.*
import javax.inject.Inject


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
        viewModel.fetchRecipe()
    }

    private fun setupObserver() {
        viewModel.getRecipe().observe(this, Observer {
            when (it) {
                is Loading -> {
                    SkProgressBar.visibility = View.VISIBLE
                }
                is Success -> {
                    SkProgressBar.visibility = View.GONE
                    it.data?.results.let {
                        var list = mutableListOf<RecipeModel>()
                        it?.forEach { recipeDetail ->
                            list.add(
                                RecipeModel(
                                    recipeDetail.title,
                                    recipeDetail.imageType,
                                    recipeDetail.image
                                )
                            )
                        }
                        adapter.addItems(list)
                    }
                }
                is Error -> {
                    SkProgressBar.visibility = View.GONE
                }
            }
        })
    }
}