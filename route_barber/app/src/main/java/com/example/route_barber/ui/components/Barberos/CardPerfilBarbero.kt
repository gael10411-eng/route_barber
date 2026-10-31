package com.routebarber.ui.components.barberos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.routebarber.model.Barbero
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun CardPerfilBarbero(barbero: Barbero) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface // Carbón Elevado[cite: 3]
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Simulación de foto de perfil
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = MaterialTheme.colorScheme.surfaceVariant, shape = CircleShape), // Gris Grafito[cite: 4]
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Foto del barbero",
                    tint = MaterialTheme.colorScheme.primary, // Dorado Ámbar[cite: 3]
                    modifier = Modifier.size(60.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = barbero.nombre,
                color = MaterialTheme.colorScheme.onSurface, // Blanco Suave[cite: 4]
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "⭐ ${barbero.calificacion} de calificación",
                color = MaterialTheme.colorScheme.primary, // Dorado Ámbar[cite: 3]
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPerfilBarberoPreview() {
    RouteBarberTheme {
        CardPerfilBarbero(barbero = Barbero(1, "Brandon Gutiérrez", "Cortes Clásicos", 4.7))
    }
}