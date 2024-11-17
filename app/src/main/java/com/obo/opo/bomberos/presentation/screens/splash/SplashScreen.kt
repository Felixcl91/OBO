package com.obo.opo.bomberos.presentation.screens.splash

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.obo.opo.bomberos.presentation.screens.splash.components.SplashContent
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    Log.d("MAINACT", "Estoy en Splash")
    Scaffold() {
            paddingValues ->
        SplashContent(navController, paddingValues)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    OBOTheme {
        SplashScreen(navController = rememberNavController())
    }
}
