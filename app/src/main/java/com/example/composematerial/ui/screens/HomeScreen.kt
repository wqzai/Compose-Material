package com.example.composematerial.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composematerial.datamodel.NavigationModel
import dev.patrickgold.compose.tooltip.tooltip
import com.example.composematerial.R.string


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(bottomPadding: PaddingValues) {
    val actionItem = listOf(
        NavigationModel(stringResource(id = string.shopping), Icons.Filled.ShoppingCart),
        NavigationModel(stringResource(id = string.collection), Icons.Filled.Favorite),
        NavigationModel(stringResource(id = string.settings), Icons.Filled.Settings),
    )
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = string.home)) },
                navigationIcon = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.tooltip(stringResource(id = string.menu))
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = stringResource(id = string.menu)
                        )
                    }

                },
                actions = {
                    actionItem.forEach {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.tooltip(it.title)
                        ) {
                            Icon(imageVector = it.icon, contentDescription = it.title)
                        }
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = bottomPadding.calculateBottomPadding())
        ) {
            val lists = (0..75).map { list ->
                list.toString()
            }
            items(count = lists.size) {
                Text(
                    text = lists[it],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(PaddingValues(bottom = 80.dp))
}

