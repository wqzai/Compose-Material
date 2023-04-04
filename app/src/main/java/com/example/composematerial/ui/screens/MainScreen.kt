package com.example.composematerial.ui.screens


import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.composematerial.R.string
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composematerial.datamodel.NavigationModel
import dev.patrickgold.compose.tooltip.tooltip


@Composable
fun MainScreen(context: Context) {
    val navigationItems = listOf(
        NavigationModel(stringResource(id = string.home), Icons.Outlined.Home),
        NavigationModel(stringResource(id = string.favorite), Icons.Outlined.FavoriteBorder),
        NavigationModel(stringResource(id = string.mine), Icons.Outlined.Person)
    )

//    选中的Item下标
    /*记住退出前的页面
    var selectItem by rememberDataSaverState("selectItem", 0)*/
    var selectItem by rememberSaveable { mutableStateOf(0) }
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.secondary
            ) {
                navigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectItem == index,
                        onClick = { selectItem = index },
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = item.title)
                        },
                        label = {
                            Text(
                                text = item.title,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 13.5.sp,
                                letterSpacing = 2.sp
                            )
                        },
                        alwaysShowLabel = false,
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        modifier = Modifier.tooltip(item.title)
                    )
                }
            }
        }
    ) {
        when (selectItem) {
            0 -> HomeScreen(it)
            1 -> StudyScreen(context)
            2 -> MineScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(LocalContext.current)
}

