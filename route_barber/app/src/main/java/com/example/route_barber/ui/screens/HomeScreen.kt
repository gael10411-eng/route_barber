package com.routebarber.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.route_barber.ui.components.common.RouteBarberBottomBar
import com.routebarber.ui.components.home.CardBarberoCercano
import com.routebarber.ui.components.home.SelectorModoDomicilio
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun HomeScreen(navController: NavController) {
    var isDomicilio by remember { mutableStateOf(true) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            Column {
                // Ficha de acceso rápido a TODAS las pantallas de la app (Navegación completa)
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.surface,
                    tonalElevation = 8.dp
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = "Navegación Rápida (Todas las pantallas):",
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Button(onClick = { navController.navigate("booking_screen") }) {
                                Text("Reservar")
                            }
                            Button(onClick = { navController.navigate("mis_citas_screen") }) {
                                Text("Mis Citas")
                            }
                            Button(onClick = { navController.navigate("perfil_cliente_screen") }) {
                                Text("Perfil")
                            }
                            Button(onClick = { navController.navigate("detalle_barbero_screen/1") }) {
                                Text("Barbero")
                            }
                            Button(onClick = { navController.navigate("tracking_screen") }) {
                                Text("Tracking")
                            }
                            Button(onClick = { navController.navigate("professional_screen") }) {
                                Text("Profesional")
                            }
                            Button(
                                onClick = { navController.navigate("login_screen") },
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                            ) {
                                Text("Salir")
                            }
                        }
                    }
                }

                // Barra de Navegación Inferior Funcional
                RouteBarberBottomBar(navController = navController)
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(MaterialTheme.colorScheme.background)
        ) {
            // Simulación del Mapa interactivo de fondo
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF1E1E1E)),
                contentAlignment = Alignment.Center
            ) {
                Text("Mapa Interactivo (Ruta Barber)", color = Color.Gray)
            }

            // Selector Superior
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 16.dp)
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
                    .padding(bottom = 16.dp)
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
}

@Preview
@Composable
fun HomeScreenPreview() {
    RouteBarberTheme {
        HomeScreen(navController = rememberNavController())
    }
}