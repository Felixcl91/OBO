package com.obo.opo.bomberos.presentation.screens.question.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.obo.opo.bomberos.R
import com.obo.opo.bomberos.presentation.components.DialogQuestions
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain
import com.obo.opo.bomberos.presentation.ui.theme.GreenTop
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetPositionQuestion(
    question: String, answer: String, relevance: String,
    hasNewResponse: Boolean, positionQuestions: Int, countQuestions: Int,
    //paddingValues: PaddingValues,
    navHostController: NavHostController
) {

    var showDialog by remember { mutableStateOf(false) }

    var showIconAndText by remember { mutableStateOf(true) }

    Log.d("GetPositionQuestion", "PREGUNTA: $question")

    Log.d("GetPositionQuestion", "ANSWER NEW: $hasNewResponse")

    Column(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, // Alineación vertical del contenido en el centro
            horizontalArrangement = Arrangement.Start, // Distribución horizontal
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 30.dp, top = 70.dp),
                text = "Pregunta",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = BlueClain,
                textAlign = TextAlign.Start
            )
            Text(
                modifier = Modifier
                    .padding(start = 30.dp, top = 70.dp),
                text = "${positionQuestions}/${countQuestions
                }",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = BlueClain
            )
        }
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
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
                text = question,
                fontWeight = FontWeight.Normal,
                fontSize = 19.sp,
                color = Color.White,
                textAlign = TextAlign.Start,
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically, // Alineación vertical del contenido en el centro
            horizontalArrangement = Arrangement.Start, // Distribución horizontal
            modifier = Modifier.fillMaxWidth()
        ) {
            /*TITULO RESPUESTA*/
            Text(
                modifier = Modifier
                    .padding(start = 30.dp, end = 20.dp),
                text = "Respuesta",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = BlueClain,
                textAlign = TextAlign.Start
            )
            /*BUTTON RELEVANCE*/
            IconButton(
                onClick = {showDialog = true}, // Acción que se ejecuta al hacer clic en el botón
                // Si relevance no esta vacio se muestra el icon
                modifier = if (!relevance.isNullOrBlank()) Modifier.size(24.dp) else Modifier.size(0.dp)
            ) {
                // Mostrar el AlertDialog solo si showDialog es true
                if (showDialog) {
                    DialogQuestions(
                        message = relevance,
                        confirmButtonText = "Confirmar",
                        onDismiss = { showDialog = false } // Cierra el diálogo
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.add), // Carga el drawable como recurso
                    contentDescription = null, // Descripción accesible (agrega una descripción si es necesario)
                    modifier = Modifier
                        .size(24.dp),
                    tint = GreenTop

                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        /*TARJETA DE RESPUESTA*/
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(10.dp),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(containerColor = GreenTop),
        ) {
            if (hasNewResponse) {
                showIconAndText = true
            }
            if (showIconAndText) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(top = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text( /******ANSWER*******/
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        text = "Toca para ver la respuesta",
                        fontWeight = FontWeight.Normal,
                        fontSize = 19.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    IconButton(
                        onClick = {
                            showIconAndText = false // Cambia el estado para ocultar el ícono y texto iniciales
                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.tap), // Carga el drawable como recurso
                            contentDescription = null, // Descripción accesible (agrega una descripción si es necesario)
                            modifier = Modifier
                                .size(30.dp),
                            tint = Color.White // TINTAMOS EL ICON BUTTON
                        ) }
                }
            } else {
                Text( /******ANSWER*******/
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),
                text = answer,
                fontWeight = FontWeight.Normal,
                fontSize = 19.sp,
                color = Color.White,
                textAlign = TextAlign.Start
            ) }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GetPositionQuestionPreview() {
    OBOTheme {
        GetPositionQuestion("", "", "",false,0,0,
            rememberNavController())
    }
}