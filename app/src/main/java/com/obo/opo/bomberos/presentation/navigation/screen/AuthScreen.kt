package com.obo.opo.bomberos.presentation.navigation.screen

import com.obo.opo.bomberos.domain.model.Block


sealed class AuthScreen(val route: String) {

    object Splash: AuthScreen("splash")
    object Login: AuthScreen("login")
    object Register: AuthScreen("register")
    object Home: AuthScreen("home")
    object Temaries: AuthScreen("temaries")

    object Blocks: AuthScreen("blocks")
    // BUSQUEDA DE BLOQUE POR TEMARIO
    object FindByTemary: AuthScreen("blocks/temary/{temary}") {
        fun passTemary(temary: String) = "blocks/temary/$temary"
    }
    object Themes: AuthScreen("themes")
    // BUSQUEDA DE TEMA POR BLOQUE
    object FindByBlock: AuthScreen("themes/block/{block}") {
        fun passBlock(block: String) = "themes/block/$block"
    }

    object Questions: AuthScreen("questions")
    // BUSQUEDA DE PREGUNTA POR TEMA
    object FindByTheme: AuthScreen("questions/theme/{theme}") {
        fun passTheme(theme: String) = "questions/theme/$theme"
    }
}