package com.routebarber.ui.components.citas

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
fun CardEstadoReserva(estado: String) {
    val esCancelada = estado.equals("Cancelada", ignoreCase = true)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface // Carbón Elevado[cite: 3]
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Estado de la reserva",
                color = MaterialTheme.colorScheme.onSurfaceVariant, // Gris Claro Muted[cite: 4]
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = estado.uppercase(),
                color = if (esCancelada) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary, // Lógica de colores estricta[cite: 3, 4]
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardEstadoReservaPreview() {
    RouteBarberTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            CardEstadoReserva(estado = "Confirmada")
            Spacer(modifier = Modifier.height(16.dp))
            CardEstadoReserva(estado = "Cancelada")
        }
    }
}