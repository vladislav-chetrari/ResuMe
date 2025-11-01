package com.vchetrari.resume.feature.launch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LaunchScreen(
    onResult: (LaunchResult) -> Unit = {},
) {
    val viewModel = koinViewModel<LaunchViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    val result = uiState.result
    if (result != null) {
        onResult(
            if (result.isSuccess) LaunchResult.Success
            else LaunchResult.Failure
        )
        return
    }
    LaunchScreen(uiState)
}

@Composable
private fun LaunchScreen(
    uiState: LaunchUiState,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        BasicText("Loading...")
    }
}