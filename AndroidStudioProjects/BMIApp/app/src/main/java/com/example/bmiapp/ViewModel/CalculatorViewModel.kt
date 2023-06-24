package com.example.bmiapp.ViewModel

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.example.bmiapp.Model.BMI

class CalculatorViewModel:ViewModel() {

    var bmi = BMI()

    fun getBMIValue(): String {
        return String.format("%.1f", bmi.value)
    }

    fun getAdvice(): String {
        return bmi.advice
    }

    fun getColor(): Int {
        return bmi.color
    }

    fun calculateBMI(weight:Float,height:Float){
        val bmiValue = weight/ (height * height)

        bmi = if (bmiValue < 18.9) {
            BMI(value = bmiValue, advice = "ZAYIF", color = Color( 0xff4000ff).toArgb()) // Mavi renk
        } else if (bmiValue < 24.5) {
            BMI(value = bmiValue, advice = "NORMAL", color = Color(0xFF00FF00).toArgb()) // Yeşil renk
        } else{
            BMI(value = bmiValue, advice = "OBEZ", color = Color(0xFFFFA500).toArgb()) // Turuncu renk
        }
    }
}

// Color( 0xff9000ff).toArgb() MOR