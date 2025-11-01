package com.vchetrari.resume.logging

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.coroutines.delay

typealias Log = Napier

suspend fun Log.init() {
    delay(1000L)
    //TODO remove debug logging once build types support added for Amper
    base(DebugAntilog())
    Log.d("Logging initialized!")
}