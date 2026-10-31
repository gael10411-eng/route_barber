package com.routebarber.ui.components.citas

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
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun CardProximaCitaProfesional(
    hora: String,
    tiempoRestante: String,
    nombreCliente: String,
    detalleServicio: String,
    direccion: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), // Carbón Elevado[cite: 3]
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = hora,
                    color = MaterialTheme.colorScheme.onSurface, // Blanco Suave[cite: 4]
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = tiempoRestante,
                    color = MaterialTheme.colorScheme.primary, // Dorado Ámbar[cite: 3]
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = nombreCliente,
                color = MaterialTheme.colorScheme.onSurface, // Blanco Suave[cite: 4]
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = detalleServicio,
                color = MaterialTheme.colorScheme.onSurfaceVariant, // Gris Claro Muted[cite: 4]
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "📍 $direccion",
                color = MaterialTheme.colorScheme.onSurfaceVariant, // Gris Claro Muted[cite: 4]
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardProximaCitaProfesionalPreview() {
    RouteBarberTheme {
        Box(modifier = Modifier.padding(16.dp)) {
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