package com.obo.opo.bomberos.presentation.screens.auth.login.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.presentation.components.ProgressBar
import com.obo.opo.bomberos.presentation.navigation.screen.AuthScreen
import com.obo.opo.bomberos.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(navHostController: NavHostController, vm: LoginViewModel = hiltViewModel()) {

    when(val response = vm.loginResponse) {
        Resource.Loading -> { ProgressBar() }
        is Resource.Success -> {

            Log.d("Login", "MOSTRANDO DATA DE USUARIO ${response.data}")
            LaunchedEffect(Unit) {
                /*GUARDAMOS LA SESION*/
                vm.saveSession(response.data)
                //navHostController.navigate(route = AuthScreen.Home.route)
                navHostController.navigate(route = AuthScreen.Temaries.route) {
                 // Eliminamos pantalla login a la hora de logearnos
                    popUpTo(AuthScreen.Login.route) { inclusive = true }
                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message ?: "Error desconocido", Toast.LENGTH_SHORT).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }

}