package com.obo.opo.bomberos.presentation.screens.question

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.obo.opo.bomberos.domain.util.Resource
import com.obo.opo.bomberos.presentation.components.DefaultTopBar
import com.obo.opo.bomberos.presentation.components.ProgressBar
import com.obo.opo.bomberos.presentation.components.TopBarQuestions
import com.obo.opo.bomberos.presentation.screens.question.components.GetQuestions
import com.obo.opo.bomberos.presentation.screens.question.components.QuestionListContent
import com.obo.opo.bomberos.presentation.screens.question.components.QuestionsByParts
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain
import com.obo.opo.bomberos.presentation.ui.theme.GreenTop
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme

@Composable
fun QuestionListScreen(
    navController: NavHostController,
    theme: String,
    vm: QuestionViewModel = hiltViewModel(),
) {

    val showParts by vm.showParts

    var showPartSelection by remember { mutableStateOf(false) }

    /*if (showParts) {
        showPartSelection = true
    }*/

    Log.d("QuestionListScreen", "DATA OF THEME: $theme")

    Scaffold(
        topBar = {
            TopBarQuestions(
                title = "Lista de preguntas",
                true,
                { vm.onBackQuestion() },
                showBackButton = vm.currentIndex > 0,
                navController = navController
            )
        },
    ) { paddingValues ->


        if (showPartSelection) {
            /**QuestionsByParts(
                currentPart = currentPart,
                onPartSelected = { part ->
                    //if (part > 1) {
                        vm.showPart(part)
                        showPartSelection = false
                   // }
                }
            )*/
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(20.dp),
                    text = "Elige una parte",
                    color = BlueClain
                )
                Button(
                    //modifier = Modifier.height(200.dp).width(250.dp),
                    colors = ButtonDefaults.buttonColors(GreenTop),
                    onClick = {
                        vm.showPart(1)
                    }) {
                    Text(
                        color = Color.White,
                        text = "Parte 1")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    //modifier = Modifier.height(200.dp).width(250.dp),
                    colors = ButtonDefaults.buttonColors(GreenTop),
                    onClick = { vm.showPart(2) }) {
                    Text(
                        color = Color.White,
                        text = "Parte 2")
                }
            }
        } else {
            //QuestionsScreen(questions = currentQuestions)
            Log.d("QuestionListScreen", "GETQUESTIONS")
            GetQuestions(
                paddingValues,
                navController = navController)
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuestionListScreenPreview() {
    OBOTheme {
        QuestionListScreen(rememberNavController(), theme = "")
    }
}