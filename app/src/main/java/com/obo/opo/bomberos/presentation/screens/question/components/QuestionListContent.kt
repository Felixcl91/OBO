package com.obo.opo.bomberos.presentation.screens.question.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.core.text.HtmlCompat
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.domain.model.Question
import com.obo.opo.bomberos.presentation.components.DefaultButton
import com.obo.opo.bomberos.presentation.navigation.screen.AuthScreen
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

    val isLastQuestion by vm.isLastQuestion.observeAsState(false)

    var hasNewResponse by remember { mutableStateOf(false) }

    //var currentIndex = vm
    Log.d("GetPositionQuestion", "CURRENT_INDEX: ${vm.currentIndex}")

    Box(modifier = Modifier
        //.padding(paddingValues = paddingValues)
        .fillMaxSize()
        .background(Color.White)
        .padding(bottom = 20.dp)
    ) {

        GetPositionQuestion(
            question = HtmlCompat.fromHtml(question!!.question, HtmlCompat.FROM_HTML_MODE_LEGACY).toString(),
            answer = HtmlCompat.fromHtml(question.answer, HtmlCompat.FROM_HTML_MODE_LEGACY).toString(),
            relevance = HtmlCompat.fromHtml(question.relevance!!, HtmlCompat.FROM_HTML_MODE_LEGACY).toString(),
            //question!!.question,
            //question!!.answer,
            //paddingValues,
            hasNewResponse, vm.currentIndex +1, vm.countQuestions(),
            navController
        )

        if (isLastQuestion) {
            hasNewResponse = false
            //Toast.makeText(LocalContext.current, "Estás en la última pregunta", Toast.LENGTH_SHORT).show()
            DefaultButton(
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomCenter),
                text = "Finalizar",
                onclick = {
                    // go to themes
                    navController.popBackStack()
                },
                color = BlueClain,

                )
        } else {
            hasNewResponse = false
            DefaultButton(
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
                    .align(alignment = Alignment.BottomCenter),
                text = "Siguiente pregunta",
                onclick = {
                    vm.nextQuestion()
                    if (!hasNewResponse) {
                        hasNewResponse = true
                    }
                    Log.d("QUESTIONLISTCONTENT", "Answer new: $hasNewResponse")
                },
                color = BlueClain,

                )
        }


    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuestionListContentPreview() {
    OBOTheme {
        //QuestionListContent(rememberNavController())
    }
}

