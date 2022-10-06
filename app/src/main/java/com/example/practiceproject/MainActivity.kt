package com.example.practiceproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.practiceproject.presenter.recipe.RecipeViewModel
import com.example.practiceproject.presenter.recipe.model.RecipePresenterModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.functions.Function
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMap
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import kotlinx.coroutines.flow.Flow
import org.reactivestreams.Publisher
import org.reactivestreams.Subscription
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var TAG = MainActivity::class.java.simpleName
    private val viewModel by viewModels<RecipeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val flowableObserver = Flowable.just(1,2,3,4,5)
        val dispose = flowableObserver.subscribe({
            Log.d(TAG, "onCreate:$it ")
        }, {
            Log.d(TAG, "onCreate: error")
        },{
            Log.d(TAG, "onCreate: complete")
        })

        Log.d(TAG, "onCreate: ${dispose.isDisposed}")

    }

    private fun setupObserver() {
        viewModel.getRecipe().observe(this,  {
            Log.d(TAG, "setupObserver: ")
        })
    }

    fun makeNetworkCall() {
        viewModel.fetchRecipe()
    }

    private fun checkFlatMapOperator() {

        val single: Single<Int> = Single.just(1)
        val disposable = single
            .flatMap {
                Single.just('a')
            }
            .subscribeWith(object : DisposableSingleObserver<Char>() {
                override fun onSuccess(t: Char?) {
                    Log.d(TAG, "onSuccess: $t")
                }

                override fun onError(e: Throwable?) {
                    Log.d(TAG, "onError: ")
                }
            })

        disposable.dispose()
    }

    private fun checkFlattenAsObservable() {
        val single = Single.just(listOf(1, 2, 3, 4))

        single
            .flattenAsObservable { it }
            .map {
                try {
                    if (it == 3) {
                        throw RuntimeException()
                    }
                    it
                } catch (e: Exception) {
                    -1
                }

            }
            .flatMap {
                Observable.just(it * 2)
            }
            .subscribeWith(object : DisposableObserver<Int>() {

                override fun onError(e: Throwable?) {
                    Log.d(TAG, "onError: ")
                }

                override fun onComplete() {
                    Log.d(TAG, "onComplete: ")
                }

                override fun onNext(t: Int?) {
                    Log.d(TAG, "onNext: $t")
                }

            })
    }

    private fun checkZipOperator() {
        val single1 = Flowable.just(1)
        val single2 = Flowable.just(2)
        val single3 = Flowable.just(3)

        val single = Flowable.zip(
            single1,
            single2,
            single3,
            { t1, t2, t3 ->
                if (t2 == 2) {
                    throw java.lang.RuntimeException()
                }
                val list = mutableListOf<Int>()
                list.apply {
                    list.add(t1)
                    list.add(t2)
                    list.add(t3)
                }
            })

        single
            .onErrorResumeNext { Flowable.just(mutableListOf(1, 2, 3)) }
            .subscribe({
                Log.d(TAG, "checkZipOperator: $it")
            }, {
                Log.d(TAG, "checkZipOperator: $it")
            })
    }

    private fun checkOnErrorResumeOperator() {
        val observable = Observable.just(1, 2, 3, 4)
        observable
            .map {
                if (it == 2) {
                    throw RuntimeException()
                }
                it
            }
            .onErrorResumeNext { Observable.just(-1) }
            .subscribe({
                Log.d(TAG, "checkOnErrorResumeOperator: $it")
            }, {
                Log.d(TAG, "checkOnErrorResumeOperator: $it")
            })
    }

}