package com.example.practiceproject.view.git

import android.os.Bundle
import android.util.Log
import com.example.practiceproject.view.BaseActivity
import kotlin.math.log

private const val TAG = "Git"

class Git() : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: reset git amend")
        
    }
}