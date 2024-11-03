package com.obo.opo.bomberos.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.obo.opo.bomberos.presentation.navigation.Graph
import com.obo.opo.bomberos.presentation.navigation.screen.AuthScreen
import com.obo.opo.bomberos.presentation.screens.auth.login.LoginScreen
import com.obo.opo.bomberos.presentation.screens.auth.register.RegisterScreen
import com.obo.opo.bomberos.presentation.screens.home.HomeScreen
import com.obo.opo.bomberos.presentation.screens.temary.list.TemaryListScreen
import com.obo.opo.bomberos.presentation.screens.block.BlockListScreen
import com.obo.opo.bomberos.presentation.screens.block.components.BlocksListContent
import com.obo.opo.bomberos.presentation.screens.question.QuestionListScreen
import com.obo.opo.bomberos.presentation.screens.theme.ThemeListScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navController)
        }
        composable(route = AuthScreen.Home.route) {
            HomeScreen(navController)
        }
        // GET TEMARIES
        composable(route = AuthScreen.Temaries.route) {
            TemaryListScreen(navController)
        }
        // GET BLOCKS
        composable(route = AuthScreen.Blocks.route) {
            //BlockListScreen(navController)
        }
        composable(
            route = AuthScreen.FindByTemary.route,
            arguments = listOf(navArgument("temary") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("temary")?.let {
                BlockListScreen(navController, it)
            }
        }
        // GET THEMES
        composable(route = AuthScreen.Themes.route) {
            //ThemeListScreen(navController)
        }
        composable(
            route = AuthScreen.FindByBlock.route,
            arguments = listOf(navArgument("block") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("block")?.let {
                ThemeListScreen(navController, it)
            }
        }
        // GET QUESTIONS
        composable(route = AuthScreen.Questions.route) {
            //QuestionListScreen(navController)
        }
        composable(
            route = AuthScreen.FindByTheme.route,
            arguments = listOf(navArgument("theme") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("theme")?.let {
                QuestionListScreen(navController, it)
            }
        }


    }
}