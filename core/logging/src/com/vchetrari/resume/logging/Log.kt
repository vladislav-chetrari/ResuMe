package com.vchetrari.resume.logging

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

typealias Log = Napier

fun Log.init() {
    //TODO remove debug logging once build types support added for Amper
    base(DebugAntilog())
    Log.d("Logging initialized!")
}