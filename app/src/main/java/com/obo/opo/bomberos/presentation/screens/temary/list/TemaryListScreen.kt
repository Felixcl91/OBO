package com.obo.opo.bomberos.presentation.screens.temary.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.obo.opo.bomberos.presentation.components.DefaultTopBar
import com.obo.opo.bomberos.presentation.screens.temary.list.components.GetTemaries
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme

@Composable
fun TemaryListScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Lista de temarios",
                true,
                navController = navHostController
            )
        },
    ) { paddingValues ->
        GetTemaries(
            paddingValues,
            navHostController = navHostController
        )
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TemaryListPreview() {
    OBOTheme {
        TemaryListScreen(rememberNavController())
    }
}