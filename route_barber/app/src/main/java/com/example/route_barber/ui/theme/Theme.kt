package com.routebarber.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val RouteBarberColorScheme = darkColorScheme(
    primary = DoradoAmbar,
    onPrimary = NegroCarbon,
    background = NegroMateProfundo,
    surface = CarbonElevado,
    surfaceVariant = GrisGrafito,
    onSurface = BlancoSuave,
    onSurfaceVariant = GrisClaroMuted,
    error = RojoCarmesi
)

@Composable
fun RouteBarberTheme(content: @Composable () -> Unit) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // Configuramos la barra de estado para que coincida con el fondo oscuro
            window.statusBarColor = NegroMateProfundo.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = RouteBarberColorScheme,
        typography = Typography,
        content = content
    )
}