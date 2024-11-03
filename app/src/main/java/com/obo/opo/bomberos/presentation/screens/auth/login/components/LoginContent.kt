package com.obo.opo.bomberos.presentation.screens.auth.login.components


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.obo.opo.bomberos.R
import com.obo.opo.bomberos.presentation.components.DefaultButton
import com.obo.opo.bomberos.presentation.components.DefaultTextField
import com.obo.opo.bomberos.presentation.navigation.screen.AuthScreen
import com.obo.opo.bomberos.presentation.screens.auth.login.LoginViewModel
import com.obo.opo.bomberos.presentation.ui.theme.BlackTop
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain
import com.obo.opo.bomberos.presentation.ui.theme.GreenTop
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun LoginContent(navController: NavHostController,paddingValues: PaddingValues, vm: LoginViewModel = hiltViewModel()) {

    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage != "") {
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
            vm.errorMessage = ""
        }
    }

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.picture_login),
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.5f, 0.5f, 0.5f, 1f ) })
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                painter = painterResource(R.drawable.logo_letras_blancas),
                contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                    //.background(Color.White.copy(alpha = 0.5f))
                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp
                ),
                colors = CardDefaults.cardColors(
                    //containerColor = Color.DarkGray.copy(alpha = 0.7f) //Card background color
                    //contentColor = Color.White,  //Card content color,e.g.text
                    containerColor = BlackTop.copy(alpha = 0.7f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, end = 30.dp, start = 30.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        text = "INGRESAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = {
                            vm.onEmailInput(it)
                        },
                        label = "Email",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = {
                            vm.onPasswordInput(it)
                        },
                        label = "Password",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "Iniciar sesión",
                        onclick = {
                            vm.login()
                                  },
                        color = BlueClain
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp, bottom = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "No tienes cuenta",
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            modifier = Modifier
                                .clickable { navController.navigate(route = AuthScreen.Register.route) },
                            text = "Registrate",
                            color = GreenTop
                        )
                    }
                }
            }
        }
    }
}