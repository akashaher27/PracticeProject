package com.example.practiceproject.presenter.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practiceproject.presenter.PostLoginViewModel
import com.example.practiceproject.domain.recipe.RecipeInteractor
import com.example.practiceproject.presenter.recipe.model.RecipePresenterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subscribers.DisposableSubscriber
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeInteractor: RecipeInteractor,
    var mapper: RecipeMapper
) : PostLoginViewModel() {

    private val recipeLiveData = MutableLiveData<RecipePresenterModel>()
    fun getRecipe(): LiveData<RecipePresenterModel> = recipeLiveData
    fun fetchRecipe() {
        val dispose = recipeInteractor.getRecipe()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map {
                mapper.map(it)
            }
            .subscribeWith(FetchRecipeSubscriber())

        addDisposable(dispose)
    }
    inner class FetchRecipeSubscriber() : DisposableSingleObserver<RecipePresenterModel>() {
        override fun onSuccess(t: RecipePresenterModel?) {
            t?.let {
                recipeLiveData.value = it
            }
        }

        override fun onError(e: Throwable?) {

        }
    }




}