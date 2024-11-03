package com.obo.opo.bomberos.presentation.screens.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.obo.opo.bomberos.presentation.screens.auth.login.components.Login
import com.obo.opo.bomberos.presentation.screens.auth.login.components.LoginContent
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme

@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold() {
            paddingValues ->
        LoginContent(navController = navController, paddingValues)
    }
    Login(navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    OBOTheme {
        LoginScreen(rememberNavController())
    }
}