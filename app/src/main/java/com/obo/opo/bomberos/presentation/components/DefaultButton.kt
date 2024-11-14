package com.obo.opo.bomberos.presentation.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.obo.opo.bomberos.presentation.ui.theme.BlueClain
import com.obo.opo.bomberos.presentation.ui.theme.OBOTheme

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onclick: () -> Unit,
    color: Color = BlueClain
    //icon: ImageVector = Icons.Default.ArrowForward
) {
    val context = LocalContext.current
    Button(
        modifier = modifier,
        onClick = { onclick.invoke() },
        colors = ButtonDefaults.buttonColors(color),
    ) {
        /*Icon(
            imageVector = icon,
            contentDescription = ""
        )*/
        Text(
            text = text,
            color = Color.White
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultButtonPreview() {
    OBOTheme {
        DefaultButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Login",
            onclick = {},
            color = Color.Blue
        )
    }
}