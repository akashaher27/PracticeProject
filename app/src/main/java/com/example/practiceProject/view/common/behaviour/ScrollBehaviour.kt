package com.example.practiceProject.view.common.behaviour

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Created by akash on 06,02,2021
 */
class ScrollBehaviour(var context: Context, var attr: AttributeSet):FloatingActionButton.Behavior(context,attr) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: FloatingActionButton,
        dependency: View
    ): Boolean {
        Log.d("ScrollBehaviour", "layoutDependsOn:")
        return super.layoutDependsOn(parent, child, dependency)
    }

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        Log.d("ScrollBehaviour", "onStartNestedScroll:")
       return  axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        Log.d("ScrollBehaviour", "onNestedScroll:")
        super.onNestedScroll(
            coordinatorLayout,
            child,
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type,
            consumed
        )

        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
            child.hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    super.onHidden(fab)
                    fab?.visibility = View.INVISIBLE
                }
            })
        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            child.show()
        }
    }

    override fun onNestedFling(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        target: View,
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean {
        Log.d("ScrollBehaviour", "onNestedFling:")
        super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed)
        if (velocityY>0 && child.getVisibility() == View.VISIBLE) {
            child.hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    super.onHidden(fab)
                    fab?.visibility = View.INVISIBLE
                }
            })
        } else if ( velocityY<0 &&child.getVisibility() != View.VISIBLE) {
            child.show()
        }
        return false
        
    }
}