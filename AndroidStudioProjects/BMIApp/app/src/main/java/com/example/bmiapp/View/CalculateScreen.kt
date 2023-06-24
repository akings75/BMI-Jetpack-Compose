package com.example.bmiapp.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bmiapp.Destinations
import com.example.bmiapp.Model.BMI
import com.example.bmiapp.ViewModel.CalculatorViewModel

@Composable
fun CalculateScreen(modifier: Modifier = Modifier,navController: NavController) {
    val viewModel = viewModel<CalculatorViewModel>()
    var kutle by remember { mutableStateOf(0f) }
    var boy by remember { mutableStateOf(0f) }
    val kutleValue = String.format("%.0f", kutle)
    val boyValue = String.format("%.2f", boy)

    Column(verticalArrangement = Arrangement.spacedBy(30.dp)) {
        Text(
            text = "CALCULATE YOUR BMI",
            fontSize = 60.sp,
            modifier = modifier.padding(start = 16.dp, top = 40.dp),
            lineHeight = 60.sp
        )
        Spacer(modifier = modifier.padding(60.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Slider(
                value = kutle,
                onValueChange = { kutle = it },
                modifier = modifier.size(width = 360.dp, height = 28.dp),
                valueRange = 0f..200f,
                colors = SliderDefaults.colors(
                    activeTrackColor = Color.Green,
                    inactiveTrackColor = Color.Red,
                    thumbColor = Color.Magenta
                ),
            )

            Text(text = "$kutleValue kg", color = Color.Gray, fontSize = 20.sp)
        }

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Slider(
                value = boy,
                onValueChange = { boy = it },
                modifier = modifier.size(width = 360.dp, height = 28.dp),
                valueRange = 0f..3f,
                colors = SliderDefaults.colors(
                    activeTrackColor = Color.Green,
                    inactiveTrackColor = Color.Red,
                    thumbColor = Color.Magenta
                ),

                )

            Text(text = "$boyValue m", color = Color.Gray, fontSize = 20.sp)

        }

        Button(onClick = {
            viewModel.calculateBMI(kutle, boy)
            navController.navigate("result/${viewModel.getBMIValue()}/${viewModel.getAdvice()}/${viewModel.getColor()}" )

        }, modifier = modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Calculate", fontSize = 24.sp)
        }
    }
}
