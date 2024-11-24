package com.obo.opo.bomberos.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.unit.dp
import com.obo.opo.bomberos.R
import com.obo.opo.bomberos.presentation.components.TextDefault.provider
import com.obo.opo.bomberos.presentation.ui.theme.GreenTop
import com.obo.opo.bomberos.presentation.ui.theme.GreyAppBarLight
import com.obo.opo.bomberos.presentation.ui.theme.PurpleGrey40
import com.obo.opo.bomberos.presentation.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarQuestions(
    title: String,
    upAvailable: Boolean = false,
    onBackQuestion: (() -> Unit)? = null, // Callback opcional
    showBackButton: Boolean = true,
    navController: NavHostController? = null
){
    val fontName = GoogleFont("Comic Sans")

    val fontFamily = FontFamily(
        Font(googleFont = fontName, fontProvider = provider)
    )

    TopAppBar(
        title = {
            Text(
                color = Color.White,
                //text = "OBO",
                fontSize = 19.sp,
                fontFamily = fontFamily, text = "OBO"
                //fontStyle = FontStyle.Normal
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(GreenTop),
        navigationIcon = {
            if (upAvailable) {
                if (showBackButton) {
                    IconButton(onClick = {
                        // question back
                        onBackQuestion?.invoke() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                } else null
            }
        }
    )
}