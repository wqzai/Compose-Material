package com.example.composematerial


import android.content.Context
import androidx.activity.ComponentActivity
import com.zxy.zxymultilingual.MultiLanguageUtil


open class BaseActivity : ComponentActivity() {
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(MultiLanguageUtil.attachBaseContext(newBase))
    }
}