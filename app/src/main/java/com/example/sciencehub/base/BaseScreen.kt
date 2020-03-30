package com.example.sciencehub.base

import androidx.compose.Composable
import com.example.sciencehub.navigation.ScreenModel

abstract class BaseScreen(navigateTo: ((ScreenModel) -> Unit)? = null) {

    @Composable
    abstract fun initScreen()
}