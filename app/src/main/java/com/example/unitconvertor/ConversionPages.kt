package com.example.unitconvertor

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController


@Composable
fun LengthPage(navController: NavController) {


    AppLayout("Length Convertor", listOf("meter", "cm", "inch", "feet", "mile"), navController)
    
}

@Composable
fun AreaPage(navController: NavController) {
    AppLayout(
        "Area Convertor",
        listOf("m\u00B2", "cm\u00B2", "inch\u00B2", "ft\u00B2", "mile\u00B2"),
        navController
    )
}

@Composable
fun VolumePage(navController: NavController) {
    AppLayout(
        "Volume Convertor",
        listOf("m\u00B3", "cm\u00B3", "inch\u00B3", "ft\u00B3", "mile\u00B3"),
        navController
    )
}

@Composable
fun WeightPage(navController: NavController) {
    AppLayout(
        "Weight Convertor",
        listOf("kg", "gram", "mg", "pound", "ounce"),
        navController
    )
}

@Composable
fun TemperaturePage(navController: NavController) {
    AppLayout("Temperature Convertor", listOf("\u00B0C", "\u00B0F", "K"), navController)
}

@Composable
fun SpeedPage(navController: NavController) {
    AppLayout(
        "Speed Convertor",
        listOf("m/s", "km/h", "mile/h"),
        navController
    )
}

@Composable
fun PressurePage(navController: NavController) {
    AppLayout(
        "Pressure Convertor",
        listOf("kg/m²", "pound/in\u00B2", "psi"),
        navController
    )
}

@Composable
fun NumberSystemPage(navController: NavController) {
    AppLayout(
        "Number System Convertor",
        listOf("decimal", "binary", "octal", "hexadecimal"),
        navController
    )
}

@Composable
fun PowerPage(navController: NavController) {
    AppLayout("Power Convertor", listOf("W", "KW", "MW", "GW"), navController)
}

@Composable
fun CurrencyPage(navController: NavController) {
    AppLayout("Currency Convertor", listOf("dollar", "euro", "rupee", "pound"), navController)
}



fun convertLength(value: Double, fromUnit: String, toUnit: String): Double {
    val inMeters = when (fromUnit) {
        "meter" -> value
        "cm" -> value / 100
        "inch" -> value * 0.0254
        "feet" -> value * 0.3048
        "mile" -> value * 1609.34
        else -> throw IllegalArgumentException("Unknown fromUnit")
    }

    return when (toUnit) {
        "meter" -> inMeters
        "cm" -> inMeters * 100
        "inch" -> inMeters / 0.0254
        "feet" -> inMeters / 0.3048
        "mile" -> inMeters / 1609.34
        else -> throw IllegalArgumentException("Unknown toUnit")
    }
}