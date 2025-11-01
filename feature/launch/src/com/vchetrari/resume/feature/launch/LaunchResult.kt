package com.vchetrari.resume.feature.launch

sealed interface LaunchResult {
    data object Success : LaunchResult
    data object Failure : LaunchResult
}