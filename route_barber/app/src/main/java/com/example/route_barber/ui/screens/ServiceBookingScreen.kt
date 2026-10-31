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
import com.routebarber.ui.components.barberos.FichaResumenBarbero
import com.routebarber.ui.components.citas.CardSeleccionServicioCheckbox
import com.routebarber.ui.components.citas.InputNotasBarbero
import com.routebarber.ui.components.citas.SelectorHorarios
import com.routebarber.ui.components.common.BotonConfirmarConTotal
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun ServiceBookingScreen(navController: NavController) {
    var notes by remember { mutableStateOf("") }
    var selectedService by remember { mutableStateOf(true) }
    var selectedTime by remember { mutableStateOf("4:00 PM") }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                InputNotasBarbero(notas = notes, onNotasChange = { notes = it })
                Spacer(modifier = Modifier.height(12.dp))
                BotonConfirmarConTotal(
                    textoBoton = "Confirmar Cita",
                    totalTexto = "Total $180",
                    onClick = { /* TODO: Confirmar Cita */ }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Reserva tu cita",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Info del Barbero
            FichaResumenBarbero(
                nombreBarbero = "Mateo Ruiz",
                detalles = "⭐ 4.9 · Barbería Norte"
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Servicios
            Text("Selecciona servicios", color = MaterialTheme.colorScheme.onSurface, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            CardSeleccionServicioCheckbox(
                nombreServicio = "Corte clásico",
                duracion = "45 min",
                precio = "$180",
                isChecked = selectedService,
                onCheckedChange = { selectedService = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Horarios
            Text("Elige horario", color = MaterialTheme.colorScheme.onSurface, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            SelectorHorarios(
                selectedTime = selectedTime,
                onTimeSelected = { selectedTime = it }
            )
        }
    }
}

@Preview
@Composable
fun ServiceBookingScreenPreview() {
    RouteBarberTheme {
        ServiceBookingScreen(rememberNavController())
    }
}