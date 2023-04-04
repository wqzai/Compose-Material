package com.example.composematerial.viewmodel


import androidx.lifecycle.ViewModel
import com.example.composematerial.App
import com.funny.data_saver.core.mutableDataSaverStateOf


class ThemeModel : ViewModel() {
    var isDark by mutableDataSaverStateOf(App.DataSaverUtils, "isDark", false)
    var auTo by mutableDataSaverStateOf(App.DataSaverUtils, "auTo", true)
}