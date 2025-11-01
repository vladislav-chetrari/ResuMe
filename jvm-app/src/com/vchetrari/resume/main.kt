package com.vchetrari.resume

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        title = "ResuMe",
        onCloseRequest = ::exitApplication,
    ) {
        App()
    }
}