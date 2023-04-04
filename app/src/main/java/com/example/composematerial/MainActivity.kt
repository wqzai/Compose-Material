package com.example.composematerial


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composematerial.ui.MainUi
import com.example.composematerial.ui.theme.ComposeMaterialTheme


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainUi(this)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    ComposeMaterialTheme {
        MainUi(LocalContext.current)
    }
}