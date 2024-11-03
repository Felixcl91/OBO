package com.obo.opo.bomberos.presentation.screens.question.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain
import com.obo.opo.bomberos.presentation.ui.theme.GreenTop
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme

@Composable
fun GetPositionQuestion(
    question: String, answer: String,
    paddingValues: PaddingValues,
    navHostController: NavHostController
) {

    Log.d("GetPositionQuestion", "PREGUNTA: $question")

    Column(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 70.dp),
            text = "Pregunta",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = BlueClain,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(10.dp),
            //.background(Color.White.copy(alpha = 0.5f))
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                //containerColor = Color.DarkGray.copy(alpha = 0.7f) //Card background color
                //contentColor = Color.White,  //Card content color,e.g.text
                containerColor = GreenTop
            ),
        ) {
            Text( /******QUESTION*******/
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                text = question,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = Color.White,
                textAlign = TextAlign.Start
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp),
            text = "Respuesta",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = BlueClain,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp),
            //.background(Color.White.copy(alpha = 0.5f))
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(
                //containerColor = Color.DarkGray.copy(alpha = 0.7f) //Card background color
                //contentColor = Color.White,  //Card content color,e.g.text
                containerColor = GreenTop
            ),
        ) {
            Text( /******QUESTION*******/
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                text = answer,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = Color.White,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GetPositionQuestionPreview() {
    OBOTheme {
        //GetPositionQuestion(rememberNavController())
    }
}