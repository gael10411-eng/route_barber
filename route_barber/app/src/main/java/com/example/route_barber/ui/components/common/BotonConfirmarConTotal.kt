package com.routebarber.ui.components.common

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
fun BotonConfirmarConTotal(
    textoBoton: String,
    totalTexto: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary, // Dorado Ámbar[cite: 3]
            contentColor = MaterialTheme.colorScheme.onPrimary // Negro Carbón[cite: 3]
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = textoBoton, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = totalTexto, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BotonConfirmarConTotalPreview() {
    RouteBarberTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            BotonConfirmarConTotal(
                textoBoton = "Confirmar Cita",
                totalTexto = "Total $180",
                onClick = {}
            )
        }
    }
}