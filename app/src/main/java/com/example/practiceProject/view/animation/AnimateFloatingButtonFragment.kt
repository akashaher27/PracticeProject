package com.example.practiceProject.view.animation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiceProject.R
import com.example.practiceProject.view.PostLoginFragment
import com.example.practiceProject.view.common.TestRVAdapter
import com.example.practiceProject.view.common.model.TestRVModel
import kotlinx.android.synthetic.main.fragment_animate_floating_button.*

/**
 * Created by akash on 06,02,2021
 */
class AnimateFloatingButtonFragment():PostLoginFragment() {

    companion object{
        fun getInstance():AnimateFloatingButtonFragment{
            var frag = AnimateFloatingButtonFragment()
            var arg = Bundle()
            frag.arguments = arg
            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animate_floating_button,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        rvTest.layoutManager = LinearLayoutManager(requireContext())
        var list : ArrayList<TestRVModel> = ArrayList()
        for (i in 1..10){
            list.add(TestRVModel())
        }
        rvTest.adapter = TestRVAdapter(requireContext(),list)
    }

}