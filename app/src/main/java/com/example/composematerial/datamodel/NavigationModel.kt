package com.example.composematerial.datamodel


import androidx.compose.ui.graphics.vector.ImageVector


data class NavigationModel(
    val title: String,
    val icon: ImageVector,
)

data class LanguageModel(
    val name: String,
    val type: Int,
)