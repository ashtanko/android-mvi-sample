package com.twere.dribbblekotlin.util

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

class ViewUtil {

  val CIRCULAR_OUTLINE: ViewOutlineProvider = object : ViewOutlineProvider() {

    override fun getOutline(view: View, outline: Outline) {
      outline.setOval(view.paddingLeft,
          view.paddingTop,
          view.width - view.paddingRight,
          view.height - view.paddingBottom)
    }
  }
}