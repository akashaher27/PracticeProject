package com.example.practiceproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.practiceproject.data.recipe.repo.RecipeRepo
import com.example.practiceproject.remote.recipe.model.RecipeRemoteModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var TAG = MainActivity::class.java.simpleName
    @Inject
    lateinit var repo: RecipeRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repo.getRecipe().enqueue(object : Callback<RecipeRemoteModel> {
            override fun onResponse(
                call: Call<RecipeRemoteModel>,
                response: Response<RecipeRemoteModel>
            ) {
                Log.d(TAG, "onResponse: ")
            }

            override fun onFailure(call: Call<RecipeRemoteModel>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }

        })
    }
}