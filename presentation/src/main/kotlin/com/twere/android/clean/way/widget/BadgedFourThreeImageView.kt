package com.twere.android.clean.way.widget

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.text.TextPaint
import android.util.AttributeSet
import android.view.Gravity
import com.twere.presentation.R

class BadgedFourThreeImageView(context: Context?, attrs: AttributeSet?) : ForegroundImageView(context, attrs) {

    private val badge: Drawable
    private var drawBadge: Boolean = false
    private var badgeBoundsSet = false
    private val badgeGravity: Int
    private val badgePadding: Int

    init {
        badge = GifBadge(context)
        val a = context?.obtainStyledAttributes(attrs, R.styleable.BadgedImageView, 0, 0)
        badgeGravity = a!!.getInt(R.styleable.BadgedImageView_badgeGravity, Gravity.END or Gravity.BOTTOM)
        badgePadding = a.getDimensionPixelSize(R.styleable.BadgedImageView_badgePadding, 0)
        a.recycle()
    }

    fun showBadge(show: Boolean) {
        drawBadge = show
    }

    fun setBadgeColor(@ColorInt color: Int) {
        badge.setColorFilter(color, PorterDuff.Mode.SRC_IN)
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        if (drawBadge) {
            if (!badgeBoundsSet) {
                layoutBadge()
            }
            badge.draw(canvas)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        layoutBadge()
    }

    private fun layoutBadge() {
        val badgeBounds = badge.bounds
        Gravity.apply(badgeGravity,
                badge.intrinsicWidth,
                badge.intrinsicHeight,
                Rect(0, 0, width, height),
                badgePadding,
                badgePadding,
                badgeBounds)
        badge.bounds = badgeBounds
        badgeBoundsSet = true
    }

    private class GifBadge(context: Context?) : Drawable() {

        private val GIF = "GIF"
        private val TEXT_SIZE = 12    // sp
        private val PADDING = 4       // dp
        private val CORNER_RADIUS = 2 // dp
        private val BACKGROUND_COLOR = Color.WHITE
        private val TYPEFACE = "sans-serif-black"
        private val TYPEFACE_STYLE = Typeface.NORMAL
        private var bitmap: Bitmap? = null
        private var width: Int = 0
        private var height: Int = 0
        private val paint: Paint

        init {
            if (bitmap == null) {
                val dm = context?.resources?.displayMetrics
                val density: Float = dm!!.density
                val scaledDensity: Float = dm.scaledDensity
                val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG or Paint.SUBPIXEL_TEXT_FLAG)
                textPaint.typeface = Typeface.create(TYPEFACE, TYPEFACE_STYLE)
                textPaint.textSize = scaledDensity * TEXT_SIZE
                val padding = PADDING * density
                val cornerRadius = CORNER_RADIUS * density
                val textBounds = Rect()
                textPaint.getTextBounds(GIF, 0, GIF.length, textBounds)
                height = (padding + textBounds.height().toFloat() + padding).toInt()
                width = (padding + textBounds.width().toFloat() + padding).toInt()
                bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                bitmap?.setHasAlpha(true)
                val canvas = Canvas(bitmap)
                val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)
                backgroundPaint.color = BACKGROUND_COLOR
                canvas.drawRoundRect(0f, 0f, width.toFloat(), height.toFloat(), cornerRadius, cornerRadius,
                        backgroundPaint)
                // punch out the word 'GIF', leaving transparency
                textPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
                canvas.drawText(GIF, padding, height - padding, textPaint)
            }
            paint = Paint()
        }

        override fun setAlpha(alpha: Int) {

        }

        override fun getOpacity(): Int {
            return 0
        }

        override fun setColorFilter(colorFilter: ColorFilter?) {
            paint.colorFilter = colorFilter
        }

        override fun draw(canvas: Canvas?) {
            canvas?.drawBitmap(bitmap, bounds.left.toFloat(), bounds.top.toFloat(), paint)
        }

        override fun getIntrinsicWidth(): Int {
            return width
        }
    }
}

