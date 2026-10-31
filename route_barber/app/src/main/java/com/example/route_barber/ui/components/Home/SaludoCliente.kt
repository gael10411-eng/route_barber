package com.routebarber.ui.components.home

import androidx.compose.foundation.layout.*
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
fun SaludoCliente(nombre: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "Hola, $nombre",
            color = MaterialTheme.colorScheme.onSurface, // Blanco Suave[cite: 4]
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "¿Listo para tu próximo corte?",
            color = MaterialTheme.colorScheme.primary, // Dorado Ámbar[cite: 3]
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SaludoClientePreview() {
    RouteBarberTheme {
        SaludoCliente(nombre = "Oscar Uriel")
    }
}