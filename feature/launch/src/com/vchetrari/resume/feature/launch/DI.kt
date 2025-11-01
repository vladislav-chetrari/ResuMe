package com.vchetrari.resume.feature.launch

import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val launchModule: Module = module {
    viewModelOf(::LaunchViewModel)
}