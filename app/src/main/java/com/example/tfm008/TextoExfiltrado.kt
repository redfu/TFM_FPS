package com.example.tfm008

import android.util.Log

class TextoExfiltrado {
    private val texto = "@Hola"
    private val textoBits = mutableListOf<Int>()
    private var indicePosicion = 0
    private var indiceLongitud = 0

    init {
        for (c in texto) {
            val bits = Integer.toBinaryString(c.toInt())
            for (b in bits.padStart(8, '0')) {
                textoBits.add(b.toString().toInt())
            }
        }
        indiceLongitud = textoBits.size
    }
    fun obtenerPosicionDeIndice(): Int {
        val indice = getIndex()
        if (indice == indiceLongitud-1) {
            resetIndex()
        }else{
            incrementaIndex()
        }
        return textoBits[indice]
    }
    private fun incrementaIndex() {
        indicePosicion++
    }
    private fun getIndex(): Int {
        return indicePosicion
    }
    private fun resetIndex() {
        indicePosicion = 0
    }
}
