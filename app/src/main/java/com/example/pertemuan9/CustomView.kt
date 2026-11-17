package com.example.pertemuan9

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Menggambar lingkaran merah
        canvas.drawCircle(200f, 100f, 80f, paint)

        // Mengubah warna dan menggambar persegi panjang biru
        paint.color = Color.BLUE
        canvas.drawRect(100f, 220f, 300f, 340f, paint)
    }
}