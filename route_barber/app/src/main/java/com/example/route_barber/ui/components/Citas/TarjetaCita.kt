package com.routebarber.ui.components.citas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.routebarber.model.Barbero
import com.routebarber.model.Cita
import com.routebarber.model.Servicio
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun TarjetaCita(
    cita: Cita,
    onClickDetalle: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickDetalle() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface // Carbón Elevado[cite: 3]
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Con: ${cita.barbero.nombre}",
                    color = MaterialTheme.colorScheme.onSurface, // Blanco Suave[cite: 4]
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${cita.fecha} •${cita.hora}",
                    color = MaterialTheme.colorScheme.onSurfaceVariant, // Gris Claro Muted[cite: 4]
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = cita.servicio.nombre,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            // Aplicamos Rojo Carmesí si está cancelada, Dorado Ámbar para los demás estados[cite: 3, 4]
            val colorEstado = if (cita.estado.equals("Cancelada", ignoreCase = true)) {
                MaterialTheme.colorScheme.error
            } else {
                MaterialTheme.colorScheme.primary
            }

            Text(
                text = cita.estado,
                color = colorEstado,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetaCitaPreview() {
    RouteBarberTheme {
        TarjetaCita(
            cita = Cita(
                id = 1,
                barbero = Barbero(1, "Gael García", "Fade & Barba", 4.9),
                servicio = Servicio(1, "Corte Clásico", 150.0, 30),
                fecha = "2026-10-28",
                hora = "16:00",
                estado = "Confirmada"
            ),
            onClickDetalle = {}
        )
    }
}