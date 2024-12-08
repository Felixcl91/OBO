package com.obo.opo.bomberos.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain
import com.obo.opo.bomberos.presentation.ui.theme.GreenTop


@Composable
fun DialogQuestions(
    message: String,
    confirmButtonText: String = "OK",
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "Información relevante",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = BlueClain,
                textAlign = TextAlign.Start
            )
        },
        text = {
            Text(modifier = Modifier.verticalScroll(rememberScrollState()),
                text = message,
                fontSize = 19.sp,
                textAlign = TextAlign.Start,
                color = Color.White
            )
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss) {
                Text(text = confirmButtonText, color = BlueClain)
            }
        },
        containerColor = GreenTop
    )
}
