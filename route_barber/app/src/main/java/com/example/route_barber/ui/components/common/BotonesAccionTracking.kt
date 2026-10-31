package com.routebarber.ui.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun BotonesAccionTracking(
    tiempoEstimado: String,
    nombreBarbero: String,
    vehiculo: String,
    onLlamarClick: () -> Unit,
    onChatClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), // Carbón Elevado
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            // Fila superior: Tiempo estimado y datos del barbero
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Tiempo estimado",
                        color = MaterialTheme.colorScheme.onSurfaceVariant, // Gris Claro Muted
                        fontSize = 12.sp
                    )
                    Text(
                        text = tiempoEstimado,
                        color = MaterialTheme.colorScheme.onSurface, // Blanco Suave
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Black
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = nombreBarbero,
                        color = MaterialTheme.colorScheme.onSurface, // Blanco Suave
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = vehiculo,
                        color = MaterialTheme.colorScheme.onSurfaceVariant, // Gris Claro Muted
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Fila inferior: Botones de Llamar y Chat
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(
                    onClick = onLlamarClick,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
                    border = ButtonDefaults.outlinedButtonBorder.copy(brush = SolidColor(MaterialTheme.colorScheme.surfaceVariant))
                ) {
                    Text("Llamar", fontWeight = FontWeight.SemiBold)
                }
                Spacer(modifier = Modifier.width(12.dp))
                OutlinedButton(
                    onClick = onChatClick,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.onSurface),
                    border = ButtonDefaults.outlinedButtonBorder.copy(brush = SolidColor(MaterialTheme.colorScheme.surfaceVariant))
                ) {
                    Text("Chat", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BotonesAccionTrackingPreview() {
    RouteBarberTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            BotonesAccionTracking(
                tiempoEstimado = "15 min",
                nombreBarbero = "Mateo Ruiz",
                vehiculo = "Moto · YB-214",
                onLlamarClick = {},
                onChatClick = {}
            )
        }
    }
}