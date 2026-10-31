package com.routebarber.ui.components.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun EncabezadoLogin() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 48.dp)
    ) {
        Text(
            text = "Route Barber",
            color = MaterialTheme.colorScheme.primary, // Dorado Ámbar[cite: 3]
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Tu estilo, tu ruta",
            color = MaterialTheme.colorScheme.onSurfaceVariant, // Gris Claro Muted[cite: 4]
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EncabezadoLoginPreview() {
    RouteBarberTheme {
        EncabezadoLogin()
    }
}