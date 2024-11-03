package com.obo.opo.bomberos.presentation.screens.auth.register

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.obo.opo.bomberos.presentation.components.DefaultTopBar
import com.obo.opo.bomberos.presentation.screens.auth.register.components.Register
import com.obo.opo.bomberos.presentation.screens.auth.register.components.RegisterContent
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Registro",
                true,
                navController = navController
            )
        },

    ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
    Register(navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    OBOTheme {
        RegisterScreen(rememberNavController())
    }
}