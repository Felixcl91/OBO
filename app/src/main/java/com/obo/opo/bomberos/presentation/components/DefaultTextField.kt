package com.obo.opo.bomberos.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain

@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = { text ->
            onValueChange(text)
        },
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = BlueClain
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),

        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
    )
}