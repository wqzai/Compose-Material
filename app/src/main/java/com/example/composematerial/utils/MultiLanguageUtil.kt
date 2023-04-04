package com.example.composematerial.utils


import android.content.Context
import android.content.Intent
import com.example.composematerial.MainActivity
import com.zxy.zxymultilingual.MultiLanguageUtil


fun changeLanguage(context: Context, language: Int) {
    MultiLanguageUtil.getInstance().updateLanguage(language)
    MultiLanguageUtil.getInstance().newIntent(context, Intent(context, MainActivity::class.java))
}
