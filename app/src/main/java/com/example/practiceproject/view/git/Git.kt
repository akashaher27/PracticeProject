package com.example.practiceproject.view.git

import android.os.Bundle
import android.util.Log
import com.example.practiceproject.view.BaseActivity

private const val TAG = "Git"

class Git() : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: git test 1")
    }
}