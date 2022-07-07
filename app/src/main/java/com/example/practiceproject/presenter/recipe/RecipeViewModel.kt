package com.example.practiceproject.presenter.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practiceproject.app.rxjava.RxDisposableFlowableObserver
import com.example.practiceproject.app.rxjava.RxDisposableSingleObserver
import com.example.practiceproject.app.sharedPref.UserStore
import com.example.practiceproject.presenter.PostLoginViewModel
import com.example.practiceproject.domain.recipe.RecipeInteractor
import com.example.practiceproject.domain.recipe.model.toRecipePresentationModel
import com.example.practiceproject.presenter.recipe.model.RecipePresenterModel
import com.example.practiceproject.app.remote.retrofit.Loading
import com.example.practiceproject.app.remote.retrofit.OnError
import com.example.practiceproject.app.remote.retrofit.Response
import com.example.practiceproject.app.remote.retrofit.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeInteractor: RecipeInteractor
) : PostLoginViewModel() {

    private val recipeLiveData = MutableLiveData<Response<RecipePresenterModel>>()
    fun getRecipe(): LiveData<Response<RecipePresenterModel>> = recipeLiveData
    fun fetchRecipe(isNetworkConnected: Boolean) {

        recipeLiveData.value = Loading()
        addDisposable(recipeInteractor.getRecipe(isNetworkConnected)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map {
                it.toRecipePresentationModel()
            }
            .subscribeWith(FetchRecipeSubscriber()))
    }

    inner class FetchRecipeSubscriber :
        RxDisposableFlowableObserver<RecipePresenterModel>(uiResolution) {
        override fun success(t: RecipePresenterModel) {
            recipeLiveData.value = Success(t)
        }

        override fun error(e: Throwable?) {
            recipeLiveData.value = OnError(e?.message)
        }

        override fun complete() {
        }
    }


    private var recipeByNutrientsLiveData = MutableLiveData<Response<RecipePresenterModel>>()
    fun getRecipeByNutrients(): LiveData<Response<RecipePresenterModel>> = recipeByNutrientsLiveData
    fun fetchRecipeByNutrients() {
        recipeByNutrientsLiveData.value = Loading()
        addDisposable(recipeInteractor.getRecipeByNutrients(true)
            .map {
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
            recipeByNutrientsLiveData.value =
                OnError(e.message)
        }

    }
}

