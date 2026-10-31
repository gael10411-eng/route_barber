package com.routebarber.ui.components.barberos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun FichaResumenBarbero(
    nombreBarbero: String,
    detalles: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Barbero",
            tint = MaterialTheme.colorScheme.primary, // Dorado Ámbar[cite: 3]
            modifier = Modifier
                .size(40.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp)) // Gris Grafito[cite: 4]
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = nombreBarbero, // <-- Mostramos el nombre recibido
                color = MaterialTheme.colorScheme.onSurface, // Blanco Suave[cite: 4]
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Text(
                text = detalles,
                color = MaterialTheme.colorScheme.onSurfaceVariant, // Gris Claro Muted[cite: 4]
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF111111) // <-- Añadimos el color de fondo mate
@Composable
fun FichaResumenBarberoPreview() {
    RouteBarberTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            FichaResumenBarbero(
                nombreBarbero = "Mateo Ruiz",
                detalles = "⭐ 4.9 · Barbería Norte"
            )
        }
    }
}