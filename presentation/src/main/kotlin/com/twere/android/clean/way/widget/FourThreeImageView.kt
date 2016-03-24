package com.twere.android.clean.way.widget

import android.content.Context
import android.util.AttributeSet

class FourThreeImageView(context: Context?, attrs: AttributeSet?) : ForegroundImageView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val fourThreeHeight = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec) * 3 / 4,
                MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, fourThreeHeight)
    }
}