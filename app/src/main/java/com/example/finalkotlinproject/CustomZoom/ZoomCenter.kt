package com.example.finalkotlinproject.CustomZoom

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Math.abs
import java.lang.Math.min

class ZoomCenter: LinearLayoutManager {
    companion object {
        const val sShrinkAmount = 0.15f
        const val sShrinkDistance = 0.9f
    }
    constructor(context: Context) : super(context)

//    constructor(context: Context,orientation: Int,reverseLayout:Boolean): super (context, orientation, reverseLayout)

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        val orientation = orientation
        if (orientation== HORIZONTAL) {
            val s = super.scrollHorizontallyBy(dx, recycler, state)
            val midpt = width/2f
            val d0 = 0f
            val d1 = sShrinkDistance * midpt
            val s0 = 1f
            val s1 = 1f - sShrinkAmount

            for (j in 0 until childCount){
                val child = getChildAt(j)
                val childMP = (getDecoratedRight(child!!) + getDecoratedLeft(child)/2f)
                val d = d1.coerceAtMost(abs(midpt-childMP))
                val scale = s0 + (s1-s0) * (d-d0)/(d1-d0)
                child.scaleX = scale
                child.scaleY = scale
            }
            return s
        }
        else return 0
    }
}