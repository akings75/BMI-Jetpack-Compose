package com.example.bmiapp.Model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

data class BMI (
    var value: Float = 0f,
    val advice: String = "",
    val color: Int = Color(0x77f5f5f5).toArgb() // toArgb(): Color sınıfını Integer sınıfına dönüştürüyor.Navigasyon ile renk gönderebilmek için
// rengi Integer sınıfına dönüştürmemiz gerekiyor.
        )
