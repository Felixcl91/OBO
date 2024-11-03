package com.obo.opo.bomberos.presentation.screens.temary.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.presentation.components.ProgressBar
import com.obo.opo.bomberos.presentation.screens.temary.list.TemaryViewModel

@Composable
fun GetTemaries(
    paddingValues: PaddingValues,
    vm: TemaryViewModel = hiltViewModel(),
    navHostController: NavHostController) {

    when(val response = vm.temariesResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            TemaryListContent(temaries = response.data, paddingValues, navHostController)
            Log.d("GetTemaries", "DATA: ${response.data}")
        }

        is Resource.Failure -> {
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