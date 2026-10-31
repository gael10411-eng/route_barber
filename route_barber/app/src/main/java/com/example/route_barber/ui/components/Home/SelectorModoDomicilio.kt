package com.routebarber.ui.components.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun SelectorModoDomicilio(
    isDomicilio: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(modifier = Modifier.padding(4.dp)) {
            Button(
                onClick = { onToggle(true) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isDomicilio) MaterialTheme.colorScheme.primary else Color.Transparent,
                    contentColor = if (isDomicilio) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                ),
                shape = RoundedCornerShape(20.dp),
                elevation = null
            ) {
                Text("A Domicilio", fontWeight = FontWeight.Bold)
            }
            Button(
                onClick = { onToggle(false) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (!isDomicilio) MaterialTheme.colorScheme.primary else Color.Transparent,
                    contentColor = if (!isDomicilio) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                ),
                shape = RoundedCornerShape(20.dp),
                elevation = null
            ) {
                Text("En Local", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectorModoDomicilioPreview() {
    RouteBarberTheme {
        SelectorModoDomicilio(isDomicilio = true, onToggle = {})
    }
}