package com.example.composematerial.ui.screens


import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composematerial.R.string
import com.example.composematerial.datamodel.LanguageModel
import com.example.composematerial.utils.changeLanguage
import com.funny.data_saver.core.rememberDataSaverState
import com.zxy.zxymultilingual.LanguageType


@Composable
fun StudyScreen(context: Context) {
    val language = listOf(
        LanguageModel(
            stringResource(id = string.follow_system),
            LanguageType.LANGUAGE_FOLLOW_SYSTEM
        ),
        LanguageModel(
            stringResource(id = string.chinese_simplified),
            LanguageType.LANGUAGE_CHINESE_SIMPLIFIED
        ),
        LanguageModel(
            stringResource(id = string.chinese_traditional),
            LanguageType.LANGUAGE_CHINESE_TRADITIONAL
        ),
        LanguageModel(
            stringResource(id = string.english),
            LanguageType.LANGUAGE_EN)
    )
    var switchLanguage by rememberDataSaverState("switchLanguage", true)

    Column {
        Text(
            text = stringResource(id = string.changeLanguage),
            modifier = Modifier.padding(bottom = 10.dp)
        )
        language.forEach {
            Button(
                onClick = {
                    switchLanguage = false
                    changeLanguage(
                        context,
                        it.type
                    )
                }
            ) {
                Text(
                    text = it.name,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }
    }
}


@Preview(showBackground = true, locale = "zh")
@Composable
fun StudyScreenPreview() {
    StudyScreen(LocalContext.current)
}

