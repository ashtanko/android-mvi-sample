package com.twere.android.clean.way.widget

import android.content.Context
import android.util.AttributeSet
import com.twere.android.clean.way.util.ViewUtil

class CircularImageView(context: Context, attributes: AttributeSet) : ForegroundImageView(context, attributes) {
    init {
        outlineProvider = ViewUtil().CIRCULAR_OUTLINE
        clipToOutline = true
    }
}