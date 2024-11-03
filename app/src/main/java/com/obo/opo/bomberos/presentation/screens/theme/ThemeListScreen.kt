package com.obo.opo.bomberos.presentation.screens.theme

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.presentation.components.DefaultTopBar
import com.obo.opo.bomberos.presentation.screens.block.components.GetBlocks
import com.obo.opo.bomberos.presentation.screens.theme.components.GetThemes
import com.obo.opo.bomberos.presentation.screens.theme.components.ThemesListContent

@Composable
fun ThemeListScreen(
    navHostController: NavHostController,
    block: String
) {
    Log.d("ThemeListScreen", "Bloque DE ThemeListScreen: ${block}")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Lista de temas",
                true,
                navController = navHostController
            )
        },
    ) { paddingValues ->
        GetThemes(
            paddingValues,
            navHostController = navHostController
        )
    }
}