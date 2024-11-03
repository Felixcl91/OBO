package com.obo.opo.bomberos.presentation.screens.question.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.domain.model.Question
import com.obo.opo.bomberos.presentation.components.DefaultButton
import com.obo.opo.bomberos.presentation.screens.question.QuestionViewModel
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme

@Composable
fun QuestionListContent(
    question: Question?,
    paddingValues: PaddingValues,
    navController: NavHostController,
    vm: QuestionViewModel
) {

    Box(modifier = Modifier
        //.padding(paddingValues = paddingValues)
        .fillMaxSize()
        .background(Color.White)
        .padding(bottom = 20.dp)
    ) {

        GetPositionQuestion(
            question!!.question,
            question!!.answer,
            paddingValues,
            navController
        )

        DefaultButton(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter),
            text = "Siguiente pregunta",
            onclick = { vm.nextQuestion() },
            color = BlueClain,

        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuestionListContentPreview() {
    OBOTheme {
        //QuestionListContent(rememberNavController())
    }
}

