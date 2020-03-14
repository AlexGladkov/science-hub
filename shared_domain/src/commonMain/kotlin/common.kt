package com.example.sciencehub

expect fun platformName(): String
expect fun testPlatform(): Int

fun createApplicationScreenMessage() : String {
    return "Kotlin Rocks on ${platformName()} version ${testPlatform()}"
}