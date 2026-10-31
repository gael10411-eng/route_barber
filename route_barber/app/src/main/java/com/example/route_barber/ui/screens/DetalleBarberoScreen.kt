package com.routebarber.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.routebarber.model.DatosDemo
import com.routebarber.ui.components.barberos.CardEspecialidad
import com.routebarber.ui.components.barberos.CardPerfilBarbero
import com.routebarber.ui.components.common.BotonRegresar
import com.routebarber.ui.components.common.FondoApp
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun DetalleBarberoScreen(navController: NavController, barberoId: Int) {
    // Buscamos el barbero en los datos de demostración
    val barbero = DatosDemo.barberos.find { it.id == barberoId } ?: DatosDemo.barberos.first()

    FondoApp {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            BotonRegresar(onClick = { navController.popBackStack() })

            Spacer(modifier = Modifier.height(16.dp))

            CardPerfilBarbero(barbero = barbero)

            Spacer(modifier = Modifier.height(16.dp))

            CardEspecialidad(especialidad = barbero.especialidad)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetalleBarberoScreenPreview() {
    RouteBarberTheme {
        DetalleBarberoScreen(navController = rememberNavController(), barberoId = 1)
    }
}