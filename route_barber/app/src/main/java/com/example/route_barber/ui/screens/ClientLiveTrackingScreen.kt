package com.routebarber.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.routebarber.ui.components.common.BotonesAccionTracking
import com.routebarber.ui.components.common.CardEstadoEnVivo
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun ClientLiveTrackingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Simulación del Mapa
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.Center
        ) {
            Text("Mapa de Seguimiento GPS", color = Color.Gray)
        }

        // Tarjeta Superior: Estado del Trayecto
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .padding(16.dp)
                .padding(top = 24.dp)
        ) {
            CardEstadoEnVivo(
                estadoBadge = "EN VIVO",
                titulo = "Barbero en Camino",
                subtitulo = "Hacia Av. Reforma 214"
            )
        }

        // Tarjeta Inferior: Tiempo Estimado y Contacto
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)
                .padding(bottom = 24.dp)
        ) {
            BotonesAccionTracking(
                tiempoEstimado = "15 min",
                nombreBarbero = "Mateo Ruiz",
                vehiculo = "Moto · YB-214",
                onLlamarClick = { /* Acción Llamar */ },
                onChatClick = { /* Acción Chat */ }
            )
        }
    }
}

@Preview
@Composable
fun ClientLiveTrackingScreenPreview() {
    RouteBarberTheme {
        ClientLiveTrackingScreen(rememberNavController())
    }
}