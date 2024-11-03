package com.obo.opo.bomberos.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.presentation.components.ProgressBar
import com.obo.opo.bomberos.presentation.navigation.screen.AuthScreen
import com.obo.opo.bomberos.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navHostController: NavHostController, vm: RegisterViewModel= hiltViewModel()) {

    when(val response = vm.registerResponse) {
        Resource.Loading -> { ProgressBar() }
        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                navHostController.navigate(route = AuthScreen.Home.route) {
                    // Eliminamos pantalla login a la hora de logearnos
                    popUpTo(AuthScreen.Register.route) { inclusive = true }
                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}