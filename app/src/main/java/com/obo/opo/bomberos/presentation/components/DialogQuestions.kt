package com.obo.opo.bomberos.presentation.components


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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
            Text(text = message,
                fontSize = 19.sp,
                textAlign = TextAlign.Start
            )
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss) {
                Text(text = confirmButtonText, color = GreenTop)
            }
        }
    )
}
