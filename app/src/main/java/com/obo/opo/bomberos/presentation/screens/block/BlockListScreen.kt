package com.obo.opo.bomberos.presentation.screens.block

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.presentation.components.DefaultTopBar
import com.obo.opo.bomberos.presentation.screens.block.components.GetBlocks

@Composable
fun BlockListScreen(
    navHostController: NavHostController,
    temary: String
) {

    Log.d("BlockListScreen", "TEMARIO DE BlockListScreen: ${temary}")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Lista de bloques",
                true,
                navController = navHostController
            )
        },
    ) { paddingValues ->
        GetBlocks(
            paddingValues,
            navHostController = navHostController
        )
    }


}