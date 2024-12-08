package com.obo.opo.bomberos.presentation.screens.question.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.presentation.components.ProgressBar
import com.obo.opo.bomberos.presentation.screens.question.QuestionViewModel

@Composable
fun GetQuestions(
    paddingValues: PaddingValues,
    vm: QuestionViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val context = LocalContext.current

        when(val response = vm.questionsResponse) {

        Resource.Loading -> {
            ProgressBar()
            Log.d("GetQuestions", "ESTOY EN PROGRESS")
        }

        is Resource.Success -> {
            //QuestionListContent(questions = response.data, paddingValues, navHostController)
            QuestionListContent(question = vm.currentQuestion(), paddingValues, navController, vm = vm)
            Log.d("GetQuestions", "DATA: ${response.data}")
        }

        is Resource.Failure -> {
            //navController.popBackStack()
            Log.d("GetQuestions", "FALLOOOOO: ${response.message}")
            Toast.makeText(
                context,
                (vm.questionsResponse as Resource.Failure).message,
                Toast.LENGTH_SHORT
            ).show()
        } else -> {
            if (response != null) {
                Toast.makeText(
                    context,
                    "Hubo un error desconocido",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}