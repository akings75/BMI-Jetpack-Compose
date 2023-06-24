package com.example.bmiapp.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ResultCalculate(
    modifier: Modifier = Modifier,
    bmiValue: String,
    advice: String,
    color: Int,
    navController: NavController,
) {


    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(color)) // Burada integer olan color'u tekrar Color sınıfına dönüştürüyoruz Color(color) yaparak
    ) {
        Text(
            text = "YOUR RESULT",
            fontSize = 50.sp,
            modifier = modifier.padding(start = 32.dp, top = 150.dp),
            color = Color.White
        )
        Text(
            text = bmiValue,
            fontSize = 60.sp,
            modifier = modifier.padding(start = 16.dp, top = 40.dp),
            lineHeight = 60.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = advice,
            fontSize = 40.sp,
            modifier = modifier.padding(start = 16.dp, top = 40.dp),
            lineHeight = 60.sp,
            color = Color.White
        )
        Button(
            onClick = { navController.navigate("calculate") },
            colors = ButtonDefaults.buttonColors(Color.White)

        ) {
            Text(text = "RECALCULATE", fontSize = 24.sp, color = Color.Magenta)
        }
    }
}