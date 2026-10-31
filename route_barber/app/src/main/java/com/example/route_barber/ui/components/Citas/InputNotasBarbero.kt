package com.routebarber.ui.components.citas

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun InputNotasBarbero(
    notas: String,
    onNotasChange: (String) -> Unit
) {
    OutlinedTextField(
        value = notas,
        onValueChange = onNotasChange,
        placeholder = { Text("Notas para tu barbero (opcional)", color = MaterialTheme.colorScheme.onSurfaceVariant) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant,
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

@Preview(showBackground = true)
@Composable
fun InputNotasBarberoPreview() {
    RouteBarberTheme {
        InputNotasBarbero(notas = "", onNotasChange = {})
    }
}