package com.example.composematerial


import android.app.Application
import com.funny.data_saver.core.DataSaverInterface
import com.funny.data_saver.core.DataSaverPreferences
import com.zxy.zxymultilingual.MultiLanguageUtil


class App : Application() {
    override fun onCreate() {
        super.onCreate()
//        第三方 DataStore 初始化
        DataSaverUtils = DataSaverPreferences(this)
//        多语言初始化
        MultiLanguageUtil.init(this)
    }

    companion object {
        lateinit var DataSaverUtils: DataSaverInterface
    }
}