package com.obo.opo.bomberos.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.obo.opo.bomberos.presentation.navigation.graph.RootNavGraph
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme
import dagger.hilt.android.AndroidEntryPoint

//PUNTO DE ENTRADA
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    //private var navController: NavHostController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OBOTheme {
                navController = rememberNavController()
                RootNavGraph(navController = navController)
                //LoginScreen()
            }
        }
    }
}


