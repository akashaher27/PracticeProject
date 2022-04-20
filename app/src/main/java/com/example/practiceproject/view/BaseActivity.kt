package com.example.baseproject.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.common.util.InternetChecker
import com.example.practiceproject.R
import com.google.android.material.snackbar.Snackbar
import kotlin.math.log

/**
 * Created by akash on 13,01,2021
 */
abstract class BaseActivity() : AppCompatActivity() {

    private var networkSnackbar: Snackbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InternetChecker(this).observe(this, {
            when (it) {
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
        })
    }

}