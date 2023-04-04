package com.example.composematerial.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColorScheme = lightColorScheme(
    primary = Bar_L,
    onPrimary = BarSelected_L,
    outline = Text_L
)

private val DarkColorScheme = darkColorScheme(
    primary = Bar_D,
    onPrimary = BarSelected_D,
    outline = Text_D
)

@Composable
fun ComposeMaterialTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
