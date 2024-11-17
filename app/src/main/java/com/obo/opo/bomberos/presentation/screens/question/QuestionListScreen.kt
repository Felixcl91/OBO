package com.obo.opo.bomberos.presentation.screens.question

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.obo.opo.bomberos.presentation.components.DefaultTopBar
import com.obo.opo.bomberos.presentation.screens.question.components.GetQuestions
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme

@Composable
fun QuestionListScreen(
    navController: NavHostController,
    theme: String
) {

    Log.d("QuestionListScreen", "DATA OF THEME: $theme")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Lista de preguntas",
                true,
                navController = navController
            )
        },
    ) { paddingValues ->
        Text(
            modifier = Modifier.padding(paddingValues = paddingValues),
            text = "QUESTION_LIST_SCREEN"
        )

        GetQuestions(
            paddingValues,
            navController = navController
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuestionListScreenPreview() {
    OBOTheme {
        QuestionListScreen(rememberNavController(), theme = "")
    }
}