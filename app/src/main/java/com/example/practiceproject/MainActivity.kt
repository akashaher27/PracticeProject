package com.example.practiceproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.common.util.isInternetConnected
import com.example.practiceproject.presenter.recipe.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.functions.Function
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.log

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var TAG = MainActivity::class.java.simpleName
    private val viewModel by viewModels<RecipeViewModel>()

    private lateinit var disposable: Disposable

    //region lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchFragment()
        launchFragment2()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart: ")
        super.onRestart()
    }

    override fun onStart() {
        Log.d(TAG, "onStart: ")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume: ")
        super.onResume()

    }

    override fun onPause() {
        Log.d(TAG, "onPause: ")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop: ")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }
    //endregion

    //region general
    private fun setupObserver() {
        viewModel.getRecipe().observe(this) {
            Log.d(TAG, "setupObserver: ")
        }
    }

    fun makeNetworkCall() {
        viewModel.fetchRecipe(isInternetConnected())
    }
    //endregion

    //region utility
    fun sleep(time:Long) {
        try {
            Thread.sleep(time)
        } catch (e: java.lang.RuntimeException) {
            Log.d(TAG, "sleep: ")
        }

    }
    //endregion

    //region Fragment
    private fun launchFragment() {
        supportFragmentManager.beginTransaction().let {
            it.add(
                R.id.fragContainer,
                TestFragment.getInstance("Akash"),
                TestFragment::class.java.simpleName
            )
                .addToBackStack(null)
                .commit()
        }
    }

    private fun launchFragment2() {
        supportFragmentManager.beginTransaction().let {
            it.replace(
                R.id.fragContainer,
                Test2Fragment.getInstance(),
                Test2Fragment::class.java.simpleName
            )
                .addToBackStack(null)
                .commit()
        }
    }
    //endregion

    //region Rxjava

    private fun mapOperator() {
        var obser = Observable
            .just(1, 2, 3, 4)
            .map {
                if (it == 3) {
                    throw  RuntimeException()
                }
                it
            }
            .map { it ->
                when (it) {
                    1 -> 'a'
                    2 -> 'b'
                    3 -> 'c'
                    else -> {
                        'd'
                    }
                }
            }
        obser.subscribe({
            Log.d(TAG, "mapOperator: $it")
        }, {})
    }

    private fun flatMapOperator() {
        var obser = Observable.just(1, 2, 3, 4)
            .flatMap(object : Function<Int, Observable<Int>> {
                override fun apply(t: Int): Observable<Int> {
                    return Observable.just(1, 2, 3)
                }

            })

        obser.subscribe(
            {
                Log.d(TAG, "flatMapOperator:$it ")
            },
            {}
        )
    }

    private fun zipOperator() {

        var obser1 = Observable.just(1, 2, 3)
            .map {
                if (it == 2) {
                    throw RuntimeException()
                }
                it
            }

        var obser2 = Observable.just(1, 2, 3)

        Observable
            .zip(obser1, obser2) { t1, t2 -> listOf(t1, t2) }
            .subscribe(
                { Log.d(TAG, "checkZipOperator: ${it[0]}") },
                { Log.d(TAG, "checkZipOperator: $it") })

    }

    private fun concatOperator() {
        var ob1 = Observable.just(1, 2, 3)
            .map {
                if (2 == it) {
                    throw RuntimeException()
                }
                it
            }
            .onErrorReturn { -1 }
        var ob2 = Observable.just(1, 2, 3)

        Observable
            .concat(ob1, ob2)
            .subscribe({
                Log.d(TAG, "concatOperator: $it")
            }, {

            })

    }

    private fun mergeOperator() {
        var ob1 = Observable.just(1, 2, 3, 4)
            .map {
                if (2 == it) {
                    throw RuntimeException()
                }
                it
            }
            .onErrorReturn { -1 }
        var ob2 = Observable.just(1, 2, 3)
            .map {
                if (3 == it) {
                    throw RuntimeException()
                }
                it
            }
            .onErrorReturn { -1 }

        Observable
            .merge(ob1, ob2)
            .subscribe({
                Log.d(TAG, "mergeOperator: $it")
            }, {

            })
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
    //endregion

}
