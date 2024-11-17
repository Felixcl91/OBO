package com.obo.opo.bomberos.presentation.screens.splash.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.R
import com.obo.opo.bomberos.presentation.navigation.screen.AuthScreen
import com.obo.opo.bomberos.presentation.screens.splash.SplashViewModel
import com.obo.opo.bomberos.presentation.ui.theme.GreenTop

@Composable
fun SplashContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    vm: SplashViewModel = hiltViewModel()
) {

    val isSplashCompleted by vm.isSplashCompleted.observeAsState(false)
    val navigateTo by vm.navigateTo.observeAsState()

    // Observa el estado del splash
    LaunchedEffect(isSplashCompleted) {
        when (navigateTo) {
            AuthScreen.Temaries.route -> {
                if (isSplashCompleted) {
                    navController.navigate(AuthScreen.Temaries.route) {
                        popUpTo(AuthScreen.Splash.route) { inclusive = true }
                    }
                }
            }
            AuthScreen.Login.route -> {
                if (isSplashCompleted) {
                    navController.navigate(AuthScreen.Login.route) {
                        popUpTo(AuthScreen.Splash.route) { inclusive = true }
                    }
                }
            }
        }
    }

    // Aquí defines tu diseño de Splash (puede ser una imagen, logo, etc.)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            //.padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                painter = painterResource(R.drawable.logo_letras_blancas),
                contentDescription = "Logo"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 20.dp),
                text = "Bienvenido a OBO",
                fontSize = 24.sp,
                color = GreenTop
            )
        }

    }
}