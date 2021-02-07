package com.example.practiceProject.view.animation

import android.os.Bundle
import com.example.mycalender.view.common.addFragment
import com.example.practiceProject.R
import com.example.practiceProject.view.PostLoginActivity

/**
 * Created by akash on 05,02,2021
 */
class AnimateFloatingButtonActivity():PostLoginActivity() {

    override fun setLayoutId(): Int? {
        return R.layout.activity_animate_floating_button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(R.id.fragHolder,supportFragmentManager,AnimateFloatingButtonFragment.getInstance(),null)
    }
}