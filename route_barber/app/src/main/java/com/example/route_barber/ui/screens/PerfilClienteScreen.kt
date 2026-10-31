package com.routebarber.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.routebarber.ui.components.common.BotonRegresar
import com.routebarber.ui.components.common.Encabezado
import com.routebarber.ui.components.common.FilaInfoConCuadro
import com.routebarber.ui.components.common.FondoApp
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun PerfilClienteScreen(navController: NavController) {
    FondoApp {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                BotonRegresar(onClick = { navController.popBackStack() })
                Spacer(modifier = Modifier.width(12.dp))
                Encabezado(titulo = "Mi Perfil")
            }

            Spacer(modifier = Modifier.height(24.dp))

            FilaInfoConCuadro(etiqueta = "Nombre", valor = "Oscar Uriel Rojas Meléndez")
            Spacer(modifier = Modifier.height(12.dp))
            FilaInfoConCuadro(etiqueta = "Correo", valor = "oscar.rojas@routebarber.com")
            Spacer(modifier = Modifier.height(12.dp))
            FilaInfoConCuadro(etiqueta = "Teléfono", valor = "5527927874")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilClienteScreenPreview() {
    RouteBarberTheme {
        PerfilClienteScreen(navController = rememberNavController())
    }
}