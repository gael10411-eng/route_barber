package com.routebarber.ui.components.citas

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun SelectorHorarios(
    selectedTime: String,
    onTimeSelected: (String) -> Unit
) {
    val horarios = listOf("4:00 PM", "5:00 PM")

    Row {
        horarios.forEach { hora ->
            val isSelected = selectedTime == hora
            Button(
                onClick = { onTimeSelected(hora) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                    contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = hora)
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectorHorariosPreview() {
    RouteBarberTheme {
        SelectorHorarios(selectedTime = "4:00 PM", onTimeSelected = {})
    }
}