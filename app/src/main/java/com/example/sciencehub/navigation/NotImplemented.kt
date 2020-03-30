package com.example.sciencehub.navigation

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Center

@Composable
inline fun <reified T> NotImplemented(key: String) {
    Center {
        Text("$key not implemented for ${T::class.java}")
    }
}