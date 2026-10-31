package com.example.route_barber.ui.components.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

// Modelo de datos para las pestañas de RouteBarber
data class RouteBarberTab(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@Composable
fun RouteBarberBottomBar(navController: NavController) {
    // Pestañas optimizadas para una app de barbería a domicilio / rutas
    val tabs = listOf(
        RouteBarberTab(
            title = "Inicio",
            route = "home_screen",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        RouteBarberTab(
            title = "Citas",
            route = "mis_citas_screen",
            selectedIcon = Icons.Filled.CalendarMonth,
            unselectedIcon = Icons.Outlined.CalendarMonth
        ),
        RouteBarberTab(
            title = "Rutas",
            route = "tracking_screen",
            selectedIcon = Icons.Filled.Map,
            unselectedIcon = Icons.Outlined.Map
        ),
        RouteBarberTab(
            title = "Perfil",
            route = "perfil_cliente_screen",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person
        )
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        tabs.forEach { tab ->
            val isSelected = currentRoute == tab.route
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (currentRoute != tab.route) {
                        navController.navigate(tab.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                label = { Text(text = tab.title) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) tab.selectedIcon else tab.unselectedIcon,
                        contentDescription = tab.title
                    )
                }
            )
        }
    }
}

// ==========================================
// VISTA PREVIA PARA ANDROID STUDIO
// ==========================================
@Preview(showBackground = true)
@Composable
fun RouteBarberBottomBarPreview() {
    Surface {
        RouteBarberBottomBar(navController = rememberNavController())
    }
}