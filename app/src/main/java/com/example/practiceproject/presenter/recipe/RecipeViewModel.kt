package com.example.practiceproject.presenter.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.network.Error
import com.example.network.Loading
import com.example.network.Response
import com.example.network.Success
import com.example.practiceproject.app.rxjava.RxDisposableSingleObserver
import com.example.practiceproject.app.sharedPref.UserStore
import com.example.practiceproject.presenter.PostLoginViewModel
import com.example.practiceproject.domain.recipe.RecipeInteractor
import com.example.practiceproject.presenter.recipe.model.RecipePresenterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeInteractor: RecipeInteractor,
    private val mapper: RecipeMapper,
    private val userStore: UserStore
) : PostLoginViewModel() {

    private val recipeLiveData = MutableLiveData<Response<RecipePresenterModel>>()
    fun getRecipe(): LiveData<Response<RecipePresenterModel>> = recipeLiveData
    fun fetchRecipe() {
        recipeLiveData.value = Loading()
        addDisposable(recipeInteractor.getRecipe()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map {
                mapper.map(it)
            }
            .subscribe({}, {})
        )
    }

    inner class FetchRecipeSubscriber : RxDisposableSingleObserver<RecipePresenterModel>() {
        override fun success(t: RecipePresenterModel) {
            recipeLiveData.value = Success(t)
        }

        override fun error(e: Throwable) {
            recipeLiveData.value = Error(e.message)
        }
    }


    private var recipeByNutrientsLiveData = MutableLiveData<Response<RecipePresenterModel>>()
    fun getRecipeByNutrients(): LiveData<Response<RecipePresenterModel>> = recipeByNutrientsLiveData
    fun fetchRecipeByNutrients() {
        recipeByNutrientsLiveData.value = Loading()
        addDisposable(recipeInteractor.getRecipeByNutrients()
            .map {
                mapper.map(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({}, {})
        )
    }

    inner class FetchRecipeByNutrientsSubscriber() :
        RxDisposableSingleObserver<RecipePresenterModel>() {
        override fun success(t: RecipePresenterModel) {
            recipeByNutrientsLiveData.value = Success(t)
        }

        override fun error(e: Throwable) {
            recipeByNutrientsLiveData.value = Error(e.message)
        }

    }
}

