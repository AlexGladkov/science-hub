package com.example.sciencehub.navigation

data class ScreenModel(val key: String, val data: Any?)

inline fun <reified T> getKey(): String {
    return T::class.java.simpleName
}