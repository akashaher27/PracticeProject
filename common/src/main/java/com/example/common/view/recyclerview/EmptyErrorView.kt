package com.example.common.view.recyclerview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.common.R
import com.example.common.databinding.EmptyErrorViewBinding
import kotlinx.android.synthetic.main.empty_error_view.view.*

/**
 * Created by akash on 01,05,2021
 */
class EmptyErrorView(context: Context) : LinearLayout(context) {

    init {
        initialiseView()
    }

    private fun initialiseView() {
        inflate(context, R.layout.empty_error_view, this)
    }

    fun setErrorMsg(errorMsg: String) {
        tvErrorMsg?.text = errorMsg
    }

    fun setErrorBackground(background: Drawable) {
        ivBackground?.setImageDrawable(background)
    }
}