package com.example.unitconvertor


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {

    val item = mapOf(
        "Currency" to Pair(R.drawable.baseline_currency_rupee_24, Routes.currencyPage),
        "Length" to Pair(R.drawable.outline_horizontal_rule_24, Routes.lengthPage),
        "Area" to Pair(R.drawable.sharp_check_box_outline_blank_24, Routes.areaPage),
        "Volume" to Pair(R.drawable.box_icon, Routes.volumePage),
        "Weight" to Pair(R.drawable.weight_icon, Routes.weightPage),
        "Temperature" to Pair(R.drawable.sharp_device_thermostat_24, Routes.temperaturePage),
        "Speed" to Pair(R.drawable.rounded_delivery_truck_speed_24, Routes.speedPage),
        "Pressure" to Pair(R.drawable.twotone_timer_24, Routes.pressurePage),
        "Number System" to Pair(R.drawable.baseline_123_24,Routes.numberSystemPage),
        "Power" to Pair(R.drawable.round_electric_bolt_24, Routes.powerPage)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Unit Convertor") },
                colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .padding(innerPadding)
                .padding(12.dp)

        )
        {
            items(item.entries.toList()) { entry ->
                val (imageRes, route) = entry.value
                BoxItems(
                    name = entry.key,
                    imageRes = imageRes,
                    route = route,
                    navController = navController
                )

            }
        }


    }


}


@Composable
fun BoxItems(name: String, imageRes: Int, route: String, navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.DarkGray)
            .padding(10.dp)
            .clickable {
                navController.navigate(route)

            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        Image(
            painter = painterResource(id = imageRes), contentDescription = name,
            colorFilter = ColorFilter.tint(Color.White)
        )

        Text(name, color = Color.White, fontSize = 12.5.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLayout(title: String, item: List<String>, navController: NavController) {
    var expanded by remember {
        mutableStateOf(false)
    }

    var initialValue by remember {
        mutableStateOf("")
    }
    var selectedItem by remember {
        mutableStateOf(item[0])
    }
    var result by remember {
        mutableStateOf("")
    }


    Scaffold(


        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_back_24),
                        contentDescription = "Back",
                        modifier = Modifier
                            .padding(7.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                    },


                colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White
                )
            )
        }


    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                value = initialValue,
                onValueChange = {
                    initialValue = it
                },
                modifier = Modifier
                    .padding(19.dp)
                    .width(250.dp),
                label = { Text("Enter Value") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                ItemButtons(item)
                ItemButtons(item)


            }
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )



        }
    }
}

@Composable
fun ItemButtons(item: List<String>) {

    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedItem by remember {
        mutableStateOf(item[0])
    }
    Box(
        modifier = Modifier
            .width(140.dp)
            .height(35.dp)
    ) {
        Button(
            onClick = {
                expanded = true
            }
        ) {
            Text(selectedItem)

            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                contentDescription = "Drop Down",
                modifier = Modifier
                    .rotate(if (expanded) 180f else 0f)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            for (i in item) {
                DropdownMenuItem(
                    text = { Text(i) },
                    onClick = {
                        selectedItem = i
                        expanded = false
                    }
                )
            }
        }
    }
}

