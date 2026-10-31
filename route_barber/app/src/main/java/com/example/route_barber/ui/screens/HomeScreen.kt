package com.routebarber.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.routebarber.ui.components.home.CardBarberoCercano
import com.routebarber.ui.components.home.SelectorModoDomicilio
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun HomeScreen(navController: NavController) {
    var isDomicilio by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Simulación del Mapa interactivo de fondo
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.Center
        ) {
            Text("Mapa Interactivo", color = Color.Gray)
        }

        // Selector Superior
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 48.dp)
        ) {
            SelectorModoDomicilio(
                isDomicilio = isDomicilio,
                onToggle = { isDomicilio = it }
            )
        }

        // Tarjeta Inferior del Barbero más cercano
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)
                .padding(bottom = 32.dp)
        ) {
            CardBarberoCercano(
                nombreBarbero = "Mateo Ruiz",
                calificacionDistancia = "⭐ 4.9 - a 8 min",
                precioDesde = "Desde $180",
                onClickVerPerfil = { navController.navigate("booking_screen") }
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    RouteBarberTheme {
        HomeScreen(navController = rememberNavController())
    }
}