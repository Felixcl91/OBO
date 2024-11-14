package com.obo.opo.bomberos.presentation.components

import androidx.compose.ui.text.googlefonts.GoogleFont
import com.obo.opo.bomberos.R

object TextDefault {

    // [START android_compose_text_df_provider]
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    // [END android_compose_text_df_provider]
}