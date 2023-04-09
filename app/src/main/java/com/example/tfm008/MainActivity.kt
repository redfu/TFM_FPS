package com.example.tfm008

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View


private var fps = 0
class MyCustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val fpsCounter = FPSCounter(null)
    private val textPaint = Paint()
    init {
        // Configura el Paint para el texto
        textPaint.color = Color.WHITE
        textPaint.textSize = 76f
        textPaint.typeface = Typeface.DEFAULT_BOLD
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText("FPS: "+fps, 50f, 100f, textPaint)
        invalidate()
    }
}

class MainActivity : AppCompatActivity() {
    private lateinit var fpsCounter: FPSCounter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide();

        fpsCounter = FPSCounter(null)

        val myCustomView = findViewById<MyCustomView>(R.id.my_custom_view)
        myCustomView.postDelayed(object : Runnable {
            override fun run() {
                fpsCounter.logFrame()
                fps = fpsCounter.fpsModificado

                myCustomView.invalidate()
                myCustomView.postDelayed(this, 10)
            }
        }, 10)
    }
}





