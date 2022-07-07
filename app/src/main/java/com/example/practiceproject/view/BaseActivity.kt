package com.example.practiceproject.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.common.util.InternetChecker
import com.example.practiceproject.R
import com.example.practiceproject.presenter.BaseViewModel
import com.google.android.material.snackbar.Snackbar
import kotlin.math.log

/**
 * Created by akash on 13,01,2021
 */
abstract class BaseActivity() : AppCompatActivity() {

    private val viewModel: BaseViewModel by viewModels()
    private var networkSnackbar: Snackbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InternetChecker(this).observe(this) { internetState ->
            when (internetState) {
                InternetChecker.InternetState.DISCONNECTED -> {
                    networkSnackbar = Snackbar.make(
                        findViewById<View>(android.R.id.content),
                        getString(R.string.error_msg_currently_you_are_offline),
                        Snackbar.LENGTH_INDEFINITE
                    )
                    networkSnackbar?.show()
                }
                InternetChecker.InternetState.CONNECTED -> {
                    networkSnackbar?.dismiss()
                }
            }
        }
        viewModel.getNetworkError().observe(this) {
            //add ui component to show error message
        }
    }

    fun handleNetworkError() {

    }

}