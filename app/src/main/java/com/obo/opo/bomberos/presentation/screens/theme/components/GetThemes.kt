package com.obo.opo.bomberos.presentation.screens.theme.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.presentation.components.ProgressBar
import com.obo.opo.bomberos.presentation.screens.block.components.BlocksListContent
import com.obo.opo.bomberos.presentation.screens.theme.ThemeViewModel

@Composable
fun GetThemes(
    paddingValues: PaddingValues,
    vm: ThemeViewModel = hiltViewModel(),
    navHostController: NavHostController) {

    when(val response = vm.themesResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            ThemesListContent(themes = response.data, paddingValues, navHostController)
            Log.d("ThemesListContent", "DATA: ${response.data}")
        }

        is Resource.Failure -> {
            Log.d("ThemesListContent", "FALLOOOOO: ${response.message}")
            Toast.makeText(
                LocalContext.current,
                response.message ?: "Error desconocido",
                Toast.LENGTH_SHORT
            ).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(
                    LocalContext.current,
                    "Hubo un error desconocido",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}