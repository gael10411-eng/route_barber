package com.routebarber.ui.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun CardEstadoEnVivo(
    estadoBadge: String,
    titulo: String,
    subtitulo: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), // Carbón Elevado[cite: 3]
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = estadoBadge,
                color = MaterialTheme.colorScheme.primary, // Dorado Ámbar[cite: 3]
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = titulo,
                color = MaterialTheme.colorScheme.onSurface, // Blanco Suave[cite: 4]
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = subtitulo,
                color = MaterialTheme.colorScheme.onSurfaceVariant, // Gris Claro Muted[cite: 4]
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardEstadoEnVivoPreview() {
    RouteBarberTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            CardEstadoEnVivo(
                estadoBadge = "EN VIVO",
                titulo = "Barbero en Camino",
                subtitulo = "Hacia Av. Reforma 214"
            )
        }
    }
}