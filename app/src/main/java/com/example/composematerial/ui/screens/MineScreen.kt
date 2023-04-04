package com.example.composematerial.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composematerial.R.string
import com.example.composematerial.viewmodel.ThemeModel
import com.funny.data_saver.core.rememberDataSaverState


@Composable
fun MineScreen() {
    val viewModel: ThemeModel = viewModel()
    var switchTheme by rememberDataSaverState("switchTheme", true)

    Column {
        Text(
            text = stringResource(id = string.themes),
            modifier = Modifier.padding(end = 10.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = string.follow_system),
                modifier = Modifier.padding(end = 10.dp)
            )
            Switch(
                checked = switchTheme,
                onCheckedChange = {
                    viewModel.auTo = !viewModel.auTo
                    switchTheme = it
                }
            )
        }

        Button(
            onClick = {
                viewModel.isDark = !viewModel.isDark
                switchTheme = false
                viewModel.auTo = false
            }
        ) {
            Text(
                text = stringResource(id = string.switch_themes),
                color = MaterialTheme.colorScheme.outline
            )
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MineScreenPreview() {
    MineScreen()
}