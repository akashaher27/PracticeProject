package com.example.baseproject.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.common.util.InternetChecker
import kotlin.math.log

/**
 * Created by akash on 13,01,2021
 */
abstract class BaseActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InternetChecker(this).observe(this,{
            when(it){
                InternetChecker.InternetState.CONNECTED ->{
                    Log.d("BaseActivity","Connected")
                }
                InternetChecker.InternetState.DISCONNECTED ->{
                    Log.d("BaseActivity","disConnected")
                }
            }
        })
    }

}