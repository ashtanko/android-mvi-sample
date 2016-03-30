package com.twere.android.clean.way.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import com.twere.presentation.R

class ForegroundLinearLayout (context: Context, attributeSet: AttributeSet, defStyle: Int) : LinearLayout(context, attributeSet, defStyle) {

    private var mForeground: Drawable
    private val mSelfBounds: Rect = Rect()
    private val mOverlayBounds: Rect = Rect()
    private var mForegroundGravity: Int = Gravity.FILL
    protected var mForegroundInPadding: Boolean = true
    var mForegroundBoundsChanged: Boolean = false

    init {
        var a: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ForegroundView, defStyle, 0)
        val d: Drawable = a.getDrawable(R.styleable.ForegroundView_android_foreground)
        mForeground = d
        mForegroundGravity = a.getInt(
                R.styleable.ForegroundView_android_foregroundGravity, mForegroundGravity)

        mForegroundInPadding = a.getBoolean(
                R.styleable.ForegroundView_android_foregroundInsidePadding, true)
        a.recycle()
    }

    override fun setForegroundGravity(gravity: Int) {
        super.setForegroundGravity(gravity)
        if (mForegroundGravity != foregroundGravity) {

            when (foregroundGravity and Gravity.VERTICAL_GRAVITY_MASK) {
                0 -> foregroundGravity = foregroundGravity or Gravity.TOP
            }

            when (foregroundGravity and Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) {
                0 -> foregroundGravity = foregroundGravity or Gravity.START
            }

            mForegroundGravity = foregroundGravity

            when (mForegroundGravity == Gravity.FILL) {
                true -> {
                    val padding = Rect()
                    mForeground.getPadding(padding)
                }
            }

            requestLayout()
        }
    }

    override fun verifyDrawable(who: Drawable?): Boolean {
        return super.verifyDrawable(who) || (who == mForeground)
    }

    override fun jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState()
        mForeground.jumpToCurrentState()
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        when (mForeground.isStateful) {
            true -> mForeground.state = drawableState
        }
    }

    override fun getForeground(): Drawable? {
        return mForeground
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        if (changed) {
            mForegroundBoundsChanged = true
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mForegroundBoundsChanged = true
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val foreground: Drawable = mForeground

        if (mForegroundBoundsChanged) {
            mForegroundBoundsChanged = false
            val selfBounds: Rect = mSelfBounds
            val overlayBounds: Rect = mOverlayBounds
            val w = right - left
            val h = bottom - top

            if (mForegroundInPadding) {
                selfBounds.set(0, 0, w, h)
            } else {
                selfBounds.set(paddingLeft, paddingTop,
                        w - paddingRight, h - paddingBottom)
            }

            Gravity.apply(mForegroundGravity, foreground.intrinsicWidth,
                    foreground.intrinsicHeight, selfBounds, overlayBounds)
            foreground.bounds = overlayBounds
        }
        foreground.draw(canvas)
    }

    override fun drawableHotspotChanged(x: Float, y: Float) {
        super.drawableHotspotChanged(x, y)
        mForeground.setHotspot(x, y)
    }
}