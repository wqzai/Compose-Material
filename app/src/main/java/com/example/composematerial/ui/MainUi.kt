package com.example.composematerial.ui


import android.content.Context
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composematerial.App
import com.example.composematerial.viewmodel.ThemeModel
import com.example.composematerial.ui.screens.MainScreen
import com.example.composematerial.ui.theme.ComposeMaterialTheme
import com.funny.data_saver.core.LocalDataSaver


@Composable
fun MainUi(context:Context) {
    val viewModel: ThemeModel = viewModel()
    if (viewModel.auTo) viewModel.isDark = isSystemInDarkTheme()
    ComposeMaterialTheme(darkTheme = viewModel.isDark) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CompositionLocalProvider(LocalDataSaver provides App.DataSaverUtils) {
                MainScreen(context)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainUiPreview() {
    ComposeMaterialTheme {
        MainUi(LocalContext.current)
    }
}