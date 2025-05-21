package com.example.unitconvertor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unitconvertor.ui.theme.UnitConvertorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConvertorTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Routes.homePage) {
                    composable(Routes.homePage) {
                        HomePage(navController)
                    }
                    composable(Routes.lengthPage) {
                        LengthPage(navController)
                    }
                    composable(Routes.areaPage) {
                        AreaPage(navController)
                    }
                    composable(Routes.volumePage) {
                        VolumePage(navController)
                    }
                    composable(Routes.speedPage) {
                        SpeedPage(navController)
                    }
                    composable(Routes.temperaturePage) {
                        TemperaturePage(navController)
                    }
                    composable(Routes.weightPage) {
                        WeightPage(navController)
                    }
                    composable(Routes.pressurePage) {
                        PressurePage(navController)
                    }
                    composable(Routes.numberSystemPage) {
                        NumberSystemPage(navController)
                    }
                    composable(Routes.powerPage) {
                        PowerPage(navController)
                    }
                    composable(Routes.currencyPage){
                        CurrencyPage(navController)
                    }


                }
            }
        }
    }
}