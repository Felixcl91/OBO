package com.obo.opo.bomberos.presentation.screens.temary.list.components


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.R
import com.obo.opo.bomberos.domain.model.Temary
import com.obo.opo.bomberos.presentation.navigation.screen.AuthScreen
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain
import com.obo.opo.bomberos.presentation.ui.theme.GreenTop
import com.obo.opo.bomberos.presentation.ui.theme.GreyAppBarLight

@Composable
fun TemariesListItem(
    navController: NavHostController,
    temary: Temary) {

    val context = LocalContext.current

    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(50.dp)
            .fillMaxSize()
            .background(Color.White)
            .clickable {
                Log.d("TemariesListItem", "ITEM SELECCIONADO: ${temary.toJson()}")
                navController.navigate(route = AuthScreen.FindByTemary.passTemary(temary.toJson()))}
    ) {

        Row {
            /*Image(
                modifier = Modifier.height(50.dp).width(50.dp),
                imageVector = Icons.Default.List,
                contentDescription = "Image User"
            )
            Spacer(Modifier.width(10.dp))*/
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = temary.name,
                    color = BlueClain,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = temary.description,
                    color = GreyAppBarLight,
                    fontSize = 12.sp
                )
            }
            Spacer(Modifier.width(15.dp))
            Column(
                Modifier
                    //.padding(top = 15.dp)
                    .align(Alignment.CenterVertically),
                //verticalArrangement = Arrangement.Center,
            ) {
                Icon(
                    modifier = Modifier.height(20.dp).width(20.dp),
                    painter = painterResource(id = R.drawable.right_black),
                    contentDescription = ""

                )
                /*Image(
                    modifier = Modifier.height(20.dp).width(20.dp),
                    painter = painterResource(id = R.drawable.right_black),
                    contentDescription = ""
                )*/
            }
            /*Spacer(Modifier.width(15.dp))
            Column(
                Modifier
                    //.padding(top = 15.dp)
                    .align(Alignment.CenterVertically),
                //verticalArrangement = Arrangement.Center,
            ) {
                Icon(
                    modifier = Modifier.height(20.dp).width(20.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = ""
                )
            }*/
        }
    }
    //Spacer(Modifier.height(5.dp))
    Divider(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp),
        color = GreenTop,
        thickness = 2.dp
        //startIndent = 30.dp
    )


}