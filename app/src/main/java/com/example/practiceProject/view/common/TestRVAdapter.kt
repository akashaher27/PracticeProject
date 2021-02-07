package com.example.practiceProject.view.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mycalender.view.common.BaseAdapter
import com.example.mycalender.view.common.BaseViewHolder
import com.example.practiceProject.R
import com.example.practiceProject.view.common.model.TestRVModel


/**
 * Created by akash on 06,02,2021
 */
class TestRVAdapter(var context: Context,var list:List<TestRVModel>):BaseAdapter<TestRVModel,TestRVAdapter.TestRVViewHolder>(list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestRVViewHolder {
        return  TestRVViewHolder(LayoutInflater.from(context).inflate(R.layout.item_test_rv,parent,false))
    }

    override fun onBindViewHolder(holder: TestRVViewHolder, position: Int) {
        holder.bindData(list[position])
    }


    inner class TestRVViewHolder(itemView: View):BaseViewHolder<TestRVModel>(itemView){

        var title = itemView.findViewById<TextView>(R.id.title)
        var subTitle = itemView.findViewById<TextView>(R.id.subTitle)

        override fun bindData(item: TestRVModel) {
            title.text = item.title
            subTitle.text = item.subTitle
        }

    }
}