package com.example.bmiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bmiapp.View.CalculateScreen
import com.example.bmiapp.View.ResultCalculate
import com.example.bmiapp.ui.theme.BMIAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIAppTheme {
                // A surface container using the 'background' color from the theme
               Navigator()
            }
        }
    }
}

@Composable
fun Navigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "calculate") {
        composable("calculate") {

            CalculateScreen(navController = navController)

        }

        composable(
            "result/{bmiValue}/{advice}/{color}",
            arguments = listOf(
                navArgument(name = "bmiValue") {
                    type = NavType.StringType
                },
                navArgument(name = "advice") {
                    type = NavType.StringType
                },navArgument(name = "color") {
                    type = NavType.IntType
                }
            ) ) {
            val bmiValue = it.arguments?.getString("bmiValue")
            val advice = it.arguments?.getString("advice")
            val color = it.arguments?.getInt("color")
            if (bmiValue != null) {
                if (advice != null) {
                    if (color != null) {
                        ResultCalculate(bmiValue = bmiValue, advice = advice,color = color, navController = navController)
                    }
                }
            }
        }
    }
}

object Destinations {
    const val CalculateScreen="calculate"
    const val ResultCalculateScreen = "result"

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMIAppTheme {
        Navigator()
    }
}