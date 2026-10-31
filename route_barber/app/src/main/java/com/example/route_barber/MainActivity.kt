package com.routebarber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Importaciones actuales
import com.routebarber.ui.screens.DetalleBarberoScreen
import com.routebarber.ui.screens.home.HomeScreen
import com.routebarber.ui.screens.LoginScreen
import com.routebarber.ui.screens.MisCitasScreen
import com.routebarber.ui.screens.PerfilClienteScreen
import com.routebarber.ui.theme.RouteBarberTheme

// Nuevas importaciones necesarias según el PDF (Punto 10)
import com.routebarber.ui.screens.ServiceBookingScreen
import com.routebarber.ui.screens.ClientLiveTrackingScreen
import com.routebarber.ui.screens.ProfessionalDashboardScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    RouteBarberTheme {
        // Contenedor principal que aplica el Negro Mate Profundo a toda la app
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "login_screen"
            ) {
                composable("login_screen") {
                    LoginScreen(navController = navController)
                }
                composable("home_screen") {
                    HomeScreen(navController = navController) // Este funciona como el "Client Home" del PDF
                }
                composable("mis_citas_screen") {
                    MisCitasScreen(navController = navController)
                }
                composable("perfil_cliente_screen") {
                    PerfilClienteScreen(navController = navController)
                }
                composable("detalle_barbero_screen/{barberoId}") { backStackEntry ->
                    // Extraemos el ID del barbero de los argumentos de navegación
                    val barberoId = backStackEntry.arguments?.getString("barberoId")?.toIntOrNull() ?: 1
                    DetalleBarberoScreen(navController = navController, barberoId = barberoId)
                }

                // ============================================================================
                // NUEVAS RUTAS BASADAS EN EL DISEÑO DE LA APLICACIÓN (PDF PUNTO 10)
                // ============================================================================

                composable("booking_screen") {
                    // Pantalla 2: Reserva de cita (Service booking)
                    ServiceBookingScreen(navController = navController)
                }
                composable("tracking_screen") {
                    // Pantalla 3: Seguimiento en vivo (Client live tracking)
                    ClientLiveTrackingScreen(navController = navController)
                }
                composable("professional_screen") {
                    // Pantalla 4: Panel del Profesional (Professional dashboard)
                    ProfessionalDashboardScreen(navController = navController)
                }
                // Nota: El "Voice assistant modal" (Pantalla 5) no requiere ruta,
                // será un componente superpuesto dentro de ProfessionalDashboardScreen.
            }
        }
    }
}

// ============================================================================
// VISTAS PREVIAS (PREVIEWS) DE TODAS LAS PANTALLAS EN MAIN ACTIVITY
// ============================================================================

@Preview(name = "1. App Completa / Login", showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainApp() {
    MainApp()
}

@Preview(name = "2. Pantalla Principal (Client Home)", showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    RouteBarberTheme {
        HomeScreen(navController = rememberNavController())
    }
}

@Preview(name = "3. Mis Citas", showBackground = true, showSystemUi = true)
@Composable
fun PreviewMisCitasScreen() {
    RouteBarberTheme {
        MisCitasScreen(navController = rememberNavController())
    }
}

@Preview(name = "4. Perfil del Cliente", showBackground = true, showSystemUi = true)
@Composable
fun PreviewPerfilClienteScreen() {
    RouteBarberTheme {
        PerfilClienteScreen(navController = rememberNavController())
    }
}

@Preview(name = "5. Detalle del Barbero", showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetalleBarberoScreen() {
    RouteBarberTheme {
        DetalleBarberoScreen(navController = rememberNavController(), barberoId = 1)
    }
}

// --- PREVIEWS DE LAS NUEVAS PANTALLAS ---

@Preview(name = "6. Reserva de Cita (Booking)", showBackground = true, showSystemUi = true)
@Composable
fun PreviewServiceBookingScreen() {
    RouteBarberTheme {
        ServiceBookingScreen(navController = rememberNavController())
    }
}

@Preview(name = "7. Seguimiento en Vivo (Tracking)", showBackground = true, showSystemUi = true)
@Composable
fun PreviewClientLiveTrackingScreen() {
    RouteBarberTheme {
        ClientLiveTrackingScreen(navController = rememberNavController())
    }
}

@Preview(name = "8. Panel Profesional", showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfessionalDashboardScreen() {
    RouteBarberTheme {
        ProfessionalDashboardScreen(navController = rememberNavController())
    }
}