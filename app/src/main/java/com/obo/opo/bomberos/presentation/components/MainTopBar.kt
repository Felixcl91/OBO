package com.obo.opo.bomberos.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.text.googlefonts.Font
import com.obo.opo.bomberos.R
import com.obo.opo.bomberos.presentation.components.TextDefault.provider
import com.obo.opo.bomberos.presentation.ui.theme.GreenTop
import com.obo.opo.bomberos.presentation.ui.theme.GreyAppBarLight
import com.obo.opo.bomberos.presentation.ui.theme.PurpleGrey40
import com.obo.opo.bomberos.presentation.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    title: String,
    upAvailable: Boolean = false,
    navController: NavHostController? = null
){
    val fontName = GoogleFont("Josefin Sans")
    //val fontName = GoogleFont("Comic Neue")
    //val fontName = GoogleFont("Lobster Two")

    val fontFamily = FontFamily(
        Font(googleFont = fontName, fontProvider = provider, style = FontStyle.Italic)
    )

    TopAppBar(
        title = {
            Text(
                color = Color.White,
                text = "OBO",
                fontSize = 22.sp,
                //fontFamily = fontFamily, text = "OBO"
                fontStyle = FontStyle.Normal
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(GreenTop)
    )
}