package com.routebarber.ui.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun SelectorDisponibilidad(
    estadoActual: Boolean,
    textoVerdadero: String,
    textoFalso: String,
    onToggle: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { onToggle(true) },
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (estadoActual) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.background,
                contentColor = if (estadoActual) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = textoVerdadero, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.width(12.dp))

        Button(
            onClick = { onToggle(false) },
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (!estadoActual) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.background,
                contentColor = if (!estadoActual) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = textoFalso, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectorDisponibilidadPreview() {
    RouteBarberTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            SelectorDisponibilidad(
                estadoActual = true,
                textoVerdadero = "Disponible",
                textoFalso = "No disponible",
                onToggle = {}
            )
        }
    }
}