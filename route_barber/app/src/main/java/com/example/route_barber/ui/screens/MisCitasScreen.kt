package com.routebarber.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.routebarber.model.DatosDemo
import com.routebarber.ui.components.common.BotonRegresar
import com.routebarber.ui.components.common.Encabezado
import com.routebarber.ui.components.common.FondoApp
import com.routebarber.ui.components.citas.TarjetaCita
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun MisCitasScreen(navController: NavController) {
    val citas = DatosDemo.citas

    FondoApp {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                BotonRegresar(onClick = { navController.popBackStack() })
                Spacer(modifier = Modifier.width(12.dp))
                Encabezado(titulo = "Mis Citas")
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                items(citas) { cita ->
                    TarjetaCita(
                        cita = cita,
                        onClickDetalle = {
                            // Navegar al detalle de la cita si se desea expandir
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MisCitasScreenPreview() {
    RouteBarberTheme {
        MisCitasScreen(navController = rememberNavController())
    }
}