package com.vchetrari.resume

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppRoute {

    @Serializable
    data object Launch : AppRoute
}