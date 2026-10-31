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
fun CardSeleccionServicioCheckbox(
    nombreServicio: String,
    duracion: String,
    precio: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), // Carbón Elevado[cite: 3]
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = onCheckedChange,
                    colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.primary) // Dorado Ámbar[cite: 3]
                )
                Column {
                    Text(
                        text = nombreServicio,
                        color = MaterialTheme.colorScheme.onSurface, // Blanco Suave[cite: 4]
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = duracion,
                        color = MaterialTheme.colorScheme.onSurfaceVariant, // Gris Claro Muted[cite: 4]
                        fontSize = 12.sp
                    )
                }
            }
            Text(
                text = precio,
                color = MaterialTheme.colorScheme.onSurface, // Blanco Suave[cite: 4]
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardSeleccionServicioCheckboxPreview() {
    RouteBarberTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            CardSeleccionServicioCheckbox(
                nombreServicio = "Corte clásico",
                duracion = "45 min",
                precio = "$180",
                isChecked = true,
                onCheckedChange = {}
            )
        }
    }
}