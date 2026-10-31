package com.routebarber.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.routebarber.ui.components.common.FondoApp
import com.routebarber.ui.components.login.BnLogin
import com.routebarber.ui.components.login.EncabezadoLogin
import com.routebarber.ui.components.login.FormularioLogin
import com.routebarber.ui.theme.RouteBarberTheme

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    FondoApp {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EncabezadoLogin()

            FormularioLogin(
                email = email,
                onEmailChange = { email = it },
                contrasena = password,
                onContrasenaChange = { password = it }
            )

            Spacer(modifier = Modifier.height(32.dp))

            BnLogin(
                onClick = {
                    navController.navigate("home_screen")
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    RouteBarberTheme {
        LoginScreen(navController = rememberNavController())
    }
}