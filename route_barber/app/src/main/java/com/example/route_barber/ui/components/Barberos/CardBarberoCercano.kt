package com.routebarber.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
fun CardBarberoCercano(
    nombreBarbero: String,
    calificacionDistancia: String,
    precioDesde: String,
    onClickVerPerfil: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Barbero más cercano",
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(text = nombreBarbero, color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                    Text(text = calificacionDistancia, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 14.sp)
                    Text(text = precioDesde, color = MaterialTheme.colorScheme.primary, fontSize = 14.sp, fontWeight = FontWeight.Medium)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = onClickVerPerfil,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Ver Perfil y Servicios", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardBarberoCercanoPreview() {
    RouteBarberTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            CardBarberoCercano(
                nombreBarbero = "Mateo Ruiz",
                calificacionDistancia = "⭐ 4.9 - a 8 min",
                precioDesde = "Desde $180",
                onClickVerPerfil = {}
            )
        }
    }
}