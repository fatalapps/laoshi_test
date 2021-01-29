package com.laoshi.test.controllers

import android.R
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import androidx.lifecycle.MutableLiveData
import java.io.InputStream
import java.net.URL
import kotlin.concurrent.thread


class ImageController {
    private var AppContext: Context

    constructor(context: Context) {
        AppContext = context
    }

    fun downloadImage(url: String?): MutableLiveData<Bitmap> {
        val liveBmp = MutableLiveData<Bitmap>()
        if (!url.isNullOrEmpty()) {
            thread {
                val input: InputStream = URL(url).openStream()
                val bmp = BitmapFactory.decodeStream(input)
                liveBmp.postValue(bmp)
            }
        }
        return liveBmp
    }

    fun roundImage(bmp: Bitmap, radius: Float): Bitmap {
        val imageRounded = Bitmap.createBitmap(bmp.width, bmp.height, bmp.config)
        val canvas = Canvas(imageRounded)
        val mpaint = Paint()
        mpaint.isAntiAlias = true
        mpaint.shader = BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        canvas.drawRoundRect(
            RectF(0.toFloat(), 0.toFloat(), bmp.width.toFloat(), bmp.height.toFloat()),
            radius,
            radius,
            mpaint
        )
        return imageRounded
    }
}