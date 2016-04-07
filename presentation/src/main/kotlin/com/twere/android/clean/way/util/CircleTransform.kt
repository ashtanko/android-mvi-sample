package com.twere.android.clean.way.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Shader
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation

class CircleTransform(context: Context) : BitmapTransformation(context) {

  override fun getId(): String? {
    return javaClass.name
  }

  override fun transform(pool: BitmapPool?, toTransform: Bitmap?, outWidth: Int,
      outHeight: Int): Bitmap? {
    return circleCrop(pool, toTransform)
  }

  //TODO need rewrite the bad kotlin code
  fun circleCrop(pool: BitmapPool?, source: Bitmap?): Bitmap? {
    if (source == null) return null

    val size = Math.min(source.width, source.height)
    val x = (source.width - size) / 2
    val y = (source.height - size) / 2

    val squared = Bitmap.createBitmap(source, x, y, size, size)
    var result: Bitmap? = pool!!.get(size, size, Bitmap.Config.ARGB_8888)
    if (result == null) {
      result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
    }

    val canvas = Canvas(result)
    val paint = Paint(Paint.FILTER_BITMAP_FLAG or Paint.DITHER_FLAG or Paint.ANTI_ALIAS_FLAG)
    paint.shader = BitmapShader(squared, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    val r = size / 2f
    canvas.drawCircle(r, r, r, paint)
    return result!!
  }
}