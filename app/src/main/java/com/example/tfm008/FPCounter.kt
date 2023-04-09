package com.example.tfm008

import android.widget.TextView

class FPSCounter(private val fpsTextView: TextView?) {
    private var startTime = System.nanoTime()
    private var frames = 0
    private var i = 0
    var ultimoNumero = 0
    var fpsModificado = 0
        private set
    val textoExfiltrado = TextoExfiltrado()
    fun logFrame() {
        frames++
        if (System.nanoTime() - startTime >= 1000000000) {
            fpsModificado = frames
            updateFPS()
            frames = 0
            startTime = System.nanoTime()
        }
    }
    private fun updateFPS() {
        fpsTextView?.text = "FPS: $fpsModificado"
        val bit = textoExfiltrado.obtenerPosicionDeIndice()
        if (bit == 0) {
                fpsModificado = 60
                if(ultimoNumero == fpsModificado) {
                    fpsModificado = 58
                }
        }else{
            fpsModificado = 61
                if(ultimoNumero == fpsModificado) {
                    fpsModificado = 59
                }
            }
        ultimoNumero = fpsModificado
        i++
    }
}