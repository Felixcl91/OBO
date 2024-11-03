package com.obo.opo.bomberos.presentation.screens.temary.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.domain.model.Temary
import com.obo.opo.bomberos.presentation.navigation.screen.AuthScreen
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain

@Composable
fun TemaryListContent(
    temaries: List<Temary>,
    paddingValues: PaddingValues,
    navController: NavHostController
) {

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()
        .background(Color.White)
        //.clickable { navController.navigate(route = AuthScreen.Blocks.route) }
        //.clickable { navController.navigate(route = AuthScreen.FindByTemary.passTemary(temary.toJson())) }
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            text = "TEMARIOS",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = BlueClain,
            textAlign = TextAlign.Center
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            items(
                items = temaries
            ) {
                TemariesListItem(
                    navController,
                    temary = it
                )
            }

        }
    }


}