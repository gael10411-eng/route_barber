package com.routebarber.ui.components.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun Encabezado(titulo: String) {
    Text(
        text = titulo,
        color = MaterialTheme.colorScheme.onSurface, // Blanco Suave[cite: 4]
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun EncabezadoPreview() {
    RouteBarberTheme {
        Encabezado(titulo = "Mis Citas")
    }
}