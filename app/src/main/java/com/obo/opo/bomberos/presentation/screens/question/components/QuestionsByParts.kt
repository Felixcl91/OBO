package com.obo.opo.bomberos.presentation.screens.question.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.domain.model.Question
import com.obo.opo.bomberos.presentation.screens.question.QuestionViewModel
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain
import com.obo.opo.bomberos.presentation.ui.theme.GreenTop

@Composable
fun QuestionsByParts(
    currentPart: Int,
    onPartSelected: (Int) -> Unit
) {

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
            onClick = { onPartSelected(1) }) {
            Text(
                color = Color.White,
                text = "Parte 1")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            //modifier = Modifier.height(200.dp).width(250.dp),
            colors = ButtonDefaults.buttonColors(GreenTop),
            onClick = { onPartSelected(2) }) {
            Text(
                color = Color.White,
                text = "Parte 2")
        }
    }


}