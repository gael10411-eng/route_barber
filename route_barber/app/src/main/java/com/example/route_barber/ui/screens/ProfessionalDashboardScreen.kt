package com.routebarber.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.routebarber.ui.components.citas.CardProximaCitaProfesional
import com.routebarber.ui.components.common.CardEstadisticas
import com.routebarber.ui.components.common.SelectorDisponibilidad
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun ProfessionalDashboardScreen(navController: NavController) {
    var isDisponible by remember { mutableStateOf(true) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Selector de disponibilidad modularizado
                SelectorDisponibilidad(
                    estadoActual = isDisponible,
                    textoVerdadero = "Disponible",
                    textoFalso = "No disponible",
                    onToggle = { isDisponible = it }
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Botón Iniciar Ruta
                Button(
                    onClick = { /* TODO: Iniciar navegación GPS */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
                ) {
                    Text("Iniciar Ruta", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("VIERNES, 6 SEPTIEMBRE", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            Text("Hola, Mateo", color = MaterialTheme.colorScheme.onSurface, fontSize = 28.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(24.dp))

            // Estadísticas modularizadas
            CardEstadisticas(citasHoy = "4", ganancias = "$850")

            Spacer(modifier = Modifier.height(32.dp))

            // Próxima Cita modularizada
            Text("Próxima cita", color = MaterialTheme.colorScheme.onSurface, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(12.dp))
            CardProximaCitaProfesional(
                hora = "4:00 PM",
                tiempoRestante = "EN 35 MIN",
                nombreCliente = "Diego Hernández",
                detalleServicio = "Corte clásico · $180",
                direccion = "Av. Reforma 214, Col. Centro"
            )
        }
    }
}

@Preview
@Composable
fun ProfessionalDashboardScreenPreview() {
    RouteBarberTheme {
        ProfessionalDashboardScreen(rememberNavController())
    }
}