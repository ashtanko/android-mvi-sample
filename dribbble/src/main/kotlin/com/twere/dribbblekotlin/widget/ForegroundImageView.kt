package com.twere.dribbblekotlin.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.ViewOutlineProvider
import android.widget.ImageView
import com.twere.dribbble.R

open class ForegroundImageView(context: Context?, attrs: AttributeSet?) : ImageView(context,
    attrs) {

  private var mForegroung: Drawable? = null

  val a = context?.obtainStyledAttributes(attrs, R.styleable.ForegroundView)
  val d = a?.getDrawable(R.styleable.ForegroundView_android_foreground)

  init {
    if (d != null) {
      foreground = d
    }
    a?.recycle()
    outlineProvider = ViewOutlineProvider.BOUNDS
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    if (mForegroung != null) {
      mForegroung?.setBounds(0, 0, w, h)
    }
  }

  override fun hasOverlappingRendering(): Boolean {
    return false
  }

  override fun verifyDrawable(dr: Drawable?): Boolean {
    return super.verifyDrawable(dr) || (dr == mForegroung)
  }

  override fun jumpDrawablesToCurrentState() {
    super.jumpDrawablesToCurrentState()
    if (mForegroung != null) mForegroung?.jumpToCurrentState()
  }

  override fun drawableStateChanged() {
    super.drawableStateChanged()
    if (mForegroung != null && mForegroung!!.isStateful) {
      mForegroung?.state = drawableState
    }
  }

  override fun draw(canvas: Canvas?) {
    super.draw(canvas)
    if (mForegroung != null) {
      mForegroung?.draw(canvas)
    }
  }

  override fun drawableHotspotChanged(x: Float, y: Float) {
    super.drawableHotspotChanged(x, y)
    if (mForegroung != null) {
      mForegroung?.setHotspot(x, y)
    }
  }

  override fun setForeground(drawable: Drawable) {
    if (mForegroung != drawable) {
      if (mForegroung != null) {
        mForegroung!!.callback = null
        unscheduleDrawable(mForegroung)
      }
      mForegroung = drawable

      if (mForegroung != null) {
        mForegroung?.setBounds(0, 0, width, height)
        setWillNotDraw(false)
        mForegroung?.callback = this
        if (mForegroung!!.isStateful) {
          mForegroung?.state = drawableState
        }
      } else {
        setWillNotDraw(false)
      }
      invalidate()
    }
  }
}